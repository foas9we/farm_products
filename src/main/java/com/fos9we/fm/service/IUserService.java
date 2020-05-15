package com.fos9we.fm.service;

import java.util.List;

import com.fos9we.fm.bean.User;
import com.fos9we.fm.bean.extend.UserExtend;
import com.fos9we.fm.utils.CustomerException;
import com.fos9we.fm.vm.UserVM;

/**
 * 
 *@ClassName: IUserService
 *@Description: 用户接口
 * @author Administrator
 *@date 2020年4月17日 上午11:38:18
 */
public interface IUserService {
	
	/**
	 * 
	 * @Title: findUserById 
	 * @Description: 通过id查找用户基本信息
	 * @param @param id
	 * @param @return    
	 * @return User    
	 * @throws
	 *
	 */
	User findUserById(long id );
	
	/**
	 * 
	 * @Title: SaveOrUpdateUser 
	 * @Description: 修改或者更新用户信息
	 * @param @param user
	 * @param @throws CustomerException    
	 * @return void    
	 * @throws
	 *
	 */
	public void SaveOrUpdateUser(User user)throws CustomerException;
	
	/**
	 * 
	 * @Title: findUserExtendById 
	 * @Description: 通过id查找用户信息(含角色)
	 * @param @param id
	 * @param @return    
	 * @return UserExtend    
	 * @throws
	 *
	 */
	UserExtend findUserExtendById(long id);
	
	/**
	 * 
	 * @Title: findAll 
	 * @Description: 查询所有用户的基本信息 
	 * @param @return    
	 * @return List<User>    
	 * @throws
	 *
	 */
	List<User> findAll();
	/**
	 * 
	 * @Title: findAllWithRole 
	 * @Description: 查找所有用户(包含角色)
	 * @param @return    
	 * @return List<UserExtend>    
	 * @throws
	 *
	 */
	List<UserExtend> findAllWithRole();
	
	/**
	 * 
	 * @Title: deleteById 
	 * @Description: 通过id删除用户信息
	 * @param @param id    
	 * @return void    
	 * @throws
	 *
	 */
	void deleteById(long id)throws CustomerException;
	
	/**
	 * 
	 * @Title: setRoles 
	 * @Description: 设置用户角色 
	 * @param @param id
	 * @param @param roles    
	 * @return void    
	 * @throws
	 *
	 */
	void setRoles(long id,List<Long> roles)throws CustomerException;
	/**
	 * 
	 * @Title: login 
	 * @Description: 用户登录
	 * @param @param userVM
	 * @param @throws CustomerException    
	 * @return void    
	 * @throws
	 *
	 */
	User login(UserVM userVM)throws CustomerException;
	/**
	 * 
	 * @Title: findByName 
	 * @Description:通过用户名查找用户信息
	 * @param @param Name
	 * @param @return    
	 * @return User    
	 * @throws
	 *
	 */
	User findByName(String name);
}
