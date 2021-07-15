package test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import unsw.loopmania.*;
import java.util.*;
import org.javatuples.Pair;



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

        //simulating purchase/sell action
        test_gold.setGold(test_gold.getGold() - 300);
        assertEquals(test_gold.getGold(), 100);

    }

    // test basic items
    @Test
    public void testBasic()
    {
        ArrayList<BasicItem> basicItem = new ArrayList<BasicItem>();

        // create instance for Armour, Shield, Helmet, Staff ,Sword, Stake, Potion
        // test wheather these basic items can be added to one BasicItem(abstarct class) array
        Armour A = new Armour(20, "Armour", 100,null);
        Shield B = new Shield(21, "Shield", 200,null);
        Helmet C = new Helmet(22, "Helmet", 300,null);
        Staff D = new Staff(23,"Staff", 400,null);
        Sword E = new Sword(24,"Sword", 500,null);
        Stake F = new Stake(25,"Stake",600,null);
        Potion G = new Potion(26,"Potion", 700,null);

        //check up on everthing !!!!
        assertEquals(A.getDropRate(), 20);
        assertEquals(A.getType(),"Armour");
        assertEquals(A.getpurchasePrice(),100);

        assertEquals(B.getDropRate(), 21);
        assertEquals(B.getType(),"Shield");
        assertEquals(B.getpurchasePrice(),200);

        assertEquals(C.getDropRate(), 22);
        assertEquals(C.getType(),"Helmet");
        assertEquals(C.getpurchasePrice(),300);

        assertEquals(D.getDropRate(), 23);
        assertEquals(D.getType(),"Staff");
        assertEquals(D.getpurchasePrice(),400);

        assertEquals(E.getDropRate(), 24);
        assertEquals(E.getType(),"Sword");
        assertEquals(E.getpurchasePrice(),500);

        assertEquals(F.getDropRate(), 25);
        assertEquals(F.getType(),"Stake");
        assertEquals(F.getpurchasePrice(),600);

        assertEquals(G.getDropRate(), 26);
        assertEquals(G.getType(),"Potion");
        assertEquals(G.getpurchasePrice(),700);

        //put everything into an array
        basicItem.add(A);
        basicItem.add(B);
        basicItem.add(C);
        basicItem.add(D);
        basicItem.add(E);
        basicItem.add(F);
        basicItem.add(G);

        //check all of the basic items can be put into an basicitem array
        int init = 50;
        for(BasicItem item : basicItem)
        {
            // check the sell price for item A to item G are from 50 to 350 
            assertEquals(item.getSellPrice(), init);
            init += 50;
        }

        //check the potion is the only applicable item
        for(BasicItem item : basicItem)
        {
            // check the sell price for item A to item G are from 50 to 350
            if(item.getType().equals("Potion"))
                assertEquals(item.isApplicable(), true);
            else
                assertEquals(item.isApplicable(), false);
        }
    }

    //test the rare item
    @Test
    public void test_rare()
    {
        //create the item "The Ring"
        TheRing ring = new TheRing(20,"TheRing",null);

        //test wheather one rare item can be put into rare item class
        RareItem contianer = ring;

        //play around with the ring
        contianer.setDropRate(30);
        assertEquals(contianer.getDropRate(),30);
        assertEquals(ring.getDropRate(),30);
        assertEquals(contianer.isApplicable(), false);
    }


    //test is everything can be put into item abstract class
    @Test
    public void test_abs()
    {
        ArrayList<Item> array = new ArrayList<Item>();
        Armour A = new Armour(20, "Armour", 100,null);
        Shield B = new Shield(21, "Shield", 200,null);
        TheRing ring = new TheRing(20,"TheRing",null);
        array.add(A);
        array.add(B);
        array.add(ring);
        assertEquals(array.get(0).getType(),"Armour");
        assertEquals(array.get(1).getType(),"Shield");
        assertEquals(array.get(2).getType(),"TheRing");
    }


    //test if the postion setters and getters are working
    @Test
    public void test_pos()
    {
        List<Pair<Integer, Integer>> path = new ArrayList<Pair<Integer, Integer>>();
        path.add(new Pair<Integer, Integer>(4,3));
        path.add(new Pair<Integer, Integer>(4,2));
        path.add(new Pair<Integer, Integer>(3,2));
        path.add(new Pair<Integer, Integer>(3,1));
        path.add(new Pair<Integer, Integer>(2,1));
        path.add(new Pair<Integer, Integer>(1,1));
        path.add(new Pair<Integer, Integer>(1,2));
        path.add(new Pair<Integer, Integer>(1,3));
        path.add(new Pair<Integer, Integer>(2,3));
        path.add(new Pair<Integer, Integer>(3,3));

        Armour A = new Armour(20, "Armour", 100,new PathPosition(0, path));
        Shield B = new Shield(21, "Shield", 200,new PathPosition(1, path));
        Helmet C = new Helmet(22, "Helmet", 300,new PathPosition(2, path));
        Staff D = new Staff(23,"Staff", 400,new PathPosition(3, path));
        Sword E = new Sword(24,"Sword", 500,new PathPosition(4, path));
        Stake F = new Stake(25,"Stake",600,new PathPosition(5, path));
        Potion G = new Potion(26,"Potion", 700,new PathPosition(6, path));
        TheRing H = new TheRing(27,"TheRing",new PathPosition(7, path));

        //A
        assertEquals(A.getX(), 4);
        assertEquals(A.getY(), 3);

        //B
        assertEquals(B.getX(), 4);
        assertEquals(B.getY(), 2);

        //C
        assertEquals(C.getX(), 3);
        assertEquals(C.getY(), 2);

        //D
        assertEquals(D.getX(), 3);
        assertEquals(D.getY(), 1);

        //E
        assertEquals(E.getX(), 2);
        assertEquals(E.getY(), 1);

        //F
        assertEquals(F.getX(), 1);
        assertEquals(F.getY(), 1);

        //F
        assertEquals(G.getX(), 1);
        assertEquals(G.getY(), 2);

        //F
        assertEquals(H.getX(), 1);
        assertEquals(H.getY(), 3);
    }

}

