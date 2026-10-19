
package versuch1;

import java.io.IOException;
import buisness.Freizeitbad;
import buisness.FreizeitbaederModel;

public class FreizeitbaederControl {

    private FreizeitbaederModel freizeitbaederModel;
    private FreizeitbaederView freizeitbaederView;

    public FreizeitbaederControl(FreizeitbaederModel model) {
        this.freizeitbaederModel = model;
    }

    public void setFreizeitbaederView(FreizeitbaederView view) {
        this.freizeitbaederView = view;
    }

    public void speichereFreizeitbad(
            String name,
            String oeffnungszeiten,
            double beckenlaenge,
            double wassertemperatur) {

        Freizeitbad bad = new Freizeitbad(
            name,
            oeffnungszeiten,
            beckenlaenge,
            wassertemperatur
        );

        freizeitbaederModel.setFreizeitbad(bad);
    }

    public String zeigeFreizeitbad() {

        Freizeitbad bad = freizeitbaederModel.getFreizeitbad();

        if (bad == null) {
            return "Noch kein Freizeitbad gespeichert!";
        }

        return bad.gibFreizeitbadZurueck(';');
    }

    public void schreibeFreizeitbaederInDatei(String typ) {
        try {
            if ("csv".equals(typ)) {

                if (freizeitbaederModel.getFreizeitbad() == null) {
                    freizeitbaederView.zeigeFehlermeldungAn(
                        "Bitte zuerst ein Freizeitbad eingeben!");
                    return;
                }

                freizeitbaederModel
                    .schreibeFreizeitbaederInCsvDatei();

                freizeitbaederView.zeigeInformationsfensterAn(
                    "Die Freizeitbäder wurden gespeichert!");
            }
            else {
                freizeitbaederView.zeigeInformationsfensterAn(
                    "Noch nicht implementiert!");
            }
        }
        catch (IOException exc) {
            freizeitbaederView.zeigeFehlermeldungAn(
                "IOException beim Speichern!");
        }
        catch (Exception exc) {
            freizeitbaederView.zeigeFehlermeldungAn(
                "Unbekannter Fehler beim Speichern!");
        }
    }
}
