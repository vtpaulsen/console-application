import java.lang.*;

/**
 * This code is taken from the following:
 * https://www.geodatasource.com/resources/tutorials/how-to-calculate-the-distance-between-2-locations-using-java/
 */
class DistanceCalculator {

    public static double distance(Airport departure, Airport arrival, String unit) {
        // I changed the method signature to take in two Airport objects instead of four doubles.
        double lat1 = departure.getLatitude();
        double lon1 = departure.getLongitude();
        double lat2 = arrival.getLatitude();
        double lon2 = arrival.getLongitude();

        if ((lat1 == lat2) && (lon1 == lon2)) {
            return 0;
        }
        else {
            double theta = lon1 - lon2;
            double dist = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2)) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.cos(Math.toRadians(theta));
            dist = Math.acos(dist);
            dist = Math.toDegrees(dist);
            dist = dist * 60 * 1.1515;
            if (unit.equals("K")) {
                dist = dist * 1.609344;
            } else if (unit.equals("N")) {
                dist = dist * 0.8684;
            }
            return (dist);
        }
    }
}