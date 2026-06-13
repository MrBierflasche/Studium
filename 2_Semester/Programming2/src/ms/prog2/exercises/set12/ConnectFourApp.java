package ms.prog2.exercises.set12;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ConnectFourApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ConnectFour.fxml"));
        Scene scene = new Scene(loader.load());
        stage.setTitle("ConnectFour");
        stage.setScene(scene);
        stage.show();
    }
}
