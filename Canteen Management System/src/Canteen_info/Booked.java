package Canteen_info;

import Account_Info.*;


import java.util.Date;

import java.sql.*;


public class Booked {
    public static int getCount(int P_id, Date date) throws SQLException {
        String query="Select sum(quantity) from booked where P_id=? and Date=?";
        Connection con= DB_Connection.getconnection();
        PreparedStatement prs= con.prepareStatement(query);
        prs.setInt(1,P_id);
        java.sql.Date sqldate =new java.sql.Date(date.getTime());
        prs.setDate(2,sqldate);

        ResultSet rs= prs.executeQuery();
       rs.next();
       return rs.getInt(1);
    }
    public static void addBooking(Date date)throws SQLException{

      String query="insert into booked (p_id,items,quantity,pur_amount,B_amount,Date,s_id)values(?,?,?,?,?,?,?)";
      Connection con=DB_Connection.getconnection();
      PreparedStatement prs= con.prepareStatement(query);
      prs.setInt(1, Booking_items.P_id);
      prs.setString(2,Product_name.Pro_name());
      prs.setInt(3,Booking_items.P_quan);
      prs.setInt(4,Booking_items.P_amt);
      prs.setInt(5,ViewBalance.viewbalace(UserVerification.accNo));
        java.sql.Date sqldate =new java.sql.Date(date.getTime());
        prs.setDate(6, sqldate);
      prs.setInt(7,UserVerification.accNo);
     prs.executeUpdate();
    }
}
