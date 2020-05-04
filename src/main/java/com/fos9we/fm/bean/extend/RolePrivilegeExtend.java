package com.fos9we.fm.bean.extend;

import java.util.List;

import com.fos9we.fm.bean.Privilege;

/**
 *@ClassName: RolePrivilegeExtend
 *@Description: TODO
 * @author Administrator
 *@date 2020年5月4日 上午10:17:15 
 */
public class RolePrivilegeExtend {
	private long roleId;
	private List<Privilege> privilege;
	public long getRoleId() {
		return roleId;
	}
	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}
	public List<Privilege> getPrivilege() {
		return privilege;
	}
	public void setPrivilege(List<Privilege> privilege) {
		this.privilege = privilege;
	}
	
	
}
