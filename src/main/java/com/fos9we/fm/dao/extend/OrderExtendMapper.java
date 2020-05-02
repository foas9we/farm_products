package com.fos9we.fm.dao.extend;

import java.util.List;

import com.fos9we.fm.bean.extend.OrderExtend;

/**
 *@ClassName: OrderExtendMapper
 *@Description: TODO
 * @author Administrator
 *@date 2020年4月24日 上午10:49:09 
 */
public interface OrderExtendMapper {
	
	List<OrderExtend> findByUserId(long id);
	
	List<OrderExtend> cascadeFindAll();
}
