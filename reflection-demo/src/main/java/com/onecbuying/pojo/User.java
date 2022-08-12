package com.onecbuying.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName User
 * @company 公司
 * @Description TODO
 * @createTime 2022年08月12日 14:56:56
 */
public class User implements Serializable {
    private String id;
    private String name;


    public User() {
    }

    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }

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


    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

