/**
 * @Title: MyCache.java 
 * @Package com.xrkj.app.cache 
 * @Description: 
 * @author ww
 * @date 2015年6月11日 下午5:34:14 
 * @version V1.0  
 */
package com.xrkj.app.cache;

import java.util.HashMap;
import java.util.Map;

import org.springframework.cache.Cache;
import org.springframework.cache.support.SimpleValueWrapper;

import com.xrkj.app.user.model.Test;

/**
 * <pre>
 * 
 * </pre>
 *
 * @author ww
 * @date 2015年6月11日 下午5:34:14
 *
 */
public class MyCache implements Cache {
    private String name;
    private Map<Object, Test> store = new HashMap<Object, Test>();;

    public MyCache() {
    }

    public MyCache(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Object getNativeCache() {
        return store;
    }

    @Override
    public ValueWrapper get(Object key) {
        ValueWrapper result = null;
        Test thevalue = store.get(key);
        if (thevalue != null) {
            thevalue.setT1("from mycache:" + name);
            result = new SimpleValueWrapper(thevalue);
        }
        return result;
    }

    @Override
    public void put(Object key, Object value) {
        Test thevalue = (Test) value;
        store.put(key, thevalue);
    }

    @Override
    public void evict(Object key) {
    }

    @Override
    public void clear() {
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.cache.Cache#get(java.lang.Object,
     * java.lang.Class)
     */
    @Override
    public <T> T get(Object key, Class<T> type) {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.cache.Cache#putIfAbsent(java.lang.Object,
     * java.lang.Object)
     */
    @Override
    public ValueWrapper putIfAbsent(Object key, Object value) {
        // TODO Auto-generated method stub
        return null;
    }

}
