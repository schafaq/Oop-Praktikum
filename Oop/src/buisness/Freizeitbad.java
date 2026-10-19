
package buisness;

public class Freizeitbad {

    private String name;
    private String oeffnungszeiten;
    private double beckenlaenge;
    private double wassertemperatur;

    public Freizeitbad(
            String name,
            String oeffnungszeiten,
            double beckenlaenge,
            double wassertemperatur) {

        this.name = name;
        this.oeffnungszeiten = oeffnungszeiten;
        this.beckenlaenge = beckenlaenge;
        this.wassertemperatur = wassertemperatur;
    }

    public String getName() {
        return name;
    }

    public String getOeffnungszeiten() {
        return oeffnungszeiten;
    }

    public double getBeckenlaenge() {
        return beckenlaenge;
    }

    public double getWassertemperatur() {
        return wassertemperatur;
    }

    public String gibFreizeitbadZurueck(char trennzeichen) {

        return name + trennzeichen
                + oeffnungszeiten + trennzeichen
                + beckenlaenge + trennzeichen
                + wassertemperatur;
    }
}
