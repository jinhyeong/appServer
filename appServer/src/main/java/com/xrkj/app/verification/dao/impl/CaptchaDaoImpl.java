/**
 * Copyright(C) 2015-2025 杏仁科技
 * All rights reserved
 * 2015年7月24日 Created
 * 
 */
package com.xrkj.app.verification.dao.impl;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.xrkj.app.verification.dao.ICaptchaDao;
import com.xrkj.app.verification.model.Captcha;

/**
 * <pre>
 * 验证码dao
 * </pre>
 *
 * @author wwh
 * @date 2015年7月24日 上午11:32:18
 *
 */
@Repository
@CacheConfig(cacheNames = "captcha")
public class CaptchaDaoImpl implements ICaptchaDao {

    @Override
    @CachePut(key = "#captcha.uuid")
    public String saveTextByUUID(Captcha captcha) {
        return captcha.getText();
    }

    @Override
    @Cacheable(unless = "true")
    public String getTextByUUID(String uuid) {
        // unless="true" 不被缓存
        return null;
    }

    @Override
    @CacheEvict
    public void cleanUUID(String uuid) {
    }

}
