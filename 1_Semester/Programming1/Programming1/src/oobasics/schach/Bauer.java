package oobasics.schach;

public class Bauer extends Figur {
    public Bauer(Farbe farbe) {
        super(farbe);
    }

    @Override
    public boolean istZugErlaubt(Brett brett, Feld start, Feld ziel) {
        return true;
    }
}
