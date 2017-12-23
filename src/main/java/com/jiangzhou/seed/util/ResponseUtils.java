package com.jiangzhou.seed.util;

import com.alibaba.fastjson.JSON;
import com.jiangzhou.seed.config.WebMvcConfigurer;
import com.jiangzhou.seed.core.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ResponseUtils {

    private final static Logger logger = LoggerFactory.getLogger(WebMvcConfigurer.class);

    public static void response(HttpServletResponse response, Result result) {
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-type", "application/json;charset=UTF-8");
        response.setStatus(200);
        try {
            response.getWriter().write(JSON.toJSONString(result));
        } catch (IOException ex) {
            logger.error(ex.getMessage());
        }
    }
}
