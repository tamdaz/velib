package fr.tamdaz.velib.models;

/**
 * Informations sur la capacité des vélos de tous types.
 */
public class BikesCapacity {
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
     * Retourne le nombre de vélos alloués à une station.
     * 
     * @return
     */
    public int getCapacity() {
        return this.capacity;
    }

    /**
     * Définir le nombre de vélos alloués à une station.
     * 
     * @param capacity
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * Retourne le nombre de bornettes disponibles.
     * 
     * @return
     */
    public int getNumberDocksAvailable() {
        return this.numberDocksAvailable;
    }

    /**
     * Définir le nombre de bornettes disponibles.
     * 
     * @param numberDocksAvailable
     */
    public void setNumberDocksAvailable(int numberDocksAvailable) {
        this.numberDocksAvailable = numberDocksAvailable;
    }

    /**
     * Retourne le nombre de vélos disponibles.
     * 
     * @return
     */
    public int getNumberBikesAvailable() {
        return this.numberBikesAvailable;
    }

    /**
     * Définir le nombre de vélos disponibles.
     * 
     * @param numberBikesAvailable
     */
    public void setNumberBikesAvailable(int numberBikesAvailable) {
        this.numberBikesAvailable = numberBikesAvailable;
    }

    /**
     * Retourne le nombre de vélos électriques disponibles.
     * 
     * @return
     */
    public int getEbike() {
        return this.ebike;
    }

    /**
     * Définir le nombre de vélos électriques disponibles.
     * 
     * @param ebike
     */
    public void setEbike(int ebike) {
        this.ebike = ebike;
    }

    /**
     * Retourne le nombre de vélos mécaniques disponibles.
     * 
     * @return
     */
    public int getMechanical() {
        return this.mechanical;
    }

    /**
     * Définir le nombre de vélos mécaniques disponibles.
     * 
     * @param mechanical
     */
    public void setMechanical(int mechanical) {
        this.mechanical = mechanical;
    }
}
