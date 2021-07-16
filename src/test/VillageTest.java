package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import unsw.loopmania.*;

public class VillageTest {
    @Test
    public void testConstructor() {
        int x = 0;
        int y = 0;
        Village village = new Village(x, y);

        // Generic Building properties
        // - Check if the building is a village
        // - Check where it can be placed
        assertTrue(village.getType().equals("Village"));
        assertTrue(village.getPlacement() == 1);
    }
}