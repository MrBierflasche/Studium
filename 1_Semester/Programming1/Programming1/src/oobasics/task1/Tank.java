package oobasics.task1;

public class Tank implements Cloneable{
    private int level;

    public int getLevel() {
        return level;
    }

    public Tank(int level) {
        this.level = level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return (Tank) super.clone();
    }
}
