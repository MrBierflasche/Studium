package oobasics.vorbereitung;

public class Katze extends Tier {
    public Katze(String name, int alter) {
        super(name, alter);
    }

    public void laute() {
        System.out.println("miaumiau");
    }
}
