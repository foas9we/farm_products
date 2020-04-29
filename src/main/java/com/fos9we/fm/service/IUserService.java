package com.fos9we.fm.service;

import com.fos9we.fm.bean.User;
import com.fos9we.fm.bean.extend.UserExtend;
import com.fos9we.fm.utils.CustomerException;

/**
 * 
 *@ClassName: IUserService
 *@Description: 用户接口
 * @author Administrator
 *@date 2020年4月17日 上午11:38:18
 */
public interface IUserService {
	
	User findUserById(long id );
	
	public void SaveOrUpdateUser(User user)throws CustomerException;
	
	//通过id查找用户信息(含权限)
	UserExtend findUserExtendById(long id);
}
