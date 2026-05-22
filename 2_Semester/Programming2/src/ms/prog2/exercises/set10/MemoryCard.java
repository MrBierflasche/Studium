package ms.prog2.exercises.set10;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class MemoryCard {
    private final String title;
    private final BooleanProperty revealed = new SimpleBooleanProperty(false);
    // besitzer: 0 = niemand, 1 = Spieler Blau, 2 = Spieler Rot
    private final IntegerProperty owner = new SimpleIntegerProperty(0);
    private final String imageName; // Dateiname des Bildes

    public MemoryCard(String title, String imageName) {
        this.title = title;
        this.imageName = imageName;
    }

    public String getTitle() {
        return title;
    }
    public String getImageName() {
        return imageName;
    }

    public BooleanProperty revealedProperty() {
        return revealed;
    }

    public boolean isRevealed() {
        return revealed.get();
    }

    public void setRevealed(boolean revealed) {
        this.revealed.set(revealed);
    }

    public IntegerProperty ownerProperty() {
        return owner;
    }

    public int getOwner() {
        return owner.get();
    }

    public void setOwner(int owner) {
        this.owner.set(owner);
    }

    @Override
    public int hashCode() {
        return title.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        MemoryCard other = (MemoryCard) obj;
        return this.title.equals(other.title);
    }
}
