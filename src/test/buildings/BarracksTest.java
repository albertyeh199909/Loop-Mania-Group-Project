package test.buildings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import unsw.loopmania.*;

public class BarracksTest {
    @Test
    public void testConstructor() {
        Barracks barracks = new Barracks();

        assertTrue(barracks.getType().equals("Barracks"));
        assertTrue(barracks.getPlacement() == 1);
    }
}