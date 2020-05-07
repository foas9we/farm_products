package com.fos9we.fm.dao.extend;

import java.util.List;

import com.fos9we.fm.bean.extend.ProductExtend;

/**
 *@ClassName: ProductExtendMapper
 *@Description: TODO
 * @author Administrator
 *@date 2020年4月23日 下午12:00:35 
 */
public interface ProductExtendMapper {
	/**
	 * 
	 * @Title: findAllProduct 
	 * @Description: 连带查询出所有的商品信息 
	 * @param @return    
	 * @return List<ProductExtend>    
	 * @throws
	 *
	 */
    List<ProductExtend> findAllProduct();
    
    /**
     * 
     * @Title: findProductByCategory 
     * @Description: 通过栏目找到农产品 
     * @param @param id
     * @param @return    
     * @return List<ProductExtend>    
     * @throws
     *
     */
    List<ProductExtend> findProductByCategory(long id);
    
    /**
     * 
     * @Title: findById 
     * @Description: 通过商品的编号查到商品信息和供应商信息
     * @param @param id
     * @param @return    
     * @return ProductExtend    
     * @throws
     *
     */
    ProductExtend  findById(long id);
    /**
     * 
     * @Title: findByName 
     * @Description: 根据农产品的名字搜索
     * @param @param name
     * @param @return    
     * @return List<ProductExtend>    
     * @throws
     *
     */
    List<ProductExtend> findByName(String name);
}
