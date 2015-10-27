/**
 * Copyright(C) 2015-2025 杏仁科技
 * All rights reserved
 * 2015年7月27日 Created
 */
package com.xrkj.app.verification;

import javax.mail.MessagingException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xrkj.app.verification.service.IMailService;

/**
 * <pre>
 * 测试邮件发送功能
 * </pre>
 *
 * @author wwh
 * @date 2015年7月27日 下午6:19:41
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext-resources.xml", "classpath:applicationContext-dao.xml",
        "classpath:applicationContext-service.xml", "classpath:applicationContext.xml" })
public class EmailTest {
    private static final Logger logger = LoggerFactory.getLogger(EmailTest.class);

    @Autowired
    private IMailService mailService;

    @Test
    public void testSendMail() {
        try {
            mailService.sendVerifyEMail("wangwen135@qq.com");
        } catch (MessagingException e) {
            logger.error("邮件发送失败", e);
            Assert.assertTrue(false);
        }
    }
}
