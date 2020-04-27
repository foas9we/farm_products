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
	/*
	 * 提交订单
	 */
	void createOrder(Order order)throws CustomerException;
	
	/*
	 * 通过用户id查找所有订单
	 */
	List<OrderExtend> findByUserId(long id);
}
