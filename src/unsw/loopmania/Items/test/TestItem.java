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
     @Test
    public void testCreate()
    {
        ArrayList<BasicItem> basicItem = new ArrayList<BasicItem>();

        // create instance for Armour, Shield, Helmet, Staff ,Sword, Stake, Potion
        // test wheather these basic items can be added to one BasicItem(abstarct class) array
        Armour A = new Armour(20, "Armour", 100);
        Shield B = new Shield(21, "Shield", 200);
        Helmet C = new Helmet(22, "Helmet", 300);
        Staff D = new Staff(23,"Staff", 400);
        Sword E = new Sword(24,"Sword", 500);
        Stake F = new Stake(25,"Stake",600);
        Potion G = new Potion(26,"Potion", 700);

        //put everything into an array
        basicItem.add(A);
        basicItem.add(B);
        basicItem.add(C);
        basicItem.add(D);
        basicItem.add(E);
        basicItem.add(F);
        basicItem.add(G);

        //check up on everthing !!!!
        


        











    }
}