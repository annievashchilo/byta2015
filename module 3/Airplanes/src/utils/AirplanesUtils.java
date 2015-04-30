package utils;

import planes.Plane;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AirplanesUtils {


    /**
     * prints all technical info of planes in aviacompany
     *
     * @param planes
     */
    public static void printPlanesInfo(List<Plane> planes) {
        for (Plane p : planes) {
            System.out.println(p);
        }
    }


    /**
     * Method sorts all airplanes in company by range
     *
     * @return list of sorted planes
     */
    public static List<Plane> sortPlanesByRange(List<Plane> planes) {
        Collections.sort(planes, new Comparator<Plane>() {
            public int compare(Plane plane, Plane t1) {
                return plane.getRange() < t1.getRange() ? -1 : plane.getRange() == t1.getRange() ? 0 : 1;
            }
        });
        return planes;
    }

    /**
     * Method sorts all airplanes in company by speed
     *
     * @param planes all airplanes
     * @return list of sorted airplanes
     */
    public static List<Plane> sortPlanesBySpeed(List<Plane> planes) {
        Collections.sort(planes, new Comparator<Plane>() {
            public int compare(Plane plane, Plane t1) {
                return plane.getSpeed() < t1.getSpeed() ? -1 : plane.getSpeed() == t1.getSpeed() ? 0 : 1;
            }
        });
        return planes;
    }

}
