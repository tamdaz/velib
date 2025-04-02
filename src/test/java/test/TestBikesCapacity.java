package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import fr.tamdaz.velib.models.BikesCapacity;

public class TestBikesCapacity {
    /**
     * Attribut pour tester cette classe.
     */
    private BikesCapacity bikesCapacity = new BikesCapacity();

    /**
     * Définir les valeurs pour tester.
     */
    @Before
    public void setUp() {
        bikesCapacity.setCapacity(30);
        bikesCapacity.setEbike(7);
        bikesCapacity.setMechanical(4);
        bikesCapacity.setNumberBikesAvailable(11);
        bikesCapacity.setNumberDocksAvailable(10);
    }

    /**
     * Vérifie que le nombre de vélos est égal à la somme
     * des vélos électriques et des vélos mécaniques
     */
    @Test
    public void testBikesCapacityIsCreated() {
        int numberEbikes = bikesCapacity.getEbike();
        int numberMechanical = bikesCapacity.getMechanical();
        int numberBikesAvailable = bikesCapacity.getNumberBikesAvailable();
        int numberBikesVerification = numberEbikes + numberMechanical;

        if (numberBikesVerification == numberBikesAvailable) {
            assertNotNull(this.bikesCapacity);
        } else {
            fail("erreur lors de la création de la classe BikesCapacity :( )");
        }
    }

    /**
     * Vérifie que les valeurs correspondent à celles définies.
     */
    @Test
    public void testVerifyValues() {
        int numberBikesCapacity = bikesCapacity.getCapacity();
        int numberDocksAvailable = bikesCapacity.getNumberDocksAvailable();
        int numberEbikes = bikesCapacity.getEbike();
        int numberMechanical = bikesCapacity.getMechanical();
        int numberBikesAvailable = bikesCapacity.getNumberBikesAvailable();

        assertEquals(numberBikesCapacity, 30);
        assertEquals(numberDocksAvailable, 10);
        assertEquals(numberEbikes, 7);
        assertEquals(numberMechanical, 4);
        assertEquals(numberBikesAvailable, 11);
    }
}
