package com.dzq.dao;


import com.dzq.pojo.Users;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;

public interface UserMapper {
    //登录
    int Login(@Param("myName") String username, @Param("myPwd") Integer password);

    //查询所有的对象
    List<Users> FindAll(Serializable condition);

    //根据id查询对象
    Users FindUsers(Serializable condition);

    // 根据删除id指定的对象
    int deleteUsers(Serializable condition);

    //根据id修改指定的对象
    int updateUsers(Users user);

    //新增对象
    int addUsers(Users user);

}
