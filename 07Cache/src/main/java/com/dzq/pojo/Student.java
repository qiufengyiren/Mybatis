package com.dzq.pojo;

public class Student {
    private  int sId;
    private String sName;
    private Integer age;

    public Student() {
    }

    public Student(int sId, String sName, Integer age) {
        this.sId = sId;
        this.sName = sName;
        this.age = age;
    }

    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sId=" + sId +
                ", sName='" + sName + '\'' +
                ", age=" + age +
                '}';
    }


}
