/**
 * Copyright(C) 2015-2025 杏仁科技
 * All rights reserved
 * 2015-06-11 Created
 * 
 */
package com.xrkj.app.user.model;

import java.io.Serializable;

public class UserRole implements Serializable {
    /**
     * <pre>
     * 
     * 表字段 : user_role.user_id
     * </pre>
     */
    private Long userId;

    /**
     * <pre>
     * 
     * 表字段 : user_role.role_id
     * </pre>
     */
    private Long roleId;

    private static final long serialVersionUID = 1L;

    /**
     * <pre>
     * 获取：
     * 表字段：user_role.user_id
     * </pre>
     *
     * @return user_role.user_id：
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：user_role.user_id
     * </pre>
     *
     * @param userId
     *            user_role.user_id：
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * <pre>
     * 获取：
     * 表字段：user_role.role_id
     * </pre>
     *
     * @return user_role.role_id：
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：user_role.role_id
     * </pre>
     *
     * @param roleId
     *            user_role.role_id：
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
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
        sb.append(", userId=").append(userId);
        sb.append(", roleId=").append(roleId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}