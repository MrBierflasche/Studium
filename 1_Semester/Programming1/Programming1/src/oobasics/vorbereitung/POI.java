package oobasics.vorbereitung;

import java.util.Objects;

public class POI extends Position {

    private String name;
    public POI(double latitude, double longitude, String name) {
        super(latitude, longitude);
        this.name = name;
    }

    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }

        POI poi = (POI) o;
        return name.equals(poi.name);
    }

    public int hashCode() {
        return 3 * super.hashCode() + 7 * name.hashCode();
    }

    public String getName() {
        return name;
    }
}
