package com.fos9we.fm.web.listener;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 *@ClassName: myListener
 *@Description: 监听器，辅助完成供应界面初始化
 * @author Administrator
 *@date 2020年4月21日 上午11:27:11 
 */
@Component
public class myListener implements ApplicationListener<ApplicationReadyEvent>{

	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
//		System.out.println("Spring监听事件启动");
	}
}
