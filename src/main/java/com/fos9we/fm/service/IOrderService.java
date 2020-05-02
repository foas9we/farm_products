package com.fos9we.fm.service;

import java.util.List;

import com.fos9we.fm.bean.Order;
import com.fos9we.fm.bean.extend.OrderExtend;
import com.fos9we.fm.utils.CustomerException;

/**
 *@ClassName: IOrderService
 *@Description: TODO
 * @author Administrator
 *@date 2020年4月24日 上午9:59:02 
 */
public interface IOrderService {
	/**
	 * 
	 * @Title: createOrder 
	 * @Description: 提交订单
	 * @param @param order
	 * @param @throws CustomerException    
	 * @return void    
	 * @throws
	 *
	 */
	void createOrder(Order order)throws CustomerException;
	
	/**
	 * 
	 * @Title: findByUserId 
	 * @Description: 通过用户id查找所有订单
	 * @param @param id
	 * @param @return    
	 * @return List<OrderExtend>    
	 * @throws
	 *
	 */
	List<OrderExtend> findByUserId(long id);
	/**
	 * 
	 * @Title: cascadeFindAll 
	 * @Description: 查询所有订单信息(级联查询出相关的用户、农产品信息)
	 * @param @return    
	 * @return List<OrderExtend>    
	 * @throws
	 *
	 */
	List<OrderExtend> cascadeFindAll();
	
	/**
	 * 
	 * @Title: deleteById 
	 * @Description: 通过id删除订单
	 * @param @param id    
	 * @return void    
	 * @throws
	 *
	 */
	void deleteById(long id)throws CustomerException;
}
