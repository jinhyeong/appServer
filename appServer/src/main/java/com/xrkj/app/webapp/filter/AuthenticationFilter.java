/**
 * Copyright(C) 2015-2025 杏仁科技
 * All rights reserved
 * 2015年6月25日 Created
 * 
 */
package com.xrkj.app.webapp.filter;

import static com.xrkj.app.Constants.REQUEST_MAPPING_AUTHORIZATION;
import static com.xrkj.app.Constants.REQUEST_MAPPING_ERROR;
import static com.xrkj.app.Constants.REQUEST_MAPPING_HOME;
import static com.xrkj.app.Constants.REQUEST_MAPPING_TEST;
import static com.xrkj.app.Constants.WELCOME_PAGE;
import static com.xrkj.app.Constants.FAVICON_ICO;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.net.URLCodec;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.OncePerRequestFilter;

import com.xrkj.app.Constants;
import com.xrkj.app.user.model.AppUser;
import com.xrkj.app.user.service.IUserService;
import com.xrkj.app.util.CodecUtils;
import com.xrkj.app.webapp.base.UserThreadLocalHolder;

/**
 * <pre>
 * 认证过滤器 authentication
 * 验证用户身份，进行安全检验
 * 
 * </pre>
 *
 * @author wwh
 * @date 2015年7月2日 下午6:57:29
 *
 */
public class AuthenticationFilter extends OncePerRequestFilter {
    /**
     * <pre>
     *  认证
     *  1、请求头中加入 【UID token】     ##不安全，token会被拦截，请求内容会被查看
     *  2、请求头中加入 【UID 以token作为密钥加密(URL + 随机数)】 token不在网络上进行传输，随机数保证每次请求的密文都不同，后台解密后对比URL并保存随机数
     *       保证相同的随机不能再次请求（在一定的时间范围内）    ##请求的数据可能会被篡改，内容会被查看到
     *  3、请求头中加入 【UID 以token作为密钥加密(URL + 随机数 + hash(请求内容))】前面的和上面一样，服务器收到请求后对内容进行hash，并对比解密后的hash，
     *       如果不等，则内容被篡改     ##内容会被查看到
     *  安全
     * 1、直接使用token作为密钥进行加密，然后在请求授权头中进行标记，收到该类型的请求后查找用户找到token进行解密（对称加密算法）
     * 2、使用HTTPS进行数据传输，由另外的过滤器控制
     * </pre>
     */

    // 如果需要通过数据库来进行动态配置
    // 注入对应的bean，然后在initFilterBean方法中加载配置信息

    private static final Logger logger = LoggerFactory.getLogger(AuthenticationFilter.class);

    // 先不使用正则表达式
    /**
     * <pre>
     * 不拦截的地址
     * </pre>
     */
    public static final String[] UNINTERCEPT_STATIC = new String[] { REQUEST_MAPPING_ERROR, REQUEST_MAPPING_HOME, REQUEST_MAPPING_AUTHORIZATION,
            REQUEST_MAPPING_TEST, WELCOME_PAGE, FAVICON_ICO };

    @Autowired
    private IUserService userService;

    // 这些参数应该是可以在web.xml 文件长进行配置的，sping会自动设置到属性上，等下试试看
    /**
     * <pre>
     * 默认启用
     * 测试时可以关闭，关闭后无法从请求对象中获取到user对象
     * </pre>
     */
    private boolean enable = true;

    /**
     * 可动态配置的不拦截路径
     */
    private String[] unintercept;

