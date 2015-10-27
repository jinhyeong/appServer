/**
 * Copyright(C) 2015-2025 杏仁科技
 * All rights reserved
 * 2015年7月15日 Created
 * 
 */
package com.xrkj.app.exception;

/**
 * <pre>
 * 输入解析异常
 *  抛出后如果不处理最终会由控制层 ExceptionAdviceHandler 处理，返回JSON对象，400  状态码
 * </pre>
 *
 * @author wwh
 * @date 2015年7月15日 上午11:03:01
 *
 */
public class InputParseException extends BaseException {

    private static final long serialVersionUID = 1L;

    public InputParseException() {
        super();
    }

    public InputParseException(String errorMsg) {
        super(errorMsg);
    }

    public InputParseException(String errorMsg, Throwable cause) {
        super(errorMsg, cause);
    }

    public InputParseException(Throwable cause) {
        super(cause);
    }

    public InputParseException(int errorCode, String errorMsg) {
        super(errorCode, errorMsg);
    }

    public InputParseException(int errorCode, String errorMsg, Throwable cause) {
        super(errorCode, errorMsg, cause);
    }

}
