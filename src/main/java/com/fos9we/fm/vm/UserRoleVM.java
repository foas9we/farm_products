package com.fos9we.fm.vm;

import java.util.List;

/**
 *@ClassName: RoleVM
 *@Description: TODO
 * @author Administrator
 *@date 2020年4月29日 下午5:41:25 
 */
public class UserRoleVM {
	private long id;
	private List<Long> roles;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public List<Long> getRoles() {
		return roles;
	}
	public void setRoles(List<Long> roles) {
		this.roles = roles;
	}
	
	
}
