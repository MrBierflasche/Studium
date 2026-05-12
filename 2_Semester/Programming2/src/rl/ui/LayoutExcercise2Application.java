package rl.ui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class LayoutExcercise2Application extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Label milesLabel = new Label("Nautical Miles:");
        Label kmLabel = new Label("Kilometers:");
        TextField milesField = new TextField();
        TextField kmField = new TextField();
        kmField.setEditable(false);
        Button btnConv = new Button("Convert");
        btnConv.setOnAction(e -> {
            kmField.setText(String.valueOf(Double.parseDouble(milesField.getText()) * 1.852));
        });
        HBox hBoxConv = new HBox(10);
        hBoxConv.getChildren().addAll(milesLabel, milesField, btnConv, kmLabel, kmField);
        hBoxConv.setPadding(new Insets(10));
        Scene scene = new Scene(hBoxConv);
        stage.setScene(scene);
        stage.show();
    }
}
