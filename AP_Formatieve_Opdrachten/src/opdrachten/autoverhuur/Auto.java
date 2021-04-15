package opdrachten.autoverhuur;

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
        return type + " met prijs per dag: " + prijsPerDag + "\n";
    }
}
