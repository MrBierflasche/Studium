package ms.prog2.exercises.set10;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MemoryGame {
    private final List<MemoryCard> cards = new ArrayList<MemoryCard>();

    // Properties für die UI-Synchronisation
    // 1 = Blau, 2 = Rot
    private final IntegerProperty currPlayer = new SimpleIntegerProperty(1);
    private final IntegerProperty scorePlayer1 = new SimpleIntegerProperty(0);
    private final IntegerProperty scorePlayer2 = new SimpleIntegerProperty(0);

    // Interner Zug-Zustand => 0 = keine Karte offen, 1 = eine offen, 2 = zwei falsche offen
    private int turnState = 0;

    // aktuell umgedrehte Karten
    private MemoryCard firstCard;
    private MemoryCard secondCard;

    private final List<String> initialTitles;

     // Erhält die Liste der Kartentitel (jeder Titel nur einmal übergeben)
    public MemoryGame(List<String> uniqueTitles) {
        this.initialTitles = uniqueTitles;
        newGame();
    }

    public void newGame() {
        cards.clear();

        // Jede Karte doppelt hinzufügen
        for (String title : initialTitles) {
            cards.add(new MemoryCard(title));
            cards.add(new MemoryCard(title));
        }

        // Karten mischen
        Collections.shuffle(cards);

        // Zustand zurücksetzen
        currPlayer.set(1);
        scorePlayer1.set(0);
        scorePlayer2.set(0);
        turnState = 0;
        firstCard = null;
    }

    public int getNumOfCards() {
        return cards.size();
    }

    public MemoryCard getCard(int index) {
        return cards.get(index);
    }

    public int getCurrPlayer() {
        return currPlayer.get();
    }

    public IntegerProperty currPlayerProperty() {
        return currPlayer;
    }

    public int getScore(int player) {
        return (player == 1) ? scorePlayer1.get() : scorePlayer2.get();
    }

    public IntegerProperty scoreProperty(int player) {
        return (player == 1) ? scorePlayer1 : scorePlayer2;
    }


     // Zentrale Spiellogik. Wird aufgerufen, wenn eine Karte angeklickt wird.
    public void turnCard(int index) {
        // Index-Validierung
        if (index < 0 || index >= cards.size()){
            return;
        }

        MemoryCard clickedCard = cards.get(index);

        // Zwei falsche Karten liegen offen
        // Der aktuelle Klick dient nur dazu, die Karten umzudrehen und den Spieler zu wechseln.
        if (turnState == 2) {
            firstCard.setRevealed(false);
            secondCard.setRevealed(false);
            firstCard = null;
            secondCard = null;

            // Spieler wechseln (Wechsel zwischen 1 und 2)
            currPlayer.set(currPlayer.get() == 1 ? 2 : 1);

            turnState = 0;
            return;
        }

        // Bereits gefundene Karten dürfen nicht geklickt werden
        if (clickedCard.getOwner() != 0) {
            return;
        }

        // Noch keine Karte aufgedreht
        if (turnState == 0) {
            clickedCard.setRevealed(true);
            firstCard = clickedCard;
            turnState = 1;
        }

        // Eine Karte liegt bereits offen
        else if (turnState == 1) {
            // Dieselbe Karte darf nicht noch mal geklickt werden
            if (clickedCard == firstCard) {
                return;
            }

            clickedCard.setRevealed(true);

            // Paartest
            if (firstCard.equals(clickedCard)) {
                // Treffer => Karten gehören dem aktuellen Spieler
                firstCard.setOwner(currPlayer.get());
                clickedCard.setOwner(currPlayer.get());

                // Score hochzählen
                if (currPlayer.get() == 1) {
                    scorePlayer1.set(scorePlayer1.get() + 1);
                } else {
                    scorePlayer2.set(scorePlayer2.get() + 1);
                }

                // Zustand zurücksetzen => Aktueller Spieler darf im Zustand 0 direkt nochmal
                firstCard = null;
                turnState = 0;
            } else {
                secondCard = clickedCard;
                turnState = 2; // Blockiert das Spiel für den nächsten "Aufräum-Klick"
            }
        }
    }

     //Überprüfen, ob das Spiel vorbei ist.
    public boolean isGameOver() {
        for (MemoryCard card : cards) {
            if (card.getOwner() == 0) {
                return false; // Es gibt noch mindestens eine freie Karte
            }
        }
        return true;
    }
}
