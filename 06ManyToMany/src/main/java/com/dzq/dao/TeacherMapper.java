package com.dzq.dao;

import com.dzq.pojo.Student;
import com.dzq.pojo.Teacher;

import java.io.Serializable;

public interface TeacherMapper {
    /**
     * 根据老师的编号 查询所有导师信息
     */
    Teacher selectStudentsByTid(Serializable id);

    /**
     * 根据学生的编号 查询所有信息
     */
    Student  selectTeachersBySid(Serializable id);
}
