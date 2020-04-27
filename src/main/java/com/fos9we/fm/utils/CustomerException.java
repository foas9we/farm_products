package com.fos9we.fm.utils;

/**
 *@ClassName: CustomerException
 *@Description: 自定义异常类
 * @author Administrator
 *@date 2020年4月25日 上午11:01:45 
 */
public class CustomerException extends RuntimeException{

	public CustomerException() {
    }

    public CustomerException(String message) {
        super(message);
    }

    public CustomerException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomerException(Throwable cause) {
        super(cause);
    }

    public CustomerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
