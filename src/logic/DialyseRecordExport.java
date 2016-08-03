package logic;

import model.mysql.Mac_setup;

import java.util.Date;
import java.util.List;

/**
 *
 * Created by 31344 on 2016/8/2.
 */
public class DialyseRecordExport {

    /**
     * 导出数据
     * @param from
     * @param to
     * @return
     */
    public boolean export(Date from, Date to){
        return true;
    }

    /**
     * 保存数据
     * @param data
     * @return
     */
    private boolean saveData(List<Mac_setup> data) {

        return true;
    }

    /**
     * 读取数据
     * @param from
     * @param to
     * @return
     */
    private List<Mac_setup> readData(Date from, Date to){
        return null;
    }
}
