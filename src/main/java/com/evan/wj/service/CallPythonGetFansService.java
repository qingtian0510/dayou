package com.evan.wj.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.evan.wj.pojo.InsUserFans;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CallPythonGetFansService {

    @Value("${carlos.python.script.path2}")
    private String pythonScriptPath;

    @Value("${carlos.python.path}")
    private String pythonPath;

    public List<InsUserFans> getByNameAndCount(String target_username, String fetch_by_username, String fetch_by_user_passwd, int count) throws IOException {


        int collect_group_id = 0;
        int operator_id = 0;
        int collect_group_type = 0;
        List<InsUserFans> list = new ArrayList<>();
        Map<String, String> res = new HashMap<>();
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
                    JSONObject jsonObject = JSON.parseObject(line);
                    String status = jsonObject.getString("status");
                    if(status.equals("OK")) {
                        JSONArray jsonArray = jsonObject.getJSONArray("fans");
                        for (int i = 0; i < jsonArray.size(); i++) {
                            JSONObject jb = jsonArray.getJSONObject(i);
                            InsUserFans insUserFans = new InsUserFans(jb.getString("id"), jb.getString("name"), jb.getString("full_name"), jb.getString("pic"), 0, 0, 0, "location", "20221029", collect_group_id, operator_id, collect_group_type);
                            list.add(insUserFans);
                        }
                    }
                }
            }

            in.close();
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("[CallPythonGetFansService][getByNameAndCount] failed! e:" + e.toString());
        }finally {
            if (in != null){
                in.close();
            }
        }
        return list;
    }
}
