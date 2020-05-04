package com.fos9we.fm.dao.extend;

import java.util.List;

import com.fos9we.fm.bean.Privilege;
import com.fos9we.fm.bean.extend.PrivilegeExtend;

/**
 *@ClassName: PrivilegeExtendMapper
 *@Description: TODO
 * @author Administrator
 *@date 2020年4月30日 上午9:17:14 
 */
public interface PrivilegeExtendMapper {
	
	List<PrivilegeExtend> findAllWithChildren();
	
	List<PrivilegeExtend> findByParentId(long id);
}
