package test;
import unsw.loopmania.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;


public class BuildingTest {
    
    @Test
    public void test1() {
        int x = 0;
        int y = 0;
        Barracks barracks = new Barracks(x, y);

        // Generic Building properties
        // - Check if the building is a barrack
        // - Check where it can be placed
        assertTrue(barracks.getType().equals("Barracks"));
        assertTrue(barracks.getPlacement() == 1);
    }
    

    
    @Test
    public void test2() {
        int x = 0;
        int y = 0;
        Campfire campfire = new Campfire(x, y);

        // Generic Building properties
        // - Check if the building is a campfire
        // - Check where it can be placed
        assertTrue(campfire.getType().equals("Campfire"));
        assertTrue(campfire.getPlacement() == 2);

        // Campfire properties
        // - Check its buff radius
        assertTrue(campfire.getBuffRadius() == 2);
    }
    

     
    @Test
    public void test3() {
        int x = 0;
        int y = 0;
        HerosCastle castle = new HerosCastle(x, y);

        // Generic Building properties
        // - Check if the building is the Hero's Castle
        // - Check where it can be placed
        assertTrue(castle.getType().equals("Hero's Castle"));
        assertTrue(castle.getPlacement() == 4);
    }

    @Test
    public void test4() {
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

    @Test
    public void test5() {
        int x = 0;
        int y = 0;
        Trap trap = new Trap(x, y);

        // Generic Building properties
        // - Check if the building is a trap
        // - Check where it can be placed
        assertTrue(trap.getType().equals("Trap"));
        assertTrue(trap.getPlacement() == 1);
    }

    @Test
    public void test6() {
        int x = 0;
        int y = 0;
        VampireCastle vampireCastle = new VampireCastle(x, y);

        // Generic Building properties
        // - Check if the building is a vampire castle
        // - Check where it can be placed
        assertTrue(vampireCastle.getType().equals("Vampire Castle"));
        assertTrue(vampireCastle.getPlacement() == 3);
    }

    @Test
    public void test7() {
        int x = 0;
        int y = 0;
        Village village = new Village(x, y);

        // Generic Building properties
        // - Check if the building is a village
        // - Check where it can be placed
        assertTrue(village.getType().equals("Village"));
        assertTrue(village.getPlacement() == 1);
    }

    @Test
    public void test8() {
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
