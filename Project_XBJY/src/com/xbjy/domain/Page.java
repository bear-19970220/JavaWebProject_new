package com.xbjy.domain;

import java.util.List;

/**
 * @author 杨智球
 * @company 东方标准
 * @date 2019/12/3 13:42
 */
public class Page<T> {

    private int currentPage;
    private int pageSize;
    private int totalPage;
    private int totalRecord;
    private List<T> beanList;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }

    public List<T> getBeanList() {
        return beanList;
    }

    public void setBeanList(List<T> beanList) {
        this.beanList = beanList;
    }

    public Page() {
    }

    public Page(int currentPage, int pageSize, int totalPage, int totalRecord, List<T> beanList) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalPage = totalPage;
        this.totalRecord = totalRecord;
        this.beanList = beanList;
    }

    @Override
    public String toString() {
        return "Page{" +
                "currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                ", totalPage=" + totalPage +
                ", totalRecord=" + totalRecord +
                ", beanList=" + beanList +
                '}';
    }
}
