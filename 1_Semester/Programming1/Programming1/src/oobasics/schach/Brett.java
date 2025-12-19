package oobasics.schach;

public class Brett {
    private final Feld[][] felder;

    public Brett() {
        this.felder = new Feld[8][8];
    }

    public Feld getFeld(char linie, int reihe){
        return felder[linie - 'A'][reihe-1];
    }

    private void setFeld(Feld feld, char linie, int reihe){
        felder[linie - 'A'][reihe-1] = feld;
    }
}
