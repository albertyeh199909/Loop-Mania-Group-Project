package test.buildings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import unsw.loopmania.*;

public class TowerTest {
    @Test
    public void testConstructor() {
        Tower tower = new Tower();

        assertTrue(tower.getType().equals("Tower"));
        assertTrue(tower.getPlacement() == 3);
    }
}