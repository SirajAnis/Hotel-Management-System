
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


@ManagedBean
@RequestScoped
public class Registration {
    
private String fname;

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

    public List<String> getGenderList() {
        return genderList;
    }

    public void setGenderList(List<String> genderList) {
        this.genderList = genderList;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<String> getUserTypeList() {
        return userTypeList;
    }

    public void setUserTypeList(List<String> userTypeList) {
        this.userTypeList = userTypeList;
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
private String lname;
private String phone;
private String email;
private List<String> genderList;
private String gender;
private List<String> userTypeList;
private String userType;
private String userName;
private String password;

    public Registration() {
        genderList = new ArrayList<>();
        userTypeList = new ArrayList<>();
        genderList.add("Male");
        genderList.add("Female");
        userTypeList.add("Admin");
        userTypeList.add("Customer");
        userTypeList.add("Employee");
        
    }
        public void data() {
        try {
            
            Registration reg = new Registration();
            DBConnection dbcon = new DBConnection();
            Connection con = dbcon.connMethod();
           // String sql = "Insert into DATATABLE(FIRSTNAME,LASTNAME,PHONE,EMAIL,GENDER,USERTYPE,USERNAME,PASSWORD,CPASSWORD) values(?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement("Insert into DATATABLE(FIRSTNAME,LASTNAME,PHONE,EMAIL,GENDER,USERTYPE,USERNAME,PASSWORD) values(?,?,?,?,?,?,?,?)");
            ps.setString(1, fname);
            ps.setString(2, lname);
            ps.setString(3, phone);
            ps.setString(4, email);
            ps.setString(5, gender);
            ps.setString(6, userType);
            ps.setString(7, userName);
            ps.setString(8, password);
            ps.executeUpdate();
            String sql1 = "Insert into LOGINDATA(USERNAME,PASSWORD,USERTYPE) values(?,?,?)";
            PreparedStatement ps1 = con.prepareStatement(sql1);
            ps1.setString(1,userName);
            ps1.setString(2, password);
            ps1.setString(3, userType);
            ps1.executeUpdate();
            System.err.println("success");
        } catch (Exception e) {
        }
    }
}
