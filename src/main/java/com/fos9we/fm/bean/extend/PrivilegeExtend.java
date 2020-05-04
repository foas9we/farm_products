package com.fos9we.fm.bean.extend;

import java.util.List;

import com.fos9we.fm.bean.Privilege;

/**
 *@ClassName: PrivilegeExtend
 *@Description: TODO
 * @author Administrator
 *@date 2020年4月30日 上午9:15:22 
 */
public class PrivilegeExtend extends Privilege{
	
	private List<Privilege> children;

	public List<Privilege> getChildren() {
		return children;
	}

	public void setChildren(List<Privilege> children) {
		this.children = children;
	}
	
	
}
