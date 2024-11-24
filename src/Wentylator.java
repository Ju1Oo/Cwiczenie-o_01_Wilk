

public class Wentylator {
    private int moc; // Moc wentylatora: 0%, 50%, 100%
    private boolean wlaczony;

    public Wentylator() {
        this.moc = 0;
        this.wlaczony = false;
    }

    public void wlacz(int moc) {
        if (moc != 0 && moc != 50 && moc != 100) {
            throw new IllegalArgumentException("Nieprawidłowa moc wentylatora. Dozwolone wartości to 0, 50, 100.");
        }
        this.moc = moc;
        this.wlaczony = true;
        System.out.println("Wentylator włączony z mocą: " + moc + "%");
    }

    public void wylacz() {
        this.moc = 0;
        this.wlaczony = false;
        System.out.println("Wentylator został wyłączony.");
    }

    public int pobierzMoc() {
        return this.moc;
    }

    public boolean czyWlaczony() {
        return this.wlaczony;
    }
}
