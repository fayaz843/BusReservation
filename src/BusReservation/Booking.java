package BusReservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Booking {

    String passangerName;
    int busNo;
    Date date;
    
    public Booking() throws ParseException {
        System.out.println("Enter your Name");
        Scanner sc=new Scanner(System.in);
        passangerName=sc.next();
        System.out.println("Enter busNo");
        busNo=sc.nextInt();
        System.out.println("Enter date in dd-MM-yyyy");
        String bookDate=sc.next();
        SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy");
        date=dateFormat.parse(bookDate);
    }

    public boolean isAvailable(ArrayList<Bus> buses, ArrayList<Booking> bookings){
        int capacity=0;
        for(Bus bus:buses){
            if(bus.getBusNo()==busNo){
                capacity=bus.getCapacity();
            }
        }
        int booked=0;
        for(Booking booking:bookings){
            if(booking.busNo==busNo && booking.date.equals(date)){
                booked++;
            }
        }
        return booked < capacity;
    }
}
