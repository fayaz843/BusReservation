package BusReservationUsingJDBC;

import java.sql.*;
import java.util.Date;

public class BookingDAO {
    public int getBookedCount(int busNo, Date date) throws SQLException {
        String query="select count(*) from booking where bus_no=? and booking_date=?";
        Connection con=JdbcConnection.getConnection();
        PreparedStatement ps=con.prepareStatement(query);
        java.sql.Date sqlDate= new java.sql.Date(date.getTime());
        ps.setInt(1,busNo);
        ps.setDate(2, sqlDate);
        ResultSet rs=ps.executeQuery();
        rs.next();
        return rs.getInt(1);
    }

    public void addBooking(Booking booking) throws SQLException {
        String query="insert into booking values(?,?,?)";
        Connection con=JdbcConnection.getConnection();
        PreparedStatement ps=con.prepareStatement(query);
        java.sql.Date sqlDate= new java.sql.Date(booking.date.getTime());
        ps.setString(1,booking.passengerName);
        ps.setInt(2, booking.busNo);
        ps.setDate(3, sqlDate);
        int rs=ps.executeUpdate();
    }
}
