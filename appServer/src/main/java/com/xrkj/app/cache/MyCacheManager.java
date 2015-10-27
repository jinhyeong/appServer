/**
 * @Title: MyCacheManager.java 
 * @Package com.xrkj.app.cache 
 * @Description: 
 * @author ww
 * @date 2015年6月11日 下午5:33:08 
 * @version V1.0  
 */
package com.xrkj.app.cache;

import java.util.Collection;

import org.springframework.cache.Cache;
import org.springframework.cache.support.AbstractCacheManager;

/**
 * <pre>
 * 
 * </pre>
 *
 * @author ww
 * @date 2015年6月11日 下午5:33:08
 *
 */
public class MyCacheManager extends AbstractCacheManager {

    private Collection<? extends MyCache> caches;

    /**
     * Specify the collection of Cache instances to use for this CacheManager.
     */
    public void setCaches(Collection<? extends MyCache> caches) {
        this.caches = caches;
    }

    @Override
    protected Collection<? extends Cache> loadCaches() {
        return this.caches;

    }

}
