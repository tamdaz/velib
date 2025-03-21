package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fr.tamdaz.velib.models.Coordinates;

public class TestCoordinates {
    private Coordinates coordinatesAttribute = new Coordinates(2.2784192115068, 48.836395736424);

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
        assertEquals(
            this.coordinatesAttribute.getLitteralLongitude(),
            "2° 16' 42,31\""
        );

        assertEquals(
            this.coordinatesAttribute.getLitteralLattitude(),
            "48° 50' 11,02\""
        );
    }
}
