
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean  
@SessionScoped
public class Login implements Serializable {

   // private static final long serialVersionUID = 1094801825228386363L;

    private String password;
    private String message;
    private String userType;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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
            PreparedStatement ps = con.prepareStatement("select USERTYPE from LOGINDATA where USERNAME=?");
            ps.setString(1, userType);       
            ResultSet rs = ps.executeQuery();
            rs.next();
            String userType =rs.getString(1);
            if ("Admin".equals(userType)) {
                return "admin";
            } else if("Employee".equals(userType)){
                return "employee";
            }else{
                return "customer";
            }
        } else {
            Alert alt=new Alert(AlertType.WARNING);
            alt.setContentText("Incorrect username or password. Please enter the correct one!");
             return "LoginPage";
                      }
          }
}
