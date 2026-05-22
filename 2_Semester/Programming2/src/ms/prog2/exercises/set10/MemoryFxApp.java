package ms.prog2.exercises.set10;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.List;

public class MemoryFxApp extends Application {
    private MemoryGame game;
    private GridPane gridPane;
    private Label statusLabel;
    @Override
    public void start(Stage stage) throws Exception {
        List<String> footballPlayers = Arrays.asList(
                "Neuer", "Goretzka", "Kimmich", "Schlotterbeck", "Wirtz", "Musiala"
        );

        game = new MemoryGame(footballPlayers);
        BorderPane root = new BorderPane();
        root.getStyleClass().add("game-table");

        // Menuleiste
        MenuBar menuBar = createMenuBar();
        root.setTop(menuBar);

        // Spielfeld- 4 Spalten x 3 Zeilen
        gridPane = new GridPane();
        gridPane.setPadding(new Insets(25));
        gridPane.setHgap(15);
        gridPane.setVgap(15);
        gridPane.setAlignment(Pos.CENTER);
        root.setCenter(gridPane);

        //Statuszeile unten
        HBox bottomBar = new HBox();
        bottomBar.setPadding(new Insets(10));
        bottomBar.setAlignment(Pos.CENTER);

        statusLabel = new Label();
        statusLabel.getStyleClass().add("status-text");
        bottomBar.getChildren().add(statusLabel);
        root.setBottom(bottomBar);

        // Kartengitter aufbauen und statusLabel setzen
        initializeGrid();
        updateStatusLabel();

        // automatische Textaktualiserung unten
        game.currPlayerProperty().addListener((obs, oldVal, newVal) -> updateStatusLabel());

        Scene scene = new Scene(root, 750, 550);
        stage.setTitle("2026 FIFA World Cup Memory");
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    private MenuBar createMenuBar() {
        MenuBar menuBar = new MenuBar();
        menuBar.getStyleClass().add("top-menu-bar");

        Menu fileMenu = new Menu("File");

        MenuItem newGameItem = new MenuItem("New Game");
        newGameItem.setOnAction(e -> handleNewGame());

        MenuItem exitItem = new MenuItem("Exit");
        exitItem.setOnAction(e -> Platform.exit());

        fileMenu.getItems().addAll(newGameItem, exitItem);
        menuBar.getMenus().add(fileMenu);

        return menuBar;
    }

    private void handleNewGame() {
        game.newGame();
        initializeGrid();
        updateStatusLabel();
    }

    private void updateStatusLabel() {
        int currentPlayer = game.getCurrPlayer();
        String playerColor = (currentPlayer == 1) ? "Blue" : "Red";
        statusLabel.setText("Next: Player " + playerColor);
    }

    private void initializeGrid() {
        gridPane.getChildren().clear();
        int totalCards = game.getNumOfCards(); // Immer 12
        int columns = 4; // Erzwingt 4 Spalten beim Aufbauen des Gitter

        for (int i = 0; i < totalCards; i++) {
            final int index = i; // extra Variable wegen Lambda final
            MemoryCard card = game.getCard(index);

            Button cardButton = new Button();
            cardButton.setPrefSize(140, 105);

            cardButton.getStyleClass().add("memory-card");

            // Karte drehen
            cardButton.setOnAction(e -> {
                game.turnCard(index);
                if (game.isGameOver()) {
                    int score1 = game.getScore(1);
                    int score2 = game.getScore(2);
                    String winner = "";
                    if (score1 > score2){
                       winner = "Player Blue wins!";
                    }
                    else if (score1 < score2){
                       winner =  "Player Red wins!";
                    }else{
                        winner = "It's a tie!";
                    }
                    statusLabel.setText(winner);
                }
            });

            // Reagiert auf das Umdrehen der Karte
            card.revealedProperty().addListener((obs, wasRevealed, isRevealed) -> {
                if (isRevealed) {
                    try {
                        // Dynamisches Laden des Bildes
                        String image = this.getClass().getResource(card.getImageName()).toExternalForm();
                        cardButton.setStyle("-fx-background-image: url('" + image + "'); -fx-background-size: cover;");
                    } catch (Exception e) {
                        // Fallback, falls die Bilddatei im Ordner fehlt
                        cardButton.setText(card.getTitle());
                        cardButton.setStyle("-fx-background-color: #222222; -fx-text-fill: white; -fx-font-weight: bold;");
                    }
                } else {
                    // Zurück zur Rückseite (falls die Karte keinen Besitzer hat)
                    if (card.getOwner() == 0) {
                        cardButton.setText("");
                        cardButton.setStyle("-fx-background-color: #cccccc;");
                    }
                }
            });

            // Reagiert auf den Gewinn der Karte
            card.ownerProperty().addListener((obs, oldOwner, newOwner) -> {
                int owner = newOwner.intValue();

                // alle zustandsabhängigen Styles vorab runter
                cardButton.getStyleClass().removeAll("card-owned-blue", "card-owned-red");
                cardButton.setStyle(null);
                cardButton.setText("");

                if (owner == 1) {
                    cardButton.getStyleClass().add("card-owned-blue"); // Aktiviert flächig Blau aus CSS
                    cardButton.setDisable(true);
                } else if (owner == 2) {
                    cardButton.getStyleClass().add("card-owned-red");  // Aktiviert flächig Rot aus CSS
                    cardButton.setDisable(true);
                } else {
                    // Reset bei neuem Spiel
                    cardButton.setDisable(false);
                }
            });

            // Richtige Position im Gitter hinzufügen
            int row = index / columns;
            int col = index % columns;
            gridPane.add(cardButton, col, row);
        }
    }
}