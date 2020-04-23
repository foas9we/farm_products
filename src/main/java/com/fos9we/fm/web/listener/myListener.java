package com.fos9we.fm.web.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.fos9we.fm.service.IProductService;

/**
 *@ClassName: myListener
 *@Description: 监听器，辅助完成供应界面初始化
 * @author Administrator
 *@date 2020年4月21日 上午11:27:11 
 */
@Component
public class myListener implements ApplicationListener<ApplicationReadyEvent>{
	@Autowired
	private IProductService productService;
	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
//		productService.findAllProduct();//在项目启动的时候将商品的信息查询查来，但是还不知道如何交给前端
	}
}
