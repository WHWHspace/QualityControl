package model.mysql;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by 31344 on 2016/8/11.
 */
@Entity
public class Drug_list {

    private int drg_id;
    private String drg_grp;
    private String drg_name;
    private String drg_code;

    @Id
    public int getDrg_id() {
        return drg_id;
    }

    public void setDrg_id(int drg_id) {
        this.drg_id = drg_id;
    }

    public String getDrg_grp() {
        return drg_grp;
    }

    public void setDrg_grp(String drg_grp) {
        this.drg_grp = drg_grp;
    }

    public String getDrg_name() {
        return drg_name;
    }

    public void setDrg_name(String drg_name) {
        this.drg_name = drg_name;
    }

    public String getDrg_code() {
        return drg_code;
    }

    public void setDrg_code(String drg_code) {
        this.drg_code = drg_code;
    }
}
