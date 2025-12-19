package oobasics.schach;

public abstract class Figur {
    private final Farbe farbe;

    public Farbe getFarbe() {
        return farbe;
    }

    protected Figur(Farbe farbe) {
        this.farbe = farbe;
    }

    public abstract boolean istZugErlaubt(Brett brett, Feld start, Feld ziel);
}
