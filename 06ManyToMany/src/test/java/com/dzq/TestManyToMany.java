package com.dzq;

import com.dzq.dao.TeacherMapper;
import com.dzq.pojo.Student;
import com.dzq.pojo.Teacher;
import com.dzq.util.SessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class TestManyToMany {
    SqlSession sqlSession = null;
    TeacherMapper mapper = null;

    @Before
    public void before() {
        sqlSession = SessionFactoryUtil.getSession();
        mapper = sqlSession.getMapper(TeacherMapper.class);
    }

    @After
    public void after() {
        sqlSession.commit();
        sqlSession.close();
    }

    /**
     * 根据导师的编号查询出 所有老师的信息  递归查询
     */
    @Test
    public  void  selectTeacherById(){
        Student student = mapper.selectTeachersBySid(1);
        System.out.println(student);
    }
    /**
     * 根据导师的编号查询出 所有老师的信息  递归查询
     */
    @Test
    public  void  selectStudentById(){
        Teacher teacher = mapper.selectStudentsByTid(1);
        System.out.println(teacher.getStudernts());
    }
}
