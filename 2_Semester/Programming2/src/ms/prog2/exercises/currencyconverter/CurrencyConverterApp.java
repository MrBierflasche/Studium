package ms.prog2.exercises.currencyconverter;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CurrencyConverterApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("CurrencyConverter.fxml"));
        Scene scene = new Scene(loader.load());
        stage.setTitle("Currency Converter");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
}
