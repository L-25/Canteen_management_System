package Account_Info;

import java.sql.*;
import java.util.Scanner;

public class UserVerification {
    public static int accNo;
   public  int pin;
    public UserVerification(){
        Scanner sc=new Scanner(System.in);
        System.out.print("\nEnter the Roll number : ");
        accNo= sc.nextInt();
        System.out.print("Enter the PIN number : ");
        pin= sc.nextInt();
    }
    public boolean Verification() throws SQLException {
        String query="select *  from Acc_info where rollno="+accNo+ " and pass="+pin;
        Connection con=DB_Connection.getconnection();
        Statement st= con.createStatement();
        ResultSet rs= st.executeQuery(query);

        while(rs.next()){
            if(accNo==rs.getInt(1) && pin== rs.getInt(2)){
                return  true;
            }
        }
        return false;
    }
}
