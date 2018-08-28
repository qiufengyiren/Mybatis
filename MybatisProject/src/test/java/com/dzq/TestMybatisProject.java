package com.dzq;

import com.dzq.dao.UserMapper;
import com.dzq.pojo.Users;
import com.dzq.util.SessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;

import java.util.List;
import java.util.Scanner;

public class TestMybatisProject {
    static SqlSession sqlSession = null;
    static UserMapper mapper = null;

    public static void main(String[] args) {
        login();
    }

    public  static void meau() {
        Scanner input = new Scanner(System.in);
        System.out.println("=============Myabtis项目============");
        System.out.println("进入二级菜单 请选择！");
        System.out.println("1：查询所有对象");
        System.out.println("2：根据id查询对象");
        System.out.println("3：根据删除id指定的对象");
        System.out.println("4：根据id修改指定的对象");
        System.out.println("5：添加对象");
        int choose = input.nextInt();
        switch (choose) {
            case 1:
                FindAll();//查询所有对象
                break;
            case 2:
                FindUsers();//根据id查询对象
                break;
            case 3:
                deleteUsers();//根据删除id指定的对象
                break;
            case 4:
                updateUsers();//根据id修改指定的对象
                break;
            case 5:
                addUsers();//添加对象
                break;
        }
    }

    /**
     * 登录
     */
    public static void login() {
        Scanner input = new Scanner(System.in);
        sqlSession = SessionFactoryUtil.getSession();
        mapper = sqlSession.getMapper(UserMapper.class);
        System.out.println("请输入用户名");
        String username = input.next();
        System.out.println("请输入密码");
        Integer password = input.nextInt();
        int login = mapper.Login(username, Integer.valueOf(password));
        if (login > 0) {
            System.out.println("登录成功");
            meau();
        } else {
            System.out.println("登录失败");
            login();
        }
    }

    /**
     * 查询所有对象
     */
    public static void FindAll() {
        Users users = new Users();
        List<Users> list = mapper.FindAll(null);
        System.out.println(list);
        meau();
    }

    /**
     * 根据id查询对象
     */
    public static void FindUsers() {
        Scanner input = new Scanner(System.in);
        System.out.println("输入要查询用户的id");
        int id = input.nextInt();
        Users users = mapper.FindUsers(id);
        System.out.println(users);
        meau();
    }

    /**
     * 根据删除id指定的对象
     */
    public static void deleteUsers() {
        int num = mapper.deleteUsers(3);
        if (num > 0) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }
        meau();
    }

    /**
     * 根据id修改指定的对象
     */
    public static void updateUsers() {
        Users users = new Users();
        users.setId(3);
        users.setUsername("张杰");
        users.setPassword(1111);
        int num = mapper.updateUsers(users);
        if (num > 0) {
            System.out.println("修改成功");
        } else {
            System.out.println("修改失败");
        }
        meau();
    }

    /**
     * 添加对象
     */
    public static void addUsers() {
        Users users = new Users();
        users.setUsername("哈哈");
        users.setPassword(123);
        int num = mapper.addUsers(users);
        if (num > 0) {
            System.out.println("新增成功");
        } else {
            System.out.println("新增失败");
        }
        meau();
    }
}


