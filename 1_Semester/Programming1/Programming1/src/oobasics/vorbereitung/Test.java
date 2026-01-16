package oobasics.vorbereitung;

import java.sql.SQLOutput;

public class Test {
    public static void main(String[] args) {
        Position position = new Position(2.5, 3.0);
        POI poi = new POI(2.5, 3.0 , "hans");
        Position position2 = poi;
        System.out.println(position.equals(poi));
        System.out.println(poi.equals(position));
        System.out.println(position.equals(position2));
        System.out.println(poi.equals(position2));
    }
}
