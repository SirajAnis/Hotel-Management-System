
import java.sql.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class Delete {

 private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public void Deletee(){
    try{
    DBConnection db=new DBConnection();
    Connection con=db.connMethod();
    PreparedStatement ps=con.prepareStatement("Delete from DATATABLE where USERNAME=?");
    ps.setString(1,userName);
    ps.executeUpdate();
    }
    catch(Exception e){
      System.out.print(e);
    }
    }  
}