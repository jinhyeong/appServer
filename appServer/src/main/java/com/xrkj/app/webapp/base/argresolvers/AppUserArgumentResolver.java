/**
 * Copyright(C) 2015-2025 杏仁科技
 * All rights reserved
 * 2015年7月13日 Created
 * 
 */
package com.xrkj.app.webapp.base.argresolvers;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.xrkj.app.user.model.AppUser;
import com.xrkj.app.webapp.base.UserThreadLocalHolder;

/**
 * <pre>
 * AppUser类型的参数解析
 * 使Controller 方法的参数直接支持AppUser对象
 * </pre>
 *
 * @author wwh
 * @date 2015年7月13日 下午6:24:56
 *
 */
public class AppUserArgumentResolver implements HandlerMethodArgumentResolver {

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.springframework.web.method.support.HandlerMethodArgumentResolver#
     * supportsParameter(org.springframework.core.MethodParameter)
     */
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        if (parameter.getParameterType() == AppUser.class)
            return true;
        return false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.springframework.web.method.support.HandlerMethodArgumentResolver#
     * resolveArgument(org.springframework.core.MethodParameter,
     * org.springframework.web.method.support.ModelAndViewContainer,
     * org.springframework.web.context.request.NativeWebRequest,
     * org.springframework.web.bind.support.WebDataBinderFactory)
     */
    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory)
            throws Exception {
        return UserThreadLocalHolder.getAppUser();
    }

}
