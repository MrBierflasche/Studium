package ms.prog2.exercises.set12;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;

public class ConnectFourController {
    // FXML-Felder
    @FXML private Button btnNewGame;
    @FXML private Label  lblStatus;

    // Spalten-Buttons
    @FXML private Button col0, col1, col2, col3, col4, col5, col6;

    // 42 Kreise:  (row 0–5, col 0–6)
    @FXML private Circle c00, c01, c02, c03, c04, c05, c06;
    @FXML private Circle c10, c11, c12, c13, c14, c15, c16;
    @FXML private Circle c20, c21, c22, c23, c24, c25, c26;
    @FXML private Circle c30, c31, c32, c33, c34, c35, c36;
    @FXML private Circle c40, c41, c42, c43, c44, c45, c46;
    @FXML private Circle c50, c51, c52, c53, c54, c55, c56;

    private ConnectFourModel model;

    @FXML
    public void initialize() {
        model = new ConnectFourModel();

        Circle[][] circles = new Circle[][] {
                {c00, c01, c02, c03, c04, c05, c06},
                {c10, c11, c12, c13, c14, c15, c16},
                {c20, c21, c22, c23, c24, c25, c26},
                {c30, c31, c32, c33, c34, c35, c36},
                {c40, c41, c42, c43, c44, c45, c46},
                {c50, c51, c52, c53, c54, c55, c56}
        };

        Button[] columnButtons = new Button[] { col0, col1, col2, col3, col4, col5, col6 };
        ConnectFourView view = new ConnectFourView(model, circles, lblStatus, columnButtons );

        // Erstanzeige manuell anstoßen
        view.onBoardChanged();
    }

    // Button-Handlers
    @FXML
    private void handleNewGame() {
        model.newGame();
    }

    @FXML
    private void handleCol0() { model.makeMove(0); }
    @FXML
    private void handleCol1() { model.makeMove(1); }
    @FXML
    private void handleCol2() { model.makeMove(2); }
    @FXML
    private void handleCol3() { model.makeMove(3); }
    @FXML
    private void handleCol4() { model.makeMove(4); }
    @FXML
    private void handleCol5() { model.makeMove(5); }
    @FXML
    private void handleCol6() { model.makeMove(6); }
}