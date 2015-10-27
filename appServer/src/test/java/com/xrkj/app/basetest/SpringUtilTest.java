/**
 * Copyright(C) 2015-2025 杏仁科技
 * All rights reserved
 * 2015年6月23日 Created
 * 
 */
package com.xrkj.app.basetest;

import org.springframework.util.StringUtils;

import com.xrkj.app.user.model.AppUser;

/**
 * <pre>
 * 
 * </pre>
 *
 * @author wwh
 * @date 2015年6月23日 上午11:58:27
 *
 */
public class SpringUtilTest {
    public static void main(String[] args) {
        Object[] ob = new Object[] { null ,"asdfsd",100,new AppUser()};
        System.out.println(StringUtils.arrayToCommaDelimitedString(ob));
    }
}
