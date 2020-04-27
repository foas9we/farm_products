package com.fos9we.fm.service;

import java.util.List;

import com.fos9we.fm.bean.Category;
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
}
