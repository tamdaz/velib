package fr.tamdaz.velib.services;

import java.time.Instant;
import java.io.IOException;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import org.json.JSONArray;
import org.json.JSONObject;

import fr.tamdaz.velib.models.Station;
import fr.tamdaz.velib.models.collection.StationCollection;
import fr.tamdaz.velib.App;
import fr.tamdaz.velib.models.Coordinates;

/**
 * Une passerelle qui permet de collecter et de traiter des informations
 * sur des stations.
 */
public class Gateway {
    public void start() throws IOException {
        String jsonData = this.getFileContent("data.json");
        JSONArray jsonArray = new JSONArray(jsonData);

        for (Object json : jsonArray) {
            JSONObject line = (JSONObject) json;

            String stationName = line.getString("name");
            String stationCode = line.getString("stationcode");
            boolean isInstalled = line.getString("is_installed").equalsIgnoreCase("OUI");
            boolean isRenting = line.getString("is_renting").equalsIgnoreCase("OUI");
            boolean isReturning = line.getString("is_returning").equalsIgnoreCase("OUI");

            Station station = new Station(stationName);
            station.setStationCode(stationCode);
            station.setIsInstalled(isInstalled);
            station.setCapacity(line.getInt("capacity"));
            station.setNumberDocksAvailable(line.getInt("numdocksavailable"));
            station.setNumberBikesAvailable(line.getInt("numbikesavailable"));
            station.setMechanical(line.getInt("mechanical"));
            station.setEbike(line.getInt("ebike"));
            station.setIsRenting(isRenting);
            station.setIsReturning(isReturning);
            Instant instant = Instant.parse(line.getString("duedate"));
            station.setDueDate(instant);

            JSONObject coordinatesObject = line.getJSONObject("coordonnees_geo");

            Coordinates coordinates = new Coordinates(
                coordinatesObject.getDouble("lon"),
                coordinatesObject.getDouble("lat")
            );
            
            station.setCoordinates(coordinates);
            station.setArrondissementName(line.getString("nom_arrondissement_communes"));
            station.setMunicipalityCodeInsee(line.getString("code_insee_commune"));

            StationCollection.addStation(station);
        }
    }

    /**
     * Permet de lire le contenu du fichier dans une ressource.
     * @param fileName Nom du fichier.
     * @return
     */
    private String getFileContent(String fileName) {
        InputStream inputStream = App.class.getResourceAsStream(fileName);
        String output = "";
        
        if (inputStream != null) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            BufferedReader reader = new BufferedReader(inputStreamReader);

            try {
                String line;
                while ((line = reader.readLine()) != null) {
                    output += line + "\n";
                }
            } catch (Exception e) {
                System.err.println("Impossible de lire le fichier " + fileName);
            }
        }

        return output;
    }
}
