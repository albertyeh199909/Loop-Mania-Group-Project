package test.buildings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import unsw.loopmania.*;

public class TowerTest {
    @Test
    public void testConstructor() {
        Tower tower = new Tower();

        // Generic Building properties
        // - Check if the building is a tower
        // - Check where it can be placed
        assertTrue(tower.getType().equals("Tower"));
        assertTrue(tower.getPlacement() == 3);

        // Tower properties
        // - Check its attack
        // - Check its attack radius
        assertTrue(tower.getAttack() == 1); 
        assertTrue(tower.getAttackRadius() == 1);
    }
}