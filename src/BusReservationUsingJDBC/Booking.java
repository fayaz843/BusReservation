package BusReservationUsingJDBC;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Booking {

    String passengerName;
    int busNo;
    Date date;
    
    public Booking() throws ParseException {
        System.out.println("Enter your Name");
        Scanner sc=new Scanner(System.in);
        passengerName=sc.next();
        System.out.println("Enter busNo");
        busNo=sc.nextInt();
        System.out.println("Enter date in dd-MM-yyyy");
        String bookDate=sc.next();
        SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy");
        date=dateFormat.parse(bookDate);
    }

    public boolean isAvailable() throws SQLException {
        BusDAO busDAO=new BusDAO();
        BookingDAO bookingDAO=new BookingDAO();
        int capacity=busDAO.getBusCapacity(busNo);
        int booked=bookingDAO.getBookedCount(busNo,date);
        return booked < capacity;
    }
}
