package Canteen_info;

import Account_Info.DB_Connection;

import Account_Info.ViewBalance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update_Balance {
    public static  void up_balance(int a,int amt) throws SQLException {
        String query ="update Acc_info set Acc_balance=? where rollno=?";
        int balance= ViewBalance.viewbalace(a);
        Connection con= DB_Connection.getconnection();
        PreparedStatement prs= con.prepareStatement(query);
        balance-=amt;
        prs.setInt(1,  balance);
        prs.setInt(2,a);
        prs.executeUpdate();
    }
}
