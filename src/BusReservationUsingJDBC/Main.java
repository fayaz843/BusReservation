package BusReservationUsingJDBC;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException, SQLException {
        BusDAO busDAO=new BusDAO();
        busDAO.displayBusInfo();

        int userOption=1;
        while(userOption==1){
            System.out.println("Enter 1 to Book and 2 to Exit");
            Scanner sc=new Scanner(System.in);
            userOption=sc.nextInt();
            if(userOption==1){
                Booking booking=new Booking();
                if(booking.isAvailable()){
                    BookingDAO bookingDAO=new BookingDAO();
                    bookingDAO.addBooking(booking);
                    System.out.println("Booking Confirmed");
                }
                else{
                    System.out.println("Bus is full try with other bus or date");
                }
            }
        }

    }
}