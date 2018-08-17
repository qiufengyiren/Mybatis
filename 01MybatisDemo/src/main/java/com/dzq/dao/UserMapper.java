package com.dzq.dao;

import com.dzq.pojo.User;

import java.io.Serializable;
import java.util.List;

public interface UserMapper {
    /**
     * 增加
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
    List<User> findAllUsers();
}
