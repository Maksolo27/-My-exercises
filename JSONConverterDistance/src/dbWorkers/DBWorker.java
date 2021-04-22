package dbWorkers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by maxim on 22.04.2021.
 */
public class DBWorker {

    public DBWorker() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loading success!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/unit?serverTimezone=UTC", "root", "root1");
            return connection;
        } catch(SQLException e) {
            e.printStackTrace();
        }

        return null;
    }


}
