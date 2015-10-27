/**
 * Copyright(C) 2015-2025 杏仁科技
 * All rights reserved
 * 2015年6月25日 Created
 * 
 */
package com.xrkj.app.cache.redis;

import java.nio.charset.Charset;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
import org.springframework.util.Assert;
import org.springframework.util.ObjectUtils;

/**
 * <pre>
 *  只能将对象转换成字符串类型的key
 *  反序列化是不完整的，只能转成String
 * </pre>
 *
 * @author wwh
 * @date 2015年6月25日 上午11:22:47
 *
 */
public class StringRedisSerializer implements RedisSerializer<Object> {
    private static final Logger logger = LoggerFactory.getLogger(StringRedisSerializer.class);
    private final Charset charset;

    public StringRedisSerializer() {
        this(Charset.forName("UTF8"));
    }

    public StringRedisSerializer(Charset charset) {
        Assert.notNull(charset);
        this.charset = charset;
    }

    @Override
    public byte[] serialize(Object t) throws SerializationException {
        return ObjectUtils.nullSafeToString(t).getBytes(charset);
    }

    @Override
    public Object deserialize(byte[] bytes) throws SerializationException {
        logger.warn("反序列化只能转成String");
        return (bytes == null ? null : new String(bytes, charset));
    }

}
