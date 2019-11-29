package com.bear.usermng.domain;

import java.io.Serializable;
import java.util.List;

/**
 * @author 杨智球
 * @company 东方标准
 * @date 2019/11/28 14:35
 */
public class PageBean implements Serializable {

    /**
     * 当前页码
     */
    private Integer currentPage;
    /**
     * 总记录数
     */
    private Integer totalRecord;
    /**
     * （页容量）
     */
    private Integer pageSize;

    /**
     * 每页记录对象
     */
    private List<User> users;


    public PageBean() {
    }

    public PageBean(Integer currentPage, Integer totalRecord, Integer pageSize, List<User> users) {
        this.currentPage = currentPage;
        this.totalRecord = totalRecord;
        this.pageSize = pageSize;
        this.users = users;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(Integer totalRecord) {
        this.totalRecord = totalRecord;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Integer getTotalPage() {
        return totalRecord % pageSize == 0 ? totalRecord / pageSize : totalRecord / pageSize + 1;
    }
}
