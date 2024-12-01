package pl.edu.zse.JW_29_OA_1;

import java.util.ArrayList;
import java.util.List;

public class Urzadzenie {
    private double temperaturaUrzadzenia;
    private double temperaturaOtoczenia;
    private boolean wlaczone;
    private int czasPracy;
    private List<Wentylator> wentylatory;
    private Czujnik czujnikUrzadzenia;
    private Czujnik czujnikOtoczenia;
    private boolean symulacja = true;

    //gettery i settery


    public Urzadzenie(double temperaturaUrzadzenia, double temperaturaOtoczenia, int liczbaWentylatorow) {

        if(temperaturaOtoczenia < -20 || temperaturaOtoczenia > 50)
        {
            System.out.println("podano nieprawidlowa temperature otoczenia zmiana wartosci na 10");
            temperaturaOtoczenia = 10;
        }

        this.wlaczone = false;
        this.wentylatory = new ArrayList<>();
        this.czujnikUrzadzenia = new Czujnik("Urzadzenie", temperaturaUrzadzenia);
        this.czujnikOtoczenia = new Czujnik("Otoczenie", temperaturaOtoczenia);
        this.temperaturaOtoczenia = czujnikOtoczenia.pobierzTemperature();
        this.temperaturaUrzadzenia = czujnikUrzadzenia.pobierzTemperature();

        // Dodanie co najmniej jednego wentylatora
        if (liczbaWentylatorow < 1) {
            liczbaWentylatorow = 1;
            System.out.println("podano nieprawidlowa liczbe wentylatorow, zmiana wartoci na 1");
        }
        for (int i = 0; i < liczbaWentylatorow; i++) {
            this.wentylatory.add(new Wentylator());
        }
    }

    public void wlaczUrzadzenie() {
        if (this.temperaturaUrzadzenia < 0) {
            System.out.println("Za niska temperatura urządzenia grozi awarią. System został wyłączony.");
            this.wlaczone = false;
            return;
        }
        this.wlaczone = true;
        System.out.println("Urządzenie zostało włączone.");
    }
    //potrzebne settery
    public void wylaczUrzadzenie() {
        this.wlaczone = false;
        System.out.println("Urządzenie zostało wyłączone.");
    }

    public void ustawCzasPracy(int godziny) {
        if (godziny != 8 && godziny != 16 && godziny != 24 )
        {
            System.out.println("podano nieprawidlowy czas pracy zmiana na 8 godzin");
            godziny = 8;
        }
        this.czasPracy = godziny * 60; // Przekształcenie godzin na minuty
    }

    public void aktualizujTemperature() {
        if (wlaczone) {
            // Nagrzewanie
            double przyrost = 5.0;

            Wentylator wentylator = wentylatory.getFirst();
            if (wentylator.czyWlaczony()) {
                przyrost -= (wentylator.pobierzMoc() / 100.0) * 2.0;
            }

            temperaturaUrzadzenia += przyrost;
        } else {
            // Chłodzenie
            for (Wentylator wentylator : wentylatory) {
                if (wentylator.pobierzMoc() == 100) {
                    temperaturaUrzadzenia -= 1 + 1/Math.abs(temperaturaOtoczenia);
                }
                else if (wentylator.pobierzMoc() == 50) {
                    temperaturaUrzadzenia -= 0.5 + 1/Math.abs(temperaturaOtoczenia);
                }
            }
        }

        // Aktualizacja temperatury w czujniku
        czujnikUrzadzenia.ustawTemperature(temperaturaUrzadzenia);
    }

    public void sprawdzStan() {
        if (temperaturaUrzadzenia < 0) {
            // Punkt 4: Urządzenie zostaje wyłączone, gdy temperatura < 0
            wylaczUrzadzenie();
            this.symulacja=false;

        } else if (temperaturaUrzadzenia > 130) {
            // Punkt 6: Urządzenie wyłącza się powyżej 130°C, wentylatory na 100%
            wylaczUrzadzenie();
            //wlaczWszystkieWentylatory(100);
            System.out.println("Temperatura przekroczyła 130°C. Urządzenie zostało wyłączone, wentylatory na pełnej mocy.");
        } else if (temperaturaUrzadzenia > 100) {
            // Punkt 5: Ostrzeżenie o wysokiej temperaturze powyżej 100°C
            System.out.println("Ostrzeżenie: Wysoka temperatura urządzenia.");
        }

        /* Punkty 1, 2, 3: Zarządzanie mocą wentylatorów w zależności od temperatury
        if (temperaturaUrzadzenia <= 50) {
            wlaczWszystkieWentylatory(0); // Wentylatory wyłączone
        } else if (temperaturaUrzadzenia <= 75) {
            wlaczWszystkieWentylatory(50); // Wentylatory na połowie mocy
        } else if (temperaturaUrzadzenia <= 130) {
            wlaczWszystkieWentylatory(100); // Wentylatory na pełnej mocy
        }*/
    }

    //chyba nie potrzebne poniewaz wentylatory maja sie uruchamiac sekwencyjnie ale wole zostawic
    public void wlaczWszystkieWentylatory(int moc) {
        for (Wentylator wentylator : wentylatory) {
            wentylator.wlacz(moc);
        }
    }
    //nowa metoda zamiast tej powyzej
    public void wlaczWentylator(int moc, int nrWentylatora) {
        Wentylator wentylator = wentylatory.get(nrWentylatora);
        if(wentylator.pobierzMoc() != moc)
        {
            System.out.println("Wentylator " + (nrWentylatora + 1) + " uruchomiony z mocą: " + moc + "%");
        }
        wentylator.wlacz(moc);
    }

    public void symulujPrace() {
        for (int i = 0; i < czasPracy; i++) {
            aktualizujTemperature();
            sprawdzStan();

            if (!symulacja) {
                System.out.println("Za niska temperatura urządzenia grozi awarią. System został wyłączony.");
                break;
            }

            // Sekwencyjne włączanie wentylatorów co minutę
            if (wlaczone) {
                int nrWentylatora = i % wentylatory.size(); // Wybór wentylatora na podstawie minuty
                int mocWentylatora = (temperaturaUrzadzenia <= 50) ? 0 :
                        (temperaturaUrzadzenia <= 75) ? 50 : 100;

                wlaczWentylator(mocWentylatora, nrWentylatora);

            }

            temperaturaUrzadzenia = (double) Math.round(temperaturaUrzadzenia * 10) / 10;
            System.out.println("Minuta: " + (i + 1) + ", Temperatura urządzenia: " + temperaturaUrzadzenia + "°C");

            // Wyłącz automatycznie poniżej 55°C
            if (!wlaczone && temperaturaUrzadzenia < 55) {
                wlaczUrzadzenie();
            }

            try {
                Thread.sleep(300); // Symulacja 1 minuty w czasie rzeczywistym
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}