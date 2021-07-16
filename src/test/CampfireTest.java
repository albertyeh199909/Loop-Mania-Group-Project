package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import unsw.loopmania.*;

public class CampfireTest {
    @Test
    public void testConstructor() {
        int x = 0;
        int y = 0;
        Campfire campfire = new Campfire(x, y);

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