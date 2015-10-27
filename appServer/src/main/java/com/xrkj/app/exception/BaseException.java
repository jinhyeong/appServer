/**
 * Copyright(C) 2015-2025 杏仁科技
 * All rights reserved
 * 2015-06-29 Created
 * 
 */
package com.xrkj.app.exception;

/**
 * <pre>
 * 系统异常基类
 * 暂时先这样
 * </pre>
 *
 * @author wwh
 * @date 2015年6月14日 下午12:25:23
 *
 */
public class BaseException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * 系统错误代码
     */
    private Integer sysErrorCode;
    /**
     * 系统错误信息
     */
    private String sysErrorMsg;

    public BaseException() {
        super();
    }

    public BaseException(String errorMsg) {
        super(errorMsg);
        this.sysErrorMsg = errorMsg;
    }

    public BaseException(String errorMsg, Throwable cause) {
        super(errorMsg, cause);
        this.sysErrorMsg = errorMsg;
    }

    public BaseException(Throwable cause) {
        super(cause);
    }

    public BaseException(int errorCode, String errorMsg) {
        super(errorMsg);
        this.sysErrorCode = errorCode;
        this.sysErrorMsg = errorMsg;
    }

    public BaseException(int errorCode, String errorMsg, Throwable cause) {
        super(errorMsg, cause);
        this.sysErrorCode = errorCode;
        this.sysErrorMsg = errorMsg;
    }

    /**
     * 获取系统错误代码
     * 
     * @return
     */
    public int getSysErrorCode() {

        return sysErrorCode;
    }

    /**
     * 设置系统错误代码
     * 
     * @param sysErrorCode
     */
    public void setSysErrorCode(int sysErrorCode) {
        this.sysErrorCode = sysErrorCode;
    }

    /**
     * 获取系统错误信息
     * 
     * @return
     */
    public String getSysErrorMsg() {
        return sysErrorMsg;
    }

    /**
     * 设置系统错误信息
     * 
     * @param sysErrorMsg
     */
    public void setSysErrorMsg(String sysErrorMsg) {
        this.sysErrorMsg = sysErrorMsg;
    }

    /**
     * 获取描述信息
     * 
     * @return
     */
    public String getDescribe() {
        StringBuffer sbf = new StringBuffer();
        
        String message = getMessage();
        
        if (message != null && !message.equals(sysErrorMsg)) {
            // 如果两个message相同则不显示
            sbf.append(" Message [");
            sbf.append(message);
            sbf.append("]");
        }

        if (sysErrorCode != null) {
            sbf.append(" sysErrorCode [");
            sbf.append(sysErrorCode);
            sbf.append("]");
        }

        if (sysErrorMsg != null) {
            sbf.append(" sysErrorMsg [");
            sbf.append(sysErrorMsg);
            sbf.append("]");
        }

        return sbf.toString();
    }
}
