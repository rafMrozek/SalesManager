package org.rmproject;

import java.util.Scanner;

import static org.rmproject.ExcImporter.importOffers;
import static org.rmproject.ImporterCSV.importOrders;
import static org.rmproject.MonthlySales.addCosts;
import static org.rmproject.MonthlySales.sumValues;
import static org.rmproject.ReadingOffers.displayOffers;
import static org.rmproject.ReadingOrders.displayOrders;
import static org.rmproject.UpdateData.updateOffers;


public class ChoiceMenu {
    public void start() {
        Scanner scanner = new Scanner(System.in);
        ImporterCSV importerCSV = new ImporterCSV();
        ExcImporter excImporter = new ExcImporter();
        ReadingOrders displayOrders = new ReadingOrders();
        ReadingOffers displayOffers = new ReadingOffers();
        UpdateData updateData = new UpdateData();
        MonthlySales monthlySales = new MonthlySales();

        while (true) {
            System.out.println("Wybierz opcję:");
            System.out.println("1. Wczytaj CSV z zamówieniami");
            System.out.println("2. Wczytaj plik z cenami zakupu");
            System.out.println("3. Podgląd zamówień");
            System.out.println("4. Podgląd ofert");
            System.out.println("5. Zmień cenę dla danego produktu");
            System.out.println("6. Zestawienie miesięczne sprzedaży");
            System.out.println("7. Moje rozliczenie");
            System.out.println("0. Wyjście");
            System.out.println("Wybierz opcję: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> importOrders(); //("Wybrano: 1. Wczytaj CSV z zamówieniami");
                // Tutaj umieścić kod dla opcji 1
                case 2 -> importOffers(); //"Wybrano: 2. Wczytaj plik z cenami zakupu");
                // Tutaj umieścić kod dla opcji 2
                case 3 -> displayOrders(); //("Wybrano: 3. Podgląd zamówień");
                // Tutaj umieścić kod dla opcji 3
                case 4 -> displayOffers(); //("Wybrano: 4. Podgląd ofert");
                //Tutaj umieścić kod dla opcji 4
                case 5 -> updateOffers(); //("Wybrano: 5. Zmień cenę dla danego produktu");
                //Tutaj umieścić kod dla opcji 5
                case 6 -> addCosts(scanner);
                //Wybrano: 6. Zestawienie miesięczne sprzedaży");
                case 7 -> System.out.println("Wybrano: 7. Moje rozliczenie");
                //Tutaj umieścić kod dla opcji 7
                case 0 -> {
                    System.out.println("Wybrano wyjście");
                    scanner.close();
                    System.exit(0);
                }
            }
        }
    }
}

