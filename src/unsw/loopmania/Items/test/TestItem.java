package unsw.loopmania.items.test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import unsw.loopmania.LoopManiaWorld;
import unsw.loopmania.items.*;

/**
 * this class is a dummy class demonstrating how to setup tests for the project
 * you should setup additional test classes in a similar fashion, aiming to achieve high coverage.
 * A clickable "Run Test" link should appear if you have installed the Java Extension Pack properly.
 */
public class TestItem {
    // test Gold class
    @Test
    public void testGold()
    {
        //create a gold class, with init number of 100 peices of gold
        Gold test_gold = new Gold(100);

        //test the getter is workinh
        assertEquals(test_gold.getGold(),100);

        //test the setter is working
        test_gold.setGold(400);
        assertEquals(test_gold.getGold(), 400);

        //simulating pruchase/sell movment
        test_gold.setGold(test_gold.getGold() - 300);
        assertEquals(test_gold.getGold(), 100);

    }
}