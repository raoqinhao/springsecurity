package com.hh.springsecurity.service;

import com.alibaba.fastjson.JSONObject;
import com.hh.springsecurity.exception.NotFoundUserNameException;
import com.hh.springsecurity.mapper.UserMapper;
import com.hh.springsecurity.pojo.UserBean;
import com.hh.springsecurity.thread.DataMigrationThread;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class UserServiceImpl implements UserService{

    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserBean findUserById(String id) {
        UserBean userBean = userMapper.findUserById(id);
        if (userBean == null)
            throw new NotFoundUserNameException("未找到用户信息");
        return userBean;
//        return null;
    }

    @Override
    public String saveUserByRegister(String json) {
        try {
            UserBean userBean = JSONObject.parseObject(json, UserBean.class);
            if (userBean != null) {
                userBean.setId(UUID.randomUUID().toString().replaceAll("-",""));
            }
            int result = userMapper.saveUserByRegister(userBean);
            if (result > 0) {
                return "注册成功";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "注册失败";
        }
        return "注册失败";
    }

    @Override
    public List<UserBean> findAllUser() {
        return userMapper.findAllUser();
    }

    @Override
    public void findUserByMulThread() {
        ExecutorService executorService = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String startTime = sdf.format(new Date());
        try {
            executorService = Executors.newFixedThreadPool(10);
            int count = userMapper.countAllUserInfo();
            CountDownLatch countDownLatch = new CountDownLatch(count);
            int page = (count % 100) == 0 ? (count / 100) : (count / 100) + 1;
            for (int i = 0; i < page; i++) {
                List<UserBean> allUserInfo = userMapper.findAllUserInfo(i * 100, 100);
                DataMigrationThread th = new DataMigrationThread(allUserInfo, countDownLatch, allUserInfo.size(),userMapper);
                executorService.execute(th);
            }
            countDownLatch.await();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (executorService != null)
                executorService.shutdown();
            try {
                String stopTime = sdf.format(new Date());
                logger.info("开始时间： {}， 结束时间： {} ，总共耗时： {} 秒", startTime,stopTime,(sdf.parse(stopTime).getTime() - sdf.parse(startTime).getTime()) / 1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public UserBean findUserByUserName(String username) {
        return userMapper.findUserByUserName(username);
    }

}
