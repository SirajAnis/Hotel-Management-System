

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class Retrive {

 String fname;
 String lname;

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public String getUserType() {
        return userType;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
 String phone;
 String email;
 String gender;
 String userType;
 String userName;
 String password;

   public Retrive(String fname, String lname, String phone, String email, String gender, String userType, String userName, String password) {
   this.fname=fname;
   this.lname=lname;
   this.phone=phone;
   this.email=email;
   this.gender=gender;
   this.userType=userType;
   this.userName=userName;
   this.password=password;

    }

}