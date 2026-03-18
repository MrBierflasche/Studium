package oobasics.vorbereitung;

public abstract class Tier {
    private final String name;
    private int alter;
    public Tier(String name, int alter) {
        this.name = name;
        this.alter = alter;
    }

    public String getName() {
        return name;
    }
    public int getAlter() {
        return alter;
    }

    public void setAlter(int alter) {
        this.alter = alter;
    }

    public abstract void laute();
}
