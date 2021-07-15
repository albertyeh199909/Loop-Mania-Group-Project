package test.buildings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import unsw.loopmania.*;

public class ZombiePitTest {
    @Test
    public void testConstructor() {
        ZombiePit zombiePit = new ZombiePit();

        assertTrue(zombiePit.getType().equals("Zombie Pit"));
        assertTrue(zombiePit.getPlacement() == 3);
    }
}