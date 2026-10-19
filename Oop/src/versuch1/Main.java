
package versuch1;

import buisness.FreizeitbaederModel;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {

        // Model erstellen
        FreizeitbaederModel model =
                new FreizeitbaederModel();

        // Controller erstellen
        FreizeitbaederControl control =
                new FreizeitbaederControl(model);

        // View erstellen
        FreizeitbaederView view =
                new FreizeitbaederView(control);

        // Controller mit View verbinden
        control.setFreizeitbaederView(view);

        // Fenster anzeigen
        view.start(stage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
