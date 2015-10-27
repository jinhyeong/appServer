/**
 * Copyright(C) 2015-2025 杏仁科技
 * All rights reserved
 * 2015年7月24日 Created
 * 
 */
package com.xrkj.app.verification.service.impl;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.code.kaptcha.Producer;
import com.xrkj.app.base.service.BaseService;
import com.xrkj.app.exception.BusinessException;
import com.xrkj.app.verification.dao.ICaptchaDao;
import com.xrkj.app.verification.model.Captcha;
import com.xrkj.app.verification.service.ICaptchaService;

/**
 * <pre>
 * 验证码服务类实现
 * </pre>
 *
 * @author wwh
 * @date 2015年7月24日 上午11:14:06
 *
 */
@Service
public class CaptchaServiceImpl extends BaseService implements ICaptchaService {

    private static final Logger log = LoggerFactory.getLogger(CaptchaServiceImpl.class);

    @Autowired
    private Producer captchaProducer;

    @Autowired
    private ICaptchaDao captchaDaoImpl;

    @Override
    public Captcha createCaptch() {
        Captcha captcha = new Captcha();
        captcha.setUuid(UUID.randomUUID().toString());

        String capText = captchaProducer.createText();
        captcha.setText(capText);

        log.debug("生成的验证码是：{}", capText);

        BufferedImage bi = captchaProducer.createImage(capText);
        captcha.setImage(bi);

        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        try {
            ImageIO.write(bi, "jpg", bout);
        } catch (IOException e) {
            log.error("图片转换成byte错误", e);
            throw new BusinessException("验证码转换错误", e);
        }

        captcha.setImageByte(bout.toByteArray());

        captcha.setDate(new Date());

        // 生成的验证码需要保存起来
        // 保存到redis中应该就可以了
        captchaDaoImpl.saveTextByUUID(captcha);

        return captcha;
    }

    @Override
    public int verifyCaptch(String uuid, String text) {
        // 一个验证码应该是可以验证多次的，一旦验证通过则应该删除
        
        String trueText = captchaDaoImpl.getTextByUUID(uuid);
        // 返回空表示验证码过期被缓存清理了，或者 这个UUID 根本不存在
        if (trueText == null) {
            return VERIFY_INEXISTENCE;
        }

        if (trueText.equalsIgnoreCase(text)) {
            // 验证通过，清空
            captchaDaoImpl.cleanUUID(uuid);
            return VERIFY_PASS;
        }

        return VERIFY_NOT_PASS;
    }

}
