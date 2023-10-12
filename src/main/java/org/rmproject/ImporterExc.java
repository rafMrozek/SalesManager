package org.rmproject;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ImporterExc {
    public static void importOffers() {
        try {
            FileInputStream excelFile = new FileInputStream(new File("cenyz.xlsx"));
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet sheet = workbook.getSheetAt(0);


            Connection connection = DatabaseManager.getConnection();

            Row headerRow = sheet.getRow(0);

            String insertQuery = "INSERT INTO offers (name, purchasePrice) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);

                preparedStatement.setString(1, row.getCell(0).getStringCellValue());
                preparedStatement.setDouble(2, row.getCell(1).getNumericCellValue());


                preparedStatement.executeUpdate();
            }
            connection.close();
            excelFile.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}