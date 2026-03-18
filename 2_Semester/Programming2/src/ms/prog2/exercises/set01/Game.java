package ms.prog2.exercises.set01;

import java.util.Scanner;

public class Game {
    private Board board;
    private Player playerX;
    private Player playerO;
    private Player currentPlayer;
    private final Scanner scanner;

    public Game() {
        board = new Board();
        playerX = new Player('X');
        playerO = new Player('O');
        currentPlayer = playerX; // Spieler X beginnt
        scanner = new Scanner(System.in);
    }

    public void play() {
        // leeres Spielfeld am Anfang ausgeben
        board.print();

        while (true) {
            int col = readColumn();
            int row = board.dropStone(col, currentPlayer.getSymbol());

            board.print();

            if (board.hasWon(row, col, currentPlayer.getSymbol())) {
                System.out.println("Spieler " + currentPlayer.getSymbol() + " gewinnt");
                break;
            }

            if (board.isFull()) {
                System.out.println("Unentschieden, das Spielbrett ist voll.");
                break;
            }

            switchPlayer();
        }

        scanner.close();
    }

    private int readColumn() {
        while (true) {
            System.out.print("Spieler " + currentPlayer.getSymbol() + ", wählen Sie eine Spalte (0-6): ");

            // Überprüfen ob Zahl eingegeben
            if (!scanner.hasNextInt()) {
                System.out.println("Ungültige Eingabe. Bitte eine Zahl von 0 bis 6 eingeben.");
                scanner.next();
                continue;
            }

            int col = scanner.nextInt();

            // Überpüft ob gülitige Zahl und nicht voll
            if (!board.isValidMove(col)) {
                System.out.println("Ungültige Eingabe. Bitte erneut eingeben.");
                continue;
            }

            return col;
        }
    }

    private void switchPlayer() {
        if (currentPlayer == playerX) {
            currentPlayer = playerO;
            return;
        }
        currentPlayer = playerX;
    }
}
