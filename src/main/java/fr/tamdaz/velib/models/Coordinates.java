package fr.tamdaz.velib.models;

/**
 * Coordonnées géographiques qui peuvent être utilisés pour des stations.
 */
public class Coordinates {
    /**
     * Longitude de la position de la station.
     */
    private final double longitude;

    /**
     * Lattiude de la position de la station.
     */
    private final double latitude;

    /**
     * Constructeur qui prend en paramètre la longitude et la lattitude.
     * 
     * @param longitude
     * @param latitude
     */
    public Coordinates(double longitude, double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    /**
     * Retourne la longitude.
     * 
     * @return
     */
    public double getLongitude() {
        return this.longitude;
    }

    /**
     * Retourne la longitude sous format degrés, minutes et secondes.
     * 
     * @return
     */
    public String getLitteralLongitude() {
        int hours = (int) this.longitude;

        double tmpMinutes = (this.longitude - hours) * 60;
        int minutes = (int) tmpMinutes;

        double seconds = (tmpMinutes - minutes) * 60;

        return String.format("%d° %d' %.2f\"", hours, minutes, seconds);
    }

    /**
     * Retourne la lattitude.
     * 
     * @return
     */
    public double getLatitude() {
        return this.latitude;
    }

    /**
     * Retourne la lattitude sous format degrés, minutes et secondes.
     * 
     * @return
     */
    public String getLitteralLatitude() {
        int hours = (int) this.latitude;

        double tmpMinutes = (this.latitude - hours) * 60;
        int minutes = (int) tmpMinutes;

        double seconds = (tmpMinutes - minutes) * 60;

        return String.format("%d° %d' %.2f\"", hours, minutes, seconds);
    }
}
