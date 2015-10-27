/**
 * Copyright(C) 2015-2025 杏仁科技
 * All rights reserved
 * 2015年6月30日 Created
 * 
 */
package com.xrkj.app.webapp.base.controlleradvice;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONException;
import com.xrkj.app.Constants;
import com.xrkj.app.exception.BaseException;
import com.xrkj.app.exception.BusinessException;
import com.xrkj.app.exception.InputParseException;
import com.xrkj.app.exception.UnauthorizedException;
import com.xrkj.app.exception.ViewException;
import com.xrkj.app.webapp.common.viewObj.ErrorVo;

/**
 * <pre>
 * ControllerAdvice
 * 用于统一的异常处理等
 * 编写服务类时只需要抛出对应的异常即可
 * </pre>
 *
 * @author wwh
 * @date 2015年6月15日 下午4:52:54
 *
 */
@ControllerAdvice(annotations = RestController.class)
public class ExceptionAdviceHandler {

    /**
     * 错误类型定义
     */
    public static final int ERROR_TYPE = 2;

    private static final Logger logger = LoggerFactory.getLogger(ExceptionAdviceHandler.class);

    /**
     * <pre>
     * 未授权异常
     * 应用到所有@RequestMapping注解的方法，在其抛出UnauthenticatedException异常时执行
     * </pre>
     * 
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(UnauthorizedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public ErrorVo processUnauthorizedException(HttpServletRequest request, UnauthorizedException e) {
        // 应该要能从异常中获取部分信息
        String radd = request.getRemoteAddr();

        String url = request.getRequestURI();

        logger.info("{} 试图请求未授权的资源：{}", radd, url);

        // 国际化先不做

        // 错误码随意先
        ErrorVo evo = new ErrorVo(ERROR_TYPE, Constants.ECODE_VIEW_AUTHORIZATION, "请求的资源未经授权");

        return evo;
    }

    /**
     * 缺少请求参数
     * 
     * @param ex
     * @return
     */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorVo processMissingServletRequestParameterException(MissingServletRequestParameterException ex) {
        // 日志记录在这里
        logger.debug("缺少请求参数", ex);

        // 错误码随意先
        ErrorVo evo = new ErrorVo(ERROR_TYPE, Constants.ECODE_VIEW_BAD_REQUEST_MISS_PARAM, "缺少请求参数：" + ex.getMessage());

        return evo;
    }

    /**
     * 请求参数校验不通过
     * 
     * @param ex
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorVo processMethodArgumentNotValidException(MethodArgumentNotValidException ex) {

        logger.debug("请求参数校验不通过", ex);

        ErrorVo evo = new ErrorVo(ERROR_TYPE, Constants.ECODE_VIEW_BAD_REQUEST_INVALID_PARAM, "请求参数校验不通过");

        // 具体的错误信息
        BindingResult bindr = ex.getBindingResult();
        if (bindr != null) {
            // 循环这个对象获取错误信息
            List<FieldError> list = bindr.getFieldErrors();
            int index = 0;
            for (FieldError fieldError : list) {
                index++;
                evo.addDetail(index, fieldError.getField(), fieldError.getDefaultMessage());
            }
        }

        return evo;
    }

    /**
     * 输入解析异常
     * 
     * @param ex
     * @return
     */
    @ExceptionHandler(InputParseException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorVo processInputParseException(InputParseException ex) {
        // 日志记录在这里
        logger.debug("输入解析异常", ex);

        // 是否应该告知详细的错误信息？
        ErrorVo evo = new ErrorVo(ERROR_TYPE, Constants.ECODE_VIEW_BAD_REQUEST_PARSE_EXCEPTION, "输入解析异常");

        return evo;
    }

    /**
     * JSON解析异常
     * 
     * @param ex
     * @return
     */
    @ExceptionHandler(JSONException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorVo processJSONException(JSONException ex) {
        // 日志记录在这里
        logger.debug("JSON解析异常", ex);

        // 错误码随意先
        ErrorVo evo = new ErrorVo(ERROR_TYPE, Constants.ECODE_VIEW_BAD_REQUEST_JSON_EXCEPTION, "错误的请求，JSON解析异常");

        return evo;
    }

    /**
     * 请求内容不能读取
     * 
     * @param ex
     * @return
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorVo processHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        // 日志记录在这里
        logger.debug("请求内容不能读取", ex);

        // 错误码随意先
        ErrorVo evo = new ErrorVo(ERROR_TYPE, Constants.ECODE_VIEW_BAD_REQUEST_UNREADABLE, "错误的请求，内容不可读");

        return evo;
    }

    /**
     * 处理视图层异常
     * 
     * @param ex
     * @return
     */
    @ExceptionHandler(ViewException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorVo processViewException(ViewException ex) {
        // 日志记录在这里
        logger.info("视图层异常", ex);

        ErrorVo evo = new ErrorVo(ERROR_TYPE, Constants.ECODE_VIEW_XX, "视图层异常");

        return evo;
    }

    /**
     * 业务层异常
     * 
     * @param ex
     * @return
     */
    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorVo processBusinessException(BusinessException ex) {
        // 日志记录在这里
        logger.info("业务层异常", ex);

        ErrorVo evo = new ErrorVo(ERROR_TYPE, Constants.ECODE_BUSINESS_XX, "业务层异常");

        return evo;
    }

    /**
     * 处理系统基础异常
     * 
     * @param ex
     * @return
     */
    @ExceptionHandler(BaseException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorVo processBaseException(BaseException ex) {
        // 正常来说不应该到这里
        // 具体异常应该具体处理

        logger.warn("系统异常", ex);

        ErrorVo evo = new ErrorVo(ERROR_TYPE, Constants.ECODE_SERVICE_XX, "系统异常");

        return evo;
    }

    @ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
    @ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE, reason = "不支持的请求类型")
    public void processHttpMediaTypeNotAcceptableException(HttpMediaTypeNotAcceptableException ex) {
        // 日志记录在这里
        logger.trace("不支持的请求类型", ex);

    }

    /**
     * 处理运行时异常
     * 
     * @param ex
     * @param request
     * @return
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorVo processRuntimeException(RuntimeException ex, HttpServletRequest request) {
        // 日志记录在这里
        logger.error("程序发生运行时异常：", ex);

        // 错误码随意先
        ErrorVo evo = new ErrorVo(ERROR_TYPE, Constants.ECODE_SERVICE_XX, "服务器发生异常1");

        return evo;
    }

    /**
     * 处理其他异常
     * 
     * @param ex
     * @return
     */
    @ExceptionHandler
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorVo processOtherException(Exception ex) {

        // 在这里记录日志
        logger.error("!!!程序发生异常!!!：", ex);

        // 错误码随意先
        ErrorVo evo = new ErrorVo(ERROR_TYPE, Constants.ECODE_SERVICE_XX, "服务器发生异常2");

        return evo;
    }

}