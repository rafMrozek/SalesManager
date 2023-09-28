package org.rmproject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
public class ImporterCSV {
    public static void importOrders() {
        String jdbcUrl="jdbc:mysql://localhost:3306/rmp";
        String username="root";
        String password="";

        String filePath="C:\\Users\\Rafał\\Desktop\\Java\\Importer CSVtoDB\\Przykładowy CSV z Allegro\\allFile.csv";

        int batchSize=20;

        Connection connection=null;
        try {
            connection= DriverManager.getConnection(jdbcUrl,username,password);
            connection.setAutoCommit(false);

            String sql="insert into orders(id,name,quantity,price,currency) values (?,?,?,?,?)";

            PreparedStatement statement=connection.prepareStatement(sql);

            BufferedReader lineReader = new BufferedReader(new FileReader(filePath));

            String lineText=null;
            int count=0;

            lineReader.readLine();
            while ((lineText=lineReader.readLine())!=null) {
                String[] data=lineText.split(",");

                String id = data[0];
                String name = data[1];
                String quantity = data[2];
                String price = data[3];
                String currency = data[4];

                statement.setInt(1, parseInt(id));
                statement.setString(2,name);
                statement.setInt(3, parseInt(quantity));
                statement.setDouble(4, parseDouble(price));
                statement.setString(5, currency);
                statement.addBatch();
                if(count%batchSize==0){
                    statement.executeBatch();
                }
            }
            lineReader.close();
            statement.executeBatch();
            connection.commit();
            connection.close();
            System.out.println("Wprowadzanie danych zakończono sukcesem.");

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

