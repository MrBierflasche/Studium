package oobasics.schach;

public class Feld {
    private final char linie ;
    private final int reihe;
    private Figur figur;
    private final Farbe farbe;

    public Feld(char linie, int reihe, Farbe farbe) {
        this.linie = linie;
        this.reihe = reihe;
        this.farbe = farbe;
    }

    public Farbe getFarbe() {
        return farbe;
    }

    public Figur getFigur() {
        return figur;
    }

    public char getLinie() {
        return linie;
    }
    public int getReihe() {
        return reihe;
    }

    public void setFigur(Figur figur) {
        this.figur = figur;
    }
}
