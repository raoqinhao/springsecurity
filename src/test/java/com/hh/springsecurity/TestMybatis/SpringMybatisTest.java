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
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;
import java.util.UUID;


//@RunWith(SpringRunner.class)
//@SpringBootTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class SpringMybatisTest {

//    @Autowired
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

//    @Test
    public void createUserBean() {
        for (int i = 0; i < 993; i++) {
            UserBean userBean = new UserBean(UUID.randomUUID().toString().replaceAll("-",""), createUserName(), "123456789", createMobilePhone());
            userMapper.saveUserByRegister(userBean);
        }
    }


    private String createUserName() {
        String randomchar = "abcdefghijklmnopqrstuvwxyz";
        String userName = "";
        for (int i = 0; i < 8; i++) {
            int index = new Random().nextInt(26);
            char charAt = randomchar.charAt(index);
            userName += charAt;
        }
        return userName;
    }

    private String createMobilePhone() {
        String randomchar = "0123456789";
        String MobilePhone = "178";
        for (int i = 0; i < 8; i++) {
            int index = new Random().nextInt(10);
            char charAt = randomchar.charAt(index);
            MobilePhone += charAt;
        }
        return MobilePhone;
    }


//    @Test
    public void testTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd").withZone(ZoneId.of("Asia/Shanghai"));
        ZonedDateTime zdt = ZonedDateTime.of(LocalDateTime.now(),ZoneId.of("Asia/Shanghai"));
        String time = zdt.getYear() + "-" + zdt.getMonthValue() + "-" + (zdt.getDayOfMonth() < 10 ? 0 + "" + zdt.getDayOfMonth() : zdt.getDayOfMonth()) + " " + zdt.getHour() + ":" + zdt.getMinute() + ":" + (zdt.getSecond() < 10 ? 0 + "" + zdt.getSecond() : zdt.getSecond());
        System.out.println(time);
    }

    @Test
    public void testSimpleDateTime() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String startTime = sdf.format(new Date());
        String stopTime = sdf.format(new Date());
        System.out.println( startTime + "" + stopTime);
        System.out.println(sdf.parse(startTime).getTime());
    }

}
