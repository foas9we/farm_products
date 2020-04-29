package com.fos9we.fm.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fos9we.fm.bean.Role;
import com.fos9we.fm.bean.User;
import com.fos9we.fm.bean.UserExample;
import com.fos9we.fm.bean.UserRole;
import com.fos9we.fm.bean.UserRoleExample;
import com.fos9we.fm.bean.extend.UserExtend;
import com.fos9we.fm.dao.UserMapper;
import com.fos9we.fm.dao.UserRoleMapper;
import com.fos9we.fm.dao.extend.UserExtendMapper;
import com.fos9we.fm.service.IUserService;
import com.fos9we.fm.utils.CustomerException;

/**
 *@ClassName: UserServiceImpl
 *@Description: 用户业务实现类
 * @author Administrator
 *@date 2020年4月17日 下午4:44:24 
 */

@Service
public class UserServiceImpl implements IUserService{
	@Resource
    private UserMapper userMapper;
	@Resource
    private UserExtendMapper userExtendMapper;
	@Resource
    private UserRoleMapper userRoleMapper;

	@Override
	public User findUserById(long id) {
		return userMapper.selectByPrimaryKey(id);
	}

	
	@Override
	public void SaveOrUpdateUser(User user) {
		//控制用户名唯一
		UserExample example = new UserExample();
		example.createCriteria().andNameEqualTo(user.getName());
		List<User> list = userMapper.selectByExample(example);
		if(list.size()>0) {
			throw new CustomerException("用户名已存在");
		}
		//当没有没传入id对用户信息进行插入
		//当传入信息有id是对用户信息进行更新
		if(user.getId()!=null) {
			userMapper.updateByPrimaryKeySelective(user);
		}else {
			userMapper.insertSelective(user);
		}
	}


	@Override
	public UserExtend findUserExtendById(long id) {
		return userExtendMapper.findUserExtendById(id);
	}


	@Override
	public List<User> findAll() {
		List<User> selectByExample = userMapper.selectByExample(new UserExample());
		return selectByExample;
	}


	@Override
	public List<UserExtend> findAllWithRole() {
		List<UserExtend> findAllWithRole = userExtendMapper.findAllWithRole();
		return findAllWithRole;
	}


	@Override
	public void deleteById(long id) {
		User user = userMapper.selectByPrimaryKey(id);
		if(user==null) {
			throw new CustomerException("该用户不存在");
		}
		userMapper.deleteByPrimaryKey(id);
	}


	@Override
	public void setRoles(long id, List<Long> roles) {
		//通过id连带找到用户的基本信息和用户的角色信息
		UserRoleExample example = new UserRoleExample();
		example.createCriteria().andIdEqualTo(id);
		//获取到id-userId-roleId模型集合
		List<UserRole> list = userRoleMapper.selectByExample(example);
		
		//将之前用户的角色id放到集合oldRoles里面
		List<Long> oldRoles = new ArrayList<Long>();
		for(long role:roles) {
			//新角色不存在于旧角色，就添加到数据库中
			if(!oldRoles.contains(role)) {
				UserRole userRole = new UserRole();
				userRole.setUserId(id);
				userRole.setRoleId(role);
				//将userId-RoleId模型插入数据库
				userRoleMapper.insert(userRole);
			}
		}
		
		
		for(UserRole userRole:list) {
			//旧角色不存在于新角色，将它从数据库中删除
			if(!roles.contains(userRole.getRoleId())) {
				userRoleMapper.deleteByPrimaryKey(userRole.getId());
			}
		}
		
		
		
		
	}
	
	
	
	
}
