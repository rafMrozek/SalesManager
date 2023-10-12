package org.rmproject;

import java.sql.*;
import java.util.Scanner;

public class MonthlySales {
    private static double costs;
    public static void addCosts(Scanner scanner) {
        System.out.println("Podaj swoje koszty: ");
        costs = Double.parseDouble(scanner.nextLine());
    }
    public static void sumValues() {
        try {
            Connection connection = DatabaseManager.getConnection();

            String updateQuery = "UPDATE orders SET priceFromOffers = (SELECT purchasePrice FROM offers WHERE offers.name = orders.name)";
            PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);

            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Liczba zmienionych wierszy: " + rowsAffected);

            String sumQuery = "SELECT SUM(priceFromOffers * quantity) AS sumPurchasePrice, SUM(price * quantity) as sumSellingPrice FROM orders";
            ResultSet resultSet = preparedStatement.executeQuery(sumQuery);

            if (resultSet.next()) {
                double sumPurchasePrice = resultSet.getDouble("sumPurchasePrice");
                double sumSellingPrice = resultSet.getDouble("sumSellingPrice");

                double profit = (sumSellingPrice - sumPurchasePrice);
                double finalProfit = (profit - costs);

                System.out.println("Miesięczne zestawienie sprzedaży: ");
                System.out.println("Suma (ceny zakupu): " + sumPurchasePrice);
                System.out.println("Suma (cena sprzedaży): " + sumSellingPrice);
                System.out.println("Koszty dodatkowe: " + costs);
                System.out.println("Zysk końcowy: " + finalProfit + "PLN");
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



