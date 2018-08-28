package com.dzq.pojo;

import java.util.Set;

public class Teacher {
    private Integer id;
    private String name;
    private Set<Student> studernts;//一个老师对应很多学生

    public Teacher() {
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", studernts=" + studernts +
                '}';
    }

    public Set<Student> getStudernts() {
        return studernts;
    }

    public void setStudernts(Set<Student> studernts) {
        this.studernts = studernts;
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

    public Teacher(Integer id, String name, Set<Student> studernts) {
        this.id = id;
        this.name = name;
        this.studernts = studernts;
    }
}
