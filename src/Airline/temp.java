package Airline;

import java.sql.*;

/**
 *
 * @author hetro
 */
public class temp {

    static String[] tempSeats = new String[6];
    static String tempLocation = "";
    static String tempDestination = "";
    static String tempFares = "";
    static String tempFlight = "";
    static String tempHoldername = "";
    static String tempAccNo;
    static String tempCVV;
    static String tempMonth;
    static String tempYear;
    static String tempuser = "";
    static String temppassword = "";
    static String tempDate = "";
    static String tempTime = "";
    static String tempFname="";
    static String tempLname="";
    static String tempEmail="";
    static String tempMobile="";
    static String seat=""; 
    static int Flight_no;
    static int indicatorPDF = 0;

    public static void main(String args[]) throws ClassNotFoundException, SQLException {

    }

    static void main() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/airline", "root", "");
            
            PreparedStatement ps = con.prepareStatement("insert into ticket(Mobile,Location,Destination,Fares,Flight,Date,Time,Seat,Flight_No)values(?,?,?,?,?,?,?,?,?)");

            Statement s = con.createStatement();
            
            int i = 0;
           
            while (i < tempSeats.length) {
                if (tempSeats[i] != null) {
                    seat = seat.concat(tempSeats[i]);
                    seat = seat.concat(" ");
                }
                i++;
            }
            
            ps.setString(1, tempMobile);
            ps.setString(2, tempLocation);
            ps.setString(3, tempDestination);
            ps.setString(4, tempFares);
            ps.setString(5, tempFlight);
            ps.setString(6, tempDate);
            ps.setString(7, tempTime);
            ps.setString(8, seat);
            ps.setInt(9,Flight_no);

            ps.executeUpdate();

            ResultSet r = s.executeQuery("select * from accounts where (Mobile='" + tempuser + "' or Email='" + tempuser + "') and password='"+temppassword+"'");

            r.next();
            tempMobile = r.getString(4);
            tempEmail = r.getString(5);
            tempFname = r.getString(2);
            tempLname = r.getString(3);

            
            tempSeats=new String[6];
            

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
