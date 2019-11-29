package com.dfbz.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 杨智球
 * @company 东方标准
 * @date 2019/11/20 19:01
 */
public class Customer implements Serializable {

    private Long cid;
    private String cname;
    private String csex;
    private String cphone;
    private String caddress;
    private Date cbirth;
    private Date cjointime;

    public Customer() {
    }

    @Override
    public String toString() {
        return "Customer{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", csex='" + csex + '\'' +
                ", cphone='" + cphone + '\'' +
                ", caddress='" + caddress + '\'' +
                ", cbirth=" + cbirth +
                ", cjointime=" + cjointime +
                '}';
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCsex() {
        return csex;
    }

    public void setCsex(String csex) {
        this.csex = csex;
    }

    public String getCphone() {
        return cphone;
    }

    public void setCphone(String cphone) {
        this.cphone = cphone;
    }

    public String getCaddress() {
        return caddress;
    }

    public void setCaddress(String caddress) {
        this.caddress = caddress;
    }

    public Date getCbirth() {
        return cbirth;
    }

    public void setCbirth(Date cbirth) {
        this.cbirth = cbirth;
    }

    public Date getCjointime() {
        return cjointime;
    }

    public void setCjointime(Date cjointime) {
        this.cjointime = cjointime;
    }

    public Customer(Long cid, String cname, String csex, String cphone, String caddress, Date cbirth, Date cjointime) {
        this.cid = cid;
        this.cname = cname;
        this.csex = csex;
        this.cphone = cphone;
        this.caddress = caddress;
        this.cbirth = cbirth;
        this.cjointime = cjointime;
    }
}
