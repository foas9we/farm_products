package com.fos9we.fm.service;

import java.util.List;

import com.fos9we.fm.bean.Role;
import com.fos9we.fm.bean.User;
import com.fos9we.fm.bean.extend.RoleExtend;
import com.fos9we.fm.utils.CustomerException;

/**
 *@ClassName: IRoleService
 *@Description: TODO
 * @author Administrator
 *@date 2020年4月29日 上午10:16:44 
 */
public interface IRoleService {
	//通过用户id找到对应的角色
	List<Role> findByUserId(long id);
	
	/**
	 * 
	 * @Title: findAll 
	 * @Description: 查找所有角色信息
	 * @param @return    
	 * @return List<Role>    
	 * @throws
	 *
	 */
	List<Role> findAll();
	
	/**
	 * 
	 * @Title: findAllRoleWithPrivilege 
	 * @Description:级联查找所有角色和相关权限
	 * @param @return    
	 * @return List<RoleExtend>    
	 * @throws
	 *
	 */
	List<RoleExtend> findAllRoleWithPrivilege();
	
	/**
	 * 
	 * @Title: deleteRoleById 
	 * @Description: 通过角色id删除角色信息
	 * @param @param id    
	 * @return void    
	 * @throws
	 *
	 */
	void deleteRoleById(long id)throws CustomerException;
	
	/**
	 * 
	 * @Title: setPrivilegeToRole 
	 * @Description: 给角色绑定权限 
	 * @param @param id
	 * @param @param ids    
	 * @return void    
	 * @throws
	 *
	 */
	void setPrivilegeToRole(long id,List<Long> ids)throws CustomerException;
	/**
	 * 
	 * @Title: saveOrUpadate 
	 * @Description: 添加或者更新用户
	 * @param @param user    
	 * @return void    
	 * @throws
	 *
	 */
	void saveOrUpadate(Role role)throws CustomerException;
	/**
	 * 
	 * @Title: deleteById 
	 * @Description: 通过id删除角色信息
	 * @param @param id
	 * @param @throws CustomerException    
	 * @return void    
	 * @throws
	 *
	 */
	void deleteById(long id)throws CustomerException;
}
