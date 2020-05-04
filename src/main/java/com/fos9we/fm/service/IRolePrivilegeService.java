package com.fos9we.fm.service;

import java.util.List;

import com.fos9we.fm.bean.Privilege;

/**
 *@ClassName: IRolePrivilegeService
 *@Description: TODO
 * @author Administrator
 *@date 2020年5月4日 上午10:22:21 
 */
public interface IRolePrivilegeService {
	/**
	 * 
	 * @Title: findByRoleId 
	 * @Description: 通过角色id查找所有权限(包括子权限)
	 * @param @param id
	 * @param @return    
	 * @return List<Privilege>    
	 * @throws
	 *
	 */
	List<Privilege> cascadeFindByRoleId(long id);
}
