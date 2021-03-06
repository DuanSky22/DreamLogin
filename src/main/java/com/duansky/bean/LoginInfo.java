package com.duansky.bean;

/**
 * Created by SkyDream on 2016/7/14.
 */
public class LoginInfo {

    private String username;
    private String password;
    private String userIndex;

    public String getUserIndex() {
        return userIndex;
    }

    public void setUserIndex(String userIndex) {
        this.userIndex = userIndex;
    }

    public LoginInfo(String username,String password){
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString(){
        return username+":"+password;
    }

}
