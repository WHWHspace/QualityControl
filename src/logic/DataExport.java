package logic;

import java.util.Date;

/**
 * Created by 31344 on 2016/8/2.
 */
public class DataExport {

    BedExport bedExport;

    public DataExport(){
        bedExport = new BedExport();
    }

    /**
     * 导出数据
     * @param from
     * @param to
     */
    public void exportData(Date from,Date to){
        bedExport.export(from,to);
    }
}
