package pl.edu.zse.JW_29_OA_1;

public class Czujnik {
    private String typ; //typ czujnika (wewnetrzny/zewnetrzny
    private double temperatura;

    public Czujnik(String typ, double temperaturaPoczatkowa) {
        this.typ = typ;
        this.temperatura = temperaturaPoczatkowa;
    }

    public void ustawTemperature(double temperatura) {
        this.temperatura = temperatura;
    }

    public double pobierzTemperature() {
        return this.temperatura;
    }

    public String pobierzTyp() {
        return this.typ;
    }
}
