package com.hh.springsecurity.TestMybatis;

import com.hh.springsecurity.mapper.UserMapper;
import com.hh.springsecurity.pojo.UserBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.rmi.NotBoundException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class SpringMybatisTest {

    @Autowired
    private UserMapper userMapper;

    //    @Test
    public void getUserMapper() {
        UserBean userBean = userMapper.findUserById("");
        UserBean userName = userMapper.findUserByUserName("zhangsan");
        System.out.println(userBean);
        System.out.println(userName);
        System.out.println(userName.getUsername());

    }

//    @Test
    public void testException () throws Exception {
        String str = new String("ces");
        System.out.println(str);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(new Date());
        String s = String.format(format + "%b", "a");
        throw new NotBoundException(s);
    }

    //    @Test
    public void insertUserInfo() {
        UserBean userBean = new UserBean(UUID.randomUUID().toString().replaceAll("-", ""), "lisi", "123", "17167495555");
        int i = userMapper.saveUserByRegister(userBean);
        System.out.println(i);
    }

    //    @Test
    public void createUUID() {
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        System.out.println(uuid);
    }
}
