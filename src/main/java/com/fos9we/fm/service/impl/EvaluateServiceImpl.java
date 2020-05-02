package com.fos9we.fm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fos9we.fm.bean.Evaluate;
import com.fos9we.fm.bean.EvaluateExample;
import com.fos9we.fm.bean.extend.EvaluateExtend;
import com.fos9we.fm.dao.EvaluateMapper;
import com.fos9we.fm.dao.extend.EvaluateExtendMapper;
import com.fos9we.fm.service.IEvaluateService;
import com.fos9we.fm.utils.CustomerException;

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
	@Resource
	private EvaluateMapper evaluateMapper;
	@Override
	public List<EvaluateExtend> findByProductId(long id) {
		return evaluateExtendMapper.findByProductId(id);
	}
	@Override
	public List<Evaluate> findAll() {
		EvaluateExample example = new EvaluateExample();
		List<Evaluate> selectByExample = evaluateMapper.selectByExampleWithBLOBs(example);
		return selectByExample;
	}
	@Override
	public void deleteById(long id) throws CustomerException {
		EvaluateExample example = new EvaluateExample();
		example.createCriteria().andIdEqualTo(id);
		evaluateMapper.deleteByExample(example);
	}
	@Override
	public List<EvaluateExtend> cascadeFindAll() {
		List<EvaluateExtend> cascadeFindAll = evaluateExtendMapper.cascadeFindAll();
		return cascadeFindAll;
	}

}
