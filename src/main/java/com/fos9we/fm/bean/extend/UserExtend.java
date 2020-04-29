package com.fos9we.fm.bean.extend;

import java.util.List;

import com.fos9we.fm.bean.Role;
import com.fos9we.fm.bean.User;

/**
 *@ClassName: UserExtend
 *@Description: TODO
 * @author Administrator
 *@date 2020年4月28日 下午6:20:10 
 */
public class UserExtend extends User{
	public static final String STATUS_NORMAL="正常";
	public static final String STATUS_FORBIDDEN="禁用";
	
	private List<Role> roles;

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	
}
