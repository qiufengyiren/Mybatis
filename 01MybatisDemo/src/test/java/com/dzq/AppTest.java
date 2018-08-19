package com.dzq;


import com.dzq.dao.UserMapper;

import com.dzq.pojo.User;
import com.dzq.util.SessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void addUser() {
        System.out.println(22);
        User user = new User();
        user.setUsername("Mapper测试");
        user.setPassword("测试数据");
        int num = mapper.addUser(user);
        if (num > 0) {
            System.out.println("新增成功");
        } else {
            System.out.println("新增失败");
        }
    }

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
     * 删除
     */
    @Test
    public void deleteUser() {
        int num = mapper.deleteUser(6);
        if (num > 0) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }
    }

    /**
     * 修改
     */
    @Test
    public void updateUser() {
        User user = new User();
        user.setId(3);
        user.setUsername("测试类");
        user.setPassword("mapper");
        int num = mapper.updateUser(user);
        if (num > 0) {
            System.out.println("修改成功");
        } else {
            System.out.println("修改失败");
        }
    }

    /**
     * 查询
     */
    @Test
    public void findUserById() {
        User user = mapper.findUserById(3);
        System.out.println(user);
    }

    /**
     * 查询所有用户
     */
    @Test
    public void findAllUsers() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> list = mapper.findAllUsers();
        System.out.println(list);
    }

    /**
     * 查询 根据name和password来查询
     */
    @Test
    public void findOneByTwoCondition() {
        User user = mapper.findOneByTwoCondition("测试类", "mapper");
        System.out.println(user);
    }

    /**
     * 查询 @Param来查询
     */
    @Test
    public void findTwoByThreeCondition() {
        User user = mapper.findTwoByThreeCondition("111", "111111");
        System.out.println(user);
    }

    /**
     * Map的普通对象
     */
    @Test
    public void findMap() {
        Map<String,Object> map = new HashMap<>();
        User user = new User();
        user.setUsername("111");
        user.setPassword("111111");
        map.put("use",user);
        System.out.println(mapper.findMap(map));
}
    /**
     * Map的单个对象
     */
    @Test
    public void findMap1() {

       Map<String,Object> map = new HashMap<>();
        map.put("name","111");
        map.put("pwd","111111");
        System.out.println(mapper.findMap1(map));
    }
}
