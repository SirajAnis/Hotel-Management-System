import java.sql.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class Update {

private String fname;

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void Update() throws ClassNotFoundException, SQLException {
             Registration reg = new Registration();
            DBConnection dbcon = new DBConnection();
            Connection con = dbcon.connMethod();
}
}
