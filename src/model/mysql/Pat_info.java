package model.mysql;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by 44 on 6/8/4.
 */
@Entity
public class Pat_info {

    private int pif_id;
    private String pif_pattyp;
    private String pif_name;
    private String pif_ic;
    private String pif_mrn;
    private String pif_dob;
    private String pif_sex;
    private String pif_address;
    private String pif_contactperson;
    private String pif_contact;
    private String pif_insurance;
    private String pif_insid;
    private String pif_imgloc;
    private String pif_createdate;
    private String pif_height;
    private String pif_docname;

    @Id
    public int getPif_id() {
        return pif_id;
    }

    public void setPif_id(int pif_id) {
        this.pif_id = pif_id;
    }

    public String getPif_pattyp() {
        return pif_pattyp==null?"":pif_pattyp;
    }

    public void setPif_pattyp(String pif_pattyp) {
        this.pif_pattyp = pif_pattyp;
    }

    public String getPif_name() {
        return pif_name==null?"":pif_name;
    }

    public void setPif_name(String pif_name) {
        this.pif_name = pif_name;
    }

    public String getPif_ic() {
        return pif_ic==null?"":pif_ic;
    }

    public void setPif_ic(String pif_ic) {
        this.pif_ic = pif_ic;
    }

    public String getPif_mrn() {
        return pif_mrn==null?"":pif_mrn;
    }

    public void setPif_mrn(String pif_mrn) {
        this.pif_mrn = pif_mrn;
    }

    public String getPif_dob() {
        return pif_dob==null?"":pif_dob;
    }

    public void setPif_dob(String pif_dob) {
        this.pif_dob = pif_dob;
    }

    public String getPif_sex() {
        return pif_sex==null?"":pif_sex;
    }

    public void setPif_sex(String pif_sex) {
        this.pif_sex = pif_sex;
    }

    public String getPif_address() {
        return pif_address==null?"":pif_address;
    }

    public void setPif_address(String pif_address) {
        this.pif_address = pif_address;
    }

    public String getPif_contactperson() {
        return pif_contactperson==null?"":pif_contactperson;
    }

    public void setPif_contactperson(String pif_contactperson) {
        this.pif_contactperson = pif_contactperson;
    }

    public String getPif_contact() {
        return pif_contact==null?"":pif_contact;
    }

    public void setPif_contact(String pif_contact) {
        this.pif_contact = pif_contact;
    }

    public String getPif_insurance() {
        return pif_insurance==null?"":pif_insurance;
    }

    public void setPif_insurance(String pif_insurance) {
        this.pif_insurance = pif_insurance;
    }

    public String getPif_insid() {
        return pif_insid==null?"":pif_insid;
    }

    public void setPif_insid(String pif_insid) {
        this.pif_insid = pif_insid;
    }

    public String getPif_imgloc() {
        return pif_imgloc==null?"":pif_imgloc;
    }

    public void setPif_imgloc(String pif_imgloc) {
        this.pif_imgloc = pif_imgloc;
    }

    public String getPif_createdate() {
        return pif_createdate==null?"":pif_createdate;
    }

    public void setPif_createdate(String pif_createdate) {
        this.pif_createdate = pif_createdate;
    }

    public String getPif_height() {
        return pif_height==null?"":pif_height;
    }

    public void setPif_height(String pif_height) {
        this.pif_height = pif_height;
    }

    public String getPif_docname() {
        return pif_docname==null?"":pif_docname;
    }

    public void setPif_docname(String pif_docname) {
        this.pif_docname = pif_docname;
    }
}
