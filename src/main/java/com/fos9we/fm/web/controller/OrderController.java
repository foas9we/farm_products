package com.fos9we.fm.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fos9we.fm.bean.Order;
import com.fos9we.fm.bean.extend.OrderExtend;
import com.fos9we.fm.service.IOrderService;
import com.fos9we.fm.service.impl.OrderServiceImpl;
import com.fos9we.fm.utils.Message;
import com.fos9we.fm.utils.MessageUtil;

import io.swagger.annotations.ApiOperation;

/**
 *@ClassName: OrderController
 *@Description: TODO
 * @author Administrator
 *@date 2020年4月24日 上午10:08:08 
 */
@Validated
@RestController
@RequestMapping("/Order")
public class OrderController {
	@Autowired
	private IOrderService orderService;
	
	@ApiOperation(value="创建新的订单")
	@PostMapping("createOrder")
	public Message createOrder(Order order) {
		orderService.createOrder(order);
		return MessageUtil.success("创建成功");
	}
	
	@ApiOperation(value="通过用户查找订单")
	@GetMapping("findByUserId")
	public Message findByUserId(long id) {
		List<OrderExtend> findByUserId = orderService.findByUserId(id);
		return MessageUtil.success(findByUserId);
	}
	
	@ApiOperation(value="通过用户查找订单(级联查询出所有相关的用户、农产品信息)")
	@GetMapping("cascadeFindAll")
	public Message cascadeFindAll() {
		List<OrderExtend> cascadeFindAll = orderService.cascadeFindAll();
		return MessageUtil.success(cascadeFindAll);
	}
	
	@ApiOperation(value="通过id删除订单")
	@GetMapping("deleteById")
	public Message deleteById(long id) {
		orderService.deleteById(id);
		return MessageUtil.success("删除成功");
	}
}
