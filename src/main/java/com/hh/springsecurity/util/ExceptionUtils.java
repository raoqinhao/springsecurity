package com.hh.springsecurity.util;

public class ExceptionUtils {

    /**
     * 异常信息统一返回
     * @param code
     * @param message
     * @return
     */
    public static String pushMessage(String code, String message) {
        return String.format("{\"code\":\"%s\",\"message\":\"%s\"}",code,message);
    }

}
