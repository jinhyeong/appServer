/**
 * @Title: ServletRequestHandledListener.java 
 * @Package com.xrkj.app.applicationlistener 
 * @Description: 
 * @author wwh
 * @date 2015年6月18日 上午11:44:56 
 * @version V1.0  
 */
package com.xrkj.app.applicationlistener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.web.context.support.ServletRequestHandledEvent;

/**
 * <pre>
 * ServletRequestHandledEvent 监听
 * </pre>
 *
 * @author wwh
 * @date 2015年6月18日 上午11:44:56
 *
 */
public class ServletRequestHandledListener implements ApplicationListener<ServletRequestHandledEvent> {
    private static final Logger logger = LoggerFactory.getLogger(ServletRequestHandledListener.class);

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.springframework.context.ApplicationListener#onApplicationEvent(org
     * .springframework.context.ApplicationEvent)
     */
    @Override
    public void onApplicationEvent(ServletRequestHandledEvent event) {
        logger.debug("=============== {}", event.getDescription());
    }

}
