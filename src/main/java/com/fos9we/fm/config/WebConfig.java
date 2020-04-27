package com.fos9we.fm.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *@ClassName: WebConfig
 *@Description: 自定义配置静态资源配置类
 * @author Administrator
 *@date 2020年4月25日 上午11:12:42 
 */
@Configuration
public class WebConfig implements WebMvcConfigurer{
	
	//跨域支持
	@Override
	public void addCorsMappings(CorsRegistry registry) {

		registry.addMapping("/**")
				.allowedOrigins("*")
				.allowedMethods("GET","POST","PUT","OPTIONS","DELETE","PATCH")
				.allowedHeaders("*")
				.allowCredentials(true)
				.maxAge(3600);
	}
}
