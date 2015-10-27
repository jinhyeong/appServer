/**
 * Copyright(C) 2015-2025 杏仁科技
 * All rights reserved
 * 2015年6月23日 Created
 * 
 */
package com.xrkj.app.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xrkj.app.user.service.ITestService;

/**
 * <pre>
 * 使用testService 测试redis 缓存
 * </pre>
 *
 * @author wwh
 * @date 2015年6月23日 上午10:39:42
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext-resources.xml", "classpath:applicationContext-dao.xml",
        "classpath:applicationContext-service.xml", "classpath:applicationContext.xml" })
public class TestRedisCache {

    private static final Logger logger = LoggerFactory.getLogger(TestRedisCache.class);

    @Autowired
    private ITestService testService;

    public void setTestService(ITestService testService) {
        this.testService = testService;
    }

    @Test
    public void insertTest() {
        com.xrkj.app.user.model.Test t;

        t = testService.getTestById(1l);
        logger.info(t == null ? "结果为空" : t.toString());

        t = testService.getTestById(1l);
        logger.info(t == null ? "结果为空" : t.toString());

        if (1 == 1) {
            return;
        }

        t = testService.getTestById(42l);
        logger.info(t == null ? "结果为空" : t.toString());

        // 插入测试
        t = new com.xrkj.app.user.model.Test();
        t.setName("测试");
        t.setPwd("测试密码");

        int rt = testService.inserTest(t);
        assertEquals(rt, 1);
        logger.info(t.toString());

        long insertID = t.getId();
        logger.info("插入对象ID为：{}", insertID);
        // 查询
        t = testService.getTestById(insertID);
        logger.info(t.toString());

        logger.info("再次查询");
        t = testService.getTestById(insertID);
        logger.info(t.toString());

        // 修改测试
        t.setT1("字段T1额");
        logger.info("######## 修改T对象，测试缓存是否被清空");
        logger.info("updateTest(t)执行结果：{}", testService.updateTest(t));

        logger.info("查询");
        t = testService.getTestById(insertID);
        logger.info(t.toString());

        logger.info("再次查询");
        t = testService.getTestById(insertID);
        logger.info(t.toString());

        // 删除测试
        rt = testService.deleteById(insertID);
        logger.info("删除结果：{}", rt);

        logger.info("再次查询");
        t = testService.getTestById(insertID);
        logger.info(t == null ? "结果为空" : t.toString());

        logger.info("######## 调用 reload 方法，清空缓存");
        testService.reload();

        t = testService.getTestById(insertID);
        logger.info(t == null ? "结果为空" : t.toString());

        t = testService.getTestById(insertID);
        logger.info(t == null ? "结果为空" : t.toString());
    }

}
