package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;

import unsw.loopmania.*;
import unsw.loopmania.Character;
import java.util.List;
import java.util.ArrayList;
import org.javatuples.Pair;


public class TestMileStone3 {
    
    // test for doggiecoin class
    @Test
    public void testDoggieCoin()
    {
        DoggieCoin d = new DoggieCoin();
        // test set and get doggiecoin amount
        d.setAmount(10000);
        assertEquals(10000, d.getAmount());

        // test set and get doggiecoin value
        d.setSellValue(100);
        assertEquals(100, d.getSellValue());

        // test the inflation 
        d.inflation();
        assertTrue(d.getSellValue() >= 100);

        // test deflation
        d.setSellValue(100);
        d.deflation();
        assertTrue(d.getSellValue() <= 100);

        // test the negative case
        d.setSellValue(0);
        d.deflation();
        assertTrue(d.getSellValue() == 0);
    }

    //test for doggie
    @Test
    public void testBosses()
    {
        DoggieCoin d = new DoggieCoin();
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

        //LoopManiaWorld world = new LoopManiaWorld(5,5, path);
        //make sure character moves to appropriate tile
        PathPosition start = new PathPosition(2, path);
        PathPosition road = new PathPosition(3, path);
        PathPosition road1 = new PathPosition(1, path);
        //init a Muske boss
        ElanMuske elanMuske = new ElanMuske(road);
        elanMuske.setDoggieCoin(d);
        // if Muske is spawned, it will generate dodgie coin
        assertTrue(d.getSellValue() >= 0);
        // note the current value of dodgie coin before the defaltion(boss is eliminated)
        int currentValue = d.getSellValue();
        Character player = new Character(start);
        DamageClass damage = new DamageClass(player, 50, 0);
        elanMuske.takeDamage(damage);
        // check elan Muske is elinmated 
        assertTrue(elanMuske.getHealth() == 0);
        assertTrue(d.getSellValue() <= currentValue);

        Doggie doggie = new Doggie(road1);
        doggie.setDoggieCoin(d);
        DamageClass damage1 = new DamageClass(player, 70, 0);
        doggie.takeDamage(damage1);

        assertTrue(d.getAmount() == 1);










        
    }
    
}
