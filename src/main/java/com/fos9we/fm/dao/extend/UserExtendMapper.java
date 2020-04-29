package com.fos9we.fm.dao.extend;

import java.util.List;

import com.fos9we.fm.bean.extend.UserExtend;

/**
 *@ClassName: UserExtendMapper
 *@Description: TODO
 * @author Administrator
 *@date 2020年4月28日 下午6:26:31 
 */
public interface UserExtendMapper {
	
	UserExtend findUserExtendById(long id);
	
	List<UserExtend> findAllWithRole();
}
