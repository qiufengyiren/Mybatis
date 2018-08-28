package com.dzq.pojo;

import java.util.Set;

public class Teacher {
    private  Integer id;   //老师或者导师的编号
    private  String  name;//老师或者导师的姓名
    //一个导师可以有多个老师
    private Set<Teacher> teachers;

    public Teacher() {
    }

    public Teacher(Integer id, String name, Set<Teacher> teachers) {
        this.id = id;
        this.name = name;
        this.teachers = teachers;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<Teacher> teachers) {
        this.teachers = teachers;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", teachers=" + teachers +
                '}';
    }
}
