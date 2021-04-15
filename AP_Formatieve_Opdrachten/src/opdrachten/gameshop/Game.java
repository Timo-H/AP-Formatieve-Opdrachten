package opdrachten.gameshop;

import java.time.LocalDate;
import java.util.Date;

public class Game {
    String naam;
    int realeaseJaar;
    double prijs;

    public Game(String naam, int realeaseJaar, double prijs) {
        this.naam = naam;
        this.realeaseJaar = realeaseJaar;
        this.prijs = prijs;
    }

    public String getNaam() {
        return naam;
    }

    public int getRealeaseJaar() {
        return realeaseJaar;
    }

    public double getPrijs() {
        return prijs;
    }

    @Override
    public String toString() {
        double nieuwprijs = getPrijs();
        for (int i = 0; i < LocalDate.now().getYear() - getRealeaseJaar(); i++) {
            nieuwprijs = nieuwprijs*0.7;
        }
        return getNaam() + ", uitgegeven in " + getRealeaseJaar() + "; nieuwprijs: €" + getPrijs() + " nu voor: €" +
                nieuwprijs + "\n";
    }
}
