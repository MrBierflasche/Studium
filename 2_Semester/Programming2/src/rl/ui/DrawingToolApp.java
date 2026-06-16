package rl.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class DrawingToolApp extends Application {
    private GraphicsContext gc;
    private double lastX, lastY;
    public void start(Stage stage) {
        AnchorPane root = new AnchorPane();
        Canvas canvas = new Canvas(300, 250);
        gc = canvas.getGraphicsContext2D();

        stage.setTitle("Drawing Tool");
        root.getChildren().add(canvas);
        stage.setScene(new Scene(root));
        stage.show();
        canvas.setOnMouseDragged(this::onDrag);
        canvas.setOnMousePressed(this::onPressed);
    }

    public void onDrag(MouseEvent e) {
        gc.setFill(Color.BLACK);
        gc.strokeLine(lastX, lastY, e.getX(), e.getY());
        lastX = e.getX();
        lastY = e.getY();
    }


    public void  onPressed(MouseEvent e) {
        lastX = e.getX();
        lastY = e.getY();
    }

}
