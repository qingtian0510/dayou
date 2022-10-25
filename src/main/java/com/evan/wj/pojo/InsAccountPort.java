package com.evan.wj.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "ins_account_port")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class InsAccountPort {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;  //端口id 自增
    String port_name;  //端口标识名称
    Date create_time;  //创建时间
    String remark;  //备注

    public InsAccountPort(String port_name, Date create_time, String remark) {
        this.port_name = port_name;
        this.create_time = create_time;
        this.remark = remark;
    }

    public InsAccountPort() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPort_name() {
        return port_name;
    }

    public void setPort_name(String port_name) {
        this.port_name = port_name;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
