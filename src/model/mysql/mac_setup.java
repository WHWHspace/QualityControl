package model.mysql;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by 31344 on 2016/8/2.
 */
@Entity
public class Mac_setup {

    private int mac_id;
    private String mac_bedno;

    @Id
    public int getMac_id() {
        return mac_id;
    }

    public void setMac_id(int mac_id) {
        this.mac_id = mac_id;
    }

    public String getMac_bedno() {
        return mac_bedno;
    }

    public void setMac_bedno(String mac_bedno) {
        this.mac_bedno = mac_bedno;
    }
}
