package com.xrkj.app.webapp.filter;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.xrkj.app.Constants;

/**
 * <pre>
 * 从请求参数或者请求头中查找local
 * 如果找到将其保存到LocaleContextHolder，并重新包装请求
 * </pre>
 *
 * @author wwh
 * @date 2015年7月3日 下午4:43:52
 *
 */
@WebFilter(filterName = "locale", urlPatterns = "/*")
public class LocaleFilter extends OncePerRequestFilter {
    /*
     * (non-Javadoc)
     * 
     * @see
     * org.springframework.web.filter.OncePerRequestFilter#doFilterInternal(
     * javax.servlet.http.HttpServletRequest,
     * javax.servlet.http.HttpServletResponse, javax.servlet.FilterChain)
     */
    public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {

        // 先清空，避免执行过程中出异常，无法清空的情况
        LocaleContextHolder.setLocaleContext(null);

        // 先从请求参数中取
        String locale = request.getParameter(Constants.LOCALE_PARAMETER);
        if (locale == null) {
            // 再从请求头中取
            locale = request.getHeader(Constants.LOCALE_PARAMETER);
        }

        Locale preferredLocale = null;

        if (locale != null) {
            int indexOfUnderscore = locale.indexOf('_');
            if (indexOfUnderscore != -1) {
                String language = locale.substring(0, indexOfUnderscore);
                String country = locale.substring(indexOfUnderscore + 1);
                preferredLocale = new Locale(language, country);
            } else {
                preferredLocale = new Locale(locale);
            }
        }

        if (preferredLocale != null && !(request instanceof LocaleRequestWrapper)) {
            request = new LocaleRequestWrapper(request, preferredLocale);
            LocaleContextHolder.setLocale(preferredLocale);
        } else {
            // 设置默认的local
            LocaleContextHolder.setLocale(request.getLocale());
        }

        chain.doFilter(request, response);

        // Reset thread-bound LocaleContext.
        LocaleContextHolder.setLocaleContext(null);
    }
}
