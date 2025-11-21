package oobasics;

public class Rectangle {
    private int left;
    private int bottom;
    private int width;
    private int height;

    public Rectangle(int left, int bottom, int width, int height) {
        this.left = left;
        this.bottom = bottom;
        this.width = width;
        this.height = height;
    }

    public int getLeft() {
        return left;
    }

    public int getRight (){
        return left + width;
    }

    public int getBottom() {
        return bottom;
    }

    public int getTop(){
        return bottom + height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }


    public boolean isDisjoint(Rectangle r) {
        boolean rAbove= this.getTop() <= r.getBottom();
        boolean rBelow= this.getBottom() >= r.getTop();
        boolean rLeft = this.getLeft() >= r.getRight();
        boolean rRight = this.getRight() <= r.getLeft();

        return getLeft() >= r.getRight() || getRight() <= r.getLeft() || getTop() <= r.getBottom() || getBottom() >= r.getTop();
    }
}
