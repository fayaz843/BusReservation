package BusReservationUsingJDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BusDAO {
    public void displayBusInfo() throws SQLException {
        String query="select * from bus";
        Connection con=JdbcConnection.getConnection();
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery(query);
        while(rs.next()){
            System.out.println("BusNo: "+rs.getInt(1));
            if(rs.getInt(2)==1)
             System.out.println("AC: Yes");
            else
              System.out.println("AC: No");
            System.out.println("Capacity: "+rs.getInt(3));
            System.out.println("_____________________________________");
        }
    }
    public int getBusCapacity(int busNo) throws SQLException {
        String query="select capacity from bus where id="+busNo;
        Connection con=JdbcConnection.getConnection();
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery(query);
        rs.next();
        return rs.getInt(1);
    }
}
