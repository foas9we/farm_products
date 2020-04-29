package com.fos9we.fm.dao.extend;

import java.util.List;

import com.fos9we.fm.bean.Role;
import com.fos9we.fm.bean.extend.RoleExtend;

/**
 *@ClassName: RoleExtendMapper
 *@Description: TODO
 * @author Administrator
 *@date 2020年4月28日 下午11:34:01 
 */
public interface RoleExtendMapper {
	/*
	 * 通过用户id查找用户的角色
	 */
	List<Role> findByUserId(long id);
	
	/**
	 * 
	 * @Title: findAllRoleWithPrivilege 
	 * @Description: 级联查询所有角色和对应的权限 
	 * @param @return    
	 * @return List<RoleExtend>    
	 * @throws
	 *
	 */
	List<RoleExtend> findAllRoleWithPrivilege();
}
