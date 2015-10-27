/**
 * Copyright(C) 2015-2025 杏仁科技
 * All rights reserved
 * 2015年7月14日 Created
 * 
 */
package com.xrkj.app.webapp.base.conversion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;

/**
 * <pre>
 * 测试转换
 * </pre>
 *
 * @author wwh
 * @date 2015年7月14日 下午5:33:52
 *
 */
public class MyConversionService implements ConversionService {

    private static final Logger log = LoggerFactory.getLogger(MyConversionService.class);

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.springframework.core.convert.ConversionService#canConvert(java.lang
     * .Class, java.lang.Class)
     */
    @Override
    public boolean canConvert(Class<?> sourceType, Class<?> targetType) {
        log.debug("原类型：{}", sourceType);
        log.debug("目标类型：{}", targetType);
        return true;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.core.convert.ConversionService#canConvert(org.
     * springframework.core.convert.TypeDescriptor,
     * org.springframework.core.convert.TypeDescriptor)
     */
    @Override
    public boolean canConvert(TypeDescriptor sourceType, TypeDescriptor targetType) {
        log.debug("原类型：{}", sourceType);
        log.debug("目标类型：{}", targetType);
        return true;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.springframework.core.convert.ConversionService#convert(java.lang.
     * Object, java.lang.Class)
     */
    @Override
    public <T> T convert(Object source, Class<T> targetType) {
        log.debug("原类型：{}", source);
        log.debug("目标类型：{}", targetType);
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.springframework.core.convert.ConversionService#convert(java.lang.
     * Object, org.springframework.core.convert.TypeDescriptor,
     * org.springframework.core.convert.TypeDescriptor)
     */
    @Override
    public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
        log.debug("原类型：{}", sourceType);
        log.debug("目标类型：{}", targetType);
        return null;
    }

}
