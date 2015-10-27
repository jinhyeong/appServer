/**
 * Copyright(C) 2015-2025 杏仁科技
 * All rights reserved
 * 2015年7月27日 Created
 */
package com.xrkj.app.verification.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.task.TaskExecutor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;

import com.xrkj.app.Constants;
import com.xrkj.app.base.service.BaseService;
import com.xrkj.app.verification.service.IMailService;

/**
 * <pre>
 * 邮件服务实现
 * </pre>
 *
 * @author wwh
 * @date 2015年7月27日 下午5:39:26
 *
 */
@Service
public class MailServiceImpl extends BaseService implements IMailService {

    @Value("${mail.default.from}")
    private String defaultFrom = "test@test.com";

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private VelocityEngine velocityEngine;

    @Autowired
    private TaskExecutor taskExecutor;

    @Override
    public void sendVerifyEMail(String emailAddr) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

        helper.setFrom(defaultFrom);
        helper.setTo(emailAddr);
        helper.setSubject("邮件主题：验证测试");

        Map<String, Object> map = new HashMap<String, Object>();

        map.put("userName", "测试用户");
        map.put("userId", new Random().nextInt(10000));
        map.put("eMail", emailAddr);
        map.put("vCode", UUID.randomUUID().toString());
        Object vv = velocityEngine.getProperty(RuntimeConstants.FILE_RESOURCE_LOADER_PATH);
        System.out.println(vv);

        String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, Constants.EMIAL_TEMPLATE, "UTF-8", map);

        helper.setText(text, true);

        // imgTest.jpg
        ClassPathResource res = new ClassPathResource("imgTest.jpg");
        helper.addInline("imgTest", res);

        mailSender.send(message);
    }
}
