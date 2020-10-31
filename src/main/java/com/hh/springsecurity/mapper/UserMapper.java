package com.hh.springsecurity.mapper;

import com.hh.springsecurity.pojo.UserBean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import java.util.List;

@Mapper
@Repository
public interface UserMapper {

//    @Select("SELECT * FROM u_user WHERE id = #{id}")
    UserBean findUserById(@Param("id") String id);

    @Select("SELECT * FROM u_user WHERE username = #{username}")
    UserBean findUserByUserName(@Param("username") String username);

    @Insert("insert into u_user(id,username,password,mobilephone) values(#{id},#{username},#{password},#{mobilephone}) ")
    int saveUserByRegister(UserBean userBean);

    List<UserBean> findAllUser();

    @Select("select * from u_user limit #{start},#{size}")
    List<UserBean> findAllUserInfo(@Param("start") int start,@Param("size")int size);

    @Select("select count(*) from u_user")
    int countAllUserInfo();
}
