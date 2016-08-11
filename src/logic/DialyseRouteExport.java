package logic;

import model.mysql.Mac_setup;
import model.mysql.Package_setup;
import model.mysql.Pat_info;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import util.AccessDBHelper;
import util.Constants;
import util.MysqlDBHelper;
import util.PatientIDMap;

/**
 * 
 * Created by 31344 on 2016/8/2.
 */
public class DialyseRouteExport {

	/**
	 * 导出数据
	 * 
	 * @param from
	 * @param to
	 * @return
	 */
	public boolean export(Date from, Date to) {
		List<Pat_info> dataPatInfo = readPatInfoData(from, to);
		List<Package_setup> dataPackageSetup = readPackageSetupData(from, to);
		if (dataPatInfo == null || dataPackageSetup == null) {
			return false;
		}
		return saveData(dataPatInfo, dataPackageSetup);
	}

	/**
	 * 保存数据
	 * 
	 * @param data
	 * @return
	 */
	private boolean saveData(List<Pat_info> dataPatInfo,
			List<Package_setup> dataPackageSetup) {
		Connection connection = AccessDBHelper.getConnection();
		try {
			Statement s = connection.createStatement();
			connection.setAutoCommit(false);
			System.out.println(dataPatInfo.size());
			for (int i = 0; i < dataPatInfo.size(); i++) {
				Pat_info p = dataPatInfo.get(i);
				if (PatientIDMap.getMappedID(p.getPif_id()) == -1) {
					String sql = "insert into DialyseRoute values('"
							+ (p.getPif_id() + Constants.OFFSET)
							+ "','"
							+ (p.getPif_id() + Constants.OFFSET)
							+ "','"
							+ p.getPif_createdate()
							+ "','"
							+ p.getPif_createdate()
							+ "','"
							+ getVesselRouteType(p.getPif_hpack(),
									dataPackageSetup) + "','" + "" + "','"
							+ "1" + "','" + "" + "','" + p.getPif_createdate()
							+ "','" + "" + "','" + "" + "')";
					s.executeUpdate(sql);
				} else {
					String sql = "insert into DialyseRoute values('"
							+ (p.getPif_id() + Constants.OFFSET)
							+ "','"
							+ p.getPif_id()
							+ "','"
							+ p.getPif_createdate()
							+ "','"
							+ p.getPif_createdate()
							+ "','"
							+ getVesselRouteType(p.getPif_hpack(),
									dataPackageSetup) + "','" + "" + "','"
							+ "1" + "','" + "" + "','" + p.getPif_createdate()
							+ "','" + "" + "','" + "" + "')";
					s.executeUpdate(sql);
				}
			}
			connection.commit();
			connection.setAutoCommit(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	/**
	 * 读取病人数据
	 * 
	 * @param from
	 * @param to
	 * @return
	 */
	private List<Pat_info> readPatInfoData(Date from, Date to) {
		final Session session = MysqlDBHelper.getSession();

		Transaction transaction = session.beginTransaction();
		String hql = "from Pat_info";
		Query query = session.createQuery(hql);
		List<Pat_info> results = query.list();

		transaction.commit();
		session.close();

		return results;
	}

	/**
	 * 读取血管通路类型数据
	 * 
	 * @param from
	 * @param to
	 * @return
	 */
	private List<Package_setup> readPackageSetupData(Date from, Date to) {
		final Session session = MysqlDBHelper.getSession();

		Transaction transaction = session.beginTransaction();
		String hql = "from Package_setup";
		Query query = session.createQuery(hql);
		List<Package_setup> results = query.list();

		transaction.commit();
		session.close();

		return results;
	}

	private String getVesselRouteType(String pif_hpack,
			List<Package_setup> dataPackageSetup) {
		String vesselRouteType = "";
		for (Package_setup p : dataPackageSetup) {
			if (p.getPck_code().equals(pif_hpack)) {
				vesselRouteType = p.getPck_name();
			}
		}
		return vesselRouteType;
	}
}
