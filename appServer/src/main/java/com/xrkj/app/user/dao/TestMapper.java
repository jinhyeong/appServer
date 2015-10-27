/**
 * Copyright(C) 2015-2025 杏仁科技
 * All rights reserved
 * 2015-06-11 Created
 * 
 */
package com.xrkj.app.user.dao;

import com.xrkj.app.user.model.Test;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;

public interface TestMapper {
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
    int insert(Test record);

    /**
     * 根据主键获取一条数据库记录
     *
     * @param id
     */
    @Cacheable(value = "testCache" , cacheResolver="myCacheResolver")
    Test selectByPrimaryKey(Long id);

    /**
     * 获取全部数据库记录
     *
     */
    List<Test> selectAll();

    /**
     * 根据主键来更新数据库记录
     *
     * @param record
     */
    int updateByPrimaryKey(Test record);
}