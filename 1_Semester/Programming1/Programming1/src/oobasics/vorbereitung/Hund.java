package oobasics.vorbereitung;

public class Hund extends Tier{
    public Hund(String name, int alter) {
        super(name, alter);
    }

    public void laute() {
        System.out.println("wauwau");
    }
}
