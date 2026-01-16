package oobasics.vorbereitung;

public class Position {
    double latitude;
    double longitude;
    public Position(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Position position = (Position) obj;
        return (this.latitude == position.latitude && this.longitude == position.longitude);
    }

    @Override
    public int hashCode() {
        return (int)(this.latitude * 21 + this.latitude * 11);
    }
}
