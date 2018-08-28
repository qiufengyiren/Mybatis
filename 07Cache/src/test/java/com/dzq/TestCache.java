package com.dzq;


import com.dzq.dao.StudentMapper;
import com.dzq.pojo.Student;
import com.dzq.util.SessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;



public class TestCache {
    SqlSession sqlSession = null;
    StudentMapper mapper = null;

    @Before
    public void before() {
        sqlSession = SessionFactoryUtil.getSession();
        mapper = sqlSession.getMapper(StudentMapper.class);
    }

    @After
    public void after() {
        sqlSession.commit();
        sqlSession.close();
    }

    /**
     * 一级缓存
     * 查询
     */
    @Test
    public void selectStudentById() {
        Student student = mapper.selectStudentById(1);
        System.out.println("第一次查询" + student);
        student = mapper.selectStudentById(1);
        System.out.println("第二次查询" + student);
    }

    /**
     * 修改
     * 验证修改是否对缓存有影响
     */
    @Test
    public void updateStudent() {
        Student student = mapper.selectStudentById(1);
        System.out.println(student);
        System.out.println("================================");
        student.setsName("张二");
        mapper.updateStudent(student);
        student = mapper.selectStudentById(1);
        System.out.println(student);
    }

    /**
     * 添加
     */
    @Test
    public void addStudent() {
        Student student = mapper.selectStudentById(4);
        System.out.println("第一次查询" + student);
        mapper.addStudent(new Student(4, "王五1", 19));
        student = mapper.selectStudentById(4);
        System.out.println("第二次查询" + student);
    }

    /**
     * 删除
     */
    @Test
    public void deleteStudent() {
        Student student = mapper.selectStudentById(4);
        System.out.println("第一次查询" + student);
        mapper.deleteStudent(student);
        student = mapper.selectStudentById(4);
        System.out.println("第二次查询" + student);
    }
    /**
     * 验证二级缓存
     */
    @Test
    public void testSecondCache(){
        Student student=mapper.selectStudentById(1);//产生SQL语句
        sqlSession.close();
        sqlSession = SessionFactoryUtil.getSession();//重获session
        mapper=sqlSession.getMapper(StudentMapper.class);
        student=mapper.selectStudentById(1);//会产生一条SQL语句
        sqlSession.close();
        sqlSession = SessionFactoryUtil.getSession();
        mapper=sqlSession.getMapper(StudentMapper.class);
        student=mapper.selectStudentById(1);
        sqlSession.close();
        sqlSession = SessionFactoryUtil.getSession();
        mapper=sqlSession.getMapper(StudentMapper.class);
        student=mapper.selectStudentById(1);


    }
}
