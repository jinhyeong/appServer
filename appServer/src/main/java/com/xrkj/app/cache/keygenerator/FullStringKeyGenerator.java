/**
 * Copyright(C) 2015-2025 杏仁科技
 * All rights reserved
 * 2015年6月23日 Created
 * 
 */
package com.xrkj.app.cache.keygenerator;

import java.lang.reflect.Method;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.util.StringUtils;

/**
 * <pre>
 *  生成String类型的缓存Key
 *  格式： 
 *  <b>简单类名.方法名(参数描述...)</b>
 * </pre>
 *
 * @author wwh
 * @date 2015年6月23日 上午11:40:58
 *
 */
public class FullStringKeyGenerator implements KeyGenerator {

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.springframework.cache.interceptor.KeyGenerator#generate(java.lang
     * .Object, java.lang.reflect.Method, java.lang.Object[])
     */
    @Override
    public Object generate(Object target, Method method, Object... params) {
        // 简单类名.方法名(参数描述...)
        StringBuffer sbf = new StringBuffer();
        sbf.append(target.getClass().getSimpleName());
        sbf.append(".");
        sbf.append(method.getName());
        sbf.append("(");
        sbf.append(StringUtils.arrayToCommaDelimitedString(params));
        sbf.append(")");
        return sbf.toString();
    }

}
