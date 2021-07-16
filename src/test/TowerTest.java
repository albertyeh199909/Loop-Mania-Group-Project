package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import unsw.loopmania.*;

public class TowerTest {
    @Test
    public void testConstructor() {
        int x = 0;
        int y = 0;
        Tower tower = new Tower(x, y);

        // Generic Building properties
        // - Check if the building is a tower
        // - Check where it can be placed
        assertTrue(tower.getType().equals("Tower"));
        assertTrue(tower.getPlacement() == 3);

        // Tower properties
        // - Check its attack
        // - Check its attack radius
        assertTrue(tower.getAttackRadius() == 1);
    }
}