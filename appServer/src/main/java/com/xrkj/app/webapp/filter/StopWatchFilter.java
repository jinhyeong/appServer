/**
 * Copyright(C) 2015-2025 杏仁科技
 * All rights reserved
 * 2015年7月2日 Created
 * 
 */
package com.xrkj.app.webapp.filter;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.xrkj.app.Constants;
import com.xrkj.app.comm.model.Logging;
import com.xrkj.app.comm.service.ILoggingService;

/**
 * <pre>
 * 记录耗时的过滤器
 * 用注解的方式不好控制过滤器的执行顺序
 * 直接定义在web.xml 中
 * 因为需要使用spring中的业务bean，所以使用DelegatingFilterProxy
 * </pre>
 *
 * @author wwh
 * @date 2015年7月2日 上午10:00:50
 *
 */
public class StopWatchFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(StopWatchFilter.class);

    @Autowired
    private ILoggingService loggingService;

    /*
     * (non-Javadoc)
     * 
     * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        // ApplicationContext ctx =
        // WebApplicationContextUtils.getRequiredWebApplicationContext(filterConfig.getServletContext());
        // Object o= ctx.getBean("loggingService");
        // 从这里也可以获取到bean
    }

    /*
     * (non-Javadoc)
     * 
     * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest,
     * javax.servlet.ServletResponse, javax.servlet.FilterChain)
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        logger.debug("######### 开始记录耗时 #########");

        Long t1 = System.currentTimeMillis();

        chain.doFilter(request, response);

        Long t = System.currentTimeMillis() - t1;

        if (t > 5000) {
            // 时间大于500ms的处理记录到数据库中

            String message = new StringBuffer("process [").append(((HttpServletRequest) request).getRequestURI()).append("] consume ").append(t).append(" ms")
                    .toString();

            logger.warn(message + "  ==> 处理时间超过500ms，记录到数据库中");

            Logging log = new Logging();
            log.setType(Constants.LOG_TYPE_TIME_CONSUME);
            log.setPriority(5);
            log.setTime(new Date());
            log.setMessage(message);
            loggingService.saveLoggingSafe(log);

        } else {
            logger.debug("process [{}] consume {} ms", ((HttpServletRequest) request).getRequestURI(), t);
        }

        logger.debug("######### 记录耗时结束 #########");
    }

    /*
     * (non-Javadoc)
     * 
     * @see javax.servlet.Filter#destroy()
     */
    @Override
    public void destroy() {

    }

}
