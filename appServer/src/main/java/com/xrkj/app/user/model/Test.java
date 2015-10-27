/**
 * Copyright(C) 2015-2025 杏仁科技
 * All rights reserved
 * 2015-06-11 Created
 * 
 */
package com.xrkj.app.user.model;

import java.io.Serializable;

public class Test implements Serializable {
    /**
     * <pre>
     * 主键
     * 表字段 : test.id
     * </pre>
     */
    private Long id;

    /**
     * <pre>
     * 姓名
     * 表字段 : test.name
     * </pre>
     */
    private String name;

    /**
     * <pre>
     * 密码
     * 表字段 : test.pwd
     * </pre>
     */
    private String pwd;

    /**
     * <pre>
     * temp 字段
     * 表字段 : test.t1
     * </pre>
     */
    private String t1;

    private static final long serialVersionUID = 1L;

    /**
     * <pre>
     * 获取：主键
     * 表字段：test.id
     * </pre>
     *
     * @return test.id：主键
     */
    public Long getId() {
        return id;
    }

    /**
     * <pre>
     * 设置：主键
     * 表字段：test.id
     * </pre>
     *
     * @param id
     *            test.id：主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * <pre>
     * 获取：姓名
     * 表字段：test.name
     * </pre>
     *
     * @return test.name：姓名
     */
    public String getName() {
        return name;
    }

    /**
     * <pre>
     * 设置：姓名
     * 表字段：test.name
     * </pre>
     *
     * @param name
     *            test.name：姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * <pre>
     * 获取：密码
     * 表字段：test.pwd
     * </pre>
     *
     * @return test.pwd：密码
     */
    public String getPwd() {
        return pwd;
    }

    /**
     * <pre>
     * 设置：密码
     * 表字段：test.pwd
     * </pre>
     *
     * @param pwd
     *            test.pwd：密码
     */
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    /**
     * <pre>
     * 获取：temp 字段
     * 表字段：test.t1
     * </pre>
     *
     * @return test.t1：temp 字段
     */
    public String getT1() {
        return t1;
    }

    /**
     * <pre>
     * 设置：temp 字段
     * 表字段：test.t1
     * </pre>
     *
     * @param t1
     *            test.t1：temp 字段
     */
    public void setT1(String t1) {
        this.t1 = t1;
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
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", pwd=").append(pwd);
        sb.append(", t1=").append(t1);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}