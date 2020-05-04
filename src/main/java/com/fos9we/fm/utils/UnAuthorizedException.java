package com.fos9we.fm.utils;

import com.fos9we.fm.utils.CustomerException;

/**
 * 
 *@ClassName: UnAuthorizedException
 *@Description: 未授权异常
 * @author Administrator
 *@date 2020年5月3日 上午11:27:44
 */
public class UnAuthorizedException extends CustomerException {
    public UnAuthorizedException() {
    }

    public UnAuthorizedException(String message) {
        super(message);
    }

    public UnAuthorizedException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnAuthorizedException(Throwable cause) {
        super(cause);
    }

    public UnAuthorizedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
