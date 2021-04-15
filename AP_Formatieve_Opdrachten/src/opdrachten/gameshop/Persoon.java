package opdrachten.gameshop;

import java.util.ArrayList;
import java.time.LocalDate;

public class Persoon {
    String naam;
    double budget;
    ArrayList<Game> games = new ArrayList<Game>();

    public Persoon(String naam, int budget) {
        this.naam = naam;
        this.budget = budget;
    }

    public String getNaam() {
        return naam;
    }

    public double getBudget() {
        return budget;
    }

    public ArrayList<Game> getGames() {
        return games;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public void setGames(ArrayList<Game> games, Game game, Boolean b) {
        if (b) {
            games.add(game);
        } else {
            games.remove(game);
        }
        this.games = games;
    }

    @Override
    public String toString() {
        StringBuilder games = new StringBuilder(" ");
        for (Game game : getGames()) {
            games.append(game.toString());
        }
        return getNaam() + " heeft een budget van €" + getBudget() + " en bezit de volgende games:\n" +
                games + "\n";
    }

    public String koop(Game game) {
        double nieuwprijs = game.getPrijs();
        for (int i = 0; i < LocalDate.now().getYear() - game.getRealeaseJaar(); i++) {
            nieuwprijs = nieuwprijs*0.7;
        }
        if (nieuwprijs < getBudget()) {
            for (Game g : getGames()) {
                if (g.getNaam().equals(game.getNaam())) {
                    return "niet gelukt";
                }
            }
            setBudget(getBudget()-nieuwprijs);
            setGames(getGames(), game, true);
            return "gelukt";
        } else {
            return "niet gelukt";
        }
    }

    public String verkoop(Game game, Persoon koper) {
        double nieuwprijs = game.getPrijs();
        for (int i = 0; i < LocalDate.now().getYear() - game.getRealeaseJaar(); i++) {
            nieuwprijs = nieuwprijs*0.7;
        }
        if (getGames().contains(game) && nieuwprijs < koper.getBudget()) {
            for (Game g : koper.getGames()) {
                if (g.getNaam().equals(game.getNaam())) {
                    return "niet gelukt";
                }
            }
            setBudget(getBudget()+nieuwprijs);
            koper.setBudget(koper.getBudget()-nieuwprijs);

            koper.setGames(koper.getGames(), game, true);
            setGames(getGames(), game, false);
            return "gelukt";
        } else {
            return "niet gelukt";
        }
    }
    public static void main(String[] args) {
        int releaseJaar1 = LocalDate.now().getYear() - 1; // 1 jaar geleden
        int releaseJaar2 = LocalDate.now().getYear() - 2; // 2 jaar geleden

        Game g1 = new Game("Just Cause 3", releaseJaar1, 49.98);
        Game g2 = new Game("Need for Speed: Rivals", releaseJaar2, 45.99);
        Game g3 = new Game("Need for Speed: Rivals", releaseJaar2, 45.99);

        Persoon p1 = new Persoon("Eric", 200);
        Persoon p2 = new Persoon("Hans", 55);
        Persoon p3 = new Persoon("Arno", 185);

// Druk de volgende transacties af (pas de code aan)
        System.out.println("p1 koopt g1: " + p1.koop(g1));
        System.out.println("p1 koopt g2: " + p1.koop(g2));
        System.out.println("p1 koopt g3: " + p1.koop(g3));
        System.out.println("p2 koopt g2: " + p2.koop(g2));
        System.out.println("p2 koopt g1: " + p2.koop(g1));
        System.out.println("p3 koopt g3: " + p3.koop(g3));
        System.out.println("\n");

// Druk personen p1 p2 p3 nu af naar de console
        System.out.println("p1: " + p1.toString());
        System.out.println("p2: " + p2.toString());
        System.out.println("p3: " + p3.toString());

// Druk de volgende transacties af (pas de code aan)
        System.out.println("p1 verkoopt g1 aan p3: " + p1.verkoop(g1, p3));
        System.out.println("p1 verkoopt g1 aan p3: " + p2.verkoop(g2, p3));
        System.out.println("p1 verkoopt g1 aan p3: " + p2.verkoop(g1, p1));
        System.out.println("\n");

// Druk personen p1 p2 p3 nu af naar de console
        System.out.println("p1: " + p1.toString());
        System.out.println("p2: " + p2.toString());
        System.out.println("p3: " + p3.toString());
    }
}
