package Canteen_info;

import Account_Info.DB_Connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Price {
    public static int price(int a) throws SQLException {
        String query="Select price from  product where p_no="+a;
        Connection con= DB_Connection.getconnection();
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery(query);
        rs.next();
        int pri=rs.getInt(1);
        return pri;
    }
}
