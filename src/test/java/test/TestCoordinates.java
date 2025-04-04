package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fr.tamdaz.velib.models.Coordinates;

public class TestCoordinates {
    private Coordinates coordinatesAttribute = new Coordinates(2.2784192115068, 48.836395736424);

    /**
     * Vérifier que la classe Coordinates est bien instancié.
     */
    @Test
    public void testCoordinatesIsCreated() {
        assertNotNull(this.coordinatesAttribute);
    }

    /**
     * Vérifier que les coordonnées sous format décimales correspondent
     * aux valeurs attendues.
     */
    @Test
    public void testCoordinatesDataIsCorrect() {
        assertTrue(this.coordinatesAttribute.getLongitude() == 2.2784192115068);
        assertTrue(this.coordinatesAttribute.getLatitude() == 48.836395736424);
    }

    /**
     * Vérifier que les coordonnées qui sous format degrés minutes secondes
     * correspondent aux valeurs attendues.
     */
    @Test
    public void testCoordinatesCanBeConvertedToHoursMinutesSeconds() {
        assertEquals("2° 16' 42,31\"", this.coordinatesAttribute.getLitteralLongitude());
        assertEquals("48° 50' 11,02\"", this.coordinatesAttribute.getLitteralLattitude());
    }
}
