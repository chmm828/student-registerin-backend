package com.server.utils;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
/**
 * @author ： 
 * @date ：Created in  2022/12/22 18:20
 * @description： 获取微信openid
 * @modified By：
 */
public class WxUtils {

    /**
     * 输入一个code，返回一个openid
     *
     * @param code
     * @return
     */
    public static String wxOpenId(String code) {
        String appid = "wx2a889b808f6f376c";  //微信小程序oppenid
        String secret = "98a32cb2d38cae9079bbc217ea44c9b6";  //微信小程序appSecret

        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + appid + "&secret=" + secret + "&js_code=" + code + "&grant_type=authorization_code";
        System.out.println("code: " + code);
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();

        Response response = null;
        try {
            response = client.newCall(request).execute();
            System.out.println(response);
            if (response.isSuccessful()) {
                String body = response.body().string();
//                System.out.println(body);
                // 转成Json对象 获取openid
                try {
                    JSONObject jsonObject = new JSONObject(body);
                    String openid = jsonObject.get("openid").toString();
                    String sessionKey = jsonObject.get("session_key").toString();
                    System.out.println(openid);//在控制台打印oppenid
//                    System.out.println(sessionKey);//在控制台打印sessionkey
                    return openid;
                } catch (JSONException e) {
                    e.printStackTrace();
                    return "JSONException";
                }
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
        return "IO错误";
    }
}