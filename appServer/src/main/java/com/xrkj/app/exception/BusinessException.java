/**
 * Copyright(C) 2015-2025 杏仁科技
 * All rights reserved
 * 2015-06-29 Created
 * 
 */
package com.xrkj.app.exception;

/**
 * <pre>
 * 业务异常
 * 抛出后如果不处理最终会由控制层 ExceptionAdviceHandler 处理，返回JSON对象，500 状态码
 * </pre>
 *
 * @author wwh
 * @date 2015年6月24日 下午12:21:20
 *
 */
public class BusinessException extends BaseException {

    private static final long serialVersionUID = 1L;

    public BusinessException() {
        super();
    }

    public BusinessException(String errorMsg) {
        super(errorMsg);
    }

    public BusinessException(String errorMsg, Throwable cause) {
        super(errorMsg, cause);
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

    public BusinessException(int errorCode, String errorMsg) {
        super(errorCode, errorMsg);
    }

    public BusinessException(int errorCode, String errorMsg, Throwable cause) {
        super(errorCode, errorMsg, cause);
    }
}
