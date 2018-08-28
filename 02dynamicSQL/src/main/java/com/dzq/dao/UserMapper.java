package com.dzq.dao;

import com.dzq.pojo.Users;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    /**
     * where+if
     * @param users
     * @return
     */
    List<Users> findUsersByCondition(Users users);

    /**
     * set +if
     */
    void updateBySet (Users users);

    /**
     *
     */
    void selectByChoose(Users users);

    /**
     * 查询id in（123）的用户信息
     * 数组
     * @param ids
     * @return
     */
    List<Users> selectByArray(int [] ids);



    /**
     * 查询id in（123）的用户信息
     * List集合 单一遍历
     * @param list
     * @param list
     * @return
     */
    List <Users> selectByList(List<Integer> list);

    /**
     *遍历list集合 对象类型
     *
     */
    List <Users> selectByListUser(List<Users> list);

    /**
     *添加信息
     */
    void  selectAddUser(List<Users> list);

    /**
     * map集合 查看用户信息
     *单一类型
     */
    List <Users> selectByMap (@Param("myMap") Map<String ,Integer> map);


    /**
     * 查询id in（123）的用户信息
     * map对象类型
     * @param map
     */
    List<Users> selectByMapUser(@Param("myMap")Map<String, Users> map);
}


