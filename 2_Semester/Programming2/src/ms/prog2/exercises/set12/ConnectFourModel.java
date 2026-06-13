package ms.prog2.exercises.set12;

public class ConnectFourModel {

    private final ConnectFourGame game;
    private GameListener listener;

    public ConnectFourModel() {
        game = new ConnectFourGame();
    }

    public void setListener(GameListener listener) {
        this.listener = listener;
    }

    //Spielzug ausführen
    public void makeMove(int col) {
        if (game.dropStone(col)) {
            if (listener != null) {
                listener.onBoardChanged();
            }
            if (game.isGameOver() && listener != null){
                listener.onGameOver(game.getWinner());
            }
        }
    }

    //Neues Spiel starten.
    public void newGame() {
        game.newGame();
        if (listener != null) {
            listener.onBoardChanged();
        }
    }

    // Lesezugriffe für View
    public char getCell(int row, int col)  { return game.getCell(row, col); }
    public char getCurrentPlayer()          { return game.getCurrentPlayer(); }
    public boolean isGameOver()             { return game.isGameOver(); }
    public char getWinner()                 { return game.getWinner(); }
    public boolean isValidMove(int col)     { return game.isValidMove(col); }
}