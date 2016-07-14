package com.duansky.bean;

/**
 * Created by SkyDream on 2016/7/14.
 */
public enum UcasMessage {
    PASSWORD_ERROR("密码不匹配"),
    EMPTY_USER("用户不存在"),
    SUCCESS("success"),
    UNKNOWN("error");

    private String content;

    private UcasMessage(String content){
        this.content = content;
    }

    public String getContent(){
        return content;
    }
}
