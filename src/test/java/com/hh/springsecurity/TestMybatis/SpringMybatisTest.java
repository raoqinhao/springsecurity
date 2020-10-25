package com.hh.springsecurity.TestMybatis;

import com.hh.springsecurity.mapper.UserMapper;
import com.hh.springsecurity.pojo.UserBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@MybatisTest
@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class SpringMybatisTest {

    @Autowired
    private UserMapper userMapper;

    @Rollback(false)
    @Test
    public void getUserMapper() {
        UserBean userBean = userMapper.findUserById(1);
        UserBean userName = userMapper.findUserByUserName("zhangsan");
        System.out.println(userBean);
        System.out.println(userName);
        System.out.println(userName.getUsername());
    }
}
