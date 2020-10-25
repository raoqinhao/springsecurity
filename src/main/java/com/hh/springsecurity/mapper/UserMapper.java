package com.hh.springsecurity.mapper;

import com.hh.springsecurity.pojo.UserBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {

    @Select("SELECT * FROM u_user WHERE id = #{id}")
    UserBean findUserById(@Param("id") Integer id);

    @Select("SELECT * FROM u_user WHERE username = #{username}")
    UserBean findUserByUserName(@Param("username") String username);
}
