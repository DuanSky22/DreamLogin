package com.duansky.dreamlogin;

import com.duansky.bean.LogoutInfo;

/**
 * Created by SkyDream on 2016/7/14.
 */
public abstract class DreamLogout {
    public final static String rootPath = System.getProperty("user.dir");
    public abstract String logout(LogoutInfo info);
}
