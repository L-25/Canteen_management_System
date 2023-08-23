package Account_Info;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Widthdraw {
    public static  int WidthAmt(int a, int debit) throws SQLException {
        String query ="update Acc_info set Acc_balance=? where RollNo=?";
        int balance= ViewBalance.viewbalace(a);
        Connection con=DB_Connection.getconnection();
        PreparedStatement prs= con.prepareStatement(query);
        balance-=debit;
        prs.setDouble(1,  balance);
        prs.setInt(2,a);
        prs.executeUpdate();

        String query1="insert into history(S_roll,debit,t_Balance) values(?,?,?)";
        PreparedStatement prs1= con.prepareStatement(query1);
        prs1.setInt(1,a);
        prs1.setInt(2,debit);
        prs1.setInt(3,balance);

        prs1.executeUpdate();
        return  balance;

    }
}
