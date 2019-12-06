package com.xbjy.domain;

import java.util.Date;

/**
 * @author 杨智球
 * @company 东方标准
 * @date 2019/12/2 19:10
 */
public class Dept {

    private Integer id;
    private String name;
    private Date createTime;
    private Integer createBy;
    private Integer delFlag;

    @Override
    public String toString() {
        return "Dept{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createTime=" + createTime +
                ", createBy=" + createBy +
                ", delFlag=" + delFlag +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Dept() {
    }

    public Dept(Integer id, String name, Date createTime, Integer createBy, Integer delFlag) {
        this.id = id;
        this.name = name;
        this.createTime = createTime;
        this.createBy = createBy;
        this.delFlag = delFlag;
    }
}
