package com.fos9we.fm.dao.extend;

import java.util.List;

import com.fos9we.fm.bean.Privilege;

/**
 *@ClassName: RolePrivilegeExtendMapper
 *@Description: TODO
 * @author Administrator
 *@date 2020年4月29日 下午7:36:05 
 */
public interface RolePrivilegeExtendMapper {
	
	List<Privilege> findByRoleId(long id);
}
