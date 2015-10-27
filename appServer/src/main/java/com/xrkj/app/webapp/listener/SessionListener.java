package com.xrkj.app.webapp.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <pre>
 * 不使用session 
 * 监控session的创建
 * </pre>
 *
 * @author wwh
 * @date 2015年6月30日 下午6:56:45
 *
 */
@WebListener
public class SessionListener implements HttpSessionListener {
    private static final Logger logger = LoggerFactory.getLogger(HttpSessionListener.class);

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        logger.warn("############ Session 创建了");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        logger.warn("############ Session 销毁了");

    }

}
