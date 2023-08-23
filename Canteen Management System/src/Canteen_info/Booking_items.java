package Canteen_info;


import java.sql.SQLException;

import java.util.Date;
import java.util.Scanner;

public class Booking_items {
    public static int P_id;
    public static int P_quan;
    public static int P_amt;

    public Booking_items() throws SQLException {
        Scanner sc = new Scanner(System.in);

        System.out.print("\nEnter the product No : ");
         P_id = sc.nextInt();
        System.out.print("Enter the Quantity of product : ");
        P_quan= sc.nextInt();
        P_amt=(P_quan*Price.price(P_id));
        System.out.println("Total Cost of Product : "+P_amt);
    }
    public boolean isAvailable(Date date) throws SQLException {
        int AvailCount=Availability.availability(P_id);
        java.sql.Date sqldate =new java.sql.Date(date.getTime());
        int booked=Booked.getCount(P_id,sqldate);
        return AvailCount>booked;
    }

}
