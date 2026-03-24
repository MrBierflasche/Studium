package ms.prog2.exercises.set03;

import java.util.Arrays;

public class Tour {
    private final Place[] places;

    public Tour(Place... places) {
        this.places = places;
    }

    public Place[] getPlaces() {
        return places;
    }
}
