
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean  
@SessionScoped
public class Login implements Serializable {


    private String password;
    private String userType;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String validateUsernamePassword() throws SQLException, ClassNotFoundException {
        boolean valid = Logn.validate(userType, password);
        if (valid) {
              DBConnection dbcon = new DBConnection();
            Connection con = dbcon.connMethod();
            PreparedStatement ps = con.prepareStatement("select USERTYPE from DATATABLE where USERNAME=?");
            ps.setString(1, userType);       
            ResultSet rs = ps.executeQuery();
            rs.next();
            String userType =rs.getString(1);
            if ("Admin".equals(userType)) {
                return "admin";
            } else if("Employee".equals(userType)){
                return "employees";
            }else{
                return "customers";
            }
        } else {
             return "log";
               }
          }
}
