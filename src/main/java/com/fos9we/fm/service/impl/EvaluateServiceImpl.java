package com.fos9we.fm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fos9we.fm.bean.extend.EvaluateExtend;
import com.fos9we.fm.dao.extend.EvaluateExtendMapper;
import com.fos9we.fm.service.IEvaluateService;

/**
 *@ClassName: EvaluateServiceImpl
 *@Description: TODO
 * @author Administrator
 *@date 2020年4月23日 下午5:47:50 
 */ 
@Service
public class EvaluateServiceImpl implements IEvaluateService{
	@Resource
	private EvaluateExtendMapper evaluateExtendMapper;
	@Override
	public List<EvaluateExtend> findByProductId(long id) {
		return evaluateExtendMapper.findByProductId(id);
	}

}
