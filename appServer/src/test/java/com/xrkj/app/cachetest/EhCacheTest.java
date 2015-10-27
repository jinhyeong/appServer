/**
 * @Title: EhCacheTest.java 
 * @Package com.xrkj.app.cachetest 
 * @Description: 
 * @author ww
 * @date 2015年6月12日 下午3:38:11 
 * @version V1.0  
 */
package com.xrkj.app.cachetest;

import java.io.IOException;

import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.Cache;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.core.io.ClassPathResource;

import com.xrkj.app.user.model.AppUser;


/**
 * <pre>
 * 
 * </pre>
 *
 * @author ww
 * @date 2015年6月12日 下午3:38:11
 *
 */
public class EhCacheTest {
    private static final Logger logger = LoggerFactory.getLogger(EhCacheTest.class);

   // @Test
    public void testEhCache() throws IOException {
        // 创建底层Cache
        net.sf.ehcache.CacheManager ehcacheManager = new net.sf.ehcache.CacheManager(new ClassPathResource("ehcache.xml").getInputStream());

        // 创建Spring的CacheManager
        EhCacheCacheManager cacheCacheManager = new EhCacheCacheManager();
        // 设置底层的CacheManager
        cacheCacheManager.setCacheManager(ehcacheManager);

        Long id = 1L;
        AppUser user = new AppUser();
        user.setId(id);
        user.setFirstName("测试");
        user.setEmail("zhang@gmail.com");

        // 根据缓存名字获取Cache
        Cache cache = cacheCacheManager.getCache("testCache");
        // 往缓存写数据
        cache.put(id, user);
        // 从缓存读数据
        AppUser object = cache.get(id, AppUser.class);
        logger.info(object.toString());
        
        Assert.assertNotNull(object);
        
        //测试超时之后是否自动清理
        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        object = cache.get(id, AppUser.class);
        
        Assert.assertNull("缓存没有被清理", object);
        
    }

}
