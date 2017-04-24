package sample.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by RENT on 2017-04-24.
 */
public class Connect {

    public static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";          // sciezka do drivera jdbc
    public static final String DB_URL = "jdbc:mysql://localhost/ksiegarnia?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";  // sciezka do bazy danych

    public static final String USER = "root";    // uzytkownik bazy
    public static final String PASSWORD = "";    // haslo do bazy

    private static Connection connection;  // zewnetrzne klasy
    private static Connect instance;

    public void Connect() {
    }

    public static Connect getInstance()  {
        if (instance == null) {
            instance = new Connect();
        }
        return instance;
    }

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);         //rejestracja sterownika
        instance.connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        return connection;
    }

}
