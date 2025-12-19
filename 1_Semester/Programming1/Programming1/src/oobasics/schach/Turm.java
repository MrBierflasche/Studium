package oobasics.schach;

public class Turm extends Figur {
    protected Turm(Farbe farbe) {
        super(farbe);
    }

    @Override
    public boolean istZugErlaubt(Brett brett, Feld start, Feld ziel) {
        return false;
    }
}
