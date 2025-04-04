package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.json.JSONArray;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import fr.tamdaz.velib.models.collection.StationCollection;
import fr.tamdaz.velib.services.Gateway;

public class TestData {
    private static int nbTotalStations;

    /**
     * Mise en place avant le test de la classe TestData
     */
    @BeforeClass
    public static void setUp() {
        Gateway.start();
        String jsonContent = Gateway.getFileContent("data.json");
        JSONArray jsonArray = new JSONArray(jsonContent);
        nbTotalStations = jsonArray.length();
    }

    /**
     * Nettoyer la collection de stations une fois cette classe testée.
     */
    @AfterClass
    public static void tearDown() {
        StationCollection.getStations().clear();
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
