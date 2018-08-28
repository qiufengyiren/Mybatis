package com.dzq.pojo;

import java.io.Serializable;

/**
 * 省会对应的实体类
 */
public class Provincial implements Serializable {
    private int pId;//省会id
    private String pName;//省会名称
    //多个省会 对应一个国家 多对一
    private Country country;


    public Provincial() {
    }

    public Provincial(int pId, String pName, Country country) {
        this.pId = pId;
        this.pName = pName;
        this.country = country;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public Country getCountry() { return country; }

    public void setCountry(Country country) { this.country = country;}


    @Override
    public String toString() {
        return "Provincial{" +
                "pId=" + pId +
                ", pName='" + pName + '\'' +
                ", country=" + country +
                '}';
    }


}
