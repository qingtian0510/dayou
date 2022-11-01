package com.evan.wj.utils;

import java.net.Proxy;
import java.util.ArrayList;
import java.util.List;

public class ProxyUtils {
    public static int MAXNUM = 10000; //https://coralip.com/#/getapi   ip代理系统单词获取代理最大值
    public static String URL = "https://coralip.com/api/v2/getIP?username=pps_rfpenf&password=mvsrzxknyb&noloop=0&protocol=1&count=%d&region=&hours=9&type=text";
    public static String TESTURL = "https://api.myip.la/en?json";
    public static List<String> getProxiesWithNum(int count){
        List<String> proxies = null;
        if (count > MAXNUM){
            System.out.println("fetch too much ip once!");
            return null;
        }
        String url = String.format(URL, count);
        System.out.println("url:" + url);
        try{
            proxies = NetworkUtils.get(url);
        }catch (Exception e){

        }

        return proxies;
    }

    public static boolean proxyIsAvailable(String proxy){
        boolean available = false;
        System.setProperty("https.proxyHost", proxy);
        try{
            List<String> res = NetworkUtils.get(TESTURL);
            for (String s: res){
                StringUtils.StringPrint(s);
            }
        }catch (Exception e){

        }
        return available;
    }

    public static void main(String[] args) {
//        List<String> proxies = ProxyUtils.getProxiesWithNum(100);
//        for(String proxy: proxies){
//            System.out.println(proxy);
//        }

        String pro = "http://MWQJMDV4J2AHHEK6HYCTUJNDYJDMCESTB2UEBCXDSOIPUW2ASP3A:MH2LHFKMC45OT3UTODNOQOX5RU@128.199.0.193:10004";
        System.out.println(proxyIsAvailable(pro));
    }
}
