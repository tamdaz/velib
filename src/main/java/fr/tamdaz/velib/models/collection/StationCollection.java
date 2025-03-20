package fr.tamdaz.velib.models.collection;

import java.util.ArrayList;

import fr.tamdaz.velib.models.Station;

/**
 * Permet d'ajouter une collection de stations pour le traitement des
 * informations.
 */
public class StationCollection {
    /**
     * Contient un ensemble de stations Vélib.
     */
    private static ArrayList<Station> stations = new ArrayList<Station>();

    /**
     * Retourne une liste de stations Vélib.
     * @return Liste de stations
     */
    public static ArrayList<Station> getStations() {
        return stations;
    }
    
    /**
     * Ajouter une nouvelle station dans une liste.
     * @param newStation Nouvelle station
     */
    public static void addStation(Station newStation) {
        stations.add(newStation);
    }
}
