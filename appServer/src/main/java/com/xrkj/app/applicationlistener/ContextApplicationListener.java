/**
 * @Title: MyApplicationListener.java 
 * @Package com.xrkj.app.applicationlistener 
 * @Description: 
 * @author wwh
 * @date 2015年6月17日 下午8:03:22 
 * @version V1.0  
 */
package com.xrkj.app.applicationlistener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.context.event.SmartApplicationListener;

/**
 * <pre>
 * ApplicationContextEvent和RequestHandledEvent。
 * ApplicationContextEvent有四个子类：ContextStartedEvent（容器启动），                                                        
 *                                                      ContextClosedEvent（容器关闭），                                                        
 *                                                      ContextRefreshedEvent（容器刷新），                                                        
 *                                                      ContextStoppedEvent（容器停止）。
 * RequestHandledEvent与web应用相关的事件，只有在web.xml中定义了DispatcherServlet时才会产生该事件
 * 有两个子类：ServletRequestHandledEvent和PortletRequestHandledEvent。
 * </pre>
 *
 * @author wwh
 * @date 2015年6月17日 下午8:03:22
 *
 */
public class ContextApplicationListener implements SmartApplicationListener {

    private static final Logger logger = LoggerFactory.getLogger(ContextApplicationListener.class);

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if (logger.isDebugEnabled()) {
            StringBuffer sbf = new StringBuffer();
            sbf.append("######## 容器事件 ########\n");
            sbf.append(event.getClass().getName());
            sbf.append("\n");
            sbf.append(event.toString());
            sbf.append("\n");
            sbf.append(event.getSource());
            sbf.append("\n######################");
            logger.debug(sbf.toString());
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.core.Ordered#getOrder()
     */
    @Override
    public int getOrder() {
        // TODO Auto-generated method stub
        return 0;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.springframework.context.event.SmartApplicationListener#supportsEventType
     * (java.lang.Class)
     */
    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> eventType) {

        if (ContextStartedEvent.class == eventType) {
            return true;
        }
        if (ContextClosedEvent.class == eventType) {
            return true;
        }
        if (ContextRefreshedEvent.class == eventType) {
            return true;
        }
        if (ContextStoppedEvent.class == eventType) {
            return true;
        }

        return false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.springframework.context.event.SmartApplicationListener#supportsSourceType
     * (java.lang.Class)
     */
    @Override
    public boolean supportsSourceType(Class<?> sourceType) {
        return true;
    }

}
