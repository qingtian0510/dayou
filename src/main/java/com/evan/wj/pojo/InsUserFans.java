package com.evan.wj.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "ins_user_fans")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class InsUserFans {

    @Id
    @Column(name = "id")
    Long id;   //真实ins系统user id

    String name;   //用户名
    String full_name;
    String pic;  //头像链接

    public InsUserFans(Long id, String name, String full_name, String pic, int article_num, int follow_num, int fans_num, String location, String last_time, int collect_group_id, int operator_id, int collect_group_type) {
        this.id = id;
        this.name = name;
        this.full_name = full_name;
        this.pic = pic;
        this.article_num = article_num;
        this.follow_num = follow_num;
        this.fans_num = fans_num;
        this.location = location;
        this.last_time = last_time;
        this.collect_group_id = collect_group_id;
        this.operator_id = operator_id;
        this.collect_group_type = collect_group_type;
    }

    int article_num;  //帖子数量
    int follow_num; //关注量
    int fans_num;  //粉丝数量
    String location;  //地区位置
    String last_time; //最近登录时间
    int collect_group_id; //所在数据爬取分组
    int operator_id; //采集任务创建人id
    int collect_group_type;  //采集类型 0：博主粉丝 1：帖子点赞 2：帖子评论

    public int getOperator_id() {
        return operator_id;
    }

    public int getCollect_group_type() {
        return collect_group_type;
    }

    public void setCollect_group_type(int collect_group_type) {
        this.collect_group_type = collect_group_type;
    }

    public void setOperator_id(int operator_id) {
        this.operator_id = operator_id;
    }

    public InsUserFans() {

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

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public int getArticle_num() {
        return article_num;
    }

    public void setArticle_num(int article_num) {
        this.article_num = article_num;
    }

    public int getFollow_num() {
        return follow_num;
    }

    public void setFollow_num(int follow_num) {
        this.follow_num = follow_num;
    }

    public int getFans_num() {
        return fans_num;
    }

    public void setFans_num(int fans_num) {
        this.fans_num = fans_num;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLast_time() {
        return last_time;
    }

    public void setLast_time(String last_time) {
        this.last_time = last_time;
    }

    public int getCollect_group_id() {
        return collect_group_id;
    }

    public void setCollect_group_id(int collect_group_id) {
        this.collect_group_id = collect_group_id;
    }

}
