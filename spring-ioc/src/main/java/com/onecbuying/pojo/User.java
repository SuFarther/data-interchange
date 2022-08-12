package com.onecbuying.pojo;

import java.io.Serializable;

/**
 * @version 1.0
 * @ClassName User
 * @company 公司
 * @Description TODO
 * @createTime 2022年08月12日 23:29:29
 */
public class User implements Serializable {

    private  String userId;
    private  String userName;

    public User() {
        System.out.println("无参构造函数");
    }

    public User(String userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
