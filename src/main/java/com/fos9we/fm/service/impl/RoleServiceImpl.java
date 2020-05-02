package com.fos9we.fm.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fos9we.fm.bean.Role;
import com.fos9we.fm.bean.RoleExample;
import com.fos9we.fm.bean.RolePrivilege;
import com.fos9we.fm.bean.RolePrivilegeExample;
import com.fos9we.fm.bean.UserRole;
import com.fos9we.fm.bean.UserRoleExample;
import com.fos9we.fm.bean.extend.RoleExtend;
import com.fos9we.fm.dao.RoleMapper;
import com.fos9we.fm.dao.RolePrivilegeMapper;
import com.fos9we.fm.dao.extend.ProductExtendMapper;
import com.fos9we.fm.dao.extend.RoleExtendMapper;
import com.fos9we.fm.service.IRoleService;
import com.fos9we.fm.utils.CustomerException;

/**
 *@ClassName: RoleServiceImpl
 *@Description: TODO
 * @author Administrator
 *@date 2020年4月29日 上午10:18:21 
 */
@Service
public class RoleServiceImpl implements IRoleService{
	@Resource
	private RoleExtendMapper roleExtendMapper;
	@Resource
	private RoleMapper roleMapper;
	@Resource
	private RolePrivilegeMapper rolePrivilegeMapper;
	@Override
	public List<Role> findByUserId(long id) {
		return roleExtendMapper.findByUserId(id);
	}
	
	@Override
	public List<Role> findAll() {
		return roleMapper.selectByExample(new RoleExample());
	}

	@Override
	public List<RoleExtend> findAllRoleWithPrivilege() {
		return roleExtendMapper.findAllRoleWithPrivilege();
	}

	@Override
	public void deleteRoleById(long id) throws CustomerException {
		Role role = roleMapper.selectByPrimaryKey(id);
		if(role==null) {
			throw new CustomerException("该角色不存在");
		}
		roleMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void setPrivilegeToRole(long id, List<Long> privilege)throws CustomerException {
		RolePrivilegeExample example = new RolePrivilegeExample();
		example.createCriteria().andRoleIdEqualTo(id);
		
		//通过角色id查找到桥表中对应的所有数据
		List<RolePrivilege> list = rolePrivilegeMapper.selectByExample(example);
		
		if(privilege!=null) {
			//将角色原本已有权限放入数组oldPrivilege中
			List<Long> oldPrivilege = new ArrayList<Long>();
			for(RolePrivilege old:list) {
				oldPrivilege.add(old.getPrivilegeId());
			}
			//判断新权限数组是否有老权限数组本没有的id
			for(Long p:privilege) {
				if(!oldPrivilege.contains(p)) {
					//如果有，添加到数据库中
					RolePrivilege rolePrivilege = new RolePrivilege();
					rolePrivilege.setPrivilegeId(p);
					rolePrivilege.setRoleId(id);
					rolePrivilegeMapper.insert(rolePrivilege);
					
				}
			}
			//将新数组中没有包含的、旧数组的id从数据库中删除
			for(RolePrivilege old:list) {
				if(!privilege.contains(old.getPrivilegeId())) {
					rolePrivilegeMapper.deleteByPrimaryKey(old.getId());
				}
			}
			
			
		}//输入权限数组非空
		else {
			//传入角色为空
			//判断之前是否有权限
			if(list.size()>0) {
				//有权限，将权限删除完
				for(RolePrivilege old:list) {
					//旧角色不存在于新角色，将它从数据库中删除
					rolePrivilegeMapper.deleteByPrimaryKey(old.getId());
				}
			}else {
				//没有权限
				throw new CustomerException("您未设置权限");
			}
		}
	}

}
