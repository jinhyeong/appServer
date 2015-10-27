/**
 * Copyright(C) 2015-2025 杏仁科技
 * All rights reserved
 * 2015年7月1日 Created
 * 
 */
package com.xrkj.app.webapp.listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <pre>
 * 用来监控放入请求对象中的内容
 * 开发测试用
 * </pre>
 *
 * @author wwh
 * @date 2015年7月1日 下午6:47:49
 *
 */
//@WebListener
public class RequestAttributeListener implements ServletRequestAttributeListener {
    private static final Logger logger = LoggerFactory.getLogger(RequestAttributeListener.class);

    /*
     * (non-Javadoc)
     * 
     * @see
     * javax.servlet.ServletRequestAttributeListener#attributeAdded(javax.servlet
     * .ServletRequestAttributeEvent)
     */
    @Override
    public void attributeAdded(ServletRequestAttributeEvent srae) {
        logger.debug("######## 设置属性{} 值为：{}", srae.getName(), srae.getValue());
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * javax.servlet.ServletRequestAttributeListener#attributeRemoved(javax.
     * servlet.ServletRequestAttributeEvent)
     */
    @Override
    public void attributeRemoved(ServletRequestAttributeEvent srae) {
        logger.debug("######## 移除属性{} 值为：{}", srae.getName(), srae.getValue());
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * javax.servlet.ServletRequestAttributeListener#attributeReplaced(javax
     * .servlet.ServletRequestAttributeEvent)
     */
    @Override
    public void attributeReplaced(ServletRequestAttributeEvent srae) {
        logger.debug("######## 覆盖属性{} 值为：{}", srae.getName(), srae.getValue());
    }

}
