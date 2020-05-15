package com.fos9we.fm.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fos9we.fm.bean.Evaluate;
import com.fos9we.fm.bean.extend.EvaluateExtend;
import com.fos9we.fm.service.IEvaluateService;
import com.fos9we.fm.service.impl.EvaluateServiceImpl;
import com.fos9we.fm.utils.Message;
import com.fos9we.fm.utils.MessageUtil;

import io.swagger.annotations.ApiOperation;

/**
 *@ClassName: EvaluateController
 *@Description: 评论拓展控制类
 * @author Administrator
 *@date 2020年4月23日 下午10:29:01 
 */
@Validated
@RestController
@RequestMapping("/evaluate")
public class EvaluateController {
	@Autowired
	private IEvaluateService evaluateService;
	
	@ApiOperation(value="通过农产品id查找评论")
	@GetMapping("findByProductId")
	public Message findByProductId(long id){
		List<EvaluateExtend> findByProductId = evaluateService.findByProductId(id); 
		return MessageUtil.success(findByProductId);
	}
	  
	@ApiOperation(value="查找所有评论")
	@GetMapping("findAll")
	public Message findAll(){
		List<Evaluate> findAll = evaluateService.findAll(); 
		return MessageUtil.success(findAll);
	}
	
	@ApiOperation(value="通过id删除评论")
	@GetMapping("deleteById")
	public Message deleteById(long id){
		evaluateService.deleteById(id);
		return MessageUtil.success("删除成功");
	}
	
	@ApiOperation(value="级联查找所有评论以及关联用户信息")
	@GetMapping("cascadeFindAll")
	public Message cascadeFindAll(){
		List<EvaluateExtend> cascadeFindAll = evaluateService.cascadeFindAll();
		return MessageUtil.success(cascadeFindAll);
	}
}
