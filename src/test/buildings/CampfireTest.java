package test.buildings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import unsw.loopmania.*;

public class CampfireTest {
    @Test
    public void testConstructor() {
        Campfire campfire = new Campfire();

        assertTrue(campfire.getType().equals("Campfire"));
        assertTrue(campfire.getPlacement() == 2);
    }
}