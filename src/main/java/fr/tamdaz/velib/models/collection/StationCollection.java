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
     * 
     * @return Liste de stations
     */
    public static ArrayList<Station> getStations() {
        return stations;
    }

    /**
     * Ajouter une nouvelle station dans une liste.
     * 
     * @param newStation Nouvelle station
     */
    public static void addStation(Station newStation) {
        stations.add(newStation);
    }

    /**
     * Filtrer les stations par arrondissement.
     * 
     * @return
     */
    public static ArrayList<Station> filterStationByArrondissement(String numArrondissement) {
        ArrayList<Station> filteredStation = new ArrayList<Station>();

        for (Station station : stations) {
            if (station.getInseeCode().startsWith("75")) {
                if (station.getStationCode().length() == 5) {
                    String arrondissement = station.getStationCode().substring(0, 2);

                    if (arrondissement.equals(numArrondissement)) {
                        filteredStation.add(station);
                    }
                }
                
                if (station.getStationCode().length() == 4) {
                    String arrondissement = station.getStationCode().substring(0, 1);

                    if (arrondissement.equals(numArrondissement)) {
                        filteredStation.add(station);
                    }
                }
            }
        }

        return filteredStation;
    }

    /**
     * Filtrer les stations par département.
     * 
     * @return
     */
    public static ArrayList<Station> filterStationByDepartment(String numDepartement) {
        ArrayList<Station> filteredStation = new ArrayList<Station>();

        for (Station station : stations) {
            if (station.getInseeCode().startsWith(numDepartement)) {
                filteredStation.add(station);
            }
        }

        return filteredStation;
    }

    /**
     * Retourne des stations mobiles (plages stations >= 92 000).
     * 
     * @return
     */
    public static ArrayList<Station> filterStationByMobile() {
        ArrayList<Station> filteredStation = new ArrayList<Station>();

        for (Station station : stations) {
            int plagesMobile = Integer.parseInt(station.getStationCode().substring(0, 2));

            if (plagesMobile >= 92) {
                filteredStation.add(station);
            }
        }

        return filteredStation;
    }
}
