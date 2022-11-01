package com.evan.wj.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class NetworkUtils {
    public static List<String> get(String url) throws Exception {
        String USER_AGENT = "Mozilla/5.0";
        List<String> content = new ArrayList<>();
        URLConnection urlConnection = new URL(url).openConnection();
        HttpURLConnection connection = (HttpURLConnection) urlConnection;
        connection.setRequestMethod("GET");
        connection.setRequestProperty("User-Agent", USER_AGENT);
        //连接
        connection.connect();
        //得到响应码
        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader
                    (connection.getInputStream(), StandardCharsets.UTF_8));
            String l;
            while ((l = bufferedReader.readLine()) != null) {
                content.add(l);
            }
        }
        return content;
    }

    public static void main(String[] args) {
        String url = "https://coralip.com/api/v2/getIP?username=pps_rfpenf&password=mvsrzxknyb&noloop=0&protocol=1&count=10&region=&hours=9&type=text";
        try {
            List<String> list = NetworkUtils.get(url);
            for(String str: list){
                System.out.println(str);
            }
        }catch (Exception e){

        }

    }

}
