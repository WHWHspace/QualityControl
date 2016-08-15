package logic;

import ui.MainWindow;

import java.util.Date;

/**
 * Created by 31344 on 2016/8/2.
 */
public class DataExport {

	BedExport bedExport;
	PatientExport patientExport;
	DiagnoseExport diagnoseExport;
	OutComeExport outComeExport;
	DialyseRouteExport dialyseRouteExport;
    MedicineTreatmentExport medicineTreatmentExport;
	MainWindow window;

	public DataExport(MainWindow window) {
		bedExport = new BedExport();
		patientExport = new PatientExport();
		diagnoseExport = new DiagnoseExport();
		outComeExport = new OutComeExport();
		dialyseRouteExport = new DialyseRouteExport();
        medicineTreatmentExport = new MedicineTreatmentExport();
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

		// 诊断
		window.showMessage("导出诊断信息中...");
		if (diagnoseExport.export(from, to)) {
			window.showMessage("病人诊断导出成功。");
		} else {
			window.showMessage("病人诊断导出错误。");
		}

        //转归
        window.showMessage("导出转归信息中...");
        if (outComeExport.export(from, to)) {
            window.showMessage("转归信息导出成功。");
        } else {
            window.showMessage("转归信息导出错误。");
        }

        //用药
        window.showMessage("导出用药信息中...");
        if (medicineTreatmentExport.export(from, to)) {
            window.showMessage("用药信息导出成功。");
        } else {
            window.showMessage("用药信息导出错误。");
        }

        // 血管通路
        window.showMessage("导出血管通路信息中...");
        if (dialyseRouteExport.export(from, to)) {
            window.showMessage("血管通路信息导出成功。");
        } else {
            window.showMessage("血管通路信息导出错误。");
        }

        //......


        window.showMessage("导出结束。");

        window.exportButton.setEnabled(true);
        window.exportButton.setText("导出");
    }
}
