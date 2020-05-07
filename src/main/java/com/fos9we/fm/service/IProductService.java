package com.fos9we.fm.service;

import java.util.List;

import com.fos9we.fm.bean.Product;
import com.fos9we.fm.bean.extend.ProductExtend;
import com.fos9we.fm.utils.CustomerException;

/**
 *@ClassName: IProductService
 *@Description: TODO
 * @author Administrator
 *@date 2020年4月23日 下午12:46:23 
 */
public interface IProductService {
	/*
	 * 级联查看所有商品
	 */
	List<ProductExtend> findAllProduct();
	
	/*
	 * 通过栏目编号查询商品
	 */
	List<ProductExtend> findProductByCategory(long id);
	
	/*
	 * 通过商品编号查到商品信息和供应商信息
	 */
	ProductExtend findById(long id);
	
	
	/*
	 * 发布或者修改农产品
	 */
	void saveOrUpdateProduct(Product product)throws CustomerException;
	
	/*
	 * 基础查询所有农产品
	 */
	List<Product> findAll();
	
	/*
	 * 通过农产品编号删除
	 */
	void deleteById(long id)throws CustomerException;
	/**
	 * 
	 * @Title: findByName 
	 * @Description: 通过名字模糊查询
	 * @param @param name
	 * @param @return    
	 * @return List<ProductExtend>    
	 * @throws
	 *
	 */
	List<ProductExtend> findByName(String name);
}
