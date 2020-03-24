package com.change.config.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author YangQ
 * @date 2020/3/24 15:32
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    @ResponseBody
    @ExceptionHandler(MsgException.class)
    public Map<String, Object> handleCustomException(MsgException msg) {
        Map<String, Object> errorResultMap = new HashMap<>(16);
        errorResultMap.put("code", msg.getCode());
        errorResultMap.put("msg", msg.getMsg());
        return errorResultMap;
    }
}
