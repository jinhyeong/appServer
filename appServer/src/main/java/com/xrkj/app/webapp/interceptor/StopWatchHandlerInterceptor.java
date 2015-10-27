/**
 * @Title: StopWatchHandlerInterceptor.java 
 * @Package com.xrkj.app.webapp.interceptor 
 * @Description: 
 * @author wwh
 * @date 2015年6月18日 下午4:44:57 
 * @version V1.0  
 */
package com.xrkj.app.webapp.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.NamedThreadLocal;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * <pre>
 * 通过处理拦截器 记录请求耗时
 * </pre>
 *
 * @author wwh
 * @date 2015年6月18日 下午4:44:57
 *
 */
public class StopWatchHandlerInterceptor extends HandlerInterceptorAdapter {
    private static final Logger logger = LoggerFactory.getLogger(StopWatchHandlerInterceptor.class);

    private NamedThreadLocal<Long> startTimeThreadLocal = new NamedThreadLocal<Long>("StopWatch-StartTime");

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        long beginTime = System.currentTimeMillis();// 1、开始时间
        startTimeThreadLocal.set(beginTime);// 线程绑定变量（该数据只有当前请求的线程可见）
        return true;// 继续流程
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        long endTime = System.currentTimeMillis();// 2、结束时间
        long beginTime = startTimeThreadLocal.get();// 得到线程绑定的局部变量（开始时间）
        long consumeTime = endTime - beginTime;// 3、消耗的时间

        // if (consumeTime > 500) // 此处认为处理时间超过500毫秒的请求为慢请求
        logger.debug("@ {} consume {} millis", request.getRequestURI(), consumeTime);
    }
}
