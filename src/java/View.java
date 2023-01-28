
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean(name="information")
@SessionScoped
public class View {
 
        public List <Retrive> arrayList;    
        public List <Retrive> getdatalist(){
        arrayList = new ArrayList<>();
        try {
            DBConnection dbcon = new DBConnection();
            Connection con = dbcon.connMethod();
            ResultSet rs = con.createStatement().executeQuery("select * from DATATABLE");
            while (rs.next()){
                
                String fname=rs.getString("FIRSTNAME");
                String Lname=rs.getString("LASTNAME");
                String phone=rs.getString("PHONE");
                String email=rs.getString("EMAIL");
                String gender=rs.getString("GENDER");
                String userType=rs.getString("USERTYPE");
                String userName=rs.getString("USERNAME");
                String password=rs.getString("PASSWORD");
                
               arrayList.add(new Retrive(fname,Lname,phone,email,gender,userType,userName,password));
            }
        } catch (ClassNotFoundException | SQLException e) {
        }
        return arrayList;
    }
}