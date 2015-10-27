/**
 * Copyright(C) 2015-2025 杏仁科技
 * All rights reserved
 * 2015年7月23日 Created
 * 
 */
package com.xrkj.app.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.xrkj.app.comm.model.Logging;
import com.xrkj.app.webapp.common.viewObj.CommonVo;

/**
 * <pre>
 * 
 * </pre>
 *
 * @author wwh
 * @date 2015年7月23日 上午11:49:53
 *
 */
public class TestController {

    //指定异常类型
    //@Test(expected = HttpClientErrorException.class)
    
    @Rule
    public ExpectedException expectedEx = ExpectedException.none();
    
    @Test
    @Ignore
    public void putLogging() {
        final String url = "http://localhost:8080/test/putLogging";
        Logging log = new Logging();
        log.setMessage("测试RestTemplate。。。。");
        // log.setType("tt1");
        RestTemplate template = new RestTemplate();
        
        //异常处理
        //抛出异常类型
        expectedEx.expect(HttpClientErrorException.class);
        //异常信息中含有
        expectedEx.expectMessage("400");
        
        ResponseEntity<Logging> rEntity = template.postForEntity(url, log, Logging.class);
        HttpStatus httpStatus = rEntity.getStatusCode();
        System.out.println(httpStatus);

    }

    @Test
    public void describe() {
        RestTemplate template = new RestTemplate();
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();

        FastJsonHttpMessageConverter fastJsonConverter = new FastJsonHttpMessageConverter();
        messageConverters.add(fastJsonConverter);

        // template.setMessageConverters(messageConverters);

        final String url = "http://localhost:8080/test";

        ResponseEntity<CommonVo[]> entity = template.getForEntity(url, CommonVo[].class);

        CommonVo[] body = entity.getBody();
        for (CommonVo commonVo : body) {
            System.out.println(commonVo);
        }

        MediaType contentType = entity.getHeaders().getContentType();
        System.out.println(contentType);

        HttpStatus statusCode = entity.getStatusCode();
        System.out.println(statusCode);

    }

    @Test
    public void ping() {
        RestTemplate template = new RestTemplate();
        final String url = "http://localhost:8080/test/ping";

        ResponseEntity<CommonVo> entity = template.getForEntity(url, CommonVo.class);

        CommonVo body = entity.getBody();
        System.out.println(body);

        MediaType contentType = entity.getHeaders().getContentType();

        System.out.println(contentType);

        HttpStatus statusCode = entity.getStatusCode();
        System.out.println("statusCode:[" + statusCode + "]");
    }

}