    public IUserService getUserService() {
        return userService;
    }

    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        if (!enable)
            logger.warn("### 授权过滤功能被关闭");
        this.enable = enable;
    }

    public String[] getUnintercept() {
        return unintercept;
    }

    public void setUnintercept(String[] unintercept) {
        logger.info("授权过滤器：不拦截这些地址：{}", Arrays.toString(unintercept));
        this.unintercept = unintercept;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.springframework.web.filter.OncePerRequestFilter#doFilterInternal(
     * javax.servlet.http.HttpServletRequest,
     * javax.servlet.http.HttpServletResponse, javax.servlet.FilterChain)
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        logger.debug("####### 进入授权控制拦截器   目前只校验用户的请求头中Authorization字段的 【id password】 ");

        // 先清空线程局部变量
        UserThreadLocalHolder.removeAppUser();

        if (!enable) {
            logger.warn("！！注意！！ 认证过滤器被禁用，所有请求都将通过");
            filterChain.doFilter(request, response);
            return;
        }

        String path = request.getServletPath();

        // 动态配置的不拦截列表
        if (unintercept != null && unintercept.length > 0) {
            for (String str : unintercept) {
                if (path.startsWith(str)) {
                    filterChain.doFilter(request, response);
                    return;
                }
            }
        }

        // 静态配置的不拦截列表
        if (UNINTERCEPT_STATIC != null && UNINTERCEPT_STATIC.length > 0) {
            for (String str : UNINTERCEPT_STATIC) {
                if (path.startsWith(str)) {
                    filterChain.doFilter(request, response);
                    return;
                }
            }
        }

        // 获得请求的路径和参数

        // 使用相对的路径

        String url = request.getRequestURL().toString();
        System.out.println(url);

        String URI = request.getRequestURI();
        System.out.println(URI);

        String query = request.getQueryString();
        System.out.println(query);

        StringBuffer requestPath = new StringBuffer(URI);
        if (query != null) {
            requestPath.append("?");
            requestPath.append(query);
        }
        
        //做一个客户端工具，模拟发请求，非HTTPS 的情况
        
        //String类型，UTF-8 编码
        //以空格分割
       //时间 随机数 url摘要  内容摘要(选填) 

        //URL解码
        String trueURL =CodecUtils.urlDecode(requestPath.toString());
        //对url 进行MD5
        String urlMd5 = CodecUtils.md5Hex(trueURL);
        
        //获取请求内容
        // BufferedReader br = request.getReader();
        // String line;
        // while((line=br.readLine())!=null){
        // System.out.println(line);
        // }
        // br.close();
       
       
        // 获得请求的内容
        // 进行has

       String bodyMd5 = CodecUtils.md5Hex(request.getInputStream());
       System.out.println(bodyMd5);
       
        // 校验授权key
        String authorization = request.getHeader(Constants.HTTP_HEAD_AUTHORIZATION);
        if (authorization == null || "".equals(authorization)) {
            unAuthorization(request, response);
            return;
        }

        Long uid;
        String token;
        try {
            // 抽取一个解析的方法出来
            // 解析异常时抛出授权异常来
            String[] auths = authorization.split("\\s+", 2); // 用一个或者多个空白字符分割

            logger.debug("用户的UID是：{}", auths[0]);
            logger.debug("用户的SID是：{}", auths[1]);

            uid = Long.parseLong(auths[0]);
            token = auths[1];

        } catch (Exception e) {
            logger.debug("解析认证信息异常", e);
            unAuthorization(request, response);
            return;
        }

        // 判断是否正确

        // 如果都不存在，或者已经过期

        // 从数据库中查询这个用户的 SID
        AppUser user = userService.getUserById(uid);

        if (user == null) {
            unAuthorization(request, response);
            return;
        }

        // 验证这个是否OK
        String pwd = user.getPassword();

        if (pwd.equals(token)) {
            // 如果OK
            logger.debug("@@@@ 用户ID：{}  认证通过", uid);
            // 放到请求对象中
            request.setAttribute(Constants.APP_USER_KEY, user);

            // 保存到线程局部变量中
            UserThreadLocalHolder.setAppUser(user);

            // 进行下一步动作
            filterChain.doFilter(request, response);

            // 清空线程局部变量
            UserThreadLocalHolder.removeAppUser();

        } else
            unAuthorization(request, response);

    }

    /**
     * 处理未授权
     * 
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void unAuthorization(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 转发
        // request.getRequestDispatcher("/error/unauthorized").forward(request,
        // response);
        // 发送到错误页面，由web.xml 文件定义
        response.sendError(401);
    }

}
