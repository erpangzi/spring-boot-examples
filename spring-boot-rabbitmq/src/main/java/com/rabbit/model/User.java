package com.rabbit.model;

import java.io.Serializable;

/**
 * Created by summer on 2016/11/29.
 */
public class User implements Serializable{

    private Integer id ;

    private String name;

    private String pass;

    public User() {
    }

    public User(Integer id, String name, String pass) {
        this.id = id;
        this.name = name;
        this.pass = pass;
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

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }
}
