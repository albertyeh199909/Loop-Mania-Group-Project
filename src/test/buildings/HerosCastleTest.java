package test.buildings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import unsw.loopmania.*;

public class HerosCastleTest {
    /**
     * Tests if the constructor correctly calls the abstract superclass
     * and sets the generic building values, (type and placement)
     */
    @Test
    public void testConstructor() {
        HerosCastle castle = new HerosCastle();

        assertTrue(castle.getType().equals("Hero's Castle"));
        assertTrue(castle.getPlacement() == 4);
    }
}