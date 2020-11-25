package com.hh.springsecurity.strategy;

import com.alibaba.fastjson.JSONObject;
import org.springframework.security.web.session.SessionInformationExpiredEvent;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LzcExpiredSessionStrategy implements SessionInformationExpiredStrategy {

    @Override
    public void onExpiredSessionDetected(SessionInformationExpiredEvent sessionInformationExpiredEvent) throws IOException, ServletException {
        // 这里也可以根据需要返回html页面或者json数据
        Map<String, Object> map = new HashMap<>();
        map.put("code",403);
        map.put("message","该用户已经超出最大登录数量");
        sessionInformationExpiredEvent.getResponse().setContentType("text/html;charset=utf-8");
        sessionInformationExpiredEvent.getResponse().getWriter().write(JSONObject.toJSONString(map));
    }

}
