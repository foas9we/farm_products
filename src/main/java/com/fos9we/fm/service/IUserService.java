package com.fos9we.fm.service;

import com.fos9we.fm.bean.User;

/**
 * 
 *@ClassName: IUserService
 *@Description: 用户接口
 * @author Administrator
 *@date 2020年4月17日 上午11:38:18
 */
public interface IUserService {
	
	User findUserById(long id );
	
	public void SaveOrUpdateUser(User user);
}
