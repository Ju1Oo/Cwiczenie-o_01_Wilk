package pl.edu.zse.JW_29_OA_1;

import java.util.Scanner;
import java.util.Random;

public class Symulacje {

    public void symulacja()
    {
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

    public void symulacjaA1()
    {

        int liczbaWentylatorow = 1;


        double temperaturaOtoczenia = 25;


        int czasPracy = 8;


        double temperaturaUrzadzenia = 70;

        // Tworzenie obiektu urządzenia
        Urzadzenie urzadzenie = new Urzadzenie(temperaturaUrzadzenia, temperaturaOtoczenia, liczbaWentylatorow);
        urzadzenie.ustawCzasPracy(czasPracy);

        // Symulacja
        urzadzenie.wlaczUrzadzenie();
        urzadzenie.symulujPrace();
    }

    public void symulacjaA2()
    {

        int liczbaWentylatorow = 2;


        double temperaturaOtoczenia = 25;


        int czasPracy = 8;


        double temperaturaUrzadzenia = 70;

        // Tworzenie obiektu urządzenia
        Urzadzenie urzadzenie = new Urzadzenie(temperaturaUrzadzenia, temperaturaOtoczenia, liczbaWentylatorow);
        urzadzenie.ustawCzasPracy(czasPracy);

        // Symulacja
        urzadzenie.wlaczUrzadzenie();
        urzadzenie.symulujPrace();
    }

    public void symulacjaB_Random()
    {
        Random rand = new Random();

        int liczbaWentylatorow = 1;


        double temperaturaOtoczenia = rand.nextInt(56) - 10;


        int czasPracy = (rand.nextInt(3)+1) * 8;


        double temperaturaUrzadzenia = rand.nextInt(81) + 10;

        // Tworzenie obiektu urządzenia
        Urzadzenie urzadzenie = new Urzadzenie(temperaturaUrzadzenia, temperaturaOtoczenia, liczbaWentylatorow);
        urzadzenie.ustawCzasPracy(czasPracy);

        // Symulacja
        urzadzenie.wlaczUrzadzenie();
        urzadzenie.symulujPrace();
    }

}
