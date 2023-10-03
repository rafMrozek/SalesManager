package org.rmproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ReadingData {
    public static void displayOrders() {
        try {

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/rmp", "root", "");

            String selectQuery = "SELECT * FROM orders";
            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int quantity = resultSet.getInt("quantity");
                double price = resultSet.getDouble("price");
                String currency = resultSet.getString("currency");

                System.out.println("Numer zamówienia: " + id + ", Nazwa: " + name + ", Ilość: " + quantity + ", Cena sprzedaży: " + price + ", Waluta: " + currency);
            }

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
