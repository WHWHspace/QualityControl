package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
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
        return null;
    }
}
