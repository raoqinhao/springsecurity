package com.hh.springsecurity.thread;

import com.hh.springsecurity.mapper.UserMapper;
import com.hh.springsecurity.pojo.UserBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.CountDownLatch;


public class DataMigrationThread implements Runnable{

    private static Logger logger = LoggerFactory.getLogger(DataMigrationThread.class);

    private List<UserBean> allUserInfo = null;

    private CountDownLatch countDownLatch;

    private UserMapper userMapper;

    int count = 0;

    public DataMigrationThread(List<UserBean> allUserInfo, CountDownLatch countDownLatch, int count, UserMapper userMapper) {
        this.allUserInfo = allUserInfo;
        this.count = count;
        this.userMapper = userMapper;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        for (int j = 0; j < count; j++) {
            synchronized (this) {
                try {
                    Thread.sleep(10);
                    int status = userMapper.insertUserDataMigration(allUserInfo.get(j));
                    countDownLatch.countDown();
                    logger.info("插入成功数据： {}  , status :{} , countDownLatch : {}",allUserInfo.get(j), status, countDownLatch.getCount());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }


}

