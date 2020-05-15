package com.fos9we.fm.service;

import java.util.List;

import com.fos9we.fm.bean.Privilege;
import com.fos9we.fm.bean.extend.PrivilegeExtend;
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
	
	/**
	 * 
	 * @Title: findALlWithChildren 
	 * @Description: 查询权限时级联查询子权限
	 * @param @return    
	 * @return List<PrivilegeExtend>    
	 * @throws
	 *
	 */
	List<PrivilegeExtend> findALlWithChildren();
	/**
	 *
	 * @Title: findParentPrivilege 
	 * @Description: 查找所有第一级权限，除了自己的当前父类
	 * @param @return    
	 * @return List<Privilege>    
	 * @throws
	 *
	 */
	List<Privilege> findParentPrivilege(long id);
	/**
	 * 
	 * @Title: findAllFist 
	 * @Description: 查询所有的一级权限
	 * @param @return    
	 * @return List<Privilege>    
	 * @throws
	 *
	 */
	List<Privilege> findAllFist();
}
