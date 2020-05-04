package com.fos9we.fm.vm;

import java.util.List;

/**
 *@ClassName: RolePrivilegeVM
 *@Description: 拓展类，用于给角色设置权限
 * @author Administrator
 *@date 2020年5月1日 下午9:13:04 
 */
public class RolePrivilegeVM {
	private long id;
	private List<Long> privilege;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public List<Long> getPrivilege() {
		return privilege;
	}
	public void setPrivilege(List<Long> privilege) {
		this.privilege = privilege;
	}
	
	
	
}	
