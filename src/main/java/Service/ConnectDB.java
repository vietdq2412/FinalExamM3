package Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
        final String DB_URL = "jdbc:mysql://localhost:3306/finalexam?serverTimezone=UTC";
        final String jdbc_USERNAME = "root";
        final String jdbc_PASSWORD = "root";

        private static ConnectDB instance;

        private ConnectDB() {
        }

        public static ConnectDB getInstance() {
            if (instance == null) {
                instance = new ConnectDB();
                return instance;
            }
            return instance;
        }

        public Connection getConnection() {
            Connection connection = null;
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(DB_URL, jdbc_USERNAME, jdbc_PASSWORD);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            return connection;
        }
    }

