/**
 * Copyright(C) 2015-2025 杏仁科技
 * All rights reserved
 * 2015年6月24日 Created
 * 
 */
package com.xrkj.app.basetest;

import com.alibaba.fastjson.JSON;
import com.xrkj.app.user.model.Test;

/**
 * <pre>
 * 
 * </pre>
 *
 * @author wwh
 * @date 2015年6月24日 下午6:22:51
 *
 */
public class JsonTest {
    private static String charsetName = "UTF-8";
    
    public static void main(String[] args) {
        Test t = new Test();
        t.setId(10l);
        t.setName("the name");
        t.setPwd("the password");
        t.setT1("T1 value");
       String ss =JSON.toJSONString(t);
       
       System.out.println(ss);
       
       Object o = JSON.parse(ss);
       System.out.println(o);
      Test t2 =  JSON.parseObject(ss, Test.class);
      System.out.println(t2);
       
    }
}
