package com.dzq.pojo;

import java.io.Serializable;
import java.util.Set;

/*
国家对应的实体类
 * */
public class Country implements Serializable {
    private int cId;//国家id
    private String cName;//国家名称
    private Set<Provincial> provincials;

    public Country() {

    }

    public Country(int cId, String cName, Set<Provincial> provincials) {
        this.cId = cId;
        this.cName = cName;
        this.provincials = provincials;
    }

    public Set<Provincial> getProvincials() {
        return provincials;
    }

    public void setProvincials(Set<Provincial> provincials) {
        this.provincials = provincials;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    @Override
    public String toString() {
        return "Country{" +
                "cId=" + cId +
                ", cName='" + cName + '\'' +
                ", provincials=" + provincials +
                '}';
    }
}
