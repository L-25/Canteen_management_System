package Canteen_info;

import Account_Info.DB_Connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Availability {
    public static int availability(int a) throws SQLException {
        String query="Select Avail from  product where p_no="+a;
        Connection con= DB_Connection.getconnection();
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery(query);
        rs.next();
        int avail=rs.getInt(1);
        return avail;
    }


}
