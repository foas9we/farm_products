package com.fos9we.fm.dao.extend;

import java.util.List;

import com.fos9we.fm.bean.extend.EvaluateExtend;

/**
 *@ClassName: EvaluateExtendMapper
 *@Description: 评论拓展Mapper
 * @author Administrator
 *@date 2020年4月23日 下午9:54:02 
 */
public interface EvaluateExtendMapper {
	
	List<EvaluateExtend> findByProductId(long id);
	
	List<EvaluateExtend> cascadeFindAll();
	
}
