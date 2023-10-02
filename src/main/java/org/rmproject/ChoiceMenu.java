package org.rmproject;

import java.util.Scanner;
public class ChoiceMenu {
    public void start() {
        Scanner scanner = new Scanner(System.in);
        ImporterCSV importerCSV = new ImporterCSV();
        ExcImporter excImporter = new ExcImporter();
        ReadingData displayOrders = new ReadingData();

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
                case 1 -> ImporterCSV.importOrders(); //("Wybrano: 1. Wczytaj CSV z zamówieniami");
                // Tutaj umieścić kod dla opcji 1
                case 2 -> ExcImporter.importOffers(); //"Wybrano: 2. Wczytaj plik z cenami zakupu");
                // Tutaj umieścić kod dla opcji 2
                case 3 -> ReadingData.displayOrders(); //("Wybrano: 3. Podgląd zamówień");
                // Tutaj umieścić kod dla opcji 3
                case 4 -> System.out.println("Wybrano: 4. Podgląd ofert");
                //Tutaj umieścić kod dla opcji 4
                case 5 -> System.out.println("Wybrano: 5. Zmień cenę dla danego produktu");
                //Tutaj umieścić kod dla opcji 5
                case 6 -> System.out.println("Wybrano: 6. Zestawienie miesięczne sprzedaży");
                //Tutaj umieścić kod dla opcji 6
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

