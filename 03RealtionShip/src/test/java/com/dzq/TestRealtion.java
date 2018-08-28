package com.dzq;


import com.dzq.dao.ContryMapper;
import com.dzq.pojo.Country;
import com.dzq.util.SessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestRealtion {


    SqlSession sqlSession = null;
    ContryMapper mapper = null;

    @Before
    public void before() {
        sqlSession = SessionFactoryUtil.getSession();
        mapper = sqlSession.getMapper(ContryMapper.class);
    }

    @After
    public void after() {
        sqlSession.commit();
        sqlSession.close();
    }

    /**
     * 直接加载
     * 运行这个方法的时候 需要在  mybatis-config.xml  文件里面把那个
     * <mapper resource="com/dzq/dao/ContryMapper.xml"></mapper>
     * 解开注释
     */
    @Test
    public void testCountry() {
        Country country = mapper.selectByCountryByCid(2);
        System.out.println(country);
    }

    /**
     * 延迟加载
     * 运行这个方法的时候 需要在  mybatis-config.xml  文件里面把那个
     * <mapper resource="com/dzq/dao/ContryLazyMapper.xml"></mapper> 解开注释
     * 并且注释掉
     * <mapper resource="com/dzq/dao/ContryMapper.xml"></mapper>
     */
    @Test
    public void testLazyCountry() {
        Country country = mapper.selectByCountryByCid(1);
        System.out.println(country.getcId());
        System.out.println(country.getProvincials());
    }
}
