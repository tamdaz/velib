package fr.tamdaz.velib.models;

import java.time.Instant;

/**
 * Modèle contenant des informations sur une station.
 */
public class Station {
    /**
     * Nom de la station.
     */
    private String name;

    /**
     * Numéro de la station.
     */
    private String stationCode;

    /**
     * Statut de la station (opérationnelle ou non).
     */
    private boolean isInstalled;

    /**
     * Statut de la borne de paiement (opérationnelle ou non).
     */
    private boolean isRenting;

    /**
     * Informations sur la capacité des vélos que peut avoir une station.
     */
    private BikesCapacity bikesCapacity;

    /**
     * Est-ce que la station peut recevoir des vélos ?
     */
    private boolean isReturning;

    /**
     * Date d'actualisation des données de la station.
     */
    private Instant dueDate;

    /**
     * Coordonnées de la station.
     */
    private Coordinates coordinates;

    /**
     * Nom de l'arrondissement.
     */
    private String arrondissement;

    /**
     * Nom de la ville.
     */
    private String cityName;

    /**
     * Le code INSEE de la commune.
     */
    private String municipalityCodeInsee;

    /**
     * Passer le nom et le code de la station en paramètre.
     * 
     * @param name
     * @param stationCode
     */
    public Station(String name, String stationCode) {
        this.name = name;
        this.stationCode = stationCode;
    }

    /**
     * Récupérer le nom de la station.
     * 
     * @return
     */
    public String getName() {
        return this.name;
    }

    /**
     * Récupérer le numéro de la station.
     * 
     * @return
     */
    public String getStationCode() {
        return this.stationCode;
    }

    /**
     * Retourne le statut de la station.
     * 
     * @return
     */
    public String getIsInstalled() {
        if (this.isInstalled) {
            return "Oui";
        } else {
            return "Non";
        }
    }

    /**
     * Définir le statut de la station.
     * 
     * @param isInstalled
     */
    public void setIsInstalled(boolean isInstalled) {
        this.isInstalled = isInstalled;
    }

    /**
     * Retourne le statut de la borne de paiement.
     * 
     * @return
     */
    public String getIsRenting() {
        if (this.isRenting) {
            return "Oui";
        } else {
            return "Non";
        }
    }

    /**
     * Définir le statut de la borne de paiement.
     * 
     * @param isRenting
     */
    public void setIsRenting(boolean isRenting) {
        this.isRenting = isRenting;
    }

    /**
     * Retourne des informations sur la capacité des vélos que peut avoir une
     * station.
     * 
     * @return
     */
    public BikesCapacity getBikesCapacity() {
        return this.bikesCapacity;
    }

    /**
     * Définir des informations sur la capacité des vélos que peut avoir une
     * station.
     * 
     * @param bikesCapacity
     */
    public void setBikesCapacity(BikesCapacity bikesCapacity) {
        this.bikesCapacity = bikesCapacity;
    }

    /**
     * Retourne si la station peut recevoir des vélos.
     * 
     * @return
     */
    public String getIsReturning() {
        if (this.isReturning) {
            return "Oui";
        } else {
            return "Non";
        }
    }

    /**
     * Définir la possibilité de recevoir des vélos.
     * 
     * @param isReturning
     */
    public void setIsReturning(boolean isReturning) {
        this.isReturning = isReturning;
    }

    /**
     * Retourne la date d'actualisation des données.
     * 
     * @return
     */
    public Instant getDueDate() {
        return this.dueDate;
    }

    /**
     * Définir la date d'actualisation des données.
     * 
     * @param dueDate
     */
    public void setDueDate(Instant dueDate) {
        this.dueDate = dueDate;
    }

    /**
     * Retourne les coordonnées de la station.
     * 
     * @return
     */
    public Coordinates getCoordinates() {
        return this.coordinates;
    }

    /**
     * Définir les coordonnées de la station.
     * 
     * @param coordinates
     */
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    /**
     * Retourne le nom de l'arrondissement.
     * 
     * @return
     */
    public String getArrondissement() {
        return this.arrondissement;
    }

    /**
     * Définir le nom de l'arrondissement.
     * 
     * @param arrondissement
     */
    public void setArrondissement(String arrondissement) {
        this.arrondissement = arrondissement;
    }

    /**
     * Retourne le nom de la ville.
     * 
     * @return
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * Définir le nom de la ville.
     * 
     * @param cityName
     */
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    /**
     * Retourne le code INSEE de la commune.
     * 
     * @return
     */
    public String getMunicipalityCodeInsee() {
        return this.municipalityCodeInsee;
    }

    /**
     * Définir le code INSEE de la commune.
     * 
     * @param municipalityCodeInsee
     */
    public void setMunicipalityCodeInsee(String municipalityCodeInsee) {
        this.municipalityCodeInsee = municipalityCodeInsee;
    }

    /**
     * Effectuer un filtre de l'arrondissement.
     * 
     * @param arrondissement
     */
    public void filtreArrondissement(String arrondissement) {
        // ...
    }
}
