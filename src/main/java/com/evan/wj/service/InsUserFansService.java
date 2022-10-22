package com.evan.wj.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.evan.wj.dao.InsUserFansDao;
import com.evan.wj.pojo.InsUserFans;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
@Service
public class InsUserFansService {
    @Autowired
    InsUserFansDao insUserFansDao;
    @Autowired
    CallPythonService callPythonService;

    public int addFansList(List<InsUserFans> list){
        for(InsUserFans fans: list){
            insUserFansDao.save(fans);
        }
        return 0;
    }

//    public List<InsUserFans> getByOperatorId(int operator_id){
//        return insUserFansDao.findInsUserFansByOperator_id(operator_id);
//    }
//
//    public  List<InsUserFans> getByOperatorIdAndCollectGroupType(int operator_id, int collect_group_type){
//        return insUserFansDao.findInsUserFansByOperator_idAndCollect_group_type(operator_id, collect_group_type);
//    }

    //TODO 单线程版本
    public int getFansByNameAndCountAndStore(String username, int count){
        Map<String, String> res = new HashMap<String, String>();
        try{
            res = callPythonService.getByNameAndCount(username, count);
        }catch (IOException e){

        }
        if (res.get("status") != "OK") return -1;
        JSONObject jsonObject = JSON.parseObject(res.get("res"));
        JSONArray jsonArray = jsonObject.getJSONArray("fans");
        List<InsUserFans> fans_list = new ArrayList<>();
        for (int i=0; i<jsonArray.size(); i++){
            JSONObject object = jsonArray.getJSONObject(i);
            Long id = object.getLong("id");
            String name = object.getString("name");
            String full_name = object.getString("full_name");
            String pic = object.getString("pic");
            System.out.println("parse data, id:" + id + ",name:" + name + ",full_name:" + full_name + ",pic:" + pic);
            InsUserFans fans = new InsUserFans(id, name, full_name, pic, 0, 0, 0, "空", "2022", 0, 0, 0);
            fans_list.add(fans);
        }
        System.out.println("fans_list:" + fans_list.size());
        return this.addFansList(fans_list);
    }
}
