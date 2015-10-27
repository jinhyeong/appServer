package com.xrkj.app.user;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.PostConstruct;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import net.sf.ehcache.Statistics;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.xrkj.app.user.model.AppUser;
import com.xrkj.app.user.service.ITestService;
import com.xrkj.app.user.service.IUserService;

@RunWith(SpringJUnit4ClassRunner.class)
// 表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = { "classpath:applicationContext-resources.xml", "classpath:applicationContext-dao.xml",
        "classpath:applicationContext-service.xml" })
// @ActiveProfiles("test")
// @Transactional
// 如果是true不会改变数据库数据，如果是false会改变数据
// @TransactionConfiguration(transactionManager = "transactionManager",
// defaultRollback = true)
public class TestUser {

    private static final Logger logger = LoggerFactory.getLogger(TestUser.class);

    @Autowired
    private IUserService userService;

    @Autowired
    private ITestService testService;

    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    public void setTestService(ITestService testService) {
        this.testService = testService;
    }

    @Test
    public void test1() {
        logger.info("@@@@@@@@@@@@@@@  开始进入测试");
        AppUser user = userService.getUserById(-3);
        logger.info(user.toString());
        logger.info("第二次查询。。");
        monitor();
        user = userService.getUserById(-3);
        logger.info(user.toString());
        monitor();
        assertNotNull(user);

    }

    @Test
    public void insertTest() {
        com.xrkj.app.user.model.Test t = new com.xrkj.app.user.model.Test();
        t.setName("测试");
        t.setPwd("测试密码");

        logger.info("插入对象");

        int it = testService.inserTest(t);
        monitor();
        assertEquals(it, 1);

        logger.info(t.toString());

        long insertID = t.getId();

        t = testService.getTestById(insertID);
        logger.info(t.toString());
        monitor();
        t = testService.getTestById(insertID);
        logger.info(t.toString());
        monitor();
        t.setT1("字段T1额");
        logger.info("######## 修改T对象，测试缓存是否被清空");
        logger.info("updateTest(t)执行结果：{}", testService.updateTest(t));
        monitor();
        t = testService.getTestById(insertID);
        logger.info(t.toString());
        monitor();
        t = testService.getTestById(insertID);
        logger.info(t.toString());
        monitor();
        logger.info("######## 调用 reload 方法，清空缓存");
        testService.reload();
        monitor();
        t = testService.getTestById(insertID);
        logger.info(t.toString());
        monitor();
        t = testService.getTestById(insertID);
        logger.info(t.toString());
        monitor();
        t = testService.getTestById(insertID);
        logger.info(t.toString());
        monitor();
    }

    public static void main(String[] args) {
        @SuppressWarnings("resource")
        ClassPathXmlApplicationContext appcontext = new ClassPathXmlApplicationContext("applicationContext-resources.xml", "applicationContext-dao.xml",
                "applicationContext-service.xml");

        IUserService userService = appcontext.getBean(IUserService.class);

        AppUser user = userService.getUserById(-3);
        System.out.println(user.toString());

        logger.info(JSON.toJSONString(user));

    }

    // org.springframework.cache.ehcache.EhCacheCacheManager

    @Autowired
    private EhCacheCacheManager ehCacheCacheManager;

    public EhCacheCacheManager getEhCacheCacheManager() {
        return ehCacheCacheManager;
    }

    public void setEhCacheCacheManager(EhCacheCacheManager ehCacheCacheManager) {
        this.ehCacheCacheManager = ehCacheCacheManager;
    }

    // 查看一下缓存信息
    private CacheManager manager;

    @PostConstruct
    public void initCacheManager() {
        manager = ehCacheCacheManager.getCacheManager();
    }

    public void monitor() {
        DateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String[] cacheNames = manager.getCacheNames();
        System.out.println("############ 缓存列表 ############");
        
        for (int i = 0; i < cacheNames.length; i++) {
            System.out.println("----------------------------------------------------------------------------------");
            System.out.println((i + 1) + "  缓存名字： " + cacheNames[i]);
            Cache cache = manager.getCache(cacheNames[i]);
            // 缓存元素集合
            
            List keys = cache.getKeys();
            System.out.println("该缓存下一共有："+keys.size());
            System.out.println("-----------------------缓存元素统计数据---------------------------------");
            for (int j =0;j<keys.size();j++) {
                Object key =keys.get(j);
                System.out.println("第 ["+(j+1)+"] 个 key=" +key);
                Element ele = cache.get(key);
                System.out.println("内容: " + ele.getObjectValue());
                System.out.println("创建时间: " + sf.format(ele.getCreationTime()));
                System.out.println("最后访问时间: " + sf.format(ele.getLastAccessTime()));
                System.out.println("过期时间: " + sf.format(ele.getExpirationTime()));
                System.out.println("最后更新时间: " + sf.format(ele.getLastUpdateTime()));
                System.out.println("命中次数: " + ele.getHitCount());
                System.out.println("存活时间: " + ele.getTimeToLive() + "sec");
                System.out.println("空闲时间: " + ele.getTimeToIdle() + "sec");
            }

            System.out.println("-----------------------缓存总统计数据---------------------------------");
            long elementsInMemory1 = cache.getMemoryStoreSize();
            System.out.println("得到缓存对象占用内存的数量：" + elementsInMemory1);

            long elementsInMemory2 = cache.getDiskStoreSize();
            System.out.println("得到缓存对对象占用磁盘的数量：" + elementsInMemory2);

            // 获取缓存统计对象
            Statistics stat = cache.getStatistics();
            long hits = stat.getCacheHits();
            System.out.println("得到缓存读取的命中次数：" + hits);

            long memoryHits = stat.getInMemoryHits();
            System.out.println("得到内存中缓存读取的命中次数：" + memoryHits);

            long diskHits = stat.getOnDiskHits();
            System.out.println("得到磁盘中缓存读取的命中次数：" + diskHits);

            long cacheMisses = stat.getCacheMisses();
            System.out.println("得到缓存读取的丢失次数：" + cacheMisses);

            long evictionCount = stat.getEvictionCount();
            System.out.println("得到缓存读取的已经被销毁的对象丢失次数：" + evictionCount);

            System.out.println("--------------------------------------------------------");
        }

    }
}
