package org.rmproject;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReadingData {
    public static void displayOrders() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/orders", "root","");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM ORDERS");
            while(rs.next()){
                String name = rs.getString("name");
                System.out.println(name);
            }

            System.out.println("Udało się połączyć z bazą danych");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReadingData.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ReadingData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
