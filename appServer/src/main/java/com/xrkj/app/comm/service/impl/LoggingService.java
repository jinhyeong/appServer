/**
 * Copyright(C) 2015-2025 杏仁科技
 * All rights reserved
 * 2015年7月2日 Created
 * 
 */
package com.xrkj.app.comm.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xrkj.app.base.service.BaseService;
import com.xrkj.app.comm.dao.LoggingMapper;
import com.xrkj.app.comm.model.Logging;
import com.xrkj.app.comm.service.ILoggingService;

/**
 * <pre>
 * 通用日志服务
 * </pre>
 *
 * @author wwh
 * @date 2015年7月2日 上午11:31:37
 *
 */
@Service
public class LoggingService extends BaseService implements ILoggingService {
    private static final Logger logger = LoggerFactory.getLogger(LoggingService.class);

    @Autowired
    private LoggingMapper loggingMapper;

    public void setLoggingMapper(LoggingMapper loggingMapper) {
        this.loggingMapper = loggingMapper;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.xrkj.app.comm.service.ILoggingService#saveLogging(com.xrkj.app.comm
     * .model.Logging)
     */
    @Override
    public void saveLogging(Logging log) {
        loggingMapper.insert(log);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.xrkj.app.comm.service.ILoggingService#saveLoggingSafe(com.xrkj.app
     * .comm.model.Logging)
     */
    @Override
    public void saveLoggingSafe(Logging log) {
        // 配置这个方法不在事物环境下运行
        try {
            loggingMapper.insert(log);
        } catch (Exception e) {
            logger.error("保存日志出错了", e);
        }
    }

}
