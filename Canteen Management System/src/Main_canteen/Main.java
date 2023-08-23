package Main_canteen;

import Account_Info.*;
import Canteen_info.*;

import java.sql.SQLException;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        UserVerification uv = new UserVerification();
        Acc_Operation op = new Acc_Operation();
         Date date;
        if (uv.Verification()) {
            while (true) {
                System.out.print("\n1.Account Information\n2.Purcahse Information\n3.Exit\n");
                System.out.print("\nEnter your choise : ");
                String dateInput= String.valueOf(java.time.LocalDate.now());
                SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-mm-dd");
                try {
                    date=dateFormat.parse(dateInput);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }

                int userOpt = sc.nextInt();
                if (userOpt == 1) {

                    while (userOpt == 1) {
                        System.out.println("\n1.View Available Balance\n2.Deposit Amount\n3.Widthraw Amount\n4.View Ministatement\n5.Go to Main menu\n");
                        System.out.print("Enter your choise :");
                        int choise = sc.nextInt();

                        if (choise == 1) {
                            int a = op.viewBalance(uv.accNo);
                            System.out.println("\nBalance amount :" + a + ".0 Rs");
                        } else if (choise == 2) {
                            System.out.print("Enter Amount to Deposit : ");
                            int deposit = sc.nextInt();
                            System.out.println(deposit + ".0 Rs Successfully Depositted !!!\n ");
                            op.creditAmount(uv.accNo, deposit);
                            System.out.println("Available Balance : " + ViewBalance.viewbalace(uv.accNo)+".0 Rs");

                        } else if (choise == 3) {
                            System.out.print("Enter Amount to Widthraw : ");
                            int Widthdraw = sc.nextInt();

                            if (Widthdraw <= ViewBalance.viewbalace(uv.accNo)) {
                                System.out.println(Widthdraw + ".0 Rs Successfully Widthdraw !!!\n");
                                op.DebitAmount(uv.accNo, Widthdraw);
                                System.out.println("Available Balance : " + ViewBalance.viewbalace(uv.accNo)+".0 Rs");

                            } else {
                                System.out.println("\nInsufficient Balance");

                            }
                        } else if (choise == 4) {
                            op.MiniStmt(uv.accNo);

                        } else if (choise == 5) {
                            userOpt = 2;
                        } else {
                            System.out.println("\nPlease enter the choise 1-5");
                        }
                    }
                } else if (userOpt == 2) {
                    while (userOpt == 2) {

                        System.out.println("\n1.Purchase Items\n2.Puchase History\n3.Go to Main menu");
                        System.out.print("\nEnter your choise : ");
                        int enter = sc.nextInt();
                        System.out.println("");
                        System.out.print("");
                        if (enter == 1) {
                            java.sql.Date sqldate =new java.sql.Date(date.getTime());
                            Dispaly_items.DisplayItems(sqldate);
                            Booking_items b = new Booking_items();

                            if( b.isAvailable(date) && Availability.availability(Booking_items.P_id)>=Booking_items.P_quan && Booking_items.P_quan>0){
                                if(ViewBalance.viewbalace(UserVerification.accNo)>=Booking_items.P_amt){
                                    Update_Balance.up_balance(UserVerification.accNo,Booking_items.P_amt);
                                    Booked.addBooking(date);
                                    System.out.println("\nPurchased successfully");
                                }
                                else{
                                    System.out.println("\nInsufficient Balance.Your Cart Value is Greater than Balance");
                                }

                            }
                            else{
                                System.out.println("\nCheck the Availability then add to cart or Don't Enter the Product quantity is '0'");
                            }
                        }
                        else if(enter==2){
                            History.Purchase_history(UserVerification.accNo);


                        }else {
                            userOpt = 0;
                        }
                    }
                } else if (userOpt == 3) {
                    System.exit(0);
                } else {
                    System.out.println("Please enter the choise 1-3");
                }
            }
        } else {
            System.out.println("\nIncorrect pin or AccNo. Please Enter the correct Pin or AccNo");
        }
    }
}


