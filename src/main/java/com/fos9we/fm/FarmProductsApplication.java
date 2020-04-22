package com.fos9we.fm;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@MapperScan("com.fos9we.fm.dao")             
public class FarmProductsApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(FarmProductsApplication.class);
    }
	public static void main(String[] args) {
		SpringApplication.run(FarmProductsApplication.class, args);
	}

}
                                                                                                                                            