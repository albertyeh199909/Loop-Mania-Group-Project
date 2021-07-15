package test.buildings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import unsw.loopmania.*;

public class VampireCastleTest {
    @Test
    public void testConstructor() {
        VampireCastle vampireCastle = new VampireCastle();

        // Generic Building properties
        // - Check if the building is a vampire castle
        // - Check where it can be placed
        assertTrue(vampireCastle.getType().equals("Vampire Castle"));
        assertTrue(vampireCastle.getPlacement() == 3);

        // Spawner properties
        // - Check how often the zombie can be spawned
        assertTrue(vampireCastle.getInterval() == 5);
    }
}