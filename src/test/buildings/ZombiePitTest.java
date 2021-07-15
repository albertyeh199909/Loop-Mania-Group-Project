package test.buildings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import unsw.loopmania.*;

public class ZombiePitTest {
    @Test
    public void testConstructor() {
        ZombiePit zombiePit = new ZombiePit();

        // Generic Building properties
        // - Check if the building is a zombie pit
        // - Check where it can be placed
        assertTrue(zombiePit.getType().equals("Zombie Pit"));
        assertTrue(zombiePit.getPlacement() == 3);

        // Spawner properties
        // - Check how often the zombie can be spawned
        assertTrue(zombiePit.getInterval() == 1);
    }
}