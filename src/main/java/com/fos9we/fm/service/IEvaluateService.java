package com.fos9we.fm.service;

import java.util.List;

import com.fos9we.fm.bean.Evaluate;
import com.fos9we.fm.bean.extend.EvaluateExtend;
import com.fos9we.fm.utils.CustomerException;

/**
 *@ClassName: IEvaluateService
 *@Description: TODO
 * @author Administrator
 *@date 2020年4月23日 下午5:47:24 
 */
public interface IEvaluateService {
	
	/*
	 * 通过农产品id查找所有评论
	 */
	List<EvaluateExtend> findByProductId(long id);
	
	/**
	 * 
	 * @Title: findAll 
	 * @Description: 查找所有评论
	 * @param @return    
	 * @return List<Evaluate>    
	 * @throws
	 *
	 */
	List<Evaluate> findAll();
	/**
	 * 
	 * @Title: deleteById 
	 * @Description: 通过id删除评论
	 * @param @param id    
	 * @return void    
	 * @throws
	 *
	 */
	void deleteById(long id)throws CustomerException;
	/**
	 * 
	 * @Title: cascadeFindAll 
	 * @Description: 级联查找所有评论以及关联用户信息
	 * @param @return    
	 * @return List<Evaluate>    
	 * @throws
	 *
	 */
	List<EvaluateExtend> cascadeFindAll();
	/**
	 * 
	 * @Title: saveOrUpdate 
	 * @Description: 添加评论 ，评论一经添加，不容修改
	 * @param @param evaluate    
	 * @return void    
	 * @throws
	 *
	 */
	void insert(Evaluate evaluate)throws CustomerException;	
	/**
	 * 
	 * @Title: cascadeFindByUserName 
	 * @Description: 通过用户名级联查找评论
	 * @param @param name
	 * @param @return    
	 * @return List<EvaluateExtend>    
	 * @throws
	 *
	 */
	List<EvaluateExtend> cascadeFindByUserName(String name)throws CustomerException;
	
}
