/**
 * Copyright(C) 2015-2025 杏仁科技
 * All rights reserved
 * 2015年6月23日 Created
 * 
 */
package com.xrkj.app.cache.keygenerator;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.util.StringUtils;

/**
 * <pre>
 *  生成String类型的缓存Key
 *  格式： 
 *  <b>参数描述,参数描述...</b>
 *  delimit 为[,]
 * </pre>
 *
 * @author wwh
 * @date 2015年6月23日 上午11:40:58
 *
 */
public class SimpleStringKeyGenerator implements KeyGenerator {
    
    public static final String EMPTY = "empty";

    private static final Logger logger = LoggerFactory.getLogger(SimpleStringKeyGenerator.class);

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.springframework.cache.interceptor.KeyGenerator#generate(java.lang
     * .Object, java.lang.reflect.Method, java.lang.Object[])
     */
    @Override
    public Object generate(Object target, Method method, Object... params) {
        if (params.length == 0) {
            logger.warn("！！！生成缓存KEY！！！ 方法参数为空，建议自行指定缓存key");
            return EMPTY;
        }
      
        // 返回字符串，便于在redis上进行查看
        return StringUtils.arrayToCommaDelimitedString(params);
    }

}
