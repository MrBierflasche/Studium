package ms.prog2.exercises.set09;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class Aufgabe1 extends Application {
    @Override
    public void start(Stage primaryStage) {
        // oberer Bereich: F-Tasten
        HBox topBox = new HBox(10); // Abstand zwischen den Knöpfen
        topBox.setPadding(new Insets(15)); //Abstand zum Fensterrand
        topBox.setAlignment(Pos.CENTER);
        topBox.getChildren().addAll(new Button("F1"), new Button("F2"), new Button("F3"), new Button("F4"));

        // Mittlerer Bereich: Steuerkreuz
        BorderPane directionalPad = new BorderPane();
        directionalPad.setPadding(new Insets(20));

        Button btnUp = new Button("Up");
        Button btnDown = new Button("Down");
        Button btnLeft = new Button("Left");
        Button btnRight = new Button("Right");

        // Buttons in der inneren BorderPane ausrichten
        directionalPad.setTop(btnUp);
        BorderPane.setAlignment(btnUp, Pos.CENTER);

        directionalPad.setBottom(btnDown);
        BorderPane.setAlignment(btnDown, Pos.CENTER);

        directionalPad.setLeft(btnLeft);
        BorderPane.setAlignment(btnLeft, Pos.CENTER);

        directionalPad.setRight(btnRight);
        BorderPane.setAlignment(btnRight, Pos.CENTER);

        // Unterer Bereich: Exit Button
        Button btnExit = new Button("Exit");
        btnExit.setMaxWidth(Double.MAX_VALUE); // volle Breite

        // Layout zusammenfügen
        BorderPane root = new BorderPane();
        root.setTop(topBox);
        root.setCenter(directionalPad);
        root.setBottom(btnExit);

        BorderPane.setMargin(btnExit, new Insets(10));

        Scene scene = new Scene(root, 300, 300);
        primaryStage.setTitle("Simple Control Panel");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
