package com.fos9we.fm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fos9we.fm.bean.Product;
import com.fos9we.fm.bean.ProductExample;
import com.fos9we.fm.bean.extend.ProductExtend;
import com.fos9we.fm.dao.ProductMapper;
import com.fos9we.fm.dao.extend.ProductExtendMapper;
import com.fos9we.fm.service.IProductService;
import com.fos9we.fm.utils.CustomerException;

/**
 *@ClassName: ProductServiceImpl
 *@Description: TODO
 * @author Administrator
 *@date 2020年4月23日 下午12:47:27 
 */
@Service
public class ProductServiceImpl implements IProductService{
	@Resource
	private ProductExtendMapper productExtendMapper;
	@Resource
	private ProductMapper productMapper;
	@Override
	public List<ProductExtend> findAllProduct() {
		return  productExtendMapper.findAllProduct();
	}
	
	@Override
	public List<ProductExtend> findProductByCategory(long id) {
		return productExtendMapper.findProductByCategory(id);
	}

	@Override
	public ProductExtend findById(long id) {
		return productExtendMapper.findById(id);
	}

	@Override
	public void saveOrUpdateProduct(Product product) {
		if(product.getId()!=null) {
//			productMapper.updateByPrimaryKey(product);
			productMapper.updateByPrimaryKeySelective(product);
		}else {
//			productMapper.insert(product);
			productMapper.insertSelective(product);
		}
	}
  
	@Override
	public List<Product> findAll() {
		return productMapper.selectByExample(new ProductExample());
	}

	@Override
	public void deleteById(long id) throws CustomerException {
		Product selectByPrimaryKey = productMapper.selectByPrimaryKey(id);
		if(selectByPrimaryKey==null) {
			throw new CustomerException("该商品不存在");
		}
		productMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<ProductExtend> findByName(String name) {
		List<ProductExtend> findByName = productExtendMapper.findByName(name);
		return findByName;
	}

	@Override
	public List<ProductExtend> findAllSupply() {
		List<ProductExtend> findAllSupply = productExtendMapper.findAllSupply();
		return findAllSupply;
	}

	@Override
	public List<ProductExtend> findByNameDemand(String name) {
		List<ProductExtend> findByNameDemand = productExtendMapper.findByNameDemand(name);
		return findByNameDemand;
	}

	@Override
	public List<ProductExtend> findDemandByCategory(long id) {
		List<ProductExtend> findDemandByCategory = productExtendMapper.findDemandByCategory(id);
		return findDemandByCategory;
	}

	

}
