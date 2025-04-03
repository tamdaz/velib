package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.json.JSONArray;
import org.junit.BeforeClass;
import org.junit.Test;

import fr.tamdaz.velib.models.collection.StationCollection;
import fr.tamdaz.velib.services.Gateway;

public class TestData {
    private static int nbTotalStations;

    @BeforeClass
    public static void setUp() {
        Gateway.start();
        String jsonContent = Gateway.getFileContent("data.json");
        JSONArray jsonArray = new JSONArray(jsonContent);
        nbTotalStations = jsonArray.length();
    }

    /**
     * Vérifier que le fichier "data.json" ne contient pas de données vides.
     */
    @Test
    public void testDataJSONIsNotNull() {
        String jsonContent = Gateway.getFileContent("data.json");
        assertNotNull(jsonContent);
    }

    /**
     * Vérifier que l'ensemble des stations sont enregistrées dans la collection
     * StationCollection.
     */
    @Test
    public void testStationCollection() {
        int tailleListe = StationCollection.getStations().size();
        assertEquals(nbTotalStations, tailleListe);
    }
}
