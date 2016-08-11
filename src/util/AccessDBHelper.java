package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 连接access数据库
 * Created by 31344 on 2016/8/2.
 */
public class AccessDBHelper {

    public static Connection getConnection(){
        try {
            Class.forName("com.hxtt.sql.access.AccessDriver");
            String url = "jdbc:Access:///" + System.getProperty("user.dir") + "/upload/upload.mdb";
            Connection connection = DriverManager.getConnection(url, "", "");
            return connection;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }



//        try {
//            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
////            String dburl = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};" +
////                    "DBQ="+System.getProperty("user.dir") + "\\upload\\upload.mdb";// 此为NO-DSN方式
// String dburl ="jdbc:odbc:upload";//此为ODBC连接方式
//            Connection conn = DriverManager.getConnection(dburl, "", "");
//            return conn;
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        return null;
    }
}
