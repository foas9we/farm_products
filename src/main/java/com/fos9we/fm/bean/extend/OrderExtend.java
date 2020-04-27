package com.fos9we.fm.bean.extend;

import com.fos9we.fm.bean.Order;
import com.fos9we.fm.bean.Product;
import com.fos9we.fm.bean.User;

/**
 *@ClassName: OrderExtend
 *@Description: TODO
 * @author Administrator
 *@date 2020年4月23日 下午10:52:57 
 */
public class OrderExtend extends Order{
	
	private Product product;
	private User user;
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
}
