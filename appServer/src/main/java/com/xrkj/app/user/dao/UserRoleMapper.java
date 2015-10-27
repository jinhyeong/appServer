/**
 * Copyright(C) 2015-2025 杏仁科技
 * All rights reserved
 * 2015-06-11 Created
 * 
 */
package com.xrkj.app.user.dao;

import com.xrkj.app.user.model.UserRole;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface UserRoleMapper {
    /**
     * 根据主键删除数据库的记录
     *
     * @param userId
     * @param roleId
     */
    int deleteByPrimaryKey(@Param("userId") Long userId, @Param("roleId") Long roleId);

    /**
     * 插入数据库记录
     *
     * @param record
     */
    int insert(UserRole record);

    /**
     * 获取全部数据库记录
     *
     */
    List<UserRole> selectAll();
}