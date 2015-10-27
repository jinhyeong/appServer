/**
 * Copyright(C) 2015-2025 杏仁科技
 * All rights reserved
 * 2015年7月23日 Created
 * 
 */
package com.xrkj.app.webapp.verification;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.code.kaptcha.Producer;
import com.xrkj.app.verification.model.Captcha;
import com.xrkj.app.verification.service.ICaptchaService;
import com.xrkj.app.webapp.common.viewObj.CommonVo;

/**
 * <pre>
 * 验证码
 * </pre>
 *
 * @author wwh
 * @date 2015年7月23日 下午5:46:43
 *
 */
@RestController
@RequestMapping("/captcha")
public class CaptchaController {

    /**
     * <pre>
     * 做记录
     * 
     * kaptcha.border  是否有边框  默认为true  我们可以自己设置yes，no  
     * kaptcha.border.color   边框颜色   默认为Color.BLACK  
     * kaptcha.border.thickness  边框粗细度  默认为1  
     * kaptcha.producer.impl   验证码生成器  默认为DefaultKaptcha  
     * kaptcha.textproducer.impl   验证码文本生成器  默认为DefaultTextCreator  
     * kaptcha.textproducer.char.string   验证码文本字符内容范围  默认为abcde2345678gfynmnpwx  
     * kaptcha.textproducer.char.length   验证码文本字符长度  默认为5  
     * kaptcha.textproducer.font.names    验证码文本字体样式  默认为new Font("Arial", 1, fontSize), new Font("Courier", 1, fontSize)  
     * kaptcha.textproducer.font.size   验证码文本字符大小  默认为40  
     * kaptcha.textproducer.font.color  验证码文本字符颜色  默认为Color.BLACK  
     * kaptcha.textproducer.char.space  验证码文本字符间距  默认为2  
     * kaptcha.noise.impl    验证码噪点生成对象  默认为DefaultNoise  
     * kaptcha.noise.color   验证码噪点颜色   默认为Color.BLACK  
     * kaptcha.obscurificator.impl   验证码样式引擎  默认为WaterRipple  
     * kaptcha.word.impl   验证码文本字符渲染   默认为DefaultWordRenderer  
     * kaptcha.background.impl   验证码背景生成器   默认为DefaultBackground  
     * kaptcha.background.clear.from   验证码背景颜色渐进   默认为Color.LIGHT_GRAY  
     * kaptcha.background.clear.to   验证码背景颜色渐进   默认为Color.WHITE  
     * kaptcha.image.width   验证码图片宽度  默认为200  
     * kaptcha.image.height  验证码图片高度  默认为50
     * </pre>
     */

    private static final Logger log = LoggerFactory.getLogger(CaptchaController.class);

    @Autowired
    private Producer captchaProducer;

    @Autowired
    private ICaptchaService captchaServiceImpl;

    /**
     * 创建一个验证码
     * 
     * @return
     */
    @RequestMapping(method = { RequestMethod.POST, RequestMethod.GET })
    public ResponseEntity<byte[]> createCaptcha() {

        Captcha captcha = captchaServiceImpl.createCaptch();
        // 应该将UUID 返回
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
        headers.add("uuid", captcha.getUuid());
        log.debug("生成的UUID是：{}", captcha.getUuid());

        return new ResponseEntity<byte[]>(captcha.getImageByte(), headers, HttpStatus.OK);
    }

    @RequestMapping(value = "json")
    public Captcha CaptchaJSON() {
        Captcha captcha = captchaServiceImpl.createCaptch();
        captcha.setText(null);
        captcha.setImage(null);
        log.debug("生成的UUID是：{}", captcha.getUuid());

        return captcha;
    }

    /**
     * 校验验证码，这个应该得提示其过期
     * 
     * @param uuid
     * @param text
     * @return
     */
    @RequestMapping("verify")
    public CommonVo verify(@RequestParam String uuid, @RequestParam String text) {
        int rt = captchaServiceImpl.verifyCaptch(uuid, text);
        CommonVo cv = null;
        switch (rt) {
        case ICaptchaService.VERIFY_INEXISTENCE:
            cv = new CommonVo(ICaptchaService.VERIFY_INEXISTENCE + "", "验证码已过期");
            break;
        case ICaptchaService.VERIFY_PASS:
            cv = new CommonVo(ICaptchaService.VERIFY_PASS + "", "验证通过");
            break;
        case ICaptchaService.VERIFY_NOT_PASS:
            cv = new CommonVo(ICaptchaService.VERIFY_NOT_PASS + "", "验证不通过");
            break;
        }
        return cv;
    }

    // ###############################################################################################

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public void captcha(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Set standard HTTP/1.1 no-cache headers.
        resp.setHeader("Cache-Control", "no-store, no-cache");

        // return a jpeg
        resp.setContentType("image/jpeg");

        // create the text for the image
        String capText = this.captchaProducer.createText();

        // create the image with the text
        BufferedImage bi = this.captchaProducer.createImage(capText);

        ServletOutputStream out = resp.getOutputStream();

        // write the data out
        ImageIO.write(bi, "jpg", out);
    }

}
