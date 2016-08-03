package logic;

import model.mysql.Mac_setup;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.AccessDBHelper;
import util.MysqlDBHelper;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;

/**
 * 床位信息导出
 * Created by 31344 on 2016/8/2.
 */
public class BedExport {

    public boolean export(Date from, Date to){
        List<Mac_setup> data = readData(from,to);
        if (data == null){
            return false;
        }

        return saveData(data);
    }

    private boolean saveData(List<Mac_setup> data) {
        Connection connection = AccessDBHelper.getConnection();
        try {
            Statement s = connection.createStatement();
            connection.setAutoCommit(false);
            for (int i = 0; i < data.size(); i++){
                Mac_setup m = data.get(i);
                s.executeUpdate("INSERT INTO Bed VALUES ('"+m.getMac_id()+"','"+m.getMac_bedno()+"','2014/11/12 14:10:00')");
            }
            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    private List<Mac_setup> readData(Date from, Date to){
        final Session session = MysqlDBHelper.getSession();

        Transaction transaction = session.beginTransaction();
        String hql = "from Mac_setup";
        Query query = session.createQuery(hql);
        List<Mac_setup> results = query.list();

        transaction.commit();
        session.close();

        return results;
    }
}
