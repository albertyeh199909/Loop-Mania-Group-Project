package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import unsw.loopmania.*;

public class TrapTest {
    @Test
    public void testConstructor() {
        int x = 0;
        int y = 0;
        Trap trap = new Trap(x, y);

        // Generic Building properties
        // - Check if the building is a trap
        // - Check where it can be placed
        assertTrue(trap.getType().equals("Trap"));
        assertTrue(trap.getPlacement() == 1);
    }
}