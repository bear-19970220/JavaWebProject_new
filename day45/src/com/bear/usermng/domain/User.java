package com.bear.usermng.domain;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 杨智球
 * @company 东方标准
 * @date 2019/11/27 17:03
 */
public class User implements Serializable {

    private Long uid;
    private String uname;
    private String sex;
    private Integer age;
    private Date birth;
    private String email;

    public String getBirthStr() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日");
        return format.format(birth);
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", birth=" + birth +
                ", email='" + email + '\'' +
                '}';
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth == null ? new Date() : birth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User() {
    }

    public User(Long uid, String uname, String sex, Integer age, Date birth, String email) {
        this.uid = uid;
        this.uname = uname;
        this.sex = sex;
        this.age = age;
        this.birth = birth;
        this.email = email;
    }

}
