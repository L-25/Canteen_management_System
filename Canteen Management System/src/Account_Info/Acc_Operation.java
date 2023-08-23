package Account_Info;

import java.sql.SQLException;


public  class Acc_Operation extends Acc_Abstract{


    @Override
    public int viewBalance(int a) throws SQLException {
        return ViewBalance.viewbalace(a);

    }

    @Override
    public int creditAmount(int a,int credit) throws SQLException {
        return Deposit.DepositAmount(a,credit);
    }

    @Override
    public int DebitAmount(int a,int debit) throws SQLException{
        return Widthdraw.WidthAmt(a,debit);
    }

    @Override
    public void MiniStmt(int a) throws SQLException {
        MiniStatement.miniStatement(a);
    }
}

