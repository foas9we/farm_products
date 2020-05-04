package com.fos9we.fm.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.fos9we.fm.bean.Privilege;
import com.fos9we.fm.bean.Role;
import com.fos9we.fm.bean.extend.UserExtend;
import com.fos9we.fm.service.IPrivilegeService;
import com.fos9we.fm.service.IRolePrivilegeService;
import com.fos9we.fm.service.IUserService;
import com.fos9we.fm.utils.CustomerException;
import com.fos9we.fm.utils.JwtTokenUtil;
import com.fos9we.fm.utils.PermissionException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.List;

public class JwtInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private IPrivilegeService privilegeService;
    @Autowired
    private IUserService userService;
    @Autowired
    private IRolePrivilegeService rolePrivilegeService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 如果是options请求，直接返回true，不进行拦截
        if (request.getMethod().equals("OPTIONS")) {
            response.setStatus(HttpServletResponse.SC_OK);
            return true;
        }
        // 获取请求头信息authorization信息
        final String token = request.getHeader(JwtTokenUtil.AUTH_HEADER_KEY);
        if(StringUtils.isEmpty(token)){
            throw new CustomerException("用户还未登录");
        }
        // 验证token是否有效--无效已做异常抛出，由全局异常处理后返回对应信息
        JwtTokenUtil.parseJWT(token, JwtTokenUtil.base64Secret);
        // 验证权限，通过token获取用户id，通过用户id获取权限，这里可以使用redis将用户信息维护在缓存中，减少与数据库交互次数
        long id = Long.parseLong(JwtTokenUtil.getUserId(token,JwtTokenUtil.base64Secret));
        System.out.println(request.getServletPath());
        this.auth(id,request.getServletPath());

        return true;
    }

    // 判断权限
    private boolean auth(long userId,String path){
		//创建权限数组
		List<Privilege> privileges = new ArrayList<Privilege>();
		//查询出该用户的拓展信息
		UserExtend userExtend = userService.findUserExtendById(userId);
		//先通过用户id查找出所有角色列表
		List<Role> roles = userExtend.getRoles();
		if(roles.size()<=0) {
			throw new CustomerException("该用户无权限");
		}
		//遍历出每个角色
		for(Role role:roles) {
			//获取到每个角色的Id
			Long roleId = role.getId();
			//通过角色id查找出该角色对应的所有权限(包括级联查找出子权限)
			List<Privilege> cascadeFindByRoleId = rolePrivilegeService.cascadeFindByRoleId(roleId);
			privileges.addAll(cascadeFindByRoleId);
			
		}
		//    	List<Privilege> privileges = privilegeService.findByParentId(userId);
		for(Privilege p : privileges){
			//将用户拥有的权限和请求的路径匹配
			System.out.println(p.getRoute());
			System.out.println(path);
		    if(p.getRoute().matches(path)) {
		    	System.out.println(true);
		    	return true;
		    }
		}
		throw new PermissionException("权限不足");
//    	return true;
    }
}
