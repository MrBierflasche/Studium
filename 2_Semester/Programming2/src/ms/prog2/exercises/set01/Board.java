package ms.prog2.exercises.set01;

public class Board {
    private static final int ROWS = 6;
    private static final int COLS = 7;

    public char[][] grid;

    public Board() {
        grid = new char[ROWS][COLS];
        initialize();
    }

    // Leeres Vier Gewinnt Layout erstellen
    private void initialize() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                grid[row][col] = '.';
            }
        }
    }

    // Spiel Brett zeichnen
    public void print() {
        for (int col = 0; col < COLS; col++) {
            System.out.print("0" + col + " ");
        }
        System.out.println();
        System.out.println("---------------------");

        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                System.out.print(" " + grid[row][col] + " ");
            }
            System.out.println();
        }
        System.out.println("---------------------");
    }

    // Überprüfen ob Spielstein eingesetzt werden darf
    public boolean isValidMove(int col) {
        return col >= 0 && col < COLS && grid[0][col] == '.';
    }

    // Setzt STein an richtiger Stelle der Reihe
    public int dropStone(int col, char symbol) {
        for (int row = ROWS - 1; row >= 0; row--) {
            if (grid[row][col] == '.') {
                grid[row][col] = symbol;
                return row;
            }
        }

        // Fehler: nix gefunden, darf aber eigentlich nicht passieren, da es ja davor überprüft wird
        return -1;
    }

    // Gibt es noch mindestens eine Spalte in der man etwas einwerfen kann?
    public boolean isFull() {
        for (int col = 0; col < COLS; col++) {
            if (grid[0][col] == '.') {
                return false;
            }
        }
        return true;
    }

    // Überprüfen ob ein Spieler gewonnen
    public boolean hasWon(int row, int col, char symbol) {
        return countConnected(row, col, 0, 1, symbol) >= 4 // waagerecht
                || countConnected(row, col, 1, 0, symbol) >= 4 // senkrecht
                || countConnected(row, col, 1, 1, symbol) >= 4 // diagonal nach rechts unten / links oben
                || countConnected(row, col, 1, -1, symbol) >= 4; //diagonal nach links unten / rechts oben
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
