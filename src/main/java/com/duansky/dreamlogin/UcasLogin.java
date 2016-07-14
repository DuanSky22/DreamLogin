package com.duansky.dreamlogin;

import com.duansky.bean.LoginInfo;
import com.duansky.bean.PasswordFactory;
import com.duansky.bean.UcasMessage;
import com.duansky.bean.UserNameFactory;
import org.apache.http.Consts;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

import static jdk.nashorn.internal.objects.NativeDate.parse;

/**
 * Created by SkyDream on 2016/7/12.
 */
public class UcasLogin extends DreamLogin {

    public static final String loginUrl = "http://210.77.16.21/eportal/InterFace.do?method=login";

    public String login(LoginInfo info){

        String username = info.getUsername();                //用户名
        String password = info.getPassword();                //密码
        String service = "";                                //net_access_type  服务
        String queryString ="wlanuserip=0bc386d9e643d188b011a0d00c9b5c40&wlanacname=5fcbc245a7ffdfa4&ssid=&nasip=2c0716b583c8ac3cbd7567a84cfde5a8&mac=53ba540bde596b811a6d5617a86fa028&t=wireless-v2&url=2c0328164651e2b4f13b933ddf36628bea622dedcc302b30";
        String operatorPwd="";                              //isNoOperatorPasswordFrameId 是否记住密码
        String validcode="";                            //isDisplayValidCode 验证码

//        RequestConfig requestConfig = RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD_STRICT).build();
//        CloseableHttpClient httpClient = HttpClients.custom().setDefaultRequestConfig(requestConfig).build();

        CloseableHttpClient httpClient = HttpClients.createDefault();

        try{
            List<NameValuePair> valuePairs = new LinkedList<NameValuePair>();
            valuePairs.add(new BasicNameValuePair("userId", username));
            valuePairs.add(new BasicNameValuePair("password", password));
            valuePairs.add(new BasicNameValuePair("service", service));
            valuePairs.add(new BasicNameValuePair("queryString", queryString));
            valuePairs.add(new BasicNameValuePair("operatorPwd", operatorPwd));
            valuePairs.add(new BasicNameValuePair("validcode", validcode));

            //完成登陆请求的构造
            UrlEncodedFormEntity entity = new UrlEncodedFormEntity(valuePairs, Consts.UTF_8);
            HttpPost post = new HttpPost(loginUrl);
            post.setEntity(entity);
            CloseableHttpResponse r = httpClient.execute(post);//登录
            String res= new String(EntityUtils.toString(r.getEntity()).getBytes("iso-8859-1"),"utf-8");
            r.close();
            if(res.contains("success")){
                int begin = res.indexOf("userIndex");
                begin += 12;
                int end = res.indexOf('"',begin);
                info.setUserIndex(res.substring(begin,end));
            }

            return res;

        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
