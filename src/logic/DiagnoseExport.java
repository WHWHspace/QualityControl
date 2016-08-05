package logic;

import model.mysql.Zinfo_f_05;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.AccessDBHelper;
import util.Constants;
import util.MysqlDBHelper;
import util.PatientIDMap;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;

/**
 *
 * Created by 31344 on 2016/8/2.
 */
public class DiagnoseExport {

    /**
     * 导出数据
     * @param from
     * @param to
     * @return
     */
    public boolean export(Date from, Date to){
        List<Zinfo_f_05> data = readData(from,to);
        if(data == null){
            return false;
        }
        return saveData(data);
    }

    /**
     * 保存数据
     * @param data
     * @return
     */
    private boolean saveData(List<Zinfo_f_05> data) {
        Connection connection = AccessDBHelper.getConnection();
        try {
            Statement s = connection.createStatement();
            connection.setAutoCommit(false);
            for (int i = 0; i < data.size(); i++){
                Zinfo_f_05 info = data.get(i);
                String sql = "INSERT INTO Diagnose VALUES (" +
                        "'" + (i + Constants.OFFSET) + "'," +           //id
                        "'" + getPatientID(info.getPat_id()) + "'," +   //patient_id
                        "'" + "主要诊断" + "'," +                       //sort type
                        "'" + info.getTxt_1() + "'," +                  //define name
                        "'" + info.getTxt_3() + "'," +                  //property
                        "'" + info.getInfo_date() + "'," +              //diagnose time
                        "'" + info.getTxt_6() + "'," +                  //doctor
                        "'" + "0" + "'," +                              //cur mark
                        "'" + info.getInfo_date() + "'" +               //create time
                        ")";
                s.executeUpdate(sql);
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

    private int getPatientID(int pat_id) {
        if(PatientIDMap.getMappedID(pat_id) == -1){
            return pat_id + Constants.OFFSET;
        }
        return PatientIDMap.getMappedID(pat_id);
    }

    /**
     * 读取数据
     * @param from
     * @param to
     * @return
     */
    private List<Zinfo_f_05> readData(Date from, Date to){
        final Session session = MysqlDBHelper.getSession();

        Transaction transaction = session.beginTransaction();
        String hql = "from Zinfo_f_05";
        Query query = session.createQuery(hql);
        List<Zinfo_f_05> results = query.list();

        transaction.commit();
        session.close();

        return results;
    }
}
