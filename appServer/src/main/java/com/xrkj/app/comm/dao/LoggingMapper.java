/**
 * Copyright(C) 2015-2025 杏仁科技
 * All rights reserved
 * 2015-08-11 Created
 */
package com.xrkj.app.comm.dao;

import com.xrkj.app.base.dao.IDao;
import com.xrkj.app.comm.model.Logging;
import java.util.List;

public interface LoggingMapper extends IDao {
    /**
     * 根据主键删除数据库的记录
     *
     * @param logid
     */
    int deleteByPrimaryKey(Long logid);

    /**
     * 插入数据库记录
     *
     * @param record
     */
    int insert(Logging record);

    /**
     * 根据主键获取一条数据库记录
     *
     * @param logid
     */
    Logging selectByPrimaryKey(Long logid);

    /**
     * 获取全部数据库记录
     *
     */
    List<Logging> selectAll();

    /**
     * 根据主键来更新数据库记录
     *
     * @param record
     */
    int updateByPrimaryKey(Logging record);
}