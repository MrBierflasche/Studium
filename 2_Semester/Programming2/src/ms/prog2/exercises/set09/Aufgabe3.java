package ms.prog2.exercises.set09;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class Aufgabe3 extends Application {
    private int count = 0;
    @Override
    public void start(Stage stage) throws Exception {
        TextField display= new TextField("0");
        display.setEditable(false);
        display.setAlignment(Pos.CENTER); // Text mittig
        display.setStyle("-fx-font-size: 24px;");

        Button btnCount = new Button("Count");
        btnCount.setOnAction(event -> {
            count++;
            display.setText(String.valueOf(count)); // TextField aktualisieren
        });

        Button btnReset = new Button("Reset");
        btnReset.setOnAction(event -> {
            count = 0;
            display.setText(String.valueOf(count));
        });

        Button btnExit = new Button("Exit");
        btnExit.setOnAction(event -> {
            Platform.exit();
        });


        HBox buttons = new HBox(20);
        buttons.setAlignment(Pos.CENTER);
        buttons.getChildren().addAll(btnCount, btnReset, btnExit);

        BorderPane root = new BorderPane();
        root.setCenter(display);
        root.setBottom(buttons);
        root.setPadding(new Insets(10, 10, 10, 10));

        stage.setTitle("Count");
        stage.setResizable(false);
        stage.setScene(new Scene(root, 200, 150));
        stage.show();
    }
}
