package com.fos9we.fm.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fos9we.fm.bean.User;
import com.fos9we.fm.bean.UserExample;
import com.fos9we.fm.bean.extend.UserExtend;
import com.fos9we.fm.dao.UserMapper;
import com.fos9we.fm.dao.extend.UserExtendMapper;
import com.fos9we.fm.service.IUserService;

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

	@Override
	public User findUserById(long id) {
		return userMapper.selectByPrimaryKey(id);
	}

	
	@Override
	public void SaveOrUpdateUser(User user) {
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
	
	
	
	
}
