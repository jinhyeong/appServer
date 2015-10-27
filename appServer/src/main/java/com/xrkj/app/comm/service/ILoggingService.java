/**
 * Copyright(C) 2015-2025 杏仁科技
 * All rights reserved
 * 2015年7月2日 Created
 * 
 */
package com.xrkj.app.comm.service;

import com.xrkj.app.base.service.IService;
import com.xrkj.app.comm.model.Logging;

/**
 * <pre>
 * 通用日志服务接口
 * </pre>
 *
 * @author wwh
 * @date 2015年7月2日 上午11:29:31
 *
 */
public interface ILoggingService extends IService {

    /**
     * 保存日志
     * 
     * @param log
     */
    void saveLogging(Logging log);
    
    /**
     * <pre>
     * 保存日志
     * <b>注意！ 这个方法内部处理异常，不会抛出</b>
     * </pre>
     * @param log
     */
    void saveLoggingSafe(Logging log);
    
    
}
