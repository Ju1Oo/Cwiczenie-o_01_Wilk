
public class Wentylator {

    private int moc; // Moc wentylatora: 0%, 50%, 100%
    private int prevMoc; // Poprzednia moc wentylatora
    private boolean wlaczony;

    public Wentylator() {
        this.moc = 0;
        this.prevMoc = 0; // Początkowo poprzednia moc to 0
        this.wlaczony = false;
    }

    public void wlacz(int moc) {
        if (moc != 0 && moc != 50 && moc != 100) {
            throw new IllegalArgumentException("Nieprawidłowa moc wentylatora. Dozwolone wartości to 0, 50, 100.");
        }

        if (this.moc != moc) { // Sprawdzamy, czy moc rzeczywiście się zmienia
            this.prevMoc = this.moc; // Zapisujemy poprzednią moc
            this.moc = moc; // Ustawiamy nową moc
            this.wlaczony = true;
            System.out.println("Wentylator uruchomiony z mocą: " + moc + "%");
        }
    }

    public void wylacz() {
        this.moc = 0;
        this.prevMoc = 0; // Przy wyłączaniu wentylatora również resetujemy poprzednią moc
        this.wlaczony = false;
        System.out.println("Wentylator został wyłączony.");
    }

    public int pobierzMoc() {
        return this.moc;
    }

    public int pobierzPrevMoc() {
        return this.prevMoc;
    }

    public boolean czyWlaczony() {
        return this.wlaczony;
    }
}
