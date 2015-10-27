/**
 * Copyright(C) 2015-2025 杏仁科技
 * All rights reserved
 * 2015-06-29 Created
 * 
 */
package com.xrkj.app.exception;

/**
 * <pre>
 * 视图层异常
 * rest
 * </pre>
 *
 * @author wwh
 * @date 2015年6月24日 下午12:18:15
 *
 */
public class ViewException extends BaseException {

    private static final long serialVersionUID = 8017498743920512016L;

    public ViewException() {
        super();
    }

    public ViewException(String errorMsg) {
        super(errorMsg);
    }

    public ViewException(String errorMsg, Throwable cause) {
        super(errorMsg, cause);
    }

    public ViewException(Throwable cause) {
        super(cause);
    }

    public ViewException(int errorCode, String errorMsg) {
        super(errorCode, errorMsg);
    }

    public ViewException(int errorCode, String errorMsg, Throwable cause) {
        super(errorCode, errorMsg, cause);
    }
}
