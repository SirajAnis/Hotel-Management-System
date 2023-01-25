import java.sql.*;
public class Logn {

    public static boolean validate(String userName, String password) {
        boolean status = false;
        try {
            DBConnection dbcon = new DBConnection();
            Connection con = dbcon.connMethod();
            PreparedStatement ps = con.prepareStatement("select * from LOGINDATA where USERNAME=? and PASSWORD=?");
            ps.setString(1, userName);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            status = rs.next();

        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }
}
