/**
 * Copyright(C) 2015-2025 杏仁科技
 * All rights reserved
 * 2015年7月15日 Created
 */
package com.xrkj.app.webapp.conversion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

import org.springframework.core.convert.converter.Converter;

import com.xrkj.app.exception.InputParseException;

/**
 * <pre>
 * 时间转换
 * spring 已经提供了注解
 * @DateTimeFormat(pattern="yyyy-MM-dd")
 * </pre>
 *
 * @author wwh
 * @date 2015年7月15日 上午10:29:30
 *
 */
public class DateConverter implements Converter<String, Date> {

    private static final Pattern p1 = Pattern.compile("\\d{4}-\\d{1,2}-\\d{1,2}");
    private static final Pattern p2 = Pattern.compile("\\d{4}-\\d{1,2}-\\d{1,2} \\d{1,2}:\\d{1,2}:\\d{1,3}");

    // 这个需要考虑线程安全性的问题
    private final SimpleDateFormat f1 = new SimpleDateFormat("yyyy-MM-dd");
    private final SimpleDateFormat f2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:sss");

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.springframework.core.convert.converter.Converter#convert(java.lang
     * .Object)
     */
    @Override
    public Date convert(String source) {
        if (source == null || "".equals(source))
            return null;

        if (p1.matcher(source).matches()) {
            try {
                return f1.parse(source);
            } catch (ParseException e) {
                // 抛出异常
                throw new InputParseException(e);
            }
        }

        if (p2.matcher(source).matches()) {
            try {
                return f2.parse(source);
            } catch (ParseException e) {
                // 抛出异常
                throw new InputParseException(e);
            }
        }

        return null;
    }

}
