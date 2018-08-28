package com.dzq.pojo;

import java.io.Serializable;

/**
 * 省会对应的实体类
 */
public class Provincial implements Serializable {
    private int pId;//省会id
    private String pName;//省会名称



    public Provincial() {
    }

    public Provincial(int pId, String pName) {
        this.pId = pId;
        this.pName = pName;
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

    @Override
    public String toString() {
        return "Provincial{" +
                "pId=" + pId +
                ", pName='" + pName + '\'' +
                '}';
    }
}
