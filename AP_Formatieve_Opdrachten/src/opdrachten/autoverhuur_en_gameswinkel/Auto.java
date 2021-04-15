package opdrachten.autoverhuur_en_gameswinkel;

public class Auto {
    String type;
    double prijsPerDag;

    public Auto(String type, double prijsPerDag) {
        this.type = type;
        this.prijsPerDag = prijsPerDag;
    }

    public void setPrijsPerDag(double prijsPerDag) {
        this.prijsPerDag = prijsPerDag;
    }

    public double getPrijsPerDag() {
        return prijsPerDag;
    }

    @Override
    public String toString() {
        return "Auto{" +
                "type='" + type + '\'' +
                ", prijsPerDag=" + prijsPerDag +
                '}';
    }
}
