package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import unsw.loopmania.*;

public class BarracksTest {
    @Test
    public void testConstructor() {
        int x = 0;
        int y = 0;
        Barracks barracks = new Barracks(x, y);

        // Generic Building properties
        // - Check if the building is a barrack
        // - Check where it can be placed
        assertTrue(barracks.getType().equals("Barracks"));
        assertTrue(barracks.getPlacement() == 1);
    }
}