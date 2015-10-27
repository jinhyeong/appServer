/**
 * Copyright(C) 2015-2025 杏仁科技
 * All rights reserved
 * 2015年7月28日 Created
 */
package com.xrkj.app.template;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.velocity.app.VelocityEngine;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.velocity.VelocityEngineUtils;

/**
 * <pre>
 * 测试Velocity模板
 * </pre>
 *
 * @author wwh
 * @date 2015年7月28日 下午4:54:27
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext-resources.xml", "classpath:applicationContext-dao.xml",
        "classpath:applicationContext-service.xml", "classpath:applicationContext.xml" })
public class VelocityTest {
    @Autowired
    private VelocityEngine velocityEngine;

    @Test
    public void testVelocity() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userName", "测试用户");
        map.put("userId", "000001");
        map.put("eMail", "aaaaaa@aasdf.com");
        map.put("vCode", UUID.randomUUID().toString());

        String test = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "emialTemplate.vm", "UTF-8", map);
        System.out.println(test);
    }
}
