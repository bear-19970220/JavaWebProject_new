package com.xbjy.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author 杨智球
 * @company 东方标准
 * @date 2019/12/2 16:23
 */
public class User {

    private Integer uid;
    private Integer deptId;
    private String dname;
    private String account;
    private String password;
    private String name;
    private Integer age;
    private Integer sex;
    private String email;
    private Date birth;
    private Date createTime;
    private Integer createBy;
    private Integer delFlag;

    @JsonIgnore
    private String birthStr;
    @JsonIgnore
    private String sexStr;
    @JsonIgnore
    private String delFlagStr;

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", deptId=" + deptId +
                ", dname='" + dname + '\'' +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", email='" + email + '\'' +
                ", birth=" + birth +
                ", createTime=" + createTime +
                ", createBy=" + createBy +
                ", delFlag=" + delFlag +
                '}';
    }

    public String getSexStr() {
        return sex == null ? "" : sex == 1 ? "男" : sex == 0 ? "女" : "不详";
    }

    public String getBirthStr() {
        if(birth != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            return sdf.format(birth);
        } else {
            return "";
        }
    }

    public String getDelFlagStr() {
        return delFlag == null ? "未知状态" : delFlag == 1 ? "已删除" : delFlag == 0 ? "可用" : "非法状态";
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    private void setAge() {
        if (birth == null) {
            this.age = null;
        } else {
            Calendar c_now = Calendar.getInstance();
            Calendar c_birth = Calendar.getInstance();
            c_now.setTime(new Date());
            c_birth.setTime(birth);
            this.age = c_now.get(Calendar.YEAR) - c_birth.get(Calendar.YEAR);
        }
    }


    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
        setAge();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public User() {
    }

    public User(Integer uid, Integer deptId, String account, String password, String name, Integer age, Integer sex, String email, Date birth, Date createTime, Integer createBy, Integer delFlag) {
        this.uid = uid;
        this.deptId = deptId;
        this.account = account;
        this.password = password;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.email = email;
        this.birth = birth;
        this.createTime = createTime;
        this.createBy = createBy;
        this.delFlag = delFlag;
    }
}