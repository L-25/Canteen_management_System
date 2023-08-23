package Account_Info;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ViewBalance {

    public static int viewbalace(int id) throws SQLException {
        String query = "select Acc_balance from Acc_info where rollno="+id;
        Connection con=DB_Connection.getconnection();
        Statement St=con.createStatement();
        ResultSet rs= St.executeQuery(query);
        rs.next();

        return rs.getInt(1);
    }
}

