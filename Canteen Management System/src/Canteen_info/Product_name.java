package Canteen_info;

import Account_Info.DB_Connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Product_name {
    public  static  String Pro_name() throws SQLException {

        String query="Select P_name from  product where p_no="+Booking_items.P_id;
        Connection con= DB_Connection.getconnection();
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery(query);
        rs.next();
        String P_name=rs.getString(1);
        return P_name;
    }
}
