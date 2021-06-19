package com.yc.ams.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 林木木
 * Description : 全局异常处理器
 * Version :1.0
 */
//@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    private static final String TGA = "GlobalExceptionHandler";
    //  指名处理那些异常
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Map<String, Object> handlerException(Exception e) {
        Map<String, Object> emap = new HashMap<String, Object>();
        //执行时间
        emap.put("excuteDurationTime", new Date().getTime());
        //状态类型
        emap.put("resultTypeEnum", 500);
        //执行结果
        log.error(TGA+e.getMessage());
        emap.put("message", "发现未知错误，请联系管理员");
        return emap;
    }

}