package com.fos9we.fm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fos9we.fm.bean.Order;
import com.fos9we.fm.bean.OrderExample;
import com.fos9we.fm.bean.extend.OrderExtend;
import com.fos9we.fm.dao.OrderMapper;
import com.fos9we.fm.dao.extend.OrderExtendMapper;
import com.fos9we.fm.service.IOrderService;
import com.fos9we.fm.utils.CustomerException;

/**
 *@ClassName: OrderServiceImpl
 *@Description: TODO
 * @author Administrator
 *@date 2020年4月24日 上午10:00:34 
 */
@Service
public class OrderServiceImpl implements IOrderService{
	@Resource
	private OrderMapper orderMapper;
	@Resource
	private OrderExtendMapper orderExtendMapper;
	
	@Override
	public void createOrder(Order order) {
		orderMapper.insertSelective(order);
	}

	@Override
	public List<OrderExtend> findByUserId(long id) {
		return orderExtendMapper.findByUserId(id);
	}

	@Override
	public List<OrderExtend> cascadeFindAll() {
		return orderExtendMapper.cascadeFindAll();
	}

	@Override
	public void deleteById(long id)throws CustomerException {
		Order order = orderMapper.selectByPrimaryKey(id);
		if(order==null) {
			throw new CustomerException("该订单不存在");
		}
		OrderExample example = new OrderExample();
		example.createCriteria().andIdEqualTo(id);
		orderMapper.deleteByExample(example);
		
	}
	

}
