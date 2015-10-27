package com.xrkj.app.webapp.common;

import static com.xrkj.app.Constants.REQUEST_MAPPING_TEST;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.xrkj.app.Constants;
import com.xrkj.app.comm.model.Logging;
import com.xrkj.app.exception.BaseException;
import com.xrkj.app.exception.BusinessException;
import com.xrkj.app.exception.ServiceException;
import com.xrkj.app.exception.UnauthorizedException;
import com.xrkj.app.exception.ViewException;
import com.xrkj.app.webapp.common.viewObj.CommonVo;
import com.xrkj.app.webapp.common.viewObj.TestVo;

/**
 * <pre>
 * 测试控制器
 * </pre>
 *
 * @author wwh
 * @date 2015年7月4日 下午3:29:19
 *
 */
@RestController
@RequestMapping(REQUEST_MAPPING_TEST)
public class TestController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @RequestMapping
    public List<CommonVo> describe() {
        // 获取当前类里面所有的方法，和方法的注解
        List<CommonVo> list = new ArrayList<CommonVo>();
        CommonVo cv;
        Method[] methods = TestController.class.getMethods();
        for (Method method : methods) {
            RequestMapping annotation = method.getAnnotation(RequestMapping.class);
            if (annotation != null) {
                cv = new CommonVo();
                String[] sv = annotation.value();
                cv.setKey(sv.length < 1 ? "" : sv[0]);
                cv.setValue("对应的方法是：" + method.getName());
                list.add(cv);
            }
        }
        return list;
    }

    @RequestMapping(value = "putLogging", method = { RequestMethod.POST, RequestMethod.PUT })
    public Logging putLogging(@Valid @RequestBody Logging log) {// ,BindingResult
                                                                // bindr
        // if(bindr.hasErrors()){
        // List<FieldError> list = bindr.getFieldErrors();
        // for (FieldError fieldError : list) {
        // System.out.println(fieldError.getField() + "  " +
        // fieldError.getDefaultMessage() );
        // }
        // //看看可以重定向不
        // //不然就抛出异常？
        // throw new ViewException();
        // }
        logger.info("收到的log对象是：{}", log.toString());
        log.setLogid(1000L);
        return log;
    }

    /**
     * 测试请求参数
     * 
     * @param str
     * @param l
     * @param date
     * @return
     */
    @RequestMapping("requestParam")
    public List<CommonVo> testRequestParam(@RequestParam("string") String str, @RequestParam("long") Long l,
            @RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
        List<CommonVo> list = new ArrayList<CommonVo>();
        CommonVo u = new CommonVo();
        u.setKey("string");
        u.setValue(str);
        list.add(u);

        u = new CommonVo();
        u.setKey("long");
        u.setValue(l == null ? "" : l.toString());
        list.add(u);

        u = new CommonVo();
        u.setKey("date");
        u.setValue(date == null ? "" : date.toString());
        list.add(u);

        return list;
    }

    @RequestMapping("ping")
    public CommonVo ping() {
        CommonVo u = new CommonVo();
        u.setKey("time");
        u.setValue(new Date().toString());
        return u;
    }

    // ResponseStatus修饰目标方法，无论它执行方法过程中有没有异常产生，用户都会得到异常的界面。而目标方法正常执行
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "原因：测试")
    // 抛出的错误将会被servlet容器处理
    @RequestMapping("/rpstatus")
    public CommonVo getUser() {
        CommonVo u = new CommonVo();
        u.setKey("ResponseStatus");
        u.setValue("ResponseStatus修饰目标方法，无论它执行方法过程中有没有异常产生，用户都会得到异常的界面。而目标方法正常执行");

        return u;
    }

    @RequestMapping("/callable")
    public Callable<CommonVo> api() {

        logger.info("测试异步处理@@@@@@@");

        return new Callable<CommonVo>() {
            @Override
            public CommonVo call() throws Exception {
                Thread.sleep(10L * 1000); // 暂停两秒
                CommonVo co = new CommonVo();
                co.setKey("key");
                co.setValue("value");
                return co;
            }
        };
    }

    @RequestMapping("getImage")
    public TestVo getImage() {
        TestVo img = new TestVo();
        img.setName("这是一个图片哦");
        img.setType(1);

        img.setImage("测试字节，一二三四五六七八九十".getBytes());

        return img;
    }

    @RequestMapping(value = "/getFile")
    public ResponseEntity<byte[]> getFile(@RequestParam("fileName") String fileName) throws IOException {
        System.out.println("load image of " + fileName);

        ClassPathResource res = new ClassPathResource(fileName);
        if (res == null || !res.exists()) {
            return new ResponseEntity<byte[]>(HttpStatus.NOT_FOUND);// 返回不同的状态代码
        }

        byte[] fileData = FileCopyUtils.copyToByteArray(res.getInputStream());

        return new ResponseEntity<byte[]>(fileData, HttpStatus.OK);
    }

    @RequestMapping(value = "fileUpload", method = RequestMethod.POST, headers = ("Content-Type=multipart/form-data"))
    public String fileUpload(@RequestParam("file") MultipartFile file) {
        // 上传文件
        // 判断文件是否为空
        if (!file.isEmpty()) {
            try {
                // 文件保存路径
                String filePath = Constants.FILE_SAVE_DIRECTORY + File.separator + "upload";

                // 转存文件
                file.transferTo(new File(filePath, file.getOriginalFilename()));

            } catch (Exception e) {
                logger.error("文件上传失败", e);
                return "文件上传失败";
            }
        }
        return "上传完成";
    }

    public void downloadFile() {
        // 下载文件

    }

    @RequestMapping("/exception/{type}")
    public String testException(@PathVariable("type") String type, HttpServletRequest request, HttpServletResponse response) throws Throwable {

        if (type == null) {
            throw new NullPointerException("不能为空");
        }
        switch (type) {
        case "1":
            throw new BaseException("BaseException 参数是1");

        case "2":
            throw new BusinessException();

        case "3":
            throw new ServiceException();

        case "4":
            throw new UnauthorizedException();

        case "5":
            throw new ViewException();

        case "6":
            throw new Exception("测试抛出异常");

        case "7":
            throw new Error();

        default:
            break;
        }

        // 直接返回json
        return "这个类型没有定义额";
    }
}
