package Account_Info;



import java.sql.*;

public class MiniStatement {
    public static void miniStatement(int a) throws SQLException {
        String query="select * from History where S_roll="+a;
        Connection con=DB_Connection.getconnection();
     Statement st=con.createStatement();
        ResultSet rs=st.executeQuery(query);
        System.out.println("\n--------------------------History---------------------------\n");
       while(rs.next()) {
           if(rs.getInt(3)<1){
               System.out.println(rs.getTimestamp(2)+"| Debit amount : "+rs.getInt(4)+"| Balance : "+rs.getInt(5));
           }
           else{
               System.out.println(rs.getTimestamp(2)+"| Credit amount : "+rs.getInt(3)+"| Balance : "+rs.getInt(5));

           }
       }
    }
}
