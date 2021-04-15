package opdrachten.autoverhuur;

import java.util.Objects;

public class Autohuur {
    int aantalDagen;
    Auto gehuurdeAuto;
    Klant huurder;

    public void setAantalDagen(int aantalDagen) {
        this.aantalDagen = aantalDagen;
    }
    public void setGehuurdeAuto(Auto gehuurdeAuto) {
        this.gehuurdeAuto = gehuurdeAuto;
    }
    public Auto getGehuurdeAuto() {
        return gehuurdeAuto;
    }

    public void setHuurder(Klant huurder) {
        this.huurder = huurder;
    }

    public Klant getHuurder() {
        return huurder;
    }
    public double totaalprijs() {
        return (aantalDagen * gehuurdeAuto.getPrijsPerDag()) * ((100-huurder.getKortingsPercentage())/100);
    }

    @Override
    public String toString() {
        String auto;
        String huurder;
        String korting;
        if (Objects.isNull(getGehuurdeAuto())){
            auto = "er is geen auto bekend\n";

        } else {
            auto = "autotype: " + getGehuurdeAuto();

        }
        if (Objects.isNull(getHuurder())){
            huurder = "er is geen huurder bekend\n";

        } else {
            huurder = getHuurder().toString();
        }
        if (Objects.isNull(getGehuurdeAuto()) || Objects.isNull(getHuurder())){
            korting = "aantal dagen: 0 en dat kost 0.0\n";
        } else {
            korting = "aantal dagen: " + aantalDagen + " en dat kost " + totaalprijs() + "\n";
        }
        return auto + huurder + korting;
    }

    public static void main(String[] args) {
        Autohuur ah1 = new Autohuur( );
        System.out.println("Eerste autohuur:\n" + ah1.toString());
        // Print "Eerste autohuur: " + ah1.toString()

        Klant k = new Klant("Mijnheer de Vries");
        k.setKorting(10.0);
        ah1.setHuurder(k);
        System.out.println("Eerste autohuur:\n" + ah1.toString());
        // Print: "Eerste autohuur: " + ah1.toString()

        Auto a1 = new Auto("Peugeot 207", 50);
        ah1.setGehuurdeAuto(a1);
        ah1.setAantalDagen(4);
        System.out.println("Eerste autohuur:\n" + ah1.toString());
        // Print "Eerste autohuur:" + ah1.toString()

        Autohuur ah2 = new Autohuur( );
        Auto a2 = new Auto("Ferrari", 3500);
        ah2.setGehuurdeAuto(a2);
        ah2.setHuurder(k);
        ah2.setAantalDagen(1);
        System.out.println("Tweede autohuur:\n" + ah2.toString());
        // Print "Tweede autohuur: " + ah2.toString()

        System.out.println("Gehuurd: " + ah1.getGehuurdeAuto());
        System.out.println("Gehuurd: " + ah2.getGehuurdeAuto());
        // Print "Gehuurd: " + ah1.getGehuurdeAuto()
        // Print "Gehuurd: " + ah2.getGehuurdeAuto()
    }
}