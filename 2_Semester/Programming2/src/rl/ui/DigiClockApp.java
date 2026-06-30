package rl.ui;

import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class DigiClockApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        TextField tfield = new TextField();
        tfield.setEditable(false);
        Label lbl = new Label("Digi clock");
       BorderPane root = new BorderPane();
       root.setCenter(tfield);
       root.setTop(lbl);
       Scene scene = new Scene(root);
       stage.setScene(scene);
       stage.setTitle("DigiClock");
       stage.show();
       Thread th = new Thread(task);
       th.setDaemon(true);
       th.start();
    }

    Task<Void> task = new Task<>() {
        @Override
        protected Void call() throws Exception {
           return null;
        }
    };
}
