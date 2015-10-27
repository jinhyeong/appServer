/**
 * Copyright(C) 2015-2025 杏仁科技
 * All rights reserved
 * 2015年7月3日 Created
 * 
 */
package com.xrkj.app.webapp.base;

import com.xrkj.app.user.model.AppUser;

/**
 * <pre>
 * User线程局部变量
 * 如果支持异步的话，应该就不能放到线程局部变量中了，得放到如请求对象中
 * </pre>
 *
 * @author wwh
 * @date 2015年7月3日 上午10:16:05
 *
 */
public class UserThreadLocalHolder {
    private static final ThreadLocal<AppUser> appUserThreadLocal = new ThreadLocal<AppUser>();

    /**
     * 保存一个user对象到线程局部变量中
     * 
     * @param appUser
     */
    public static void setAppUser(AppUser appUser) {
        appUserThreadLocal.set(appUser);
    }

    /**
     * 从线程局部变量中获取一个user对象
     * 
     * @return
     */
    public static AppUser getAppUser() {
        return appUserThreadLocal.get();
    }

    /**
     * 从线程局部变量中移除user对象
     */
    public static void removeAppUser() {
        appUserThreadLocal.remove();
    }
}
