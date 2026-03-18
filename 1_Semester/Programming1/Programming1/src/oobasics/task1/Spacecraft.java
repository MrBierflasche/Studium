package oobasics.task1;

public class Spacecraft implements Cloneable{
    private String type;
    private String name;
    private Tank tank;

    public Spacecraft(String type, String name, Tank tank) {
        this.type = type;
        this.name = name;
        this.tank = tank;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public Tank getTank() {
        return tank;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
       Spacecraft result = (Spacecraft) super.clone();
       result.tank = (Tank) tank.clone();
        return result;
    }
}
