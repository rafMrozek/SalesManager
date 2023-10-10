package org.rmproject;

import java.sql.*;
import java.util.Scanner;

public class MonthlySales {
    public static void addCosts(Scanner scanner) {
        System.out.println("Podaj swoje koszty: ");
        double costs = Double.parseDouble(scanner.nextLine());
    }
    public static void sumValues() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/rmp", "root", "");

            String updateQuery = "UPDATE orders SET priceFromOffers = (SELECT purchasePrice FROM offers WHERE offers.name = orders.name)";
            PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);

            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Liczba zmienionych wierszy: " + rowsAffected);

            String sumQuery = "SELECT SUM(priceFromOffers) as sumPurchasePrice, SUM(price) as sumSellingPrice FROM orders";
            ResultSet resultSet = preparedStatement.executeQuery(sumQuery);

            if (resultSet.next()) {
                double sumPurchasePrice = resultSet.getDouble("sumPurchasePrice");
                double sumSellingPrice = resultSet.getDouble("sumSellingPrice");
                System.out.println("Suma cen zakupu: " + sumPurchasePrice);
                System.out.println("Suma cen sprzedaży: " + sumSellingPrice);
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



