package ms.prog2.exercises.set12;

public interface GameListener {
    void onBoardChanged();
    void onGameOver(char winner);
}
