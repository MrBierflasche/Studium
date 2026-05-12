package rl.ui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class LayoutExcerciseApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Button btnCenter = new Button("Center");
        btnCenter.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        Button btnLeft = new Button("Left");
        btnLeft.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        Button btnTop1 = new Button("<Top");
        Button btnTop2 = new Button("Top>>>");
        Button btnBottom1 = new Button("<Bottom");
        Button btnBottom2 = new Button("Bottom>>>");
        HBox hBoxBottom = new HBox();
        hBoxBottom.getChildren().addAll(btnBottom1, btnBottom2);
        hBoxBottom.setAlignment(Pos.CENTER);
        HBox hBoxTop = new HBox();
        hBoxTop.getChildren().addAll(btnTop1, btnTop2);
        hBoxTop.setAlignment(Pos.CENTER);
        BorderPane centerPane = new BorderPane();
        centerPane.setTop(hBoxTop);
        centerPane.setCenter(btnCenter);
        centerPane.setBottom(hBoxBottom);
        centerPane.setPadding(new Insets(10));
        BorderPane rootPane = new BorderPane();
        rootPane.setLeft(btnLeft);
        rootPane.setCenter(centerPane);
        Scene scene = new Scene(rootPane);
        stage.setScene(scene);
        stage.setTitle("Layout Excercise");
        stage.show();
    }
}
