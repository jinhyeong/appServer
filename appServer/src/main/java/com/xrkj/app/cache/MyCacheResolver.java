/**
 * Copyright(C) 2015-2025 杏仁科技
 * All rights reserved
 * 2015年7月6日 Created
 * 
 */
package com.xrkj.app.cache;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.interceptor.CacheOperationInvocationContext;
import org.springframework.cache.interceptor.CacheResolver;
import org.springframework.stereotype.Component;

/**
 * <pre>
 * Cache解析器，用于根据实际情况来动态解析使用哪个Cache
 * 下面示例：给使用了MyCacheResolver 的增加一个缓存
 * </pre>
 *
 * @author wwh
 * @date 2015年7月6日 下午3:50:07
 *
 */
@Component
public class MyCacheResolver implements CacheResolver {

    @Autowired
    private CacheManager cacheManager;

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.springframework.cache.interceptor.CacheResolver#resolveCaches(org
     * .springframework.cache.interceptor.CacheOperationInvocationContext)
     */
    @Override
    public Collection<? extends Cache> resolveCaches(CacheOperationInvocationContext<?> context) {
        List<Cache> caches = new ArrayList<Cache>();
        for (String cacheName : context.getOperation().getCacheNames()) {
            caches.add(cacheManager.getCache(cacheName));
        }

        // if (context.getTarget() instanceof TestServiceImpl) {
        caches.add(cacheManager.getCache("CacheResolver"));
        // }
        return caches;

    }

}
