package com.evan.wj.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.evan.wj.dao.InsAccountDao;
import com.evan.wj.pojo.InsAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static com.evan.wj.utils.FileUtils.readFile;
import static com.evan.wj.utils.StringUtils.isString;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class InsAccountService {

    @Autowired
    InsAccountDao insAccountDao;

    public int addAccountFromFile(String path){
        List<String> strs = readFile(path);
        List<InsAccount> list = new ArrayList<>();
        for(String str: strs){
            try {
                JSONObject obj = JSON.parseObject(str);
                String user_id = obj.getString("userId");
                String user_name = obj.getString("userName");
                String password = obj.getString("passWord");
                System.out.println("id:" + user_id + ",name:" + user_name + ",passwd:" + password);
                //user_id user_name password 不能为空或空字符串
                if(!isString(user_id) || !isString(user_name) || !isString(password)) continue;
                String remark = "备注";
                Date upload_time = new Date();
                int port_id = 0;
                int status = 0;
                int login_status = 0;
                int upload_user_id = 0;
                InsAccount insAccount = new InsAccount(user_id, user_name, password, remark, upload_time, port_id, upload_user_id, status, login_status);
                list.add(insAccount);
            }catch (JSONException e){
                System.out.print("[InsAccountService][addAccountFromFile] exception:" + e.getMessage());

            } catch (Exception e){
                System.out.println("[InsAccountService][addAccountFromFile] exception:" + e.getMessage());

            }finally {
                continue;
            }

        }

        for(InsAccount account: list){
            insAccountDao.save(account);
        }
        System.out.println("add " + list.size() + " account");
        return 0;
    }

    public List<InsAccount> getAccountBy
}
