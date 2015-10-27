/**
 * @Title: ITestService.java 
 * @Package com.xrkj.app.user.service 
 * @Description: 
 * @author ww
 * @date 2015年6月11日 下午12:16:35 
 * @version V1.0  
 */
package com.xrkj.app.user.service;

import com.xrkj.app.user.model.Test;

/**
 * <pre>
 * 
 * </pre>
 *
 * @author ww
 * @date 2015年6月11日 下午12:16:35
 *
 */
public interface ITestService {

    Test getTestById(Long id);

    int inserTest(Test t);

    int updateTest(Test t);

    int deleteById(Long id);

    void reload();
}
