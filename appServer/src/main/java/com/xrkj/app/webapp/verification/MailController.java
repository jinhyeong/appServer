/**
 * Copyright(C) 2015-2025 杏仁科技
 * All rights reserved
 * 2015年7月27日 Created
 */
package com.xrkj.app.webapp.verification;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xrkj.app.verification.service.IMailService;

/**
 * <pre>
 * 邮件
 * 应该包括发送邮件 和 验证结果返回
 * 那这个就不应该是RESTful
 * 还得弄一个jsp页面，告知返回结果
 * </pre>
 *
 * @author wwh
 * @date 2015年7月27日 下午5:31:46
 *
 */
@Controller
@RequestMapping("/mail")
public class MailController {

    private static final Logger log = LoggerFactory.getLogger(MailController.class);

    @Autowired
    private IMailService mailServiceImpl;

    // 发送邮件是由系统调用的

    // 邮件应该不单单只有普通的邮箱验证
    // 还应该有发一些其他信息的功能，如提醒，广告等
    // 那么应该选择一个邮件模板

    // 还包括找回密码功能。。。找回密码就发验证码，然后在app端改吧

    // 然后还得有一个进行验证的方法
    // 验证的结果保存在哪里？？？应该就是一个

    // 注册时还应该判断邮箱是否注册过
    // 那就应该有是不是激活的概念
    // 如果是没有激活的邮箱怎么整？
    // 如果邮箱被胡乱注册了

    @RequestMapping("send")
    @ResponseBody
    public String sendMail(@RequestParam("email") String email) {

        try {
            mailServiceImpl.sendVerifyEMail(email);
            return "邮件发送成功";
        } catch (Exception e) {
            log.error("邮件发送失败", e);
            return "邮件发送失败";
        }
    }

    // 应该先判断是不是已经被别的用户给验证过了
    @RequestMapping("validate/{userId}/{eMail}/{vCode}")
    public ModelAndView validateEmail(@PathVariable("userId") String userId, @PathVariable("eMail") String eMail, @PathVariable("vCode") String vCode) {

        log.debug("####  进行邮箱有效性验证的用户id是：{}  验证的邮箱是：{}   对应的验证码是：{}", userId, eMail, vCode);

        // 调用service方法进行验证
        int id = Integer.parseInt(userId);

        ModelAndView modelAndView = new ModelAndView();

        if (id % 2 == 0) {
            // 验证通过
            modelAndView.setViewName("verification/validateEmail_ok");// 验证通过视图
            modelAndView.addObject("userId", userId);
            modelAndView.addObject("eMail", eMail);
            modelAndView.addObject("vCode", vCode);
        } else {

            // 验证不通过，如：不存在，过期等
            modelAndView.setViewName("verification/validateEmail_fail");// 验证不通过视图
            modelAndView.addObject("userId", userId);
            modelAndView.addObject("eMail", eMail);
            modelAndView.addObject("vCode", vCode);
        }

        return modelAndView;
    }

}
