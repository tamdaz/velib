package fr.tamdaz.velib.models;

import java.time.Instant;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Modèle contenant des informations sur une station.
 */
public class Station {
    /**
     * Nom de la station.
     */
    private SimpleStringProperty name;

    /**
     * Numéro de la station.
     */
    private SimpleStringProperty stationCode;

    /**
     * Statut de la station (opérationnelle ou non).
     */
    private SimpleBooleanProperty isInstalled;

    /**
     * Statut de la borne de paiement (opérationnelle ou non).
     */
    private SimpleBooleanProperty isRenting;

    /**
     * Nombre maximal de vélos alloués.
     */
    private int capacity;

    /**
     * Nombre de bornettes disponibles.
     */
    private int numberDocksAvailable;

    /**
     * Nombre de vélos disponibles.
     */
    private int numberBikesAvailable;

    /**
     * Nombre de vélos éléctriques disponibles parmi tous les vélos.
     */
    private int ebike;

    /**
     * Nombre de vélos mécaniques disponibles parmi tous les vélos.
     */
    private int mechanical;

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
    private String arrondissementName;

    /**
     * Le code INSEE de la commune.
     */
    private String municipalityCodeInsee;

    /**
     * Passer le nom et le code de la station en paramètre.
     * @param name
     * @param stationCode
     */
    public Station(String name, String stationCode) {
        this.name = new SimpleStringProperty(name);
        this.stationCode = new SimpleStringProperty(stationCode);
    }

    /**
     * Récupérer le nom de la station.
     * @return
     */
    public String getName() {
        return this.name.get();
    }

    /**
     * Récupérer le numéro de la station.
     * @return
     */
    public String getStationCode() {
        return this.stationCode.get();
    }

    /**
     * Retourne le statut de la station.
     * @return
     */
    public String getIsInstalled() {
        if (this.isInstalled.get()) {
            return "Oui";
        } else {
            return "Non";
        }
    }

    /**
     * Définir le statut de la station.
     * @param isInstalled
     */
    public void setIsInstalled(boolean isInstalled) {
        this.isInstalled = new SimpleBooleanProperty(isInstalled);
    }

    /**
     * Retourne le nombre alloué de vélos.
     * @return
     */
    public int getCapacity() {
        return this.capacity;
    }

    /**
     * Définir le nombre maximal de vélos disponibles.
     * @param capacity
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * Retourne le nombre de bornettes disponibles.
     * @return
     */
    public int getNumberDocksAvailable() {
        return this.numberDocksAvailable;
    }

    /**
     * Définir le nombre de bornettes disponibles.
     * @param numberDocksAvailable
     */
    public void setNumberDocksAvailable(int numberDocksAvailable) {
        this.numberDocksAvailable = numberDocksAvailable;
    }

    /**
     * Retourne le nombre de vélos disponibles.
     * @return
     */
    public int getNumberBikesAvailable() {
        return this.numberBikesAvailable;
    }

    /**
     * Définir le nombre de vélos disponibles.
     * @param numberBikesAvailable
     */
    public void setNumberBikesAvailable(int numberBikesAvailable) {
        this.numberBikesAvailable = numberBikesAvailable;
    }

    /**
     * Retourne le nombre de vélos mécaniques disponibles.
     * @return
     */
    public int getMechanical() {
        return this.mechanical;
    }

    /**
     * Définir le nombre de vélos mécaniques disponibles.
     * @param mechanical
     */
    public void setMechanical(int mechanical) {
        this.mechanical = mechanical;
    }

    /**
     * Retourne le nombre de vélos électriques disponibles.
     * @return
     */
    public int getEbike() {
        return this.ebike;
    }

    /**
     * Définir le nombre de vélos électriques disponibles.
     * @param ebike
     */
    public void setEbike(int ebike) {
        this.ebike = ebike;
    }

    /**
     * Retourne le statut de la borne de paiement.
     * @return
     */
    public String getIsRenting() {
        if (this.isRenting.get()) {
            return "Oui";
        } else {
            return "Non";
        }
    }

    /**
     * Définir le statut de la borne de paiement.
     * @param isRenting
     */
    public void setIsRenting(boolean isRenting) {
        this.isRenting = new SimpleBooleanProperty(isRenting);
    }

    /**
     * Retourne si la station peut recevoir des vélos.
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
     * @param isReturning
     */
    public void setIsReturning(boolean isReturning) {
        this.isReturning = isReturning;
    }

    /**
     * Retourne la date d'actualisation des données.
     * @return
     */
    public Instant getDueDate() {
        return this.dueDate;
    }

    /**
     * Définir la date d'actualisation des données.
     * @param dueDate
     */
    public void setDueDate(Instant dueDate) {
        this.dueDate = dueDate;
    }

    /**
     * Retourne les coordonnées de la station.
     * @return
     */
    public Coordinates getCoordinates() {
        return this.coordinates;
    }

    /**
     * Définir les coordonnées de la station.
     * @param coordinates
     */
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    /**
     * Retourne le nom de l'arrondissement.
     * @return
     */
    public String getArrondissementName() {
        return this.arrondissementName;
    }

    /**
     * Définir le nom de l'arrondissement.
     * @param arrondissementName
     */
    public void setArrondissementName(String arrondissementName) {
        this.arrondissementName = arrondissementName;
    }

    /**
     * Retourne le code INSEE de la commune.
     * @return
     */
    public String getMunicipalityCodeInsee() {
        return this.municipalityCodeInsee;
    }

    /**
     * Définir le code INSEE de la commune.
     * @param municipalityCodeInsee
     */
    public void setMunicipalityCodeInsee(String municipalityCodeInsee) {
        this.municipalityCodeInsee = municipalityCodeInsee;
    }

    /**
     * Effectuer un filtre de l'arrondissement.
     * @param arrondissementName
     */
    public void filtreArrondissement(String arrondissementName){
        // ...
    }
}
