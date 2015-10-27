package com.xrkj.app.webapp.listener;

import java.io.IOException;
import java.io.InputStream;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.jar.Attributes;
import java.util.jar.Manifest;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xrkj.app.Constants;

/**
 * <pre>
 * 用来初始化、数据库设置、填充任何应用程序范围的信息
 * 目前看来是没什么用的
 * 
 * 是否考虑给每个实例生成一个固定的编号：如：IP + xxxx + (执行目录等，一般不同的实例会保存到不同的目录，比较容易区分)
 * 用于标记一些信息，如记录日志时可能需要
 * </pre>
 *
 * @author wwh
 * @date 2015年7月1日 下午2:26:05
 *
 */
@WebListener
public class StartupListener implements ServletContextListener {
    private static final Logger logger = LoggerFactory.getLogger(StartupListener.class);

    public void contextInitialized(ServletContextEvent event) {
        logger.info("初始化上下文...");

        ServletContext context = event.getServletContext();

        // 检查配置信息
        @SuppressWarnings("unchecked")
        Map<String, Object> config = (HashMap<String, Object>) context.getAttribute(Constants.CONFIG);

        if (config == null) {
            config = new HashMap<String, Object>();
        }

        // ApplicationContext ctx =
        // WebApplicationContextUtils.getRequiredWebApplicationContext(context);

        RuntimeMXBean runtime = ManagementFactory.getRuntimeMXBean();
        String name = runtime.getName();

        config.put(Constants.APP_RUNTIME_NAME, name);

        context.setAttribute(Constants.CONFIG, config);

        // 版本号可以从配置文件中取

        // Determine version number for CSS and JS Assets
        String appVersion = null;
        try {
            InputStream is = context.getResourceAsStream("/META-INF/MANIFEST.MF");
            if (is == null) {
                logger.warn("META-INF/MANIFEST.MF not found.");
            } else {
                Manifest mf = new Manifest();
                mf.read(is);
                Attributes atts = mf.getMainAttributes();
                appVersion = atts.getValue("Implementation-Version");
            }
        } catch (IOException e) {
            logger.error("I/O Exception reading manifest: " + e.getMessage());
        }

        // If there was a build number defined in the war, then use it for
        // the cache buster. Otherwise, assume we are in development mode
        // and use a random cache buster so developers don't have to clear
        // their browser cache.
        if (appVersion == null || appVersion.contains("SNAPSHOT")) {
            appVersion = "" + new Random().nextInt(100000);
        }
        // 这个版本号暂时也没什么用
        logger.info("Application version set to: " + appVersion);
        context.setAttribute(Constants.APP_VERSION, appVersion);
    }

    /*
     * (non-Javadoc)
     * 
     * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.
     * ServletContextEvent)
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }

}
