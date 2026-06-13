package ms.prog2.exercises.set12;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;

public class ConnectFourView implements GameListener {
    private final ConnectFourModel model;
    private final Circle[][] circles;
    private final Label lblStatus;
    private final Button[] columnButtons;

    public ConnectFourView(ConnectFourModel model, Circle[][] circles, Label lblStatus, Button[] columnButtons) {
        this.model = model;
        this.circles = circles;
        this.lblStatus = lblStatus;
        this.columnButtons = columnButtons;

        this.model.setListener(this);
    }

    @Override
    public void onBoardChanged() {
        // Kreise Farbe setzen
        for (int row = 0; row < ConnectFourGame.ROWS; row++) {
            for (int col = 0; col < ConnectFourGame.COLS; col++) {
                circles[row][col].setFill(cellColor(model.getCell(row, col)));
            }
        }

        setButtonsDisabled(model.isGameOver());

        // Status-Text setzen
        if (!model.isGameOver()) {
            char p = model.getCurrentPlayer();
            String name  = (p == ConnectFourGame.RED) ? "Red" : "Yellow";
            lblStatus.setText("Next move: " + name);
        }
    }

    @Override
    public void onGameOver(char winner) {
        onBoardChanged();

        // Buttons direkt sperren
        setButtonsDisabled(true);

        if (winner == ConnectFourGame.EMPTY) {
            lblStatus.setText("Draw! No more moves.");
        } else {
            String name = (winner == ConnectFourGame.RED) ? "Red" : "Yellow";
            lblStatus.setText(name + " wins!");
        }
    }

    private void setButtonsDisabled(boolean disabled) {
        for (Button btn : columnButtons) {
            if (btn != null) {
                btn.setDisable(disabled);
            }
        }
    }

    private Color cellColor(char cell) {
        return switch (cell) {
            case ConnectFourGame.RED    -> Color.RED;
            case ConnectFourGame.YELLOW -> Color.YELLOW;
            default                     -> Color.web("#0a2a52");
        };
    }
}