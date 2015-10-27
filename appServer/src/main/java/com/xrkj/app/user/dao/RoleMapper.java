/**
 * Copyright(C) 2015-2025 杏仁科技
 * All rights reserved
 * 2015-06-11 Created
 * 
 */
package com.xrkj.app.user.dao;

import com.xrkj.app.user.model.Role;

import java.util.List;

public interface RoleMapper {
    /**
     * 根据主键删除数据库的记录
     *
     * @param id
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 插入数据库记录
     *
     * @param record
     */
    int insert(Role record);

    /**
     * 根据主键获取一条数据库记录
     *
     * @param id
     */
    Role selectByPrimaryKey(Long id);

    /**
     * 获取全部数据库记录
     *
     */
    List<Role> selectAll();

    /**
     * 根据主键来更新数据库记录
     *
     * @param record
     */
    int updateByPrimaryKey(Role record);
}