package com.dzq;

import com.dzq.dao.UserMapper;
import com.dzq.pojo.Users;
import com.dzq.util.SessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestdynamicSQL {
    SqlSession sqlSession = null;
    UserMapper mapper = null;

    @Before
    public void before() {
        sqlSession = SessionFactoryUtil.getSession();
        mapper = sqlSession.getMapper(UserMapper.class);
    }

    @After
    public void after() {
        sqlSession.commit();
        sqlSession.close();
    }

    /**
     * 查询 where+if+trim
     */
    @Test
    public void findUSersByCondition() {
        Users users = new Users(1);
        users.setUsername("Mapper测试1");
        users.setPassword("测试数据1");
        List<Users> list = mapper.findUsersByCondition(users);
        System.out.println(list);
    }

    /**
     * 修改 update  set+if+trim
     */
    @Test
    public void updateBySet() {
        Users users = new Users(1);
        users.setId(12);
        users.setUsername("Mapper测试1111");
        mapper.updateBySet(users);
    }

    /**
     * choose +when +otherwise+where
     */
    @Test
    public void selectByChoose() {
        Users users = new Users(1);
        users.setId(12);
        users.setUsername("Mapper测试1111");
        mapper.selectByChoose(users);
    }

    /**
     * 数组遍历
     * choose +when +otherwise+where
     */
    @Test
    public void selectByArray() {
        int[] ids = {12, 13, 10};
        List<Users> list = mapper.selectByArray(ids);
        System.out.println(list);
    }

    /**
     * List集合 单一遍历
     */
    @Test
    public void selectByList() {
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(8);
        List<Users> list = mapper.selectByList(ids);
    }

    /**
     * List集合 对象类型
     */
    @Test
    public void selectByListUser() {
        List<Users> ids = new ArrayList<>();
        Users u1 = new Users(1);
        Users u2 = new Users(13);
        Users u3 = new Users(12);
        ids.add(u1);
        ids.add(u2);
        ids.add(u3);
        List<Users> users = mapper.selectByListUser(ids);
        System.out.println(users);
    }

    /**
     * List集合 对象类型
     */
    @Test
    public void selectAddUser() {
        List<Users> ids = new ArrayList<>();
        Users u1 = new Users("111", "111");
        Users u2 = new Users("222", "222");
        Users u3 = new Users("333", "333");
        ids.add(u1);
        ids.add(u2);
        ids.add(u3);
        mapper.selectAddUser(ids);
    }

    /**
     * Map集合 查看用户信息 单一类型
     */
    @Test
    public void selectByMap() {
        Map<String, Integer> map = new HashMap<>();
        Users u1 = new Users(1);
        Users u2 = new Users(12);
        Users u3 = new Users(11);
        map.put("key1", 1);
        map.put("key2", 2);
        map.put("key3", 2);
        List<Users> users = mapper.selectByMap(map);
        System.out.println(users);
    }

    /**
     * Map集合 查看用户信息 单一类型
     */
    @Test
    public void selectByMapUser() {
        Map<String, Users> map = new HashMap<>();
        Users u1 = new Users(1);
        Users u2 = new Users(12);
        Users u3 = new Users(11);
        map.put("key1", u1);
        map.put("key2", u2);
        map.put("key3", u3);
        List<Users> users = mapper.selectByMapUser(map);
        System.out.println(users);

    }


}
