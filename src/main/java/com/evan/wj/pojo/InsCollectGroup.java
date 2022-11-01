package com.evan.wj.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "ins_collect_group")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class InsCollectGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;  //自增id

    String ins_user_name; //被抓取粉丝的ins账号名称
    String remark; //采集分组的备注
    int count; //采集量
    int count_real; //实际采集量
    int status; //采集任务状态  0：采集中、1：采集完成、2：采集失败
    int type; //采集类型 0：博主粉丝采集、 1：帖子点赞用户采集 2：帖子评论用户采集
    int operator_id; //采集任务创建人id 对应user表

    public InsCollectGroup() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIns_user_name() {
        return ins_user_name;
    }

    public void setIns_user_name(String ins_user_name) {
        this.ins_user_name = ins_user_name;
    }

    public InsCollectGroup(String ins_user_name, String remark, int count, int count_real, int status, int type, int operator_id) {
        this.ins_user_name = ins_user_name;
        this.remark = remark;
        this.count = count;
        this.count_real = count_real;
        this.status = status;
        this.type = type;
        this.operator_id = operator_id;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount_real() {
        return count_real;
    }

    public void setCount_real(int count_real) {
        this.count_real = count_real;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getOperator_id() {
        return operator_id;
    }

    public void setOperator_id(int operator_id) {
        this.operator_id = operator_id;
    }

    @Override
    public String toString() {
        return "InsCollectGroup{" +
                "id=" + id +
                ", ins_user_name='" + ins_user_name + '\'' +
                ", remark='" + remark + '\'' +
                ", count=" + count +
                ", count_real=" + count_real +
                ", status=" + status +
                ", type=" + type +
                ", operator_id=" + operator_id +
                '}';
    }
}
