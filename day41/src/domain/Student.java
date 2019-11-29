package domain;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 杨智球
 * @company 东方标准
 * @date 2019/11/26 17:16
 */
public class Student {

    private String sname;
    private String ssex;
    private Date sbirth;

    public String getSbirthStr() {
        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.applyPattern("yyyy年MM月dd日 HH:mm:ss");
        String sbirthStr = sdf.format(sbirth);
        return sbirthStr;
    }

    public Date getSbirth() {
        return sbirth;
    }

    public void setSbirth(Date sbirth) {
        this.sbirth = sbirth;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sname='" + sname + '\'' +
                ", ssex='" + ssex + '\'' +
                ", sbirth=" + sbirth +
                '}';
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSsex() {
        return ssex;
    }

    public void setSsex(String ssex) {
        this.ssex = ssex;
    }


    public Student() {
    }

    public Student(String sname, String ssex, Date sbirth) {
        this.sname = sname;
        this.ssex = ssex;
        this.sbirth = sbirth;
    }
}
