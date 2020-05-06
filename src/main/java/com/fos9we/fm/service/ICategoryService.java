package com.fos9we.fm.service;

import java.util.List;

import com.fos9we.fm.bean.Category;
import com.fos9we.fm.bean.extend.CategoryExtend;
import com.fos9we.fm.utils.CustomerException;

/**
 *@ClassName: ICategory
 *@Description: TODO
 * @author Administrator
 *@date 2020年4月27日 下午7:35:08 
 */
public interface ICategoryService {
	List<Category> findAll();
	void saveOrUpdate(Category category)throws CustomerException;
	void deleteById(long id)throws CustomerException;
	void batchDelete(long[] ids)throws CustomerException;
	/**
	 * 
	 * @Title: findByParentId 
	 * @Description: 通过父类id查找栏目 
	 * @param @param id
	 * @param @return    
	 * @return List<Category>    
	 * @throws
	 *
	 */
	/*List<Category> findByParentId(Long id)throws CustomerException;*/
	/**
	 * 
	 * @Title: cascodeFindAll 
	 * @Description: 级联查找所有栏目 
	 * @param @return    
	 * @return List<CategoryExtend>    
	 * @throws
	 *
	 */
	List<CategoryExtend> cascodeFindAll();
	
	
}
