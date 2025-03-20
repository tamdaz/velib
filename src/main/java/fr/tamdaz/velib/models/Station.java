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

    public Station(String name) {
        this.name = new SimpleStringProperty(name);
    }

    public String getName() {
        return this.name.get();
    }

    public String getStationCode() {
        return this.stationCode.get();
    }

    public void setStationCode(String stationCode) {
        this.stationCode = new SimpleStringProperty(stationCode);
    }

    public boolean getIsInstalled() {
        return this.isInstalled.get();
    }

    public void setIsInstalled(boolean isInstalled) {
        this.isInstalled = new SimpleBooleanProperty(isInstalled);
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getNumberDocksAvailable() {
        return this.numberDocksAvailable;
    }

    public void setNumberDocksAvailable(int numberDocksAvailable) {
        this.numberDocksAvailable = numberDocksAvailable;
    }

    public int getNumberBikesAvailable() {
        return this.numberBikesAvailable;
    }

    public void setNumberBikesAvailable(int numberBikesAvailable) {
        this.numberBikesAvailable = numberBikesAvailable;
    }

    public int getMechanical() {
        return this.mechanical;
    }

    public void setMechanical(int mechanical) {
        this.mechanical = mechanical;
    }

    public int getEbike() {
        return this.ebike;
    }

    public void setEbike(int ebike) {
        this.ebike = ebike;
    }

    public boolean getIsRenting() {
        return this.isRenting.get();
    }

    public void setIsRenting(boolean isRenting) {
        this.isRenting = new SimpleBooleanProperty(isRenting);
    }

    public boolean getIsReturning() {
        return this.isReturning;
    }

    public void setIsReturning(boolean isReturning) {
        this.isReturning = isReturning;
    }

    public Instant getDueDate() {
        return this.dueDate;
    }

    public void setDueDate(Instant dueDate) {
        this.dueDate = dueDate;
    }

    public Coordinates getCoordinates() {
        return this.coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public String getArrondissementName() {
        return this.arrondissementName;
    }

    public void setArrondissementName(String arrondissementName) {
        this.arrondissementName = arrondissementName;
    }

    public String getMunicipalityCodeInsee() {
        return this.municipalityCodeInsee;
    }

    public void setMunicipalityCodeInsee(String municipalityCodeInsee) {
        this.municipalityCodeInsee = municipalityCodeInsee;
    }

    public void filtreArrondissement(String arrondissementName){
        
    }
}
