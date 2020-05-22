package com.fos9we.fm.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fos9we.fm.bean.Product;
import com.fos9we.fm.bean.extend.ProductExtend;
import com.fos9we.fm.service.IProductService;
import com.fos9we.fm.utils.Message;
import com.fos9we.fm.utils.MessageUtil;

import io.swagger.annotations.ApiOperation;

/**
 *@ClassName: ProductController
 *@Description: 产品控制类
 * @author Administrator
 *@date 2020年4月23日 下午1:58:52 
 */
@Validated
@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private IProductService productService;
	
	@ApiOperation(value="查询所有农产品信息")
	@GetMapping("findAllProduct")
	public Message findAllProduct(){
		List<ProductExtend> list = productService.findAllProduct();
		return MessageUtil.success(list);
		
	}
	
	@ApiOperation(value="通过栏目id查找农产品信息")
	@GetMapping("findByCategory")
	public Message findProductByCategory(long id){
		List<ProductExtend> list = productService.findProductByCategory(id);
		return MessageUtil.success(list);
		
	}
	
	@ApiOperation(value="通过农产品编号查到农产品信息和供应商信息")
	@GetMapping("findById")
	public Message findById(long id){
		ProductExtend findById = productService.findById(id);
		return MessageUtil.success(findById);
		
	}
	
	@ApiOperation(value="发布或者更新农产品信息")
	@PostMapping("saveOrUpdateProduct")
	public Message saveOrUpdateProduct(Product product){
		productService.saveOrUpdateProduct(product);;
		return MessageUtil.success("更新成功");
		 
	}
	
	@ApiOperation(value="简单的查询所有的农产品基本信息")
	@GetMapping("findAll")
	public Message findAll() {
		List<Product> findAll = productService.findAll();
		return MessageUtil.success(findAll);
	}
	
	@ApiOperation(value="通过id删除农产品基本信息")
	@GetMapping("deleteById")
	public Message deleteById(long id) {
		productService.deleteById(id);
		return MessageUtil.success("删除成功");
		 		
	}
	
	@ApiOperation(value="通过产品名字模糊查询")
	@GetMapping("findByName")
	public Message findByName(String name) {
		List<ProductExtend> findByName = productService.findByName(name);
		return MessageUtil.success(findByName);
		 		
	}
	
	@ApiOperation(value="级联查询所有采购信息")
	@GetMapping("findAllSupply")
	public Message findAllSupply() {
		List<ProductExtend> findAllSupply = productService.findAllSupply();
		return MessageUtil.success(findAllSupply);
	}
	
	@ApiOperation(value="按照名字级联模糊查询采购信息")
	@GetMapping("findByNameDemand")
	public Message findByNameDemand(String name) {
		List<ProductExtend> findByNameDemand = productService.findByNameDemand(name);
		return MessageUtil.success(findByNameDemand);
	}
	
	@ApiOperation(value="通过栏目查找采购信息")
	@GetMapping("findDemandByCategory")
	public Message findDemandByCategory(long id) {
		List<ProductExtend> findDemandByCategory = productService.findDemandByCategory(id);
		return MessageUtil.success(findDemandByCategory);
	}
}
