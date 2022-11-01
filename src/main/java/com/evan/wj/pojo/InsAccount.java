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
    @Column(name = "user_id")
    String userId; //真实ins系统user id
    @Column(name = "name")
    String name;   //用户名
    @Column(name = "password")
    String password; //登录秘密
    @Column(name = "remark")
    String remark; //备注
    @Column(name = "upload_time")
    Date uploadTime;  //上传时间
    @Column(name = "port_id")
    int portId; //所在端口id
    @Column(name = "upload_user_id")
    int uploadUserId; //上传客户id（购买端口客户id） User.id
    @Column(name = "status")
    int status; //账号状态，  0：正常 1：异常
    @Column(name = "login_status")
    int loginStatus; //登录状态

    public InsAccount(String userId, String name, String password, String remark, Date uploadTime, int portId, int uploadUserId, int status, int loginStatus) {
        this.userId = userId;
        this.name = name;
        this.password = password;
        this.remark = remark;
        this.uploadTime = uploadTime;
        this.portId = portId;
        this.uploadUserId = uploadUserId;
        this.status = status;
        this.loginStatus = loginStatus;
    }

    public InsAccount() {
    }

    @Override
    public String toString() {
        return "InsAccount{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", remark='" + remark + '\'' +
                ", uploadTime=" + uploadTime +
                ", portId=" + portId +
                ", uploadUserId=" + uploadUserId +
                ", status=" + status +
                ", loginStatus=" + loginStatus +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    public int getPortId() {
        return portId;
    }

    public void setPortId(int portId) {
        this.portId = portId;
    }

    public int getUploadUserId() {
        return uploadUserId;
    }

    public void setUploadUserId(int uploadUserId) {
        this.uploadUserId = uploadUserId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(int loginStatus) {
        this.loginStatus = loginStatus;
    }
}
