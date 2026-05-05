package ms.prog2.exercises.set09;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class Aufgabe2 extends Application {
    private int count = 0;
    @Override
    public void start(Stage stage) throws Exception {
        TextField display= new TextField("0");
        display.setEditable(false);

        Button btnCount = new Button("Count");
        btnCount.setOnAction(event -> {
            count++;
            display.setText(String.valueOf(count)); // TextField aktualisieren
        });

        BorderPane root = new BorderPane();
        root.setTop(display);
        root.setLeft(btnCount);

        stage.setTitle("Count");
        stage.setResizable(false);
        stage.setScene(new Scene(root));
        stage.show();
    }
}
