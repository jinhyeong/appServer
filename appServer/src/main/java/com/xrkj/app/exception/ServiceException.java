/**
 * Copyright(C) 2015-2025 杏仁科技
 * All rights reserved
 * 2015-06-29 Created
 * 
 */
package com.xrkj.app.exception;

/**
 * <pre>
 * 服务层异常
 * DAO层不处理异常，所有异常抛出由服务层处理
 * 服务层决定包装成运行时异常 或 抛出由控制层感知
 * </pre>
 *
 * @author wwh
 * @date 2015年6月24日 下午12:16:40
 *
 */
public class ServiceException extends BaseException {

    private static final long serialVersionUID = -5053122101118109878L;

    public ServiceException() {
        super();
    }

    public ServiceException(String errorMsg) {
        super(errorMsg);
    }

    public ServiceException(String errorMsg, Throwable cause) {
        super(errorMsg, cause);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

    public ServiceException(int errorCode, String errorMsg) {
        super(errorCode, errorMsg);
    }

    public ServiceException(int errorCode, String errorMsg, Throwable cause) {
        super(errorCode, errorMsg, cause);
    }

}
