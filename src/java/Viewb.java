
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


@ManagedBean(name="viewb")
@RequestScoped
public class Viewb {
public List<Registration> getUserList()
{
List<Registration>list = new ArrayList<>();
PreparedStatement ps = null;
Connection con = null;
ResultSet rs = null;
try
{
Class.forName("oracle.jdbc.driver.OracleDriver");
con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "USER1", "12345");
String sql = "select * from DATATABLE";
ps= con.prepareStatement(sql); 
rs= ps.executeQuery(); 
while (rs.next())
{
Registration usr = new Registration();
usr.setFname(rs.getString("fname"));
usr.setLname(rs.getString("LName"));
usr.setPhone(rs.getString("phone"));
usr.setEmail(rs.getString("email"));
usr.setGender(rs.getString("gender"));
usr.setUserType(rs.getString("userType"));
usr.setUserName(rs.getString("userName"));
usr.setPassword(rs.getString("password"));
list.add(usr);
} 
}
catch(Exception e)
{
e.printStackTrace();
}
finally
{
try
{
con.close();
ps.close();
}
catch(Exception e)
{
e.printStackTrace();
}
}
return list;
}
}