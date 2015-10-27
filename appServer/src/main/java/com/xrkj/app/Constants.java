/**
 * Copyright(C) 2015-2025 杏仁科技
 * All rights reserved
 * 2015-06-29 Created
 */
package com.xrkj.app;

/**
 * <pre>
 * 常量定义
 * </pre>
 *
 * @author wwh
 * @date 2015年7月3日 下午3:58:43
 *
 */
public final class Constants {
    private Constants() {
    }

    /**
     * 应用程序运行时名字，一般包括pid和计算机名
     */
    public static final String APP_RUNTIME_NAME = "app_runtime_name";

    /**
     * The name of the ResourceBundle used in this application
     */
    public static final String BUNDLE_KEY = "messages.ApplicationResources";

    /**
     * The name of the configuration hashmap stored in application scope.
     */
    public static final String CONFIG = "appConfig";

    /**
     * 应用程序版本
     */
    public static final String APP_VERSION = "app_version";

    /**
     * <pre>
     * 文件保存目录
     * 暂时先这么弄这
     * </pre>
     */
    public static final String FILE_SAVE_DIRECTORY = "C:\\FileBaseDirectory";

    /**
     * 邮件模板
     */
    public static final String EMIAL_TEMPLATE = "emialTemplate.vm";

    /**
     * HTTP 请求头中的认证授权字段
     */
    public static final String HTTP_HEAD_AUTHORIZATION = "Authorization";

    // 请求头中的内容是否需要保存

    // 向具体的实现屏蔽http？

    /**
     * 保存在请求对象中的user对象的key值
     */
    public static final String APP_USER_KEY = "_AppUser_KEY";

    /**
     * 请求中设置的语言环境
     */
    public static final String LOCALE_PARAMETER = "locale";

    // ################################################################
    // ########### 请求路径映射
    // ################################################################
    /**
     * 欢迎页面
     */
    public static final String WELCOME_PAGE = "/index.html";

    /**
     * 网站图标
     */
    public static final String FAVICON_ICO = "/favicon.ico";
    // controller
    /**
     * 错误请求根路径
     */
    public static final String REQUEST_MAPPING_ERROR = "/error";

    /**
     * Home请求根路径
     */
    public static final String REQUEST_MAPPING_HOME = "/home";

    /**
     * 测试请求根路径
     */
    public static final String REQUEST_MAPPING_TEST = "/test";

    /**
     * 授权请求根路径
     */
    public static final String REQUEST_MAPPING_AUTHORIZATION = "/auth";

    // ################################################################
    // ########## 下面开始定义系统的错误代码
    // ################################################################
    /**
     * 未定义的视图错误
     */
    public static final int ECODE_VIEW_XX = 1001;

    /**
     * 错误的请求
     */
    public static final int ECODE_VIEW_BAD_REQUEST = 1400;

    /**
     * 请求缺少参数
     */
    public static final int ECODE_VIEW_BAD_REQUEST_MISS_PARAM = 14001;

    /**
     * 请求参数校验不通过/无效参数
     */
    public static final int ECODE_VIEW_BAD_REQUEST_INVALID_PARAM = 14002;

    /**
     * 输入解析异常
     */
    public static final int ECODE_VIEW_BAD_REQUEST_PARSE_EXCEPTION = 14003;

    /**
     * JSON 解析异常
     */
    public static final int ECODE_VIEW_BAD_REQUEST_JSON_EXCEPTION = 14004;

    /**
     * 不能读取请求内容
     */
    public static final int ECODE_VIEW_BAD_REQUEST_UNREADABLE = 14005;

    /**
     * 认证未通过
     */
    public static final int ECODE_VIEW_AUTHENTICATION = 14011;

    /**
     * 请求的资源未授权
     */
    public static final int ECODE_VIEW_AUTHORIZATION = 14012;

    /**
     * 强制HTTPS
     */
    public static final int ECODE_VIEW_FORCE_HTTPS = 14034;

    /**
     * 资源未找到
     */
    public static final int ECODE_VIEW_NOT_FOUND = 1404;

    /**
     * 请求的方法不支持
     */
    public static final int ECODE_VIEW_METHOD_NOT_ALLOWED = 1405;

    /**
     * 不支持的请求类型
     */
    public static final int ECODE_VIEW_NOT_ACCEPTABLE = 1406;

    /**
     * <pre>
     * 服务器内部错误
     * 定义成视图层错误：因为是web容器回调ErrorController，算是在视图层处理
     * </pre>
     */
    public static final int ECODE_VIEW_SERVER_ERROR = 1500;

    /**
     * 未定义的业务逻辑错误
     */
    public static final int ECODE_BUSINESS_XX = 2001;

    /**
     * 未定义的服务错误
     */
    public static final int ECODE_SERVICE_XX = 3001;

    // ################################################################
    // ############ 缓存名称定义
    // ################################################################

    /**
     * 配置缓存
     */
    public static final String CACHE_NAME_CONFIG = "config";

    // ################################################################
    // ############ 日志类型，级别定义
    // ################################################################

    public static final String LOG_TYPE_TIME_CONSUME = "timeConsume";

}
