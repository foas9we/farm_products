package com.fos9we.fm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *@ClassName: WebConfig
 *@Description: 自定义配置静态资源配置类
 * @author Administrator
 *@date 2020年4月25日 上午11:12:42 
 */
@Configuration
public class WebConfig implements WebMvcConfigurer{
	/**
	 * @Title: jwtInterceptor 
	 * @Description: 将拦截器作为bean写入
	 * @param @return    
	 * @return HandlerInterceptor    
	 * @throws
	 * 
	 */
	@Bean
	public JwtInterceptor jwtInterceptor() {
		return new JwtInterceptor();
	}
	
	public void addInterceptors(InterceptorRegistry registry) {
		//拦截路径可以配置多个，使用逗号分隔开
		registry.addInterceptor(jwtInterceptor())
		.addPathPatterns("/**")
		.excludePathPatterns(
				"/swagger-resources/**","/v2/**","/swagger-ui.html","/webjars/**",
				"/vue-element-admin/user/login","/vue-element-admin/user/logout"
				);
	}
	
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
