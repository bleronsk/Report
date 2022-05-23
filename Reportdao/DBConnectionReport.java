package sep.gruppea.Report.Reportdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionReport {
    private static final String HOST = "127.0.0.1";
    private static final int PORT = 3306;
    private static final String DB_NAME = "report_db";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "";
    static Connection connection ;
    public static Connection getConnection()  {

        try {
            connection = DriverManager.getConnection(String.format("jdbc:mysql://%s:%d/%s", HOST, PORT, DB_NAME),USER_NAME,PASSWORD );
        } catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
        return connection;
    }
}
