/**
 * Copyright(C) 2015-2025 杏仁科技
 * All rights reserved
 * 2015-08-11 Created
 */
package com.xrkj.app.comm.model;

import com.xrkj.app.base.model.BaseEntity;
import java.io.Serializable;
import java.util.Date;

public class Logging extends BaseEntity implements Serializable {
    /**
     * <pre>
     * ID主键
     * 表字段 : logging.logid
     * </pre>
     */
    private Long logid;

    /**
     * <pre>
     * 类型
     * 表字段 : logging.type
     * </pre>
     */
    private String type;

    /**
     * <pre>
     * 用户ID
     * 表字段 : logging.userid
     * </pre>
     */
    private String userid;

    /**
     * <pre>
     * 时间
     * 表字段 : logging.time
     * </pre>
     */
    private Date time;

    /**
     * <pre>
     * 级别
     * 表字段 : logging.priority
     * </pre>
     */
    private Integer priority;

    /**
     * <pre>
     * 日志内容
     * 表字段 : logging.message
     * </pre>
     */
    private String message;

    private static final long serialVersionUID = 1L;

    /**
     * <pre>
     * 获取：ID主键
     * 表字段：logging.logid
     * </pre>
     *
     * @return logging.logid：ID主键
     */
    public Long getLogid() {
        return logid;
    }

    /**
     * <pre>
     * 设置：ID主键
     * 表字段：logging.logid
     * </pre>
     *
     * @param logid
     *            logging.logid：ID主键
     */
    public void setLogid(Long logid) {
        this.logid = logid;
    }

    /**
     * <pre>
     * 获取：类型
     * 表字段：logging.type
     * </pre>
     *
     * @return logging.type：类型
     */
    public String getType() {
        return type;
    }

    /**
     * <pre>
     * 设置：类型
     * 表字段：logging.type
     * </pre>
     *
     * @param type
     *            logging.type：类型
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * <pre>
     * 获取：用户ID
     * 表字段：logging.userid
     * </pre>
     *
     * @return logging.userid：用户ID
     */
    public String getUserid() {
        return userid;
    }

    /**
     * <pre>
     * 设置：用户ID
     * 表字段：logging.userid
     * </pre>
     *
     * @param userid
     *            logging.userid：用户ID
     */
    public void setUserid(String userid) {
        this.userid = userid;
    }

    /**
     * <pre>
     * 获取：时间
     * 表字段：logging.time
     * </pre>
     *
     * @return logging.time：时间
     */
    public Date getTime() {
        return time;
    }

    /**
     * <pre>
     * 设置：时间
     * 表字段：logging.time
     * </pre>
     *
     * @param time
     *            logging.time：时间
     */
    public void setTime(Date time) {
        this.time = time;
    }

    /**
     * <pre>
     * 获取：级别
     * 表字段：logging.priority
     * </pre>
     *
     * @return logging.priority：级别
     */
    public Integer getPriority() {
        return priority;
    }

    /**
     * <pre>
     * 设置：级别
     * 表字段：logging.priority
     * </pre>
     *
     * @param priority
     *            logging.priority：级别
     */
    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    /**
     * <pre>
     * 获取：日志内容
     * 表字段：logging.message
     * </pre>
     *
     * @return logging.message：日志内容
     */
    public String getMessage() {
        return message;
    }

    /**
     * <pre>
     * 设置：日志内容
     * 表字段：logging.message
     * </pre>
     *
     * @param message
     *            logging.message：日志内容
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     *
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", logid=").append(logid);
        sb.append(", type=").append(type);
        sb.append(", userid=").append(userid);
        sb.append(", time=").append(time);
        sb.append(", priority=").append(priority);
        sb.append(", message=").append(message);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}