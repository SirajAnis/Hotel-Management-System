
import java.sql.*;

public class DBConnection {
    static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";

    static final String USER = "USER1";
    static final String PASS = "12345";
    Connection con = null;

    public Connection connMethod() throws ClassNotFoundException, SQLException {
        Class.forName(DRIVER);
        con = DriverManager.getConnection(URL, USER, PASS);
        return con;
    }
}
