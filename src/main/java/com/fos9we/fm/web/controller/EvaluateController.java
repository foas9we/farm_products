package com.fos9we.fm.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	@GetMapping("findByCategory")
	public Message findByProductId(long id){
		List<EvaluateExtend> findByProductId = evaluateService.findByProductId(id); 
		return MessageUtil.success(findByProductId);
	}
	
}
