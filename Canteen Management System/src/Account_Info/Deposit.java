package Account_Info;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Deposit {
    public static int DepositAmount(int a, int credit) throws SQLException {

        String query ="update Acc_info set Acc_balance=? where rollno=?";
        int balance= ViewBalance.viewbalace(a);
        Connection con=DB_Connection.getconnection();
        PreparedStatement prs= con.prepareStatement(query);
        balance+=credit;
        prs.setInt(1,  balance);
        prs.setInt(2,a);
        prs.executeUpdate();

        String query1="insert into history(S_roll,credit,t_Balance) values(?,?,?)";
        PreparedStatement prs1= con.prepareStatement(query1);
        prs1.setInt(1,a);
        prs1.setInt(2,credit);
        prs1.setInt(3,balance);

        prs1.executeUpdate();

        return  balance;
    }
}