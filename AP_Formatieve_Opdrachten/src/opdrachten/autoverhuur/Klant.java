package opdrachten.autoverhuur;

public class Klant {
    String naam;
    double kortingsPercentage = 0;

    public Klant(String naam) {
        this.naam = naam;
    }

    public void setKorting(double kortingsPercentage) {
        this.kortingsPercentage = kortingsPercentage;
    }

    public double getKortingsPercentage() {
        return kortingsPercentage;
    }

    @Override
    public String toString() {
        return "op naam van: " + naam + " (korting: " + kortingsPercentage + "%)\n";
    }
}
