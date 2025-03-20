package fr.tamdaz.velib.models;

/**
 * Coordonnées géographiques qui peuvent être utilisés pour des stations.
 */
public class Coordinates {
    private final double longitude;
    private final double latitude;

    public Coordinates(double longitude, double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    /**
     * Retourne la longitude.
     * @return
     */
    public double getLongitude() {
        return this.longitude;
    }

    /**
     * Retourne la lattitude.
     * @return
     */
    public double getLatitude() {
        return this.latitude;
    }
}
