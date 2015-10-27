/**
 * Copyright(C) 2015-2025 杏仁科技
 * All rights reserved
 * 2015年7月27日 Created
 */
package com.xrkj.app.verification.service;

import javax.mail.MessagingException;

import com.xrkj.app.base.service.IService;

/**
 * <pre>
 * 邮件服务
 * </pre>
 *
 * @author wwh
 * @date 2015年7月27日 下午5:32:12
 *
 */
public interface IMailService extends IService {

    //验证邮件 表现上应该有两种方式 （原理上都是一样的）
    //1.点连接进行验证
    //2.邮件里面有一个验证码，可以在某个地方输入这个验证码进行验证
    
    /**
     * 验证邮箱
     * @param emailAddr 要验证的邮箱地址
     * @throws MessagingException 
     */
    void sendVerifyEMail(String emailAddr) throws MessagingException;
}
