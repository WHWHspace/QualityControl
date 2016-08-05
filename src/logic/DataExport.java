package logic;

import ui.MainWindow;

import java.util.Date;

/**
 * Created by 31344 on 2016/8/2.
 */
public class DataExport {

	BedExport bedExport;
	PatientExport patientExport;
	OutComeExport outComeExport;
	MainWindow window;

	public DataExport(MainWindow window) {
		bedExport = new BedExport();
		outComeExport = new OutComeExport();
		patientExport = new PatientExport();
	
		this.window = window;
	}

	/**
	 * 导出数据
	 * 
	 * @param from
	 * @param to
	 */
	public void exportData(Date from, Date to) {
		window.showMessage("开始导出...");

		// 床位
		window.showMessage("导出床位信息中...");
		if (bedExport.export(from, to)) {
			window.showMessage("床位信息导出成功。");
		} else {
			window.showMessage("床位信息导出错误。");
		}

		// 病人
		window.showMessage("导出病人信息中...");
		if (patientExport.export(from, to)) {
			window.showMessage("病人信息导出成功。");
		} else {
			window.showMessage("病人信息导出错误。");
		}

		window.showMessage("导出转归信息中...");
		if (outComeExport.export(from, to)) {
			window.showMessage("转归信息导出成功。");
		} else {
			window.showMessage("转归信息导出错误。");
		}
		// ......

		window.showMessage("导出结束。");
	}
}
