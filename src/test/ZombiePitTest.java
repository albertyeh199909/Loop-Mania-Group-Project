package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import unsw.loopmania.*;

public class ZombiePitTest {
    @Test
    public void testConstructor() {
        int x = 0;
        int y = 0;
        ZombiePit zombiePit = new ZombiePit(x, y);

        // Generic Building properties
        // - Check if the building is a zombie pit
        // - Check where it can be placed
        assertTrue(zombiePit.getType().equals("Zombie Pit"));
        assertTrue(zombiePit.getPlacement() == 3);
    }
}