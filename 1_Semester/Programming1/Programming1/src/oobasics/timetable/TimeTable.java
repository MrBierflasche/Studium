package oobasics.timetable;

public class TimeTable {
    private  TimeTableItem[] items = new TimeTableItem[7*6];
    private int size;

    public void addItem(TimeTableItem item) {
        items[size++] = item;
    }
}
