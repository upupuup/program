package com.navi.mini.program.utils;

import com.alibaba.fastjson.JSONObject;
import okhttp3.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * HTTP同步请求
 *
 * @author wanagpeng
 * @version 1.0
 * @date:2019/6/21 16:50
 * @since JDK 1.8
 */
public class HttpUtils {

    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

    public static JSONObject doGet(String url) {
        OkHttpClient client = new OkHttpClient.Builder().connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS).build();
        Request request = new Request.Builder().url(url).build();
        JSONObject jsonObject = null;
        try {
            Response response = client.newCall(request).execute();
            jsonObject = JSONObject.parseObject(response.body().string());
        } catch (IOException e) {
        }
        return jsonObject;
    }

    public static JSONObject doPost(String url, String json) {
        OkHttpClient client = new OkHttpClient.Builder().connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS).build();
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder().url(url).post(body).build();
        JSONObject jsonObject = null;
        try {
            Response response = client.newCall(request).execute();
            jsonObject = JSONObject.parseObject(response.body().string());
        } catch (IOException e) {
        }
        return jsonObject;
    }
}
