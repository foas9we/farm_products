package com.fos9we.fm.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fos9we.fm.bean.Evaluate;
import com.fos9we.fm.bean.EvaluateExample;
import com.fos9we.fm.bean.Product;
import com.fos9we.fm.bean.User;
import com.fos9we.fm.bean.extend.EvaluateExtend;
import com.fos9we.fm.dao.EvaluateMapper;
import com.fos9we.fm.dao.ProductMapper;
import com.fos9we.fm.dao.UserMapper;
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
	@Resource
	private UserMapper userMapper;
	@Resource
	private ProductMapper productMapper;
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
		Evaluate evaluate = evaluateMapper.selectByPrimaryKey(id);
		if(evaluate==null) {
			throw new CustomerException("该评论不存在");
		}
		EvaluateExample example = new EvaluateExample();
		example.createCriteria().andIdEqualTo(id);
		evaluateMapper.deleteByExample(example);
	}
	@Override
	public List<EvaluateExtend> cascadeFindAll() {
		List<EvaluateExtend> cascadeFindAll = evaluateExtendMapper.cascadeFindAll();
		return cascadeFindAll;
	}
	@Override
	public void insert(Evaluate evaluate)throws CustomerException {
		if(evaluate.getContent()==null) {
			throw new CustomerException("评论内容不能为空");
		}
		if(evaluate.getUserId()==null) {
			throw new CustomerException("用户不能为空");
		}
		Product product = productMapper.selectByPrimaryKey(evaluate.getProductId());
		if(product==null) {
			throw new CustomerException("该产品已被下架，不能评论");
		}
		evaluate.setDate(new Date().getTime());//设置评论时间
		evaluateMapper.insertSelective(evaluate);
	}

}
