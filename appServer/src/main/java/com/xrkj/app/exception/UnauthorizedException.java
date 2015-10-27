/**
 * Copyright(C) 2015-2025 杏仁科技
 * All rights reserved
 * 2015-06-29 Created
 * 
 */
package com.xrkj.app.exception;

import java.util.Date;

/**
 * <pre>
 * 未被授权异常
 * 权限分为 认证 和 授权 两个部分
 * </pre>
 *
 * @author wwh
 * @date 2015年7月24日 下午1:03:02
 *
 */
public class UnauthorizedException extends BaseException {

    private static final long serialVersionUID = 1L;

    public UnauthorizedException() {
        super();
    }

    public UnauthorizedException(String errorMsg) {
        super(errorMsg);
    }

    public UnauthorizedException(String errorMsg, Throwable cause) {
        super(errorMsg, cause);
    }

    public UnauthorizedException(Throwable cause) {
        super(cause);
    }

    public UnauthorizedException(int errorCode, String errorMsg) {
        super(errorCode, errorMsg);
    }

    public UnauthorizedException(int errorCode, String errorMsg, Throwable cause) {
        super(errorCode, errorMsg, cause);
    }

    // 时间
    private Date time;
    // 人
    private String userID;
    // 请求的资源
    private String URI;
    // 请求参数信息
    private Object[] parameters;
    // 原因
    private String reason;

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getURI() {
        return URI;
    }

    public void setURI(String uRI) {
        URI = uRI;
    }

    public Object[] getParameters() {
        return parameters;
    }

    public void setParameters(Object... parameters) {
        this.parameters = parameters;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

}
