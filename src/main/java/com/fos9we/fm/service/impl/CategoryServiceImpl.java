package com.fos9we.fm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fos9we.fm.bean.Category;
import com.fos9we.fm.bean.CategoryExample;
import com.fos9we.fm.bean.CategoryExample.Criteria;
import com.fos9we.fm.bean.extend.CategoryExtend;
import com.fos9we.fm.dao.CategoryMapper;
import com.fos9we.fm.dao.extend.CategoryExtendMapper;
import com.fos9we.fm.service.ICategoryService;
import com.fos9we.fm.utils.CustomerException;

/**
 *@ClassName: CategoryServiceImpl
 *@Description: TODO
 * @author Administrator
 *@date 2020年4月27日 下午7:36:03 
 */
@Service
public class CategoryServiceImpl implements ICategoryService{
	@Resource
	private CategoryMapper categoryMapper; 
	@Resource
	private CategoryExtendMapper categoryExtendMapper; 
	@Override
	public List<Category> findAll() {
		return categoryMapper.selectByExample(new CategoryExample());
	}

	@Override
	public void saveOrUpdate(Category category) throws CustomerException {
		if(category.getId()!=null) {
			//修改栏目
			categoryMapper.updateByPrimaryKeySelective(category);
		}else {
			//栏目不能重复
			CategoryExample example = new CategoryExample();
			example.createCriteria().andNameEqualTo(category.getName());
			List<Category> list = categoryMapper.selectByExample(example);
			if(list.size()>0) {
				throw new CustomerException("栏目名不能重复");
			}
			//添加栏目
			categoryMapper.insertSelective(category);
		}
	}

	@Override
	@Transactional
	public void deleteById(long id) throws CustomerException {
		Category category = categoryMapper.selectByPrimaryKey(id);
		if(category==null) {
			throw new CustomerException("找不到对应的栏目");
		}
		categoryMapper.deleteByPrimaryKey(id);
	}

	@Override
	@Transactional
	public void batchDelete(long[] ids) throws CustomerException {
		for(long id:ids) {
			this.deleteById(id);
		}
	}

	/*@Override
	public List<Category> findByParentId(Long id) throws CustomerException {
		CategoryExample example = new CategoryExample();
		if(id==null) {
			example.createCriteria().andParentIdIsNull();
		}
		example.createCriteria().andParentIdEqualTo(id);
		List<Category> selectByExample = categoryMapper.selectByExample(example);
		return selectByExample;
	}*/

	@Override
	public List<CategoryExtend> cascodeFindAll() {
		List<CategoryExtend> cascodeFindAll = categoryExtendMapper.cascodeFindAll();
		return cascodeFindAll;
	}

	
	
}
