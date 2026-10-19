
package versuch1;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FreizeitbaederView {

    private FreizeitbaederControl freizeitbaederControl;

    private MenuItem mnItmCsvExport;
    private MenuItem mnItmTxtExport;

    public FreizeitbaederView(FreizeitbaederControl control) {
        this.freizeitbaederControl = control;
    }

    public void start(Stage stage) {

        MenuBar menuBar = new MenuBar();
        Menu menuDatei = new Menu("Datei");

        mnItmCsvExport = new MenuItem("csv-Export");
        mnItmTxtExport = new MenuItem("txt-Export");

        menuDatei.getItems().addAll(
            mnItmCsvExport, mnItmTxtExport);

        menuBar.getMenus().add(menuDatei);

        TextField txtName = new TextField();
        txtName.setPromptText("Name");

        TextField txtOeffnungszeiten = new TextField();
        txtOeffnungszeiten.setPromptText("Öffnungszeiten");

        TextField txtBeckenlaenge = new TextField();
        txtBeckenlaenge.setPromptText("Beckenlänge");

        TextField txtWassertemperatur = new TextField();
        txtWassertemperatur.setPromptText("Wassertemperatur");

        Button btnEingabe = new Button("Eingabe");
        Button btnAnzeige = new Button("Anzeige");

        Label lblAusgabe = new Label();

        btnEingabe.setOnAction(e -> {
            try {
                String name = txtName.getText();
                String oeffnungszeiten =
                    txtOeffnungszeiten.getText();

                double beckenlaenge = Double.parseDouble(
                    txtBeckenlaenge.getText());

                double wassertemperatur = Double.parseDouble(
                    txtWassertemperatur.getText());

                freizeitbaederControl.speichereFreizeitbad(
                    name,
                    oeffnungszeiten,
                    beckenlaenge,
                    wassertemperatur
                );

                zeigeInformationsfensterAn(
                    "Freizeitbad wurde aufgenommen!");

            } catch (NumberFormatException ex) {
                zeigeFehlermeldungAn(
                    "Bitte gültige Zahlen eingeben!");
            }
        });

        btnAnzeige.setOnAction(e -> {
            lblAusgabe.setText(
                freizeitbaederControl.zeigeFreizeitbad()
            );
        });

        VBox root = new VBox(10,
            menuBar,
            new Label("Freizeitbad"),
            txtName,
            txtOeffnungszeiten,
            txtBeckenlaenge,
            txtWassertemperatur,
            btnEingabe,
            btnAnzeige,
            lblAusgabe
        );

        root.setPadding(new Insets(15));

        initListener();

        Scene scene = new Scene(root, 450, 450);
        stage.setTitle("Freizeitbäder");
        stage.setScene(scene);
        stage.show();
    }

    private void initListener() {

        mnItmCsvExport.setOnAction(e ->
            schreibeFreizeitbaederInDatei("csv"));

        mnItmTxtExport.setOnAction(e ->
            schreibeFreizeitbaederInDatei("txt"));
    }

    private void schreibeFreizeitbaederInDatei(String typ) {
        freizeitbaederControl
            .schreibeFreizeitbaederInDatei(typ);
    }

    public void zeigeInformationsfensterAn(String meldung) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(meldung);
        alert.showAndWait();
    }

    public void zeigeFehlermeldungAn(String meldung) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(meldung);
        alert.showAndWait();
    }
}
