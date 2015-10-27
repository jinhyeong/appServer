/**
 * Copyright(C) 2015-2025 杏仁科技
 * All rights reserved
 * 2015年6月30日 Created
 * 
 */
package com.xrkj.app.webapp.base.controller;

import java.util.Locale;
import java.util.Map;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.ServletContextAware;

import com.xrkj.app.user.model.AppUser;

/**
 * <pre>
 * 统一控制器接口
 * 相关属性只能保存在线程局部变量中
 * 使用完成后需要清理
 * </pre>
 *
 * @author wwh
 * @date 2015年6月30日 下午5:46:36
 *
 */
@RestController
interface IController extends ServletContextAware {
    /**
     * 根据指定的语言环境获取信息
     * 
     * @param msgKey
     * @param locale
     * @return
     */
    String getText(String msgKey, Locale locale);

    /**
     * 根据当前线程的语言环境来获取信息
     * 
     * @param msgKey
     * @return
     */
    String getText(String msgKey);

    /**
     * 根据指定的语言环境获取信息
     * 
     * @param msgKey
     * @param arg
     * @param locale
     * @return
     */
    String getText(String msgKey, String arg, Locale locale);

    /**
     * 根据当前线程的语言环境来获取信息
     * 
     * @param msgKey
     * @param arg
     * @return
     */
    String getText(String msgKey, String arg);

    /**
     * 根据指定的语言环境获取信息
     * 
     * @param msgKey
     * @param locale
     * @param args
     * @return
     */
    String getText(String msgKey, Locale locale, Object... args);

    /**
     * 根据当前线程的语言环境来获取信息
     * 
     * @param msgKey
     * @param args
     * @return
     */
    String getText(String msgKey, Object... args);

    /**
     * 获取ServletContext 中保存的配置信息
     * 
     * @return
     */
    Map<String, Object> getConfiguration();

    /**
     * <pre>
     * 设置appUser 对象
     * </pre>
     * 
     * @param appUser
     */
    void setAppUser(AppUser appUser);

    /**
     * 移除appUser对象
     */
    void removeAppUser();

    /**
     * <pre>
     * 获取appUser对象
     * </pre>
     * 
     * @return
     */
    AppUser getAppUser();
}
