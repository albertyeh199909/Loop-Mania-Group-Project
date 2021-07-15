package test.buildings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import unsw.loopmania.*;

public class VillageTest {
    @Test
    public void testConstructor() {
        Village village = new Village();

        // Generic Building properties
        // - Check if the building is a village
        // - Check where it can be placed
        assertTrue(village.getType().equals("Village"));
        assertTrue(village.getPlacement() == 1);

        // Village properties
        // - Check its heal
        assertTrue(village.getHeal() == 1); 
    }
}