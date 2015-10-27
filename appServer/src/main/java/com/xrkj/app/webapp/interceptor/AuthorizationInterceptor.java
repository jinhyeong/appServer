/**
 * Copyright(C) 2015-2025 杏仁科技
 * All rights reserved
 * 2015年6月25日 Created
 * 
 */
package com.xrkj.app.webapp.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.xrkj.app.user.service.IUserService;

/**
 * <pre>
 * 授权拦截器 authorization 
 * 在执行具体Handler之前进行权限验证
 * 
 * 可以通过配置、注解等指定执行相应的handler需要什么样的权限
 * 
 * </pre>
 *
 * @author ww
 * @date 2015年6月5日 下午6:04:13
 *
 */
public class AuthorizationInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(AuthorizationInterceptor.class);

    @Autowired
    private IUserService userService;

    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception {
        logger.debug("####### 进入授权控制拦截器  对应的handler是：{} ", handler);

        // 根据请求路径
        // 注解
        // 其他配置等
        // 判断执行该controller需要什么样的权限

        // 权限是配置在user对象中还是单独放在另外的表中？
        // 权限就设计成角色的概念？那只是资源的权限，针对这种权限，应该放到另外的表中，所有用户都公用的，可以减少缓存的数量。比如A角色可以访问资源AAA，B角色可以访问资源BBB等
        // 还有一层数据的权限？这里应该有两个概念，如果：A用户只能访问A用户的数据；1级用户可以访问1级数据，2级用户只能访问2级数据

        // 可以得到请求的路径
        // String path = req.getServletPath();

        // 可以获取标记在handler上的注解
        // handler.getClass().getAnnotations();

        // 可以通过配置

        // 可以得到登录的用户
        // UserThreadLocalHolder.getAppUser();

        // 可以通过用户得到角色

        // 进行权限判断

        //或者可以通过方法回调的方式来进行判断，具体的权限验证动作交给具体的handler来执行？？？，这个可以定义在baseContoller中？？
        
        // 如果通过权限认证
        return true;

        // 否则抛出 未授权异常
        // throw new UnauthorizedException();

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }

}
