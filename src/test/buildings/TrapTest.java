package test.buildings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import unsw.loopmania.*;

public class TrapTest {
    @Test
    public void testConstructor() {
        Trap trap = new Trap();

        assertTrue(trap.getType().equals("Trap"));
        assertTrue(trap.getPlacement() == 1);
    }
}