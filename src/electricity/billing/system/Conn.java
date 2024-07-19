package electricity.billing.system;

import java.sql.Connection;
import java.sql.*;

public class Conn {
    Connection c;
    Statement s;
    Conn(){
        try {
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebs", "root", "mysqlpassword");
            s = c.createStatement();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
