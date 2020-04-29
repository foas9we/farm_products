package com.fos9we.fm.bean.extend;

import java.util.List;

import com.fos9we.fm.bean.Privilege;
import com.fos9we.fm.bean.Role;

/**
 *@ClassName: RoleExtend
 *@Description: TODO
 * @author Administrator
 *@date 2020年4月29日 下午7:17:23 
 */
public class RoleExtend extends Role{
	private List<Privilege> privilege;

	public List<Privilege> getPrivilege() {
		return privilege;
	}

	public void setPrivilege(List<Privilege> privilege) {
		this.privilege = privilege;
	}
	
	
}
