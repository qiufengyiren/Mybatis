package src.test.java.com.dzq;


import com.dzq.dao.ContryMapper;

import com.dzq.pojo.Provincial;
import com.dzq.util.SessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestManyToOne {


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
     * 延迟加载
     * 运行这个方法的时候 需要在  mybatis-config.xml  文件里面把那个
     * <mapper resource="com/dzq/dao/ContryLazyMapper.xml"></mapper> 解开注释
     * 并且注释掉
     * <mapper resource="com/dzq/dao/ContryMapper.xml"></mapper>
     */
    @Test
    public void TestselectByProvincialByPid() {
        Provincial provincial=mapper.selectByProvincialByPid(1);
        System.out.println(provincial.getpName());//获取省会名称 只会执行1条sql语句
        System.out.println(provincial.getCountry().getcName());//获取对应的名称 执行2条sql语句

    }
}
