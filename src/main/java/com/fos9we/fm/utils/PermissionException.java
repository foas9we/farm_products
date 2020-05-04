package com.fos9we.fm.utils;
import com.fos9we.fm.utils.CustomerException;

/**
 * 
 *@ClassName: PermissionException
 *@Description: 权限异常
 * @author Administrator
 *@date 2020年5月3日 上午11:27:01
 */
public class PermissionException extends CustomerException {
    public PermissionException() {
    }

    public PermissionException(String message) {
        super(message);
    }

    public PermissionException(String message, Throwable cause) {
        super(message, cause);
    }

    public PermissionException(Throwable cause) {
        super(cause);
    }

    public PermissionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
