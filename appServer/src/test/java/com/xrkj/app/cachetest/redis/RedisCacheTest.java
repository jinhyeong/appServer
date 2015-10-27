package com.xrkj.app.cachetest.redis;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.Cache.ValueWrapper;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * <pre>
 * redis测试
 * 
 * </pre>
 *
 * @author ww
 * @date 2015年6月12日 下午7:38:45
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext-resources.xml", "classpath:applicationContext-dao.xml",
        "classpath:applicationContext-service.xml" })
public class RedisCacheTest {

    @Autowired
    RedisCacheManager redisCacheManager;

    @Autowired
    RedisTemplate<Object, Object> redisTemplate;

    public RedisCacheManager getRedisCacheManager() {
        return redisCacheManager;
    }

    public void setRedisCacheManager(RedisCacheManager redisCacheManager) {
        this.redisCacheManager = redisCacheManager;
    }

    String cacheName = "aaa";

    @Test
    public void testGet() {
        Cache c = redisCacheManager.getCache(cacheName);
        ValueWrapper vw = c.get("putkey");
        if (vw != null) {
            String v = (String) vw.get();
            System.out.println(v);
            Assert.assertEquals("the value", v);
        }
    }

    @Test
    public void testPut() {
        Cache c = redisCacheManager.getCache(cacheName);
        c.put("putkey", "the value");
        c.put("putkey1", "the value1");
    }

    @Test
    public void testEvict() {
        Cache c = redisCacheManager.getCache(cacheName);
        c.evict("putkey");
        Assert.assertNull(c.get("putkey"));

    }

}
