package test.buildings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import unsw.loopmania.*;

public class VampireCastleTest {
    @Test
    public void testConstructor() {
        VampireCastle vampireCastle = new VampireCastle();

        assertTrue(vampireCastle.getType().equals("Vampire Castle"));
        assertTrue(vampireCastle.getPlacement() == 3);
    }
}