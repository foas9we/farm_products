package com.fos9we.fm.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fos9we.fm.bean.Category;
import com.fos9we.fm.bean.extend.CategoryExtend;
import com.fos9we.fm.service.ICategoryService;
import com.fos9we.fm.utils.Message;
import com.fos9we.fm.utils.MessageUtil;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;



/**
 *@ClassName: CategoryController
 *@Description: TODO
 * @author Administrator
 *@date 2020年4月27日 下午7:57:38 
 */
@Validated
@RestController
@RequestMapping("/category")
public class CategoryController {
	@Autowired
	private ICategoryService categoryService;
	@ApiOperation(value="查找所有栏目")
	@GetMapping("findAll")
	public Message findAll(){
		List<Category> findAll = categoryService.findAll();
		return MessageUtil.success(findAll);
	}
	
	@ApiOperation(value="添加或者修改栏目")
	@PostMapping("saveOrUpdate")
	public Message saveOrUpdate(Category category) {
		categoryService.saveOrUpdate(category);
		return MessageUtil.success("更新成功");
	} 
	
	@ApiOperation(value="通过id删除栏目") 
	@GetMapping("deleteById")
	public Message deleteById(long id) {
		categoryService.deleteById(id);
		return MessageUtil.success("删除成功");
	}
	
	@ApiOperation(value="批量删除栏目")
	@PostMapping("batchDelete")
	public Message batchDelete(@RequestBody long[] ids) {
		categoryService.batchDelete(ids);
		return MessageUtil.success("批量删除成功"); 
	}
	
	@ApiOperation(value="级联查询栏目")
	@GetMapping("cascodeFindAll")
	public Message cascodeFindAll() {
		List<CategoryExtend> cascodeFindAll = categoryService.cascodeFindAll();
		return MessageUtil.success(cascodeFindAll); 
	}
}
