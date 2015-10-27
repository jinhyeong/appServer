/**
 * Copyright(C) 2015-2025 杏仁科技
 * All rights reserved
 * 2015年6月30日 Created
 * 
 */
package com.xrkj.app.webapp.base.controller;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.MessageSourceAccessor;

import com.xrkj.app.Constants;
import com.xrkj.app.user.model.AppUser;
import com.xrkj.app.webapp.base.UserThreadLocalHolder;

/**
 * <pre>
 * 控制器基类
 * 提供一些通用的功能
 * </pre>
 *
 * @author wwh
 * @date 2015年7月3日 下午7:11:57
 *
 */
public class BaseController implements IController {

    @SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(BaseController.class);

    private ServletContext servletContext;
    private MessageSourceAccessor messages;

    @Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    @Autowired
    public void setMessages(MessageSource messageSource) {
        messages = new MessageSourceAccessor(messageSource);
    }

    @Override
    public String getText(String msgKey, Locale locale) {
        return messages.getMessage(msgKey, locale);
    }

    @Override
    public String getText(String msgKey) {
        return messages.getMessage(msgKey, LocaleContextHolder.getLocale());
    }

    @Override
    public String getText(String msgKey, String arg, Locale locale) {
        return getText(msgKey, new Object[] { arg }, locale);
    }

    @Override
    public String getText(String msgKey, String arg) {
        return getText(msgKey, new Object[] { arg }, LocaleContextHolder.getLocale());
    }

    @Override
    public String getText(String msgKey, Locale locale, Object... args) {
        return messages.getMessage(msgKey, args, locale);
    }

    @Override
    public String getText(String msgKey, Object... args) {
        return messages.getMessage(msgKey, args, LocaleContextHolder.getLocale());
    }

    @Override
    public Map<String, Object> getConfiguration() {
        @SuppressWarnings("unchecked")
        Map<String, Object> config = (HashMap<String, Object>) servletContext.getAttribute(Constants.CONFIG);

        if (config == null) {
            return new HashMap<String, Object>();
        }

        return config;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.xrkj.app.webapp.base.IController#setAppUser(com.xrkj.app.user.model
     * .AppUser)
     */
    @Override
    public void setAppUser(AppUser appUser) {
        UserThreadLocalHolder.setAppUser(appUser);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.xrkj.app.webapp.base.IController#getAppUser()
     */
    @Override
    public AppUser getAppUser() {
        return UserThreadLocalHolder.getAppUser();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.xrkj.app.webapp.base.controller.IController#removeAppUser()
     */
    @Override
    public void removeAppUser() {
        UserThreadLocalHolder.removeAppUser();
    }
}
