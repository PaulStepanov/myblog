package database;

import com.mysql.fabric.jdbc.FabricMySQLConnection;
import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by Павел on 02-Sep-16.
 */
public class SQLConnect {
    private static SQLConnect sqlConnect=new SQLConnect();
    private Connection connection;

    private SQLConnect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection=DriverManager.getConnection(
                    SETTINGS.getProp("url"),
                    SETTINGS.getProp("user"),
                    SETTINGS.getProp("password")
            );
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return sqlConnect.connection;
    }
}
