/**
 * Copyright(C) 2015-2025 杏仁科技
 * All rights reserved
 * 2015-06-11 Created
 * 
 */
package com.xrkj.app.user.model;

import java.io.Serializable;

public class Role implements Serializable {
    /**
     * <pre>
     * 
     * 表字段 : role.id
     * </pre>
     */
    private Long id;

    /**
     * <pre>
     * 
     * 表字段 : role.description
     * </pre>
     */
    private String description;

    /**
     * <pre>
     * 
     * 表字段 : role.name
     * </pre>
     */
    private String name;

    private static final long serialVersionUID = 1L;

    /**
     * <pre>
     * 获取：
     * 表字段：role.id
     * </pre>
     *
     * @return role.id：
     */
    public Long getId() {
        return id;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：role.id
     * </pre>
     *
     * @param id
     *            role.id：
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * <pre>
     * 获取：
     * 表字段：role.description
     * </pre>
     *
     * @return role.description：
     */
    public String getDescription() {
        return description;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：role.description
     * </pre>
     *
     * @param description
     *            role.description：
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * <pre>
     * 获取：
     * 表字段：role.name
     * </pre>
     *
     * @return role.name：
     */
    public String getName() {
        return name;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：role.name
     * </pre>
     *
     * @param name
     *            role.name：
     */
    public void setName(String name) {
        this.name = name;
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
        sb.append(", description=").append(description);
        sb.append(", name=").append(name);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}