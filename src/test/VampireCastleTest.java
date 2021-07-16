package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import unsw.loopmania.*;

public class VampireCastleTest {
    @Test
    public void testConstructor() {
        int x = 0;
        int y = 0;
        VampireCastle vampireCastle = new VampireCastle(x, y);

        // Generic Building properties
        // - Check if the building is a vampire castle
        // - Check where it can be placed
        assertTrue(vampireCastle.getType().equals("Vampire Castle"));
        assertTrue(vampireCastle.getPlacement() == 3);
    }
}