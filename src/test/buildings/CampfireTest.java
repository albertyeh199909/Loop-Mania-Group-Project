package test.buildings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import unsw.loopmania.*;

public class CampfireTest {
    @Test
    public void testConstructor() {
        Campfire campfire = new Campfire();

        // Generic Building properties
        // - Check if the building is a campfire
        // - Check where it can be placed
        assertTrue(campfire.getType().equals("Campfire"));
        assertTrue(campfire.getPlacement() == 2);

        // Campfire properties
        // - Check its buff radius
        assertTrue(campfire.getBuffRadius() == 1);
    }
}