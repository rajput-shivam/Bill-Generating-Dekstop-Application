
package shivampractical;
import java.sql.*;

// Normal statement is simply used for executing queries.
// Prepared statment is also used for executing queries but in a better way.
// Callable statmenet are used for calling procedures and functions in dbms.

public class DatabaseClass 
{
        
        int insertRows(String n, String un, String pwd) throws ClassNotFoundException, SQLException
        {
          
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sybsc","root","");
                PreparedStatement stmt= con.prepareStatement("insert into studentlog values(?,?,?)");
                stmt.setString(1,n);
                stmt.setString(2,un);
                stmt.setString(3,pwd);
                int num=stmt.executeUpdate();
                stmt.close();
                con.close();
                
                return num;
      
        }
    
        boolean checkUsername(String username) throws ClassNotFoundException, SQLException 
        {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sybsc","root","");
                Statement stmt= con.createStatement();
                ResultSet rs=stmt.executeQuery("select * from studentlog; ");
                
                boolean bool=false;
                while( rs.next() )
                {
                        String un = rs.getString("username");
                        if ( un.equals(username))
                            bool=true;
                }
                stmt.close();
                con.close();
                return bool;
                
        }
        
        boolean checkDatabase2(String username, String pass) throws ClassNotFoundException, SQLException 
        {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sybsc","root","");
                Statement stmt= con.createStatement();
                ResultSet rs=stmt.executeQuery("select * from studentlog; ");
                
                boolean bool=false;
                while( rs.next() )
                {
                        String un = rs.getString("username");
                        String pwd = rs.getString("password");
                        if ( un.equals(username) && pwd.equals(pass) )
                            bool=true;
                }
                stmt.close();
                con.close();
                return bool;
                
        }
        

        
        
}
