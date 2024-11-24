

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Pobranie danych od użytkownika
        System.out.print("Podaj liczbę wentylatorów: ");
        int liczbaWentylatorow = scanner.nextInt();

        System.out.print("Podaj temperaturę otoczenia (-20 do 50): ");
        double temperaturaOtoczenia = scanner.nextDouble();

        System.out.print("Podaj czas pracy urządzenia (8, 16, 24 godziny): ");
        int czasPracy = scanner.nextInt();

        System.out.print("Podaj początkową temperaturę urządzenia: ");
        double temperaturaUrzadzenia = scanner.nextDouble();

        // Tworzenie obiektu urządzenia
        Urzadzenie urzadzenie = new Urzadzenie(temperaturaUrzadzenia, temperaturaOtoczenia, liczbaWentylatorow);
        urzadzenie.ustawCzasPracy(czasPracy);

        // Symulacja
        urzadzenie.wlaczUrzadzenie();
        urzadzenie.symulujPrace();
    }
}
