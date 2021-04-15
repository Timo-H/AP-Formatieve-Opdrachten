package opdrachten.autoverhuur_en_gameswinkel;

public class Klant {
    String naam;
    double kortingsPercentage;

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
        return "Klant{" +
                "naam='" + naam + '\'' +
                ", kortingsPercentage=" + kortingsPercentage +
                '}';
    }
}
