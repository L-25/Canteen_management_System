package Account_Info;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_Connection {
    private  static  final String url="jdbc:mysql://localhost:3306/canteen_management";
    private  static  final String user="root";
    private  static  final String password="2003";
     public static Connection getconnection() throws SQLException {
         return  DriverManager.getConnection(url,user,password);

     }
}

