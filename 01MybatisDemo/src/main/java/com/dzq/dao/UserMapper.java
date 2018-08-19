package com.dzq.dao;

import com.dzq.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface UserMapper {
    /**
     * 增加
     *
     * @param user
     * @return
     */
    int addUser(User user);

    /*
     * 删除
     * @param condition
     * @return
     */
    int deleteUser(Serializable condition);

    /*
     * 修改
     */
    int updateUser(User user);

    /*
     * 查询
     */
    User findUserById(Serializable condition);

    /*
     *查询所有的 返回List集合
     */
    User user(Serializable id);

    /**
     * 查询所有
     * @return
     */
    List<User> findAllUsers();
    /**
     * 根据name和password查询指定数据
     */
    User findOneByTwoCondition(String name,String pasword);
    /**
     * 根据@Param查询指定数据
     */
    User findTwoByThreeCondition (@Param("myName")String name,@Param("myPwd")String password);

    /**
     * map的 普通对象
     */
     User  findMap1(Map<String,Object> a);

    /**
     * map的 普通对象
     */
    User  findMap(Map<String,Object> a);
}


