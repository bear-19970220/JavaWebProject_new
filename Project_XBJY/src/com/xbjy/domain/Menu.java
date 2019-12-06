package com.xbjy.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 杨智球
 * @company 东方标准
 * @date 2019/12/2 11:17
 */
public class Menu implements Serializable {

    private Integer id;
    private Integer pId;
    private String type;
    private String name;
    private String menuUrl;
    private Integer orderBy;
    private Date creatTime;
    private Integer createBy;
    private String delFlag;

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", pId=" + pId +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", menuUrl='" + menuUrl + '\'' +
                ", orderBy=" + orderBy +
                ", creatTime=" + creatTime +
                ", createBy=" + createBy +
                ", delFlag='" + delFlag + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public Integer getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(Integer orderBy) {
        this.orderBy = orderBy;
    }

    public Date getcreatTime() {
        return creatTime;
    }

    public void setcreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public Menu() {
    }

    public Menu(Integer id, Integer pId, String type, String name, String menuUrl, Integer orderBy, Date creatTime, Integer createBy, String delFlag) {
        this.id = id;
        this.pId = pId;
        this.type = type;
        this.name = name;
        this.menuUrl = menuUrl;
        this.orderBy = orderBy;
        this.creatTime = creatTime;
        this.createBy = createBy;
        this.delFlag = delFlag;
    }
}