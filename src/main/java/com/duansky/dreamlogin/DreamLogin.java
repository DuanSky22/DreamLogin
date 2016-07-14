package com.duansky.dreamlogin;

import com.duansky.bean.LoginInfo;

/**
 * Created by SkyDream on 2016/7/14.
 */
public  abstract class DreamLogin {

    public final static String rootPath = System.getProperty("user.dir");

    public abstract String login(LoginInfo info);
}
