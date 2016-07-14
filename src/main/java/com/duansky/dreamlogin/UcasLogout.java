package com.duansky.dreamlogin;

import com.duansky.bean.LogoutInfo;
import org.apache.http.Consts;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by SkyDream on 2016/7/14.
 */
public class UcasLogout extends DreamLogout{

    public static final String logoutUrl = "http://210.77.16.21/eportal/InterFace.do?method=logout";

    public String logout(LogoutInfo info) {

//        String ms2g = "http://121.195.186.149/selfservice/module/billself/web/portal_offline_success.jsf?channel=cG9ydGFs";
//        String name = info.getUsername();
//        String password = info.getPassword();
//        String userIp = "124.16.137.194";
//        String ip = "210.77.16.21";
//        String callBack = "portal_offline_success";

        String userIndex = info.getUserIndex();
        String keepaliveInterval = "0";

        CloseableHttpClient httpClient = HttpClients.createDefault();

        try{
            List<NameValuePair> valuePairs = new LinkedList<NameValuePair>();
//            valuePairs.add(new BasicNameValuePair("ms2g", ms2g));
//            valuePairs.add(new BasicNameValuePair("name", name));
//            valuePairs.add(new BasicNameValuePair("password", password));
//            valuePairs.add(new BasicNameValuePair("userIp", userIp));
//            valuePairs.add(new BasicNameValuePair("ip", ip));
//            valuePairs.add(new BasicNameValuePair("callBack", callBack));

            valuePairs.add(new BasicNameValuePair("userIndex", userIndex));
            valuePairs.add(new BasicNameValuePair("keepaliveInterval", keepaliveInterval));


            //完成登陆请求的构造
            UrlEncodedFormEntity entity = new UrlEncodedFormEntity(valuePairs, Consts.UTF_8);
            HttpPost post = new HttpPost(logoutUrl);
            post.setEntity(entity);
            CloseableHttpResponse r = httpClient.execute(post);//登录
            String res= new String(EntityUtils.toString(r.getEntity()).getBytes("iso-8859-1"),"utf-8");
            r.close();
            return res;

        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
