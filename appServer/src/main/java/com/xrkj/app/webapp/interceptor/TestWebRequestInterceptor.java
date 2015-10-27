 /**
 * Copyright(C) 2015-2025 杏仁科技
 * All rights reserved
 * 2015年7月15日 Created
 * 
 */
package com.xrkj.app.webapp.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;

/**
 * <pre>
 * 
 * </pre>
 *
 * @author wwh
 * @date 2015年7月15日 下午3:18:48 
 *
 */
public class TestWebRequestInterceptor implements WebRequestInterceptor {
    
    private static final Logger log = LoggerFactory.getLogger(TestWebRequestInterceptor.class);

    /* (non-Javadoc)
     * @see org.springframework.web.context.request.WebRequestInterceptor#preHandle(org.springframework.web.context.request.WebRequest)
     */
    @Override
    public void preHandle(WebRequest request) throws Exception {
        log.debug("preHandle....");
    }

    /* (non-Javadoc)
     * @see org.springframework.web.context.request.WebRequestInterceptor#postHandle(org.springframework.web.context.request.WebRequest, org.springframework.ui.ModelMap)
     */
    @Override
    public void postHandle(WebRequest request, ModelMap model) throws Exception {
        log.debug("postHandle>>>>");
    }

    /* (non-Javadoc)
     * @see org.springframework.web.context.request.WebRequestInterceptor#afterCompletion(org.springframework.web.context.request.WebRequest, java.lang.Exception)
     */
    @Override
    public void afterCompletion(WebRequest request, Exception ex) throws Exception {
        log.debug("afterCompletion.....");
    }

}
