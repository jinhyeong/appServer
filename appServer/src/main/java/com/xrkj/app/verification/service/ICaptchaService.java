/**
 * Copyright(C) 2015-2025 杏仁科技
 * All rights reserved
 * 2015年7月24日 Created
 * 
 */
package com.xrkj.app.verification.service;

import com.xrkj.app.base.service.IService;
import com.xrkj.app.verification.model.Captcha;

/**
 * <pre>
 * 验证码服务类
 * </pre>
 *
 * @author wwh
 * @date 2015年7月24日 上午11:11:20
 *
 */
public interface ICaptchaService extends IService {

    /**
     * 验证通过
     */
    public static final int VERIFY_PASS = 0;
    /**
     * 验证不通过
     */
    public static final int VERIFY_NOT_PASS = 1;
    /**
     * 验证码不存在
     */
    public static final int VERIFY_INEXISTENCE = 2;

    /**
     * 生成一个验证码
     * 
     * @return 返回验证码信息
     */
    Captcha createCaptch();

    /**
     * 校验验证码
     * 
     * @param uuid
     * @param text
     * @return 0=验证通过，1=验证不通过，2=UUID不存在
     */
    int verifyCaptch(String uuid, String text);
}
