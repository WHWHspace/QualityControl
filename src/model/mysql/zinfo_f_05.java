package model.mysql;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by 31344 on 2016/8/5.
 */
@Entity
public class Zinfo_f_05 {
    private int pat_id;
    private String info_date;
    private String info_user;
    private String txt_1;
    private String txt_2;
    private String txt_3;
    private String txt_4;
    private String txt_5;
    private String txt_6;

    @Id
    public int getPat_id() {
        return pat_id;
    }

    public void setPat_id(int pat_id) {
        this.pat_id = pat_id;
    }

    public String getInfo_date() {
        return info_date;
    }

    public void setInfo_date(String info_date) {
        this.info_date = info_date;
    }

    public String getInfo_user() {
        return info_user;
    }

    public void setInfo_user(String info_user) {
        this.info_user = info_user;
    }

    public String getTxt_1() {
        return txt_1;
    }

    public void setTxt_1(String txt_1) {
        this.txt_1 = txt_1;
    }

    public String getTxt_2() {
        return txt_2;
    }

    public void setTxt_2(String txt_2) {
        this.txt_2 = txt_2;
    }

    public String getTxt_3() {
        return txt_3;
    }

    public void setTxt_3(String txt_3) {
        this.txt_3 = txt_3;
    }

    public String getTxt_4() {
        return txt_4;
    }

    public void setTxt_4(String txt_4) {
        this.txt_4 = txt_4;
    }

    public String getTxt_5() {
        return txt_5;
    }

    public void setTxt_5(String txt_5) {
        this.txt_5 = txt_5;
    }

    public String getTxt_6() {
        return txt_6;
    }

    public void setTxt_6(String txt_6) {
        this.txt_6 = txt_6;
    }
}
