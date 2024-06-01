package BusReservation;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        ArrayList<Bus> buses=new ArrayList<Bus>();
        ArrayList<Booking> bookings=new ArrayList<Booking>();
        buses.add(new Bus(1,true,1));
        int userOption=1;
        while(userOption==1){
            System.out.println("Enter 1 to Book and 2 to Exit");
            Scanner sc=new Scanner(System.in);
            userOption=sc.nextInt();
            if(userOption==1){
                Booking booking=new Booking();
                if(booking.isAvailable(buses,bookings)){
                    bookings.add(booking);

                    System.out.println("BusReservation.Booking Confirmed");
                }
                else{
                    System.out.println("BusReservation.Bus is full try with other bus or date");
                }
            }
        }

    }
}