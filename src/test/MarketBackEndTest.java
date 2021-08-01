package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

import java.util.ArrayList;
import java.util.List;

import javax.swing.text.AbstractDocument.Content;

import org.hamcrest.core.IsInstanceOf;
import org.javatuples.Pair;
import org.junit.Test;

import unsw.loopmania.*;
import unsw.loopmania.Character;
import javafx.beans.property.SimpleIntegerProperty;

public class MarketBackEndTest {
    @Test
    public void TestPurchase()
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
        LoopManiaWorld world = new LoopManiaWorld(5,5, path);
        PathPosition start = new PathPosition(2, path);
        Character player = new Character(start);
        world.setCharacter(player);

        // purchase sword
        world.getCharacter().setGold(49);
        assertTrue(world.getCharacter().getGold() == 49);
        assertTrue(!world.purchase("sword"));
        world.getCharacter().setGold(50);
        assertTrue(world.purchase("sword"));

        // purchase staff
        world.getCharacter().setGold(74);
        assertTrue(world.getCharacter().getGold() == 74);
        assertTrue(!world.purchase("staff"));
        world.getCharacter().setGold(75);
        assertTrue(world.getCharacter().getGold() == 75);
        assertTrue(world.purchase("staff"));

        // purchase stake
        world.getCharacter().setGold(49);
        assertTrue(world.getCharacter().getGold() == 49);
        assertTrue(!world.purchase("stake"));
        world.getCharacter().setGold(50);
        assertTrue(world.purchase("stake"));

        // purchase Armour
        world.getCharacter().setGold(99);
        assertTrue(world.getCharacter().getGold() == 99);
        assertTrue(!world.purchase("armour"));
        world.getCharacter().setGold(100);
        assertTrue(world.purchase("armour"));

        // purchase Shield
        world.getCharacter().setGold(74);
        assertTrue(world.getCharacter().getGold() == 74);
        assertTrue(!world.purchase("shield"));
        world.getCharacter().setGold(75);
        assertTrue(world.purchase("shield"));

        // purchase Helmet
        world.getCharacter().setGold(24);
        assertTrue(world.getCharacter().getGold() == 24);
        assertTrue(!world.purchase("helmet"));
        world.getCharacter().setGold(25);
        assertTrue(world.purchase("helmet"));

        // purchase Potion
        world.getCharacter().setGold(49);
        assertTrue(world.getCharacter().getGold() == 49);
        assertTrue(!world.purchase("potion"));
        world.getCharacter().setGold(50);
        assertTrue(world.purchase("potion"));
    }

    @Test
    public void TestSell()
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
        LoopManiaWorld world = new LoopManiaWorld(5,5, path);
        PathPosition start = new PathPosition(2, path);
        Character player = new Character(start);
        world.setCharacter(player);

        world.addItem(ItemFactory.generateBasicItems(eItems.Sword,0,0));
        world.addItem(ItemFactory.generateBasicItems(eItems.Staff,1,0));
        world.addItem(ItemFactory.generateBasicItems(eItems.Stake,2,0));
        world.addItem(ItemFactory.generateBasicItems(eItems.Armour,3,0));
        world.addItem(ItemFactory.generateBasicItems(eItems.Helmet,4,0));
        world.addItem(ItemFactory.generateBasicItems(eItems.Shield,5,0));
        world.addItem(ItemFactory.generateBasicItems(eItems.Potion,6,0));

        world.getCharacter().setGold(0);
        world.sell("Sword");
        assertTrue(world.getCharacter().getGold() == 50);
        world.sell("Stake");
        assertTrue(world.getCharacter().getGold() == 100);
        world.sell("Staff");
        assertTrue(world.getCharacter().getGold() == 175);
        world.sell("Shield");
        assertTrue(world.getCharacter().getGold() == 250);
        world.sell("Armour");
        assertTrue(world.getCharacter().getGold() == 350);
        world.sell("Helmet");
        assertTrue(world.getCharacter().getGold() == 375);
        world.sell("Potion");
        assertTrue(world.getCharacter().getGold() == 425);
    }
}   
