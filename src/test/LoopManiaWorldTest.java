package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.javatuples.Pair;
import org.junit.Test;

import unsw.loopmania.*;
import unsw.loopmania.Character;
import unsw.loopmania.Slug;

import javafx.beans.property.SimpleIntegerProperty;

import java.io.FileNotFoundException;

public class LoopManiaWorldTest {
    // the rest is by Harrington, Albert and james 
    @Test
    public void SimWorld() {
        // List<Pair<Integer, Integer>> path and its subsequent details are taken from CharacterTest.java
        List<Pair<Integer, Integer>> path = new ArrayList<Pair<Integer, Integer>>();
        path.add(new Pair<Integer, Integer>(4,3));
        path.add(new Pair<Integer, Integer>(4,2));
        path.add(new Pair<Integer, Integer>(3,2));      // main character(20) ---> 1
        path.add(new Pair<Integer, Integer>(3,1));      // Slug(3) ---> 3
        path.add(new Pair<Integer, Integer>(2,1));      // vampire(10) ---> 10 
        path.add(new Pair<Integer, Integer>(1,1));      // tower attack ---> 2
        path.add(new Pair<Integer, Integer>(1,2));
        path.add(new Pair<Integer, Integer>(1,3));      // 20 - 13 - 10
        path.add(new Pair<Integer, Integer>(2,3));
        LoopManiaWorld world = new LoopManiaWorld(5,5, path);

        // check the getters and setters are working for the world
        assertEquals(5, world.getWidth());
        assertEquals(5, world.getHeight());

        // simply try to call all the functions in world
        // and try to simulate a game

        // init a charcter fisrt, 
        PathPosition position = new PathPosition(2, path);
        Character c = new Character(position);
        world.setCharacter(c);
        

        //check the character is set in this position
        assertEquals(3,c.getX());
        assertEquals(2,c.getY());

        // create cards: campfire and one tower
        //create campfire card
        CampfireCard campcard = new CampfireCard(new SimpleIntegerProperty(1), new SimpleIntegerProperty(1));
        campcard.setType("campfire");
        world.addACard(campcard);

        TowerCard towercard = new TowerCard(new SimpleIntegerProperty(1), new SimpleIntegerProperty(2));
        towercard.setType("Tower");
        world.addACard(towercard);
        
        // create a Slug
        position = new PathPosition(3, path);
        Slug slug = new Slug(position); 
        assertEquals(3,slug.getX());
        assertEquals(1,slug.getY());
        world.addEnemy(slug);
        //create a Vampire
        position = new PathPosition(4, path);
        Vampire vampire = new Vampire(position);
        assertEquals(2,vampire.getX());
        assertEquals(1,vampire.getY());
        world.addEnemy(vampire);

        //convert the campfire card to buiding
        Building b1 = world.convertCardToBuildingByCoordinates(1,1,3,3);
        assertEquals(3,world.getBuildingList().get(0).getX()); 
        assertEquals(3,world.getBuildingList().get(0).getY()); 

        // convert the tower card to building
        Building b2 = world.convertCardToBuildingByCoordinates(1,2,2,2);
        assertEquals(2,world.getBuildingList().get(1).getX()); 
        assertEquals(2,world.getBuildingList().get(1).getY());

        //add two friendly soldiers
        world.addSoldier();
        world.addSoldier();
        world.runBattles();
        assertEquals(20, world.getCharacter().getHealth());

    }
        @Test
        public void testCard() {
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

        for(int i = 0; i < 5; i++) {
            world.Card();
        }
        Card card = world.getCardEntities().get(0);
        Card card1 = world.getCardEntities().get(4);
        
        world.Card();
        assertFalse(world.getCardEntities().get(0) == card);
        assertFalse(world.getCardEntities().get(4) == card1);
        card = world.getCardEntities().get(0);
        card1 = world.getCardEntities().get(4);
        assertTrue(world.getCardEntities().get(0) == card);

        assertEquals(player.getExperience(), 100);
        assertEquals(player.getGold(),100);
        world.Card();
        assertFalse(world.getCardEntities().get(0) == card);
        assertFalse(world.getCardEntities().get(4) == card1);

        assertEquals(player.getExperience(), 200);
        assertEquals(player.getGold(),200);

        Building building = world.convertCardToBuildingByCoordinates(0,0,3,3);
        card = world.getCardEntities().get(3);
        if(card instanceof VampireCastleCard) {
            assertEquals(building, null);
        }
        else if (card instanceof ZombiePitCard) {
            assertEquals(building, null);
        }
        else if (card instanceof TowerCard) {
            assertEquals(building, null);
        }
        else if (card instanceof CampfireCard) {
            assertEquals(building, null);
        }
        else if (card instanceof VillageCard) {
            assertTrue(building instanceof Village) ;
            assertEquals(world.getCardEntities().size(),4);
        }
        else if (card instanceof BarracksCard) {
            assertTrue(building instanceof Barracks) ;
            assertEquals(world.getCardEntities().size(),4);
        }
        
        Tower tower = new Tower(2, 2);
        ZombiePit zp = new ZombiePit(4,5);
        assertEquals(world.adjacentTile(tower), 5);
        assertEquals(world.adjacentTile(zp),-1);
         
    }
    
    @Test
    public void testRunTickMoves() {
        // Test details are shared with CharacterTest
        //@ by micheal
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

        PathPosition start = new PathPosition(1, path);
        Character player = new Character(start);



        world.setCharacter(player);
        assertNotNull(world.getCharacter());

        
        world.runTickMoves();

        assertEquals(player.getX(), 3);
        assertEquals(player.getY(), 2);
        
        assertNotNull(player);

        world.runTickMoves();
        
        assertEquals(player.getX(), 3);
        assertEquals(player.getY(), 1);

        VillageCard villagecard = new VillageCard(new SimpleIntegerProperty(1), new SimpleIntegerProperty(1));
        villagecard.setType("Village");
        world.addACard(villagecard);

        
        world.convertCardToBuildingByCoordinates(1,1,1,1);
        
        world.runTickMoves();
        world.runTickMoves();

        assertEquals(player.getX(), 1);
        assertEquals(player.getY(), 1);

        assertEquals(player.getHealth(), 20);
    }

    @Test
    public void addUnequipped() {
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
        assertTrue(world.addUnequippedBasicItem("Sword") instanceof Sword);
        assertTrue(world.addUnequippedBasicItem("Staff") instanceof Staff);
        assertTrue(world.addUnequippedBasicItem("Stake") instanceof Stake);
        assertTrue(world.addUnequippedBasicItem("Helmet") instanceof Helmet);
        assertTrue(world.addUnequippedBasicItem("Armour") instanceof Armour);
        assertTrue(world.addUnequippedBasicItem("Shield") instanceof Shield);

    }

    @Test 
    public void givenInventory() {
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

        Sword sword = new Sword(10,"Sword",100,0,0);
        world.addItem(sword);
        Sword sword1 = new Sword(10,"Sword",100,0,2);
        world.addItem(sword1);
        world.removeUnequippedInventoryItemByCoordinates(0,0);
        assertTrue(world.getInventory().get(0) == null);


    }



      
}






