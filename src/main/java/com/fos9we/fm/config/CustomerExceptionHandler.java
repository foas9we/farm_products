package com.fos9we.fm.config;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.fos9we.fm.utils.CustomerException;
import com.fos9we.fm.utils.Message;
import com.fos9we.fm.utils.MessageUtil;

/**
 *@ClassName: CustomerExceptionHandler
 *@Description:统一异常处理类
 * @author Administrator
 *@date 2020年4月25日 上午11:03:27 
 */
@RestControllerAdvice
public class CustomerExceptionHandler {
	@ExceptionHandler(value =  Exception.class) // 捕获 Controller 中抛出的指定类型的异常，也可以指定其他异常
    public <E> Message handler(Exception exception){
        exception.printStackTrace();
        
        if(exception instanceof CustomerException){
            return MessageUtil.error(exception.getMessage());
        }
        return MessageUtil.error("后台接口异常！");
    }
}
