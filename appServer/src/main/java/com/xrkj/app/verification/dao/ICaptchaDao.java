/**
 * Copyright(C) 2015-2025 杏仁科技
 * All rights reserved
 * 2015年7月24日 Created
 * 
 */
package com.xrkj.app.verification.dao;

import com.xrkj.app.base.dao.IDao;
import com.xrkj.app.verification.model.Captcha;

/**
 * <pre>
 * 验证码DAO
 * </pre>
 *
 * @author wwh
 * @date 2015年7月24日 上午11:31:52
 *
 */
public interface ICaptchaDao extends IDao {

    /**
     * <pre>
     * 保存text到redis
     * 以UUID为KEY
     * redis过期自动清理
     * </pre>
     * 
     * @return 验证码文本
     */
    String saveTextByUUID(Captcha captcha);

    /**
     * 根据UUID获取text
     * 
     * @param uuid
     * @return 验证码的文本
     */
    String getTextByUUID(String uuid);

    /**
     * 清除UUID的对应的值
     * 
     * @param uuid
     */
    void cleanUUID(String uuid);
}
