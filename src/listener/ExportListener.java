package listener;

import logic.DataExport;
import ui.MainWindow;
import util.Constants;
import util.FileHelper;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 导出按钮事件监听，读取选择的时间，导出上传文件
 * Created by 31344 on 2016/8/2.
 */
public class ExportListener implements ActionListener{

    public MainWindow window;
    DataExport export;

    public ExportListener(MainWindow window){
        this.window = window;
        export = new DataExport(window);
    }

    /**
     * 读取开始和结束时间，导出上传文件
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        window.clearMessage();
        String from = window.startYearBox.getSelectedItem() + "-" + window.startMonthBox.getSelectedItem() + "-" + window.startDayBox.getSelectedItem();
        String to = window.stopYearBox.getSelectedItem() + "-" + window.stopMonthBox.getSelectedItem() + "-" + window.stopDayBox.getSelectedItem();
        try {
            Date fromDate = new SimpleDateFormat("yyyy-MM-dd").parse(from);
            Date toDate = new SimpleDateFormat("yyyy-MM-dd").parse(to);
            if(fromDate.after(toDate)){
                window.showMessage("开始时间必须小于结束时间！");
                return;
            }
            //复制上传文件
            FileHelper.CopyFile(Constants.SOURCE, Constants.DESTINATION);

            export.exportData(fromDate,toDate);
        } catch (ParseException e1) {
            e1.printStackTrace();
        }
    }
}
