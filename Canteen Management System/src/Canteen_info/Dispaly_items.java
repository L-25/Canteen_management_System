package Canteen_info;

import  Account_Info.*;

import java.sql.Connection;
import java.sql.*;
import java.sql.SQLException;
import java.sql.Statement;

public class Dispaly_items {
    public static void DisplayItems(java.sql.Date sqldate) throws SQLException {
        String query="Select * from  product";
        Connection con=DB_Connection.getconnection();
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery(query);

        while(rs.next()){
                System.out.println(
                        "Product No : " + rs.getInt(1) + "| Product Name : " + rs.getString(2)
                                + "| Avalability : " + ((rs.getInt(3)) - (Booked.getCount(rs.getInt(1), sqldate))) + "| Price : " + rs.getInt(4));


        }

    }
}
