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

    @Test
    public void testDataJSONIsNotNull() {
        String jsonContent = Gateway.getFileContent("data.json");
        assertNotNull(jsonContent);
    }

    @Test
    public void testStationCollection() {
        int tailleListe = StationCollection.getStations().size();
        assertEquals(
            nbTotalStations, 
            tailleListe);

        System.out.println("premier : " + tailleListe);
        System.out.println("second : " + nbTotalStations);
    }
}
