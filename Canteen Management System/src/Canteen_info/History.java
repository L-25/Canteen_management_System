package Canteen_info;

import Account_Info.DB_Connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class History {
    public static  void Purchase_history(int a) throws SQLException {
    String query="select * from booked where S_id="+a;
    Connection con= DB_Connection.getconnection();
    Statement st=con.createStatement();
    ResultSet rs=st.executeQuery(query);
        System.out.println("\n-------------------------------------------Purchase-History--------------------------------------------------\n");
       while(rs.next()) {

            System.out.println(rs.getTimestamp(7)+"| Product Name : "+rs.getString(2)+"| Purchased Quantity : "+rs.getInt(3)+
            "| Purchased Amount : "+rs.getInt(4)+"| Balance : "+rs.getInt(5));
        }
        System.out.println("\n-------------------------------------------------------------------------------------------------------------\n");


    }
}
