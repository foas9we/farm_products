package com.fos9we.fm.service;

import java.util.List;

import com.fos9we.fm.bean.extend.EvaluateExtend;

/**
 *@ClassName: IEvaluateService
 *@Description: TODO
 * @author Administrator
 *@date 2020年4月23日 下午5:47:24 
 */
public interface IEvaluateService {
	
	/*
	 * 通过农产品id查找所有评论
	 */
	List<EvaluateExtend> findByProductId(long id);
	
}
