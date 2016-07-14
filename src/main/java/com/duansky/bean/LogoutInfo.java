package com.duansky.bean;

/**
 * Created by SkyDream on 2016/7/14.
 */
public class LogoutInfo {

    private String username;
    private String password;

    private String userIndex;

    public String getUserIndex() {
        return userIndex;
    }

    public void setUserIndex(String userIndex) {
        this.userIndex = userIndex;
    }

    public LogoutInfo(String username, String password,String userIndex){
        this.username = username;
        this.password = password;
        this.userIndex = userIndex;
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
}
