package com.dzq;

import static org.junit.Assert.assertTrue;

import com.dzq.dao.UserMapper;

import com.dzq.pojo.User;
import com.dzq.util.SessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

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
        public void findAllUsers(){
            UserMapper mapper=sqlSession.getMapper(UserMapper.class);
            List<User> list=mapper.findAllUsers();
            System.out.println(list);
        }
    }
