package logic;

import model.mysql.Mac_setup;
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
public class OutComeExport {

	/**
	 * 导出数据
	 * 
	 * @param from
	 * @param to
	 * @return
	 */
	public boolean export(Date from, Date to) {
		List<Pat_info> data = readData(from, to);
		if (data == null) {
			return false;
		}
		return saveData(data);
	}

	/**
	 * 保存数据
	 * 
	 * @param data
	 * @return
	 */
	private boolean saveData(List<Pat_info> data) {
		Connection connection = AccessDBHelper.getConnection();
		try {
			Statement s = connection.createStatement();
			connection.setAutoCommit(false);
			int temp = 0;
			for (int i = 0; i < data.size(); i++) {
				Pat_info p = data.get(i);
				temp++;
				if (PatientIDMap.getMappedID(p.getPif_id()) == -1) {
					String sql = "insert into OutCome values('"
							+ (temp + Constants.OFFSET) + "','"
							+ (p.getPif_id() + Constants.OFFSET) + "','" + "转入"
							+ "','" + "转入" + "','" + p.getPif_createdate()
							+ "','" + p.getPif_createdate() + "')";
					s.executeUpdate(sql);
				} else {
					String sql = "insert into OutCome values('"
							+ (temp + Constants.OFFSET) + "','" + p.getPif_id()
							+ "','" + "转入" + "','" + "转入" + "','"
							+ p.getPif_createdate() + "','"
							+ p.getPif_createdate() + "')";
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
	 * 读取数据
	 * 
	 * @param from
	 * @param to
	 * @return
	 */
	private List<Pat_info> readData(Date from, Date to) {
		final Session session = MysqlDBHelper.getSession();

		Transaction transaction = session.beginTransaction();
		String hql = "from Pat_info";
		Query query = session.createQuery(hql);
		List<Pat_info> results = query.list();

		transaction.commit();
		session.close();

		return results;
	}
}
