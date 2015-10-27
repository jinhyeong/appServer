/**
 * Copyright(C) 2015-2025 杏仁科技
 * All rights reserved
 * 2015年6月19日 Created
 * 
 */
package com.xrkj.app.cache.redis;

import java.nio.charset.Charset;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
import org.springframework.util.Assert;

import com.alibaba.fastjson.JSON;

/**
 * <pre>
 * JSON 格式的数据序列化 与 反序列化
 * 使用阿里的fastjson
 * <b>只能用于key的序列化</b>
 * 问题：
 * 反序列化时使用的是： JSON.parse(jsonstring); 返回的是 JSONObject 对象，对象转换时会有问题
 *  如果要转换成正确的对象需要使用：JSON.parseObject(ss, class); 而class是不确定的
 * </pre>
 *
 * @author wwh
 * @date 2015年6月19日 下午3:24:19
 *
 */
public class JsonRedisSerializer implements RedisSerializer<Object> {
    private static final Logger logger = LoggerFactory.getLogger(JsonRedisSerializer.class);

    private final Charset charset;

    public JsonRedisSerializer() {
        this(Charset.forName("UTF8"));
    }

    public JsonRedisSerializer(Charset charset) {
        Assert.notNull(charset);
        this.charset = charset;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.springframework.data.redis.serializer.RedisSerializer#serialize(java
     * .lang.Object)
     */
    @Override
    public byte[] serialize(Object t) throws SerializationException {
        if (t == null) {
            t = "null";
        }
        return JSON.toJSONString(t).getBytes(charset);

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.springframework.data.redis.serializer.RedisSerializer#deserialize
     * (byte[])
     */
    @Override
    public Object deserialize(byte[] bytes) throws SerializationException {
        logger.warn("返回的是 JSONObject 对象");
        return JSON.parse(new String(bytes, charset));

    }

}
