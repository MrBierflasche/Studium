package rl.ui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GuessingGameMvc  extends Application {

    @Override
    public void start(Stage stage){
        GGModel model = new GGModel();
        GGView view = new GGView(stage, model);
        GGController controller = new GGController(model, view);
        view.setController(controller);
        model.addObserver(view);
        stage.show();
    }
}

// GUI Layer
class GGView implements Observer{
    private Spinner<Integer> guessSpin;
    private TextField feedbackFld;
    private GGModel model;
    GGController controller;
    public GGView(Stage stage, GGModel model) {
        this.model = model;
        Button startBtn = new Button("Start");
        startBtn.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        startBtn.setId("StartBtn");
        Button  guessBtn = new Button("Guess");
        guessBtn.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        guessBtn.setId("GuessBtn");
        guessSpin = new Spinner<>(1, model.GetMaxNumber(), 1);
        feedbackFld = new TextField();
        GridPane pane = new GridPane(10,10);
        pane.setPadding(new Insets(10));
        pane.add(startBtn, 0, 0);
        pane.add(guessBtn, 1, 0);
        pane.add(guessSpin, 0, 1, 2, 1);
        pane.add(feedbackFld, 0, 2, 2, 1);
        pane.setAlignment(Pos.CENTER);

        startBtn.setOnAction(e -> controller.handle(e));
        guessBtn.setOnAction(e -> controller.handle(e));

        stage.setScene(new Scene(pane));
        stage.setTitle("Guessing Game");

    }

    public void setController(GGController controller) {
        this.controller = controller;
    }

    public int getGuessNumber(){
        return guessSpin.getValue();
    }

    @Override
    public void update() {
        feedbackFld.setText(model.getFeedback());
    }
}


class GGController{
    GGModel model;
    GGView view;
    public GGController(GGModel model, GGView view){
        this.model = model;
        this.view = view;
    }

  public void handle(ActionEvent e){
      if (((Node) e.getSource()).getId().equals("StartBtn")){
          model.startGame();
      }
      else if (((Node) e.getSource()).getId().equals("GuessBtn")){
         model.guess(view.getGuessNumber());
      }
  }
}

// domain layer
class GGModel{
    private final int maxNumber;
    private int myNumber;
    private int trialCounter;
    private String feedback;
    private final Random random = new Random();
    private List<Observer> observers;

    public String getFeedback() {
        return feedback;
    }
    public int GetMaxNumber() {
        return maxNumber;
    }

    GGModel(){
        this(10);
    }

    GGModel(int maxNumber) {
        this.maxNumber = maxNumber;
        observers = new ArrayList<>();
    }

    public void addObserver(Observer observer){
        observers.add(observer);
    }

    private void notifyObservers(){
        for (Observer observer : observers){
            observer.update();
        }
    }

    public void startGame(){
        myNumber = random.nextInt(maxNumber) + 1;
        trialCounter = 0;
        feedback = "Guess my number between 1 and " +  maxNumber + "!";
        notifyObservers();
    }

    public void guess(int number){
        trialCounter++;
        if( myNumber < number){
            feedback = "My Number is smaller";
        } else if (myNumber > number) {
            feedback = "My Number is larger";
        }else {
            feedback = "Correct!";
        }
        notifyObservers();
    }
}

// foundationLayer

interface Observer{
    void update();
}
