package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import fr.tamdaz.velib.models.Coordinates;
import fr.tamdaz.velib.models.Station;
import fr.tamdaz.velib.models.collection.StationCollection;

public class TestStation {
    private static Station station;

    @BeforeClass
    public static void setUp() {
        station = new Station("stationTest", "404");
        Coordinates coordinates = new Coordinates(1.5, 1.6);
        
        station.setIsInstalled(false);
        station.setIsRenting(false);
        station.setIsReturning(false);
        station.setArrondissement("loin là-bas");
        station.setInseeCode("75000");
        station.setCoordinates(coordinates);
    }

    /**
     * Vérifier que les informations ne sont pas nulles.
     */
    @Test
    public void testStationInfoIsNotNull() {
        assertNotNull(station);
    }

    /**
     * Vérifier que les informations correspondent aux valeurs attendues.
     */
    @Test
    public void testStationSameDatas() {
        assertEquals(station.getName(), "stationTest");
        assertEquals(station.getStationCode(), "404");
        assertEquals(station.getIsInstalled(), "Non");
        assertEquals(station.getIsRenting(), "Non");
        assertEquals(station.getIsReturning(), "Non");
        assertEquals(station.getArrondissement(), "loin là-bas");
        assertEquals(station.getInseeCode(), "75000");
    }
    
    /**
     * Vérifier que les coordonnées peuvent être ajoutées à une station.
     */
    @Test
    public void testStationSettingCoordinates() {
        assertTrue(station.getCoordinates().getLongitude() == 1.5);
        assertTrue(station.getCoordinates().getLatitude() == 1.6);
    }

    /**
     * Vérifier qu'on peut filtrer les stations par arrondissement.
     */
    @Test
    public void testStationFilteredArrondissement() {
        ArrayList<Station> filteredStationsArr1 = StationCollection.filterStationByArrondissement("1");
        assertEquals(26, filteredStationsArr1.size());

        ArrayList<Station> filteredStationsArr2 = StationCollection.filterStationByArrondissement("2");
        assertEquals(23, filteredStationsArr2.size());

        ArrayList<Station> filteredStationsArr3 = StationCollection.filterStationByArrondissement("3");
        assertEquals(15, filteredStationsArr3.size());

        ArrayList<Station> filteredStationsArr4 = StationCollection.filterStationByArrondissement("4");
        assertEquals(26, filteredStationsArr4.size());

        ArrayList<Station> filteredStationsArr5 = StationCollection.filterStationByArrondissement("5");
        assertEquals(36, filteredStationsArr5.size());

        ArrayList<Station> filteredStationsArr6 = StationCollection.filterStationByArrondissement("6");
        assertEquals(33, filteredStationsArr6.size());

        ArrayList<Station> filteredStationsArr7 = StationCollection.filterStationByArrondissement("7");
        assertEquals(27, filteredStationsArr7.size());

        ArrayList<Station> filteredStationsArr8 = StationCollection.filterStationByArrondissement("8");
        assertEquals(53, filteredStationsArr8.size());

        ArrayList<Station> filteredStationsArr9 = StationCollection.filterStationByArrondissement("9");
        assertEquals(46, filteredStationsArr9.size());

        ArrayList<Station> filteredStationsArr10 = StationCollection.filterStationByArrondissement("10");
        assertEquals(51, filteredStationsArr10.size());
        
        ArrayList<Station> filteredStationsArr11 = StationCollection.filterStationByArrondissement("11");
        assertEquals(57, filteredStationsArr11.size());

        ArrayList<Station> filteredStationsArr12 = StationCollection.filterStationByArrondissement("12");
        assertEquals(67, filteredStationsArr12.size());

        ArrayList<Station> filteredStationsArr13 = StationCollection.filterStationByArrondissement("13");
        assertEquals(66, filteredStationsArr13.size());

        ArrayList<Station> filteredStationsArr14 = StationCollection.filterStationByArrondissement("14");
        assertEquals(53, filteredStationsArr14.size());

        ArrayList<Station> filteredStationsArr15 = StationCollection.filterStationByArrondissement("15");
        assertEquals(89, filteredStationsArr15.size());

        ArrayList<Station> filteredStationsArr16 = StationCollection.filterStationByArrondissement("16");
        assertEquals(63, filteredStationsArr16.size());

        ArrayList<Station> filteredStationsArr17 = StationCollection.filterStationByArrondissement("17");
        assertEquals(63, filteredStationsArr17.size());

        ArrayList<Station> filteredStationsArr18 = StationCollection.filterStationByArrondissement("18");
        assertEquals(58, filteredStationsArr18.size());

        ArrayList<Station> filteredStationsArr19 = StationCollection.filterStationByArrondissement("19");
        assertEquals(62, filteredStationsArr19.size());

        ArrayList<Station> filteredStationsArr20 = StationCollection.filterStationByArrondissement("20");
        assertEquals(65, filteredStationsArr20.size());
    }

    /**
     * Vérifier qu'on peut filtrer les stations par département.
     */
    @Test
    public void testStationFilteredDepartement() {
        ArrayList<Station> filteredStationsDpt75 = StationCollection.filterStationByDepartement("75");
        assertEquals(981, filteredStationsDpt75.size());

        ArrayList<Station> filteredStationsDpt92 = StationCollection.filterStationByDepartement("92");
        assertEquals(232, filteredStationsDpt92.size());
       
        ArrayList<Station> filteredStationsDpt93 = StationCollection.filterStationByDepartement("93");
        assertEquals(115, filteredStationsDpt93.size());

        ArrayList<Station> filteredStationsDpt94 = StationCollection.filterStationByDepartement("94");
        assertEquals(136, filteredStationsDpt94.size());

        ArrayList<Station> filteredStationsDpt95 = StationCollection.filterStationByDepartement("95");
        assertEquals(7, filteredStationsDpt95.size());
    }

    // Vérifier qu'on peut filtrer les stations par stations mobiles.
    @Test
    public void testStationFilteredMobile() {
        ArrayList<Station> filteredStationMobile = StationCollection.filterStationByMobile();
        assertEquals(8 , filteredStationMobile.size());
    }
}
