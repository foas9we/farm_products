package com.fos9we.fm.bean.extend;

import com.fos9we.fm.bean.Category;
import com.fos9we.fm.bean.Product;
import com.fos9we.fm.bean.User;

/**
 *@ClassName: ProductExtend
 *@Description: 产品扩展类
 * @author Administrator
 *@date 2020年4月23日 上午11:54:14 
 */
public class ProductExtend extends Product{
	private Category category;
	private User user;
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
}
