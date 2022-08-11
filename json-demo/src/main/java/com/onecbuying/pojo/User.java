package com.onecbuying.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName User
 * @company 公司
 * @Description json对象
 * @createTime 2022年08月11日 15:40:40
 */
public class User implements Serializable {
    private String id;
    private String name;
    private List<Items> items;

    public User() {
    }

    public User(String id, String name, List<Items> items) {
        this.id = id;
        this.name = name;
        this.items = items;
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

    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", items=" + items +
                '}';
    }
}
