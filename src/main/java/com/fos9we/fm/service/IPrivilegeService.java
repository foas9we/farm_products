package com.fos9we.fm.service;

import java.util.List;

import com.fos9we.fm.bean.Privilege;
import com.fos9we.fm.utils.CustomerException;

/**
 *@ClassName: IPrivilegeService
 *@Description: TODO
 * @author Administrator
 *@date 2020年4月29日 下午8:08:09 
 */
public interface IPrivilegeService {
	/**
	 * 
	 * @Title: findAll 
	 * @Description: 查询所有权限信息
	 * @param @return    
	 * @return List<Privilege>    
	 * @throws
	 *
	 */
	List<Privilege> findAll();
	
	/**
	 * 
	 * @Title: findByParentId 
	 * @Description: 通过parentId找到父权限
	 * @param @param id
	 * @param @return    
	 * @return List<Privilege>    
	 * @throws
	 *
	 */
	List<Privilege> findByParentId(Long id);
	/**
	 * 
	 * @Title: saveOrUpdate 
	 * @Description: 保存或更新
	 * @param @param privilege    
	 * @return void    
	 * @throws
	 *
	 */
	void saveOrUpdate(Privilege privilege)throws CustomerException;
}
