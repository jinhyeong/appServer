/**
 * Copyright(C) 2015-2025 杏仁科技
 * All rights reserved
 * 2015年6月23日 Created
 * 
 */
package com.xrkj.app.user;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.xrkj.app.user.model.AppUser;
import com.xrkj.app.user.service.ITestService;
import com.xrkj.app.user.service.IUserService;

/**
 * <pre>
 * 
 * </pre>
 *
 * @author wwh
 * @date 2015年6月23日 上午10:39:42
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
// 表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = { "classpath:applicationContext-resources.xml", "classpath:applicationContext-dao.xml",
        "classpath:applicationContext-service.xml" })
public class UserTest2 {

    private static final Logger logger = LoggerFactory.getLogger(UserTest2.class);

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
        user = userService.getUserById(-3);
        logger.info(user.toString());
        assertNotNull(user);

    }

    @Test
    public void insertTest() {
        com.xrkj.app.user.model.Test t = new com.xrkj.app.user.model.Test();
        t.setName("测试");
        t.setPwd("测试密码");

        int it = testService.inserTest(t);
        assertEquals(it, 1);
        logger.info(t.toString());
        long insertID = t.getId();
        logger.info("插入对象ID为：{}", insertID);

        t = testService.getTestById(insertID);
        logger.info(t.toString());
        logger.info("再次查询");
        t = testService.getTestById(insertID);
        logger.info(t.toString());
        t.setT1("字段T1额");
        logger.info("######## 修改T对象，测试缓存是否被清空");
        logger.info("updateTest(t)执行结果：{}", testService.updateTest(t));

        logger.info("查询");
        t = testService.getTestById(insertID);
        logger.info(t.toString());
        logger.info("再次查询");
        t = testService.getTestById(insertID);
        logger.info(t.toString());
        logger.info("######## 调用 reload 方法，清空缓存");
        testService.reload();
        t = testService.getTestById(insertID);
        logger.info(t.toString());
        t = testService.getTestById(insertID);
        logger.info(t.toString());
        t = testService.getTestById(insertID);
        logger.info(t.toString());
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

}
