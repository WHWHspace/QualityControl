package logic;

import model.mysql.Pat_info;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * Created by 31344 on 2016/8/2.
 */
public class PatientExport {

    /**
     * 导出数据
     * @param from
     * @param to
     * @return
     */
    public boolean export(Date from, Date to){
        List<Pat_info> data = readData(from, to);
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
    private boolean saveData(List<Pat_info> data) {
        Connection connection = AccessDBHelper.getConnection();
        try {
            Statement s = connection.createStatement();
            connection.setAutoCommit(false);
            for (int i = 0; i < data.size(); i++){
                Pat_info p = data.get(i);
                //未找到与原系统对应的病人，保存信息
                if(PatientIDMap.getMappedID(p.getPif_id()) == -1){
                    String sql = "INSERT INTO Patient VALUES(" +
                            "'" + (p.getPif_id()+ Constants.OFFSET) + "',"+      //id
                            "'" + "',"+                     //casecode
                            "'" + p.getPif_name()+ "',"+      //name
                            "'" + getSex(p.getPif_sex()) + "',"+      //sex
                            "'" + getAge(p.getPif_dob()) + "',"+      //age
                            "'" + p.getPif_ic()+ "',"+      //ic
                            "'" + getSource(p.getPif_pattyp())+ "',"+      //source
                            "'" + p.getPif_createdate()+ "',"+      //firsttime
                            "'" + p.getPif_insid()+ "',"+      //dialysecode
                            "'" + "浙江省"+ "',"+      //province
                            "'" + "杭州市"+ "',"+      //city
                            "'" + "',"+      //workplace
                            "'" + "',"+      //occupation
                            "'" + getPaymentWay(p.getPif_insurance())+ "',"+      //payment
                            "'" + p.getPif_dob()+ "',"+      //birthday
                            "'" + "',"+      //bloodtype
                            "'" + p.getPif_address()+ "',"+      //address
                            "'" +"',"+      //postcode
                            "'" + "',"+      //telephone
                            "'" + "',"+      //mobilephone
                            "'" + "转入"+ "',"+      //status
                            "'" + "转入"+ "',"+      //changemode
                            "'" + "',"+      //
                            "'" + "',"+      //
                            "'" + p.getPif_insid()+ "',"+      //insure
                            "'" + "0"+ "',"+      //delete
                            "'" + "0"+ "',"+      //dead
                            "'" + "0"+ "',"+      //changemark
                            "'" + p.getPif_createdate()+ "',"+      //createtime
                            "'" + p.getPif_createdate()+ "',"+      //incometime
                            "'" + p.getPif_contactperson()+ "',"+      //contactperson
                            "'" + p.getPif_contact()+ "',"+      //contact telephone
                            "'" + p.getPif_contact()+ "',"+      //contact mobile phone
                            "'" +  "',"+      //inpatient code
                            "'" +  "'"+      //height
                            ")";
                    s.executeUpdate(sql);
                }
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

    private String getPaymentWay(String pif_insurance) {
        if("00001".equals(pif_insurance)){
            return "医保";
        }
        return "自费";
    }

    private String getSource(String pif_pattyp) {
        if("H".equals(pif_pattyp)){
            return "住院";
        }
        if("W".equals(pif_pattyp)){
            return "门诊";
        }
        return "";
    }

    private String getAge(String pif_dob) {
        try {
            Date dob = new SimpleDateFormat("YYYY/MM/dd").parse(pif_dob);
            int age = new Date().getYear() - dob.getYear();
            return Integer.toString(age);
        } catch (ParseException e) {
            e.printStackTrace();
            return "";
        }
    }

    private String getSex(String pif_sex) {
        if("M".equals(pif_sex)){
            return "男";
        }
        if("F".equals(pif_sex)){
            return "女";
        }
        return "";
    }

    /**
     * 读取数据
     * @param from
     * @param to
     * @return
     */
    private List<Pat_info> readData(Date from, Date to){
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
