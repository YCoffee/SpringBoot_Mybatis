package com.gdyx.dbo.model;

import java.io.Serializable;

/**
 * Created by mac on 2017/5/12.
 */
public class Demo implements Serializable {
    private String id="";
    private String name="";
    private String pasv="";
    private String descr="";

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPasv() {
        return pasv;
    }

    public void setPasv(String pasv) {
        this.pasv = pasv;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }
}
