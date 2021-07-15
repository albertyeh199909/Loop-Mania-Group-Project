package test.buildings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import unsw.loopmania.*;

public class VillageTest {
    @Test
    public void testConstructor() {
        Village village = new Village();

        assertTrue(village.getType().equals("Village"));
        assertTrue(village.getPlacement() == 1);
    }
}