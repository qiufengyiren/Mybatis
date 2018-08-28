package com.dzq.dao;

import com.dzq.pojo.Student;

import java.io.Serializable;

public interface StudentMapper {
    /**
     * 查询 一级缓存
     * @param id
     * @return
     */
    Student selectStudentById(Serializable id);

    /**
     * 修改
     */
    void updateStudent(Student id);

    /**
     * 添加
     */
    void addStudent(Student student);
    /**
     * 删除
     */
    void deleteStudent(Student id);
}
