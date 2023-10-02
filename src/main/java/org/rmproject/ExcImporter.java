package org.rmproject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import static java.lang.Integer.parseInt;

public class ExcImporter {
    public static void importOffers() {
        String jdbcUrl = "jdbc:mysql://localhost:3306/rmp";
        String username = "root";
        String password = "";

        String filePath = "C:\\Users\\Rafał\\Desktop\\Java\\Importer CSVtoDB\\Lista ofert z cenami zakupu\\cenyz.csv";

        int batchSize = 20;

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(jdbcUrl, username, password);
            connection.setAutoCommit(false);

            String sql = "insert into offers(name,purchasePrice) values (?,?)";

            PreparedStatement statement = connection.prepareStatement(sql);

            BufferedReader lineReader = new BufferedReader(new FileReader(filePath));

            String lineText = null;
            int count = 0;

            lineReader.readLine();
            while ((lineText = lineReader.readLine()) != null) {
                String[] data = lineText.split(";");


                String name = data[0];
                String purchasePrice = data[1];


                statement.setString(1, name);
                statement.setInt(2, parseInt(purchasePrice));
                statement.addBatch();
                if (count % batchSize == 0) {
                    statement.executeBatch();
                }
            }
            lineReader.close();
            statement.executeBatch();
            connection.commit();
            connection.close();
            System.out.println("Wprowadzanie danych zakończono sukcesem.");

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
