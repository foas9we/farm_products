package com.fos9we.fm.bean.extend;

import com.fos9we.fm.bean.Evaluate;
import com.fos9we.fm.bean.User;

/**
 *@ClassName: EvaluteExtend
 *@Description: 评论拓展类，封装用户信息
 * @author Administrator
 *@date 2020年4月23日 下午5:55:17 
 */
public class EvaluateExtend extends Evaluate{
	
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
