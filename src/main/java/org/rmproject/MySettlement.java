package org.rmproject;

import java.util.Scanner;

public class MySettlement {
    public static void myCosts(Scanner scanner){

        System.out.println("Podaj swoje przychody w PLN: ");
        double myProfitPl = Double.parseDouble(scanner.nextLine());
        System.out.println("Podaj swoje przychody w CZK: ");
        double myProfitCzk = Double.parseDouble(scanner.nextLine());
        System.out.println("Podaj kurs PLN/CZK: ");
        double conversionFactor = Double.parseDouble(scanner.nextLine());
        System.out.println("Podaj swoje koszty w PLN: ");
        double myCostsPl = Double.parseDouble(scanner.nextLine());
        System.out.println("Podaj swoje koszty w CZK: ");
        double myCostsCzk = Double.parseDouble(scanner.nextLine());


        double myValue = (myProfitPl + (myProfitCzk * conversionFactor)) - (myCostsPl + (myCostsCzk * conversionFactor));
        System.out.println("Twoje rozliczenie: " + myValue + " PLN");
    }

}
