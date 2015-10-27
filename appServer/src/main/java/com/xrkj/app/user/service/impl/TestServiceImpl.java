/**
 * @Title: TestServiceImpl.java 
 * @Package com.xrkj.app.user.service.impl 
 * @Description: 
 * @author ww
 * @date 2015年6月11日 下午12:17:36 
 * @version V1.0  
 */
package com.xrkj.app.user.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.xrkj.app.user.dao.TestMapper;
import com.xrkj.app.user.model.Test;
import com.xrkj.app.user.service.ITestService;

/**
 * <pre>
 * 测试
 * </pre>
 *
 * @author ww
 * @date 2015年6月11日 下午12:17:36
 *
 */
@Service
@CacheConfig(cacheNames = "testCache")
public class TestServiceImpl implements ITestService {

    private static final Logger logger = LoggerFactory.getLogger(TestServiceImpl.class);

    @Autowired
    private TestMapper testMapper;

    public void setTestMapper(TestMapper testMapper) {
        this.testMapper = testMapper;
    }

    // @Cacheable(value = "testCache")
    @Override
    public Test getTestById(Long id) {
        logger.info("@@@@@@@@@@@从数据库中查询的。。");
        return testMapper.selectByPrimaryKey(id);
    }

    @Override
    // @CacheEvict(value = "testCache", allEntries = true)
    // 清空 accountCache 缓存
    // @CachePut(value = "testCache", key = "#t.id" )
    @Cacheable
    public int inserTest(Test t) {
        logger.debug("情况testCache 中 全部的缓存");
        return testMapper.insert(t);
    }

    @Override
    @CacheEvict(value = "testCache", key = "#t.id ")
    public int updateTest(Test t) {
        logger.info("@@@@@@@@@@@使id为：{}  的缓存失效", t.getId());
        return testMapper.updateByPrimaryKey(t);
    }

    @Override
    @CacheEvict(value = "testCache", allEntries = true)
    // 清空 accountCache 缓存
    public void reload() {
        logger.info("@@@@@@@@@@@缓存都被清空了");

    }

    @Override
    @CacheEvict(value = "testCache")
    public int deleteById(Long id) {
        logger.info("删除id为：{} 的数据库记录，并清空该条缓存");
        return testMapper.deleteByPrimaryKey(id);
    }

}
