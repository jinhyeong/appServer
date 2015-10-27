/**
 * Copyright(C) 2015-2025 杏仁科技
 * All rights reserved
 * 2015年6月24日 Created
 * 
 */
package com.xrkj.app.cache.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.interceptor.SimpleKey;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.util.ObjectUtils;

/**
 * <pre>
 * 减少序列化后的字节大小为目的，并尽量使用String，便于查看
 * <b>未完成的，且不支持反序列化</b>
 * 组合序列化
 * key 默认由SimpleKeyGenerator生成
 * 基本类型使用 StringRedisSerializer （单个参数时）
 * 其他类型使用 JdkSerializationRedisSerializer (simpleKey 类型时)
 * </pre>
 * 
 * @author wwh
 * @date 2015年6月24日 下午7:56:50
 *
 */
public class CompositeSerializer implements RedisSerializer<Object> {

    private static final Logger logger = LoggerFactory.getLogger(CompositeSerializer.class);
    // 常量定义
    // 定义各种类型标记

    private JdkSerializationRedisSerializer jdks = new JdkSerializationRedisSerializer();
    private StringRedisSerializer strings = new StringRedisSerializer();

    public JdkSerializationRedisSerializer getJdks() {
        return jdks;
    }

    public void setJdks(JdkSerializationRedisSerializer jdks) {
        this.jdks = jdks;
    }

    public StringRedisSerializer getStrings() {
        return strings;
    }

    public void setStrings(StringRedisSerializer strings) {
        this.strings = strings;
    }

    @Override
    public byte[] serialize(Object t) throws SerializationException {
        // Boolean.TYPE, Character.TYPE, Byte.TYPE, Short.TYPE, Integer.TYPE,
        // Long.TYPE, Float.TYPE, Double.TYPE, Void.TYPE

        // 用一个字节标记类型，然后对应的序列化 和 反序列化

        if (t instanceof SimpleKey) {
            return jdks.serialize(t);
        } else {
            return strings.serialize(ObjectUtils.nullSafeToString(t));
        }

    }

    @Override
    public Object deserialize(byte[] bytes) throws SerializationException {
        // TODO 未实现
        logger.warn("未实现的方法");
        return null;
    }

}
