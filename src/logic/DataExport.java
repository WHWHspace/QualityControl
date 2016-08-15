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
    CRRTTouxifanganExport crrtTouxifanganExport;
    DeathRecordExport deathRecordExport;
    DializerExport dializerExport;
    DializerClassExport dializerClassExport;
    DialyseMachineExport dialyseMachineExport;
    DialyseRecordExport dialyseRecordExport;
    DialyseSchemeSubExport dialyseSchemeSubExport;
    WaterDetectExport waterDetectExport;
    WaterDisposeDetectExport waterDisposeDetectExport;
    WaterQualityExport waterQualityExport;
	MainWindow window;

	public DataExport(MainWindow window) {
		bedExport = new BedExport();
		patientExport = new PatientExport();
		diagnoseExport = new DiagnoseExport();
		outComeExport = new OutComeExport();
		dialyseRouteExport = new DialyseRouteExport();
        medicineTreatmentExport = new MedicineTreatmentExport();
        crrtTouxifanganExport = new CRRTTouxifanganExport();
        deathRecordExport = new DeathRecordExport();
        dializerExport = new DializerExport();
        dializerClassExport = new DializerClassExport();
        dialyseMachineExport = new DialyseMachineExport();
        dialyseRecordExport = new DialyseRecordExport();
        dialyseSchemeSubExport = new DialyseSchemeSubExport();
        waterDetectExport = new WaterDetectExport();
        waterDisposeDetectExport = new WaterDisposeDetectExport();
        waterQualityExport = new WaterQualityExport();
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


        //化验元素

        //CRRT记录
        window.showMessage("导出CRRT记录信息中...");
        if (crrtTouxifanganExport.export(from, to)) {
            window.showMessage("CRRT记录信息导出成功。");
        } else {
            window.showMessage("CRRT记录信息导出错误。");
        }

        // 死亡记录
        window.showMessage("导出死亡记录信息中...");
        if (deathRecordExport.export(from, to)) {
            window.showMessage("死亡记录信息导出成功。");
        } else {
            window.showMessage("死亡记录信息导出错误。");
        }

        // 诊断
        window.showMessage("导出诊断信息中...");
        if (diagnoseExport.export(from, to)) {
            window.showMessage("病人诊断导出成功。");
        } else {
            window.showMessage("病人诊断导出错误。");
        }

        // 透析器
        window.showMessage("导出透析器信息中...");
        if (dializerExport.export(from, to)) {
            window.showMessage("透析器诊断信息导出成功。");
        } else {
            window.showMessage("透析器诊断信息导出错误。");
        }

        // 透析器类型
        window.showMessage("导出透析器类型信息中...");
        if (dializerClassExport.export(from, to)) {
            window.showMessage("透析器类型诊断信息导出成功。");
        } else {
            window.showMessage("透析器类型诊断信息导出错误。");
        }

        // 透析液
        window.showMessage("导出透析液信息中...");
        if (dializerClassExport.export(from, to)) {
            window.showMessage("透析液信息导出成功。");
        } else {
            window.showMessage("透析液信息导出错误。");
        }

        // 透析机
        window.showMessage("导出透析机信息中...");
        if (dialyseMachineExport.export(from, to)) {
            window.showMessage("透析机信息导出成功。");
        } else {
            window.showMessage("透析机信息导出错误。");
        }

        // 透析记录
        window.showMessage("导出透析记录信息中...");
        if (dialyseRecordExport.export(from, to)) {
            window.showMessage("透析记录信息导出成功。");
        } else {
            window.showMessage("透析记录信息导出错误。");
        }

        // 血管通路
        window.showMessage("导出血管通路信息中...");
        if (dialyseRouteExport.export(from, to)) {
            window.showMessage("血管通路信息导出成功。");
        } else {
            window.showMessage("血管通路信息导出错误。");
        }

        //透析主方案


        // 透析子方案
        window.showMessage("导出透析子方案信息中...");
        if (dialyseSchemeSubExport.export(from, to)) {
            window.showMessage("透析子方案信息导出成功。");
        } else {
            window.showMessage("透析子方案信息导出错误。");
        }

        //用药
        window.showMessage("导出用药信息中...");
        if (medicineTreatmentExport.export(from, to)) {
            window.showMessage("用药信息导出成功。");
        } else {
            window.showMessage("用药信息导出错误。");
        }

        //转归
        window.showMessage("导出转归信息中...");
        if (outComeExport.export(from, to)) {
            window.showMessage("转归信息导出成功。");
        } else {
            window.showMessage("转归信息导出错误。");
        }


        //化验记录

		// 病人
		window.showMessage("导出病人信息中...");
		if (patientExport.export(from, to)) {
			window.showMessage("病人信息导出成功。");
		} else {
			window.showMessage("病人信息导出错误。");
		}


        // 细菌，内毒素
        window.showMessage("导出细菌，内毒素信息中...");
        if (waterDetectExport.export(from, to)) {
            window.showMessage("细菌，内毒素信息导出成功。");
        } else {
            window.showMessage("细菌，内毒素信息导出错误。");
        }

        // 水处理设备
        window.showMessage("水处理设备信息中...");
        if (waterDisposeDetectExport.export(from, to)) {
            window.showMessage("水处理设备信息导出成功。");
        } else {
            window.showMessage("水处理设备信息导出错误。");
        }

        // 水质检测
        window.showMessage("导出水质检测信息中...");
        if (waterQualityExport.export(from, to)) {
            window.showMessage("水质检测信息导出成功。");
        } else {
            window.showMessage("水质检测信息导出错误。");
        }







        //......


        window.showMessage("导出结束。");

        window.exportButton.setEnabled(true);
        window.exportButton.setText("导出");
    }
}
