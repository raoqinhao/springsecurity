package com.hh.springsecurity.thread;

import com.hh.springsecurity.pojo.UserBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


public class DataMigrationThread implements Runnable{

    private static Logger logger = LoggerFactory.getLogger(DataMigrationThread.class);

    private List<UserBean> allUserInfo = null;

    int count = 0;

    public DataMigrationThread(List<UserBean> allUserInfo, int count) {
        this.allUserInfo = allUserInfo;
        this.count = count;
    }

    @Override
    public void run() {
        for (int j = 0; j < count; j++) {
            synchronized (this) {
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                logger.info(allUserInfo.get(j).toString());
            }
        }
    }


}

