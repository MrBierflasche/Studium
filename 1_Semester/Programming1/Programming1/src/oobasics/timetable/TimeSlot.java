package oobasics.timetable;

public enum TimeSlot {
    FIRST(8, 0),
    SECOND(9, 50),
    THIRD(11,30);
    //...
    private TimeSlot(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }
    private int hour;
    private int minute;

    private int GetHour() {
        return hour;
    }
    private int GetMinute() {
        return minute;
    }
}
