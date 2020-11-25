package com.hh.springsecurity.util;

public class ExceptionUtils {

    public static String pushMessage(String code, String message) {
        return String.format("{\"code\":\"%s\",\"message\":\"%s\"}",code,message);
    }

}
