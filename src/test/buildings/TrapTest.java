package test.buildings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import unsw.loopmania.*;

public class TrapTest {
    @Test
    public void testConstructor() {
        Trap trap = new Trap();

        // Generic Building properties
        // - Check if the building is a trap
        // - Check where it can be placed
        assertTrue(trap.getType().equals("Trap"));
        assertTrue(trap.getPlacement() == 1);

        // Trap properties
        // - Check its attack
        assertTrue(trap.getAttack() == 1);
    }
}