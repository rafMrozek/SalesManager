package org.rmproject;

import java.sql.*;
import java.util.Scanner;

import static com.sun.org.apache.xpath.internal.XPath.SELECT;

public class MonthlySales {
    public static void addCosts(Scanner scanner) {
        System.out.println("Podaj swoje koszty: ");
        double costs = Double.parseDouble(scanner.nextLine());
    }
    public static void sumValues() {

        String jdbcUrl = "jdbc:mysql://localhost:3306/rmp";  //
        String username = "root";
        String password = "";

        double purchasePrice = Double.parseDouble(("purchasePrice"));
        double price = Double.parseDouble(("price"));

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/rmp", "root", "");

            String query = "UPDATE orders SET priceFromOffers = (SELECT purchasePrice FROM offers WHERE offers.name = orders.name)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Liczba zmienionych wierszy: " + rowsAffected);

            ResultSet resultSet = preparedStatement.executeQuery(query);
            String query1 = "SELECT SUM(" + purchasePrice + ")"; //, SUM(" + price + ") FROM orders");

            ResultSet resultSet1 = preparedStatement.executeQuery(query1);

            if (resultSet1.next()) {
                double sumPurchasePrice = resultSet1.getDouble("purchasePrice");
                double sumSellingPrice = resultSet1.getDouble("price");
            }

            resultSet.close();
            resultSet1.close();
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


