package model.access;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by 31344 on 2016/8/2.
 */
@Entity
public class Bed {

    private int BedID;
    private String BedCode;
    private String CreateTime;

    @Id
    public int getBedID() {
        return BedID;
    }

    public void setBedID(int bedID) {
        BedID = bedID;
    }

    public String getBedCode() {
        return BedCode;
    }

    public void setBedCode(String bedCode) {
        BedCode = bedCode;
    }

    public String getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(String createTime) {
        CreateTime = createTime;
    }
}
