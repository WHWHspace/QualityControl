package logic;

import model.mysql.Drug_list;
import model.mysql.Longterm_Ordermgt;
import model.mysql.Pat_info;
import model.mysql.Shortterm_Ordermgt;
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
 * 导出用药记录
 * Created by 31344 on 2016/8/2.
 */
public class MedicineTreatmentExport {

    /**
     * 导出数据
     * @param from
     * @param to
     * @return
     */
    public boolean export(Date from, Date to){
        List<Longterm_Ordermgt> longterm_ordermgts = readLongtermOrderData(from, to);
        List<Shortterm_Ordermgt> shortterm_ordermgts = readShorttermOrderData(from,to);

        if(saveLongtermOrderData(longterm_ordermgts) && saveShorttermOrderData(shortterm_ordermgts)){
            return true;
        }
        return false;
    }

    /**
     * 保存长期医嘱数据
     * @param data
     * @return
     */
    private boolean saveLongtermOrderData(List<Longterm_Ordermgt> data) {
        Connection connection = AccessDBHelper.getConnection();
        try {
            Statement s = connection.createStatement();
            connection.setAutoCommit(false);
            for (int i = 0; i < data.size(); i++){
                Longterm_Ordermgt info = data.get(i);
                Drug_list drug = getDrug(info.getLgord_drug());
                if(drug == null){
                    continue;
                }
                String sql = "INSERT INTO MedicineTreatment VALUES (" +
                        "'" + (info.getLgord_id() + Constants.OFFSET) + "'," +           //medicine treatment id
                        "'" + getPatientID(info.getLgord_patic()) + "'," +   //patient_id
                        "'" + info.getLgord_dateord() + "'," +                       //medicine date
                        "'" + drug.getDrg_grp() + "'," +                  //classification
                        "'" + drug.getDrg_name() + "'," +                  //name
                        "'" + info.getLgord_medway() + "'," +              //method
                        "'" + info.getLgord_intake() + "'," +                  //amount
                        "'" + info.getLgord_medway() + "'," +                              //medicine way
                        "'" + "长期" + "'," +               //type
                        "'" + info.getLgord_dtactst() + "'," +                              //stop date
                        "'" + "" + "'," +                              //stop reason
                        "'" + info.getLgord_dateord() + "'," +                              //create time
                        "'" + getStatus(info.getLgord_actst()) + "'" +                              //stopmark
                        ")";
                s.executeUpdate(sql);
            }
            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    private String getStatus(String lgord_actst) {
        if("00002".equals(lgord_actst)){
            return "0";
        }
        return "1";
    }

    private Drug_list getDrug(String lgord_drug) {
        final Session session = MysqlDBHelper.getSession();

        Transaction transaction = session.beginTransaction();
        String hql = "from Drug_list where drg_code = '" + lgord_drug +"'";
        Query query = session.createQuery(hql);
        List<Drug_list> results = query.list();

        transaction.commit();
        session.close();

        if(results.size() > 0){
            return results.get(0);
        }
        return null;
    }

    private int getPatientID(String lgord_patic) {
        final Session session = MysqlDBHelper.getSession();

        Transaction transaction = session.beginTransaction();
        String hql = "from Pat_info where pif_ic = '" + lgord_patic + "'";
        Query query = session.createQuery(hql);
        List<Pat_info> results = query.list();

        transaction.commit();
        session.close();

        if(results.size() > 0){
            int id = results.get(0).getPif_id();
            if(PatientIDMap.getMappedID(id) == -1){
                return id + Constants.OFFSET;
            }
            else {
                return PatientIDMap.getMappedID(id);
            }
        }
        return 0;
    }

    /**
     * 保存短期医嘱数据
     * @param data
     * @return
     */
    private boolean saveShorttermOrderData(List<Shortterm_Ordermgt> data) {
        Connection connection = AccessDBHelper.getConnection();
        try {
            Statement s = connection.createStatement();
            connection.setAutoCommit(false);
            for (int i = 0; i < data.size(); i++){
                Shortterm_Ordermgt info = data.get(i);
                Drug_list drug = getDrug(info.getShord_drug());
                if(drug == null){
                    continue;
                }
                String sql = "INSERT INTO MedicineTreatment VALUES (" +
                        "'" + (info.getShord_id() + 2 * Constants.OFFSET) + "'," +           //medicine treatment id
                        "'" + getPatientID(info.getShord_patic()) + "'," +   //patient_id
                        "'" + info.getShord_dateord() + "'," +                       //medicine date
                        "'" + drug.getDrg_grp() + "'," +                  //classification
                        "'" + drug.getDrg_name() + "'," +                  //name
                        "'" + info.getShord_medway() + "'," +              //method
                        "'" + info.getShord_intake() + "'," +                  //amount
                        "'" + info.getShord_medway() + "'," +                              //medicine way
                        "'" + "短期" + "'," +               //type
                        "'" + info.getShord_dtactst() + "'," +                              //stop date
                        "'" + "" + "'," +                              //stop reason
                        "'" + info.getShord_dateord() + "'," +                              //create time
                        "'" + getStatus(info.getShord_actst()) + "'" +                              //stopmark
                        ")";
                s.executeUpdate(sql);
            }
            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    /**
     * 读取长期医嘱数据
     * @param from
     * @param to
     * @return
     */
    private List<Longterm_Ordermgt> readLongtermOrderData(Date from, Date to){
        final Session session = MysqlDBHelper.getSession();

        Transaction transaction = session.beginTransaction();
        String hql = "from Longterm_Ordermgt";
        Query query = session.createQuery(hql);
        List<Longterm_Ordermgt> results = query.list();

        transaction.commit();
        session.close();

        return results;
    }

    /**
     * 读取短期医嘱数据
     * @param from
     * @param to
     * @return
     */
    private List<Shortterm_Ordermgt> readShorttermOrderData(Date from, Date to){
        final Session session = MysqlDBHelper.getSession();

        Transaction transaction = session.beginTransaction();
        String hql = "from Shortterm_Ordermgt";
        Query query = session.createQuery(hql);
        List<Shortterm_Ordermgt> results = query.list();

        transaction.commit();
        session.close();

        return results;
    }
}
