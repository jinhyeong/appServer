/**
 * Copyright(C) 2015-2025 杏仁科技
 * All rights reserved
 * 2015年7月16日 Created
 * 
 */
package com.xrkj.app.webapp.common.viewObj;

/**
 * <pre>
 * 错误详情
 * </pre>
 *
 * @author wwh
 * @date 2015年7月16日 下午6:28:09
 *
 */
public class ErrorDetail {

    /**
     * 索引
     */
    private int index;
    
    /**
     *类型 
     */
    private String type;
    
    /**
     * 消息
     */
    private String message;

    public ErrorDetail() {
    }

    public ErrorDetail(int index, String type, String message) {
        this.index = index;
        this.type = type;
        this.message = message;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
