/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Airline;

import java.sql.*;

/**
 *
 * @author hetro
 */
public class retriveData {
    
    public static void main(String str[])
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
                      
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/airline","root","");
            Statement s=con.createStatement();
            
            ResultSet rs=s.executeQuery("select * from createaccount");
            
        
            
            
            while(rs.next())
            {
                System.out.println(rs.getString(3)+" "+rs.getString(4));
            }
            con.close();
            
            
        
        }catch(Exception e)
        {
            
        }
    }
    
}
