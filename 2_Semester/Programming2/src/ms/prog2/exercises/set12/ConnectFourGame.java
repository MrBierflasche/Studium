package ms.prog2.exercises.set12;

public class ConnectFourGame {

    public static final int ROWS = 6;
    public static final int COLS = 7;

    public static final char RED    = 'R';
    public static final char YELLOW = 'Y';
    public static final char EMPTY  = '.';

    private char[][] grid;
    private char currentPlayer;
    private boolean gameOver;
    private char winner; // EMPTY = Unentschieden

    public ConnectFourGame() {
        newGame();
    }

    //Setzt das Spiel zurück
    public void newGame() {
        grid = new char[ROWS][COLS];
        for (int r = 0; r < ROWS; r++){
            for (int c = 0; c < COLS; c++){
                grid[r][c] = EMPTY;
            }
        }

        currentPlayer = RED;
        gameOver = false;
        winner = EMPTY;
    }

   // Setzt Stein an richtiger Stelle der Reihe
    public boolean dropStone(int col) {
        if (gameOver || !isValidMove(col)) {
            return false;
        }

        for (int row = ROWS - 1; row >= 0; row--) {
            if (grid[row][col] == EMPTY) {
                grid[row][col] = currentPlayer;

                if (hasWon(row, col, currentPlayer)) {
                    gameOver = true;
                    winner = currentPlayer;
                } else if (isFull()) {
                    gameOver = true;
                    winner = EMPTY;
                } else {
                    currentPlayer = (currentPlayer == RED) ? YELLOW : RED;
                }
                return true;
            }
        }
        return false;
    }

    // Überprüfen ob Spielstein eingesetzt werden darf
    public boolean isValidMove(int col) {
        return col >= 0 && col < COLS && grid[0][col] == EMPTY;
    }

    // Gibt es noch mindestens eine Spalte in der man etwas einwerfen kann?
    public boolean isFull() {
        for (int c = 0; c < COLS; c++){
            if (grid[0][c] == EMPTY) {
                return false;
            }
        }
        return true;
    }

    public boolean isGameOver() { return gameOver; }
    public char getWinner()     { return winner; }
    public char getCurrentPlayer() { return currentPlayer; }

    public char getCell(int row, int col) { return grid[row][col]; }

    // Überprüfen ob ein Spieler gewonnen
    private boolean hasWon(int row, int col, char symbol) {
        return countConnected(row, col, 0, 1, symbol) >= 4
            || countConnected(row, col, 1, 0, symbol) >= 4
            || countConnected(row, col, 1, 1, symbol) >= 4
            || countConnected(row, col, 1, -1, symbol) >= 4;
    }

    // Beide Richtungen vom Stein abhängig zählen
    private int countConnected(int row, int col, int dRow, int dCol, char symbol) {
        int count = 1;
        count += countDirection(row, col, dRow, dCol, symbol);
        count += countDirection(row, col, -dRow, -dCol, symbol);
        return count;
    }

    private int countDirection(int row, int col, int dRow, int dCol, char symbol) {
        int count = 0;
        int r = row + dRow;
        int c = col + dCol;

        // Geht so lange noch im Spielbrett gezählt wird und der selbe Stein liegt
        while (r >= 0 && r < ROWS && c >= 0 && c < COLS && grid[r][c] == symbol) {
            count++;
            r += dRow;
            c += dCol;
        }

        return count;
    }
}
