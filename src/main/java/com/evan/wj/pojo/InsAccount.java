package com.evan.wj.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ins_account")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class InsAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;   //自增id
    String user_id; //真实ins系统user id
    String name;   //用户名
    String password; //登录秘密
    String remark; //备注

    Date upload_time;  //上传时间

    int port_id; //所在端口id

    int status; //账号状态，  0：正常 1：异常

    int login_status; //登录状态

    public InsAccount(String user_id, String name, String password, String remark, Date upload_time, int port_id, int status, int login_status) {
        this.user_id = user_id;
        this.name = name;
        this.password = password;
        this.remark = remark;
        this.upload_time = upload_time;
        this.port_id = port_id;
        this.status = status;
        this.login_status = login_status;
    }



    public InsAccount() {

    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public Date getUpload_time() {
        return upload_time;
    }

    public void setUpload_time(Date upload_time) {
        this.upload_time = upload_time;
    }

    public int getPort_id() {
        return port_id;
    }

    public void setPort_id(int port_id) {
        this.port_id = port_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getLogin_status() {
        return login_status;
    }

    public void setLogin_status(int login_status) {
        this.login_status = login_status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }


}
