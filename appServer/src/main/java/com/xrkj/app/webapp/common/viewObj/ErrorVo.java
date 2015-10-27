/**
 * Copyright(C) 2015-2025 杏仁科技
 * All rights reserved
 * 2015年7月16日 Created
 * 
 */
package com.xrkj.app.webapp.common.viewObj;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * 用于显示错误的视图对象
 * </pre>
 *
 * @author wwh
 * @date 2015年6月16日 下午6:02:16
 *
 */
public class ErrorVo {

    public ErrorVo() {
    }

    public ErrorVo(int type, int code) {
        this.eType = type;
        this.eCode = code;
    }

    public ErrorVo(int type, int code, String msg) {
        this.eType = type;
        this.eCode = code;
        this.eMsg = msg;
    }

    /**
     * 错误类型
     */
    private int eType;

    /**
     * 错误代码
     */
    private int eCode;

    /**
     * 错误信息
     */
    private String eMsg;

    /**
     * 错误详情
     */
    private List<ErrorDetail> detail;

    /**
     * 添加一个详情
     * 
     * @param d
     */
    public void addDetail(ErrorDetail d) {
        if (detail == null)
            detail = new ArrayList<ErrorDetail>();
        detail.add(d);
    }

    /**
     * 添加一个详情
     * 
     * @param index
     * @param type
     * @param message
     */
    public void addDetail(int index, String type, String message) {
        addDetail(new ErrorDetail(index, type, message));
    }

    /**
     * 添加一个详情
     * 
     * @param type
     * @param message
     */
    public void addDetail(String type, String message) {
        int index = detail == null ? 1 : detail.size() + 1;
        addDetail(index, type, message);
    }

    /**
     * 获取一个详情
     * 
     * @param index
     * @return
     */
    public ErrorDetail getDetail(int index) {
        if (detail == null)
            return null;
        return detail.get(index);
    }

    /**
     * 获取详情
     * 
     * @return
     */
    public List<ErrorDetail> getDetail() {
        return detail;
    }

    /**
     * 移除详情
     */
    public void removeDetail() {
        this.detail = null;
    }

    public int geteType() {
        return eType;
    }

    public void seteType(int eType) {
        this.eType = eType;
    }

    public int geteCode() {
        return eCode;
    }

    public void seteCode(int eCode) {
        this.eCode = eCode;
    }

    public String geteMsg() {
        return eMsg;
    }

    public void seteMsg(String eMsg) {
        this.eMsg = eMsg;
    }

}
