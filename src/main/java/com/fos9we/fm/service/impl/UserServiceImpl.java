package com.fos9we.fm.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fos9we.fm.bean.User;
import com.fos9we.fm.bean.UserExample;
import com.fos9we.fm.dao.UserMapper;
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

	@Override
	public User findUserById(long id) {
		return userMapper.selectByPrimaryKey(id);
	}
	
	
}
