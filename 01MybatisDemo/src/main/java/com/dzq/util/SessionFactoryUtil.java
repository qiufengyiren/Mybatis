package com.dzq.util;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SessionFactoryUtil {
    //创建需要的单例对象
    private static SqlSessionFactory factory;

    //私有化构造
    private SessionFactoryUtil() {

    }

    //对外部访问的接口
    public static synchronized SqlSession getSession() {
        try {
            InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
            //通过构造器创建工厂
            if (factory == null) {
                factory = new SqlSessionFactoryBuilder().build(stream);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return factory.openSession();//通过工厂获取session
    }
}
