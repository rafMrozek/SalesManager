package org.rmproject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UpdateData {
    public static void updateOffers() {
        try {

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/rmp", "root", "");

            String updateQuery = "UPDATE offers SET purchasePrice=? WHERE name=?";


            Scanner scanner = new Scanner(System.in);
            System.out.println("Podaj nową cenę zakupu: ");

            int purchasePrice = Integer.parseInt(scanner.nextLine());

            System.out.println("Podaj nazwę produktu do zmiany ceny: ");

            String name = scanner.nextLine();

            PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, purchasePrice);
            preparedStatement.executeUpdate();

            System.out.println("Zaktualizowano cenę zakupu");
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}