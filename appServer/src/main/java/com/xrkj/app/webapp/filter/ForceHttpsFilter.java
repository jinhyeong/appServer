package com.xrkj.app.webapp.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <pre>
 * 强制使用HTTPS的过滤器
 * </pre>
 *
 * @author ww
 * @date 2015年6月5日 上午10:19:34
 *
 */
public class ForceHttpsFilter implements Filter {

    //注入对应的bean对象
    //然后在后处理方法中加载数据库中配置的数据
    //实现HTTPS的动态配置
    
	private static final Logger logger = LoggerFactory.getLogger(ForceHttpsFilter.class);
	/**
	 * web.xml 文件中的配置key 强中HTTPS
	 */
	public static final String KEY_FORCEHTTPS_CONFIG = "forceHTTPS";

	/**
	 * 强制HTTPS
	 */
	private String[] forceHttps_config;

	/**
	 * 强制HTTPS -- 固定的
	 */
	public static final String[] forceHTTPS = new String[] {};

	public String[] getForceHttps_config() {
		return forceHttps_config;
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		String fc = filterConfig.getInitParameter(KEY_FORCEHTTPS_CONFIG);
		if (fc != null && !"".equals(fc)) {
			logger.info("授权过滤器：这些地址强制使用HTTPS：{}", fc);
			forceHttps_config = fc.split(";");
		}

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		String protocol = req.getProtocol();//还不确定是否是这么做的
		// 判断是否是HTTPS的
		if ("HTTPS".equals(protocol)) {
			// HTTPS的请求全部通过
			chain.doFilter(request, response);
		}

		String path = req.getServletPath();
		if (forceHttps_config != null && forceHttps_config.length > 0) {
			for (String str : forceHttps_config) {
				if (path.startsWith(str)) {
					// 转发到错误页面
					res.sendRedirect("/error/forceHTTPS");
				}
			}
		}

		if (forceHTTPS != null && forceHTTPS.length > 0) {
			for (String str : forceHTTPS) {
				if (path.startsWith(str)) {
					// 转发到错误页面
					res.sendRedirect("/error/forceHTTPS");
				}
			}
		}

		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {

	}

}
