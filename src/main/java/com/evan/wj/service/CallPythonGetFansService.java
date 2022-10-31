package com.evan.wj.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

@Service
public class CallPythonGetFansService {

    @Value("${carlos.python.script.path}")
    private String pythonScriptPath;

    @Value("${carlos.python.path}")
    private String pythonPath;

    public Map<String, String> getByNameAndCount(String target_username, String fetch_by_username, String fetch_by_user_passwd, int count) throws IOException {

        Map<String, String> res = new HashMap<>();
        //TODO "55407457717" 抓取请求uid替换
        String[] arg = new String[]{pythonPath, pythonScriptPath, target_username, fetch_by_username, fetch_by_user_passwd, Integer.toString(count)};
//        打印出来的命令行，也是在bash或者cmd上执行的命令，可预先测试下
        System.out.println("=======================command line=======================");
        for (String s : arg) {
            System.out.print(s + " ");
        }
        System.out.println("\n=======================command line=======================");
        Process proc;
        BufferedReader in = null;
        try {
            proc = Runtime.getRuntime().exec(arg); // 执行py文件
            in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            String line;

            while ((line = in.readLine()) != null) {
//                打印python脚本输出
                System.out.println(line);
//                判断是否为返回结果
                if (line.startsWith("{") && line.endsWith("}") && line.contains("status")){
                    res.put("res", line);
                    res.put("status", "OK");
                    return res;
//                    return JSON.parse(line);
                }
            }

            in.close();
        }catch (IOException e){
            e.printStackTrace();
            res.put("status", "error");
            res.put("msg", "python script run error,e:" + e.toString());
        }finally {
            if (in != null){
                in.close();
            }
        }

        return res;

    }
}
