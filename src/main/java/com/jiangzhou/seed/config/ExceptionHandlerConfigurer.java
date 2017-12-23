package com.jiangzhou.seed.config;

import com.jiangzhou.seed.core.Result;
import com.jiangzhou.seed.core.ResultCode;
import com.jiangzhou.seed.core.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.HandlerMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestControllerAdvice
public class ExceptionHandlerConfigurer {

    private final Logger logger = LoggerFactory.getLogger(ExceptionHandlerConfigurer.class);

    @Value("${spring.profiles.active}")
    private String env;

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result resolveException(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) {
        Result result = new Result();
        Message msg = formatExceptionMessage(request, response, o, e);
        result.setCode(msg.code).setMsg(msg.subMessage);
        logger.error("错误代码:" + msg.code + ", 错误信息:" + msg.message);
        return result;
    }

    private Message formatExceptionMessage(HttpServletRequest request, HttpServletResponse response, Object o, Exception e){
        Message msg = new Message();

        if (e instanceof ServiceException) {
            msg.code = ((ServiceException) e).code;
            msg.message = e.getMessage();
            msg.subMessage = e.getMessage();
        } else {
            msg.code = ResultCode.INTERNAL_SERVER_ERROR.code;

            if (o instanceof HandlerMethod) {
                HandlerMethod handlerMethod = (HandlerMethod) o;
                msg.message = String.format("接口 [%s] 出现异常，方法：%s.%s，异常摘要：%s",
                        request.getRequestURI(),
                        handlerMethod.getBean().getClass().getName(),
                        handlerMethod.getMethod().getName(),
                        e.getMessage());
            } else {
                msg.message = e.getMessage();
            }
            if (env.equals("dev")){
                msg.subMessage = msg.message;
            }
            else {
                msg.subMessage = "接口 [" + request.getRequestURI() + "] 内部错误，请联系管理员";
            }
        }
        return msg;
    }

    class Message {
        int code;
        String message;
        String subMessage;
    }
}
