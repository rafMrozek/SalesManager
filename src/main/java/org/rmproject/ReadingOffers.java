package org.rmproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class ReadingOffers {
    public static void displayOffers() {
        try {

            Connection connection = DatabaseManager.getConnection();

            String selectQuery = "SELECT * FROM offers";
            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                double purchasePrice = resultSet.getDouble("purchasePrice");

                System.out.println("Nazwa: " + name + " | Cena zakupu: " + purchasePrice);
            }

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
