import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class Update {

 String fname;
 String lname;
 String phone;
 String email;
 String gender;

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
 String userType;
 String userName;
 String password;
 List<String> genderList;

    public List<String> getGenderList() {
        return genderList;
    }

    public void setGenderList(List<String> genderList) {
        this.genderList = genderList;
    }

    public List<String> getUserTypeList() {
        return userTypeList;
    }

    public void setUserTypeList(List<String> userTypeList) {
        this.userTypeList = userTypeList;
    }
 List<String> userTypeList;
  
     public Update() {
        genderList = new ArrayList<>();
        userTypeList = new ArrayList<>();
        genderList.add("Male");
        genderList.add("Female");
        userTypeList.add("Admin");
        userTypeList.add("Customer");
        userTypeList.add("Employee");
        
    }
      public void updated(){
    try {
         
         
        DBConnection dbcon = new DBConnection();
        Connection con = dbcon.connMethod();
        String s2= "update DATATABLE set FIRSTNAME='"+fname+"',LASTNAME='"+lname+"',PHONE='"+phone+"',EMAIL='"+email+"',GENDER='"+gender+"',USERTYPE='"+userType+"',PASSWORD='"+password+"' where USERNAME='"+userName+"'";
        Statement ps2=null;
        ps2 = con.createStatement();
        ps2.executeQuery(s2);
            
          
       
            System.err.println("success");
    } catch (ClassNotFoundException | SQLException e) {
        
    }
    
 
} 
 
 

}