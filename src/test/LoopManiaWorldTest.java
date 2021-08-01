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
        world.getCharacter().setHealth(1000000);
        assertTrue(world.getCharacter().getHealth() == 1000000);
        

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

        // add stake to play
        world.addItem(ItemFactory.generateBasicItems(eItems.Stake,0,0));
        world.equip(0, 0);
        assertTrue(world.getCharacter().getWeapon() instanceof Stake);
        
        // create 10 zombies
        for(int i = 0; i < 5; i++)
        {
            position = new PathPosition(3, path);
            Zombie zombie = new Zombie(position); 
            assertEquals(3,zombie.getX());
            assertEquals(1,zombie.getY());
            world.addEnemy(zombie);
        }

        // create 10 Muskes 
        for(int i = 0; i < 5; i++)
        {
            position = new PathPosition(3, path);
            ElanMuske muske = new ElanMuske(position); 
            muske.setDoggieCoin(world.getDoggieCoin());
            assertEquals(3,muske.getX());
            assertEquals(1,muske.getY());
            world.addEnemy(muske);
        }

        //create 100 a Vampire
        position = new PathPosition(4, path);
        Vampire vampire = new Vampire(position);
        Vampire vampire1 = new Vampire(position);
        assertEquals(2,vampire.getX());
        assertEquals(1,vampire.getY());
        world.addEnemy(vampire);
        world.addEnemy(vampire1);

        //convert the campfire card to buiding
        Building b1 = world.convertCardToBuildingByCoordinates(1,1,3,3);
        assertEquals(3,world.getBuildingList().get(0).getX()); 
        assertEquals(3,world.getBuildingList().get(0).getY()); 

        // convert the tower card to building
        Building b2 = world.convertCardToBuildingByCoordinates(1,2,2,2);
        assertEquals(2,world.getBuildingList().get(1).getX()); 
        assertEquals(2,world.getBuildingList().get(1).getY());

        //add three friendly soldiers
        world.addSoldier();
        world.addSoldier();
        world.addSoldier();

        world.runBattles();

        // make sure there is no infinite loop
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

        //randomly generates 500 cards
        for(int i = 0; i < 500; i++) {
            world.Card();
        }
        // get the fisrt one
        Card card = world.getCardEntities().get(0);

        // get the last one
        Card card1 = world.getCardEntities().get(4);
        
        // just make sure the sequence is not changing
        world.Card();
        assertFalse(world.getCardEntities().get(0) == card);
        assertFalse(world.getCardEntities().get(4) == card1);
        card = world.getCardEntities().get(0);
        card1 = world.getCardEntities().get(4);
        assertTrue(world.getCardEntities().get(0) == card);

        // make sure the player is rewarded if the guy
        assertTrue(player.getExperience() > 0);
        assertTrue(player.getGold() > 0);
        world.Card();
        assertFalse(world.getCardEntities().get(0) == card);
        assertFalse(world.getCardEntities().get(4) == card1);

        // make another new card is added so the player is rewarded more based on that
        assertTrue(player.getExperience() > 0);
        assertTrue(player.getGold() > 0);
        
        // select card first, and then call card to buidling !!
        card = world.getCardEntities().get(3);
        Building building = world.convertCardToBuildingByCoordinates(3,0,3,3);

        // the cards will be destoried after be placed to unaviliable tiles 
        if(card instanceof VampireCastleCard) {
            // can not be placed to the path
            assertTrue(building == null);
            assertEquals(world.getCardEntities().size(),4);
        }
        else if (card instanceof ZombiePitCard) {
            // can not be placed to the path
            assertTrue(building == null);
            assertEquals(world.getCardEntities().size(),4);
        }
        else if (card instanceof TowerCard) {
            // can not be placed to the path
            assertTrue(building == null);
            assertEquals(world.getCardEntities().size(),4);
        }
        else if (card instanceof CampfireCard) {
            // can not be placed to the path
            assertTrue(building == null);
            assertEquals(world.getCardEntities().size(),4);
        }
        else if (card instanceof VillageCard) {
            assertTrue(building instanceof Village);
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
        world.runTickMoves();
        world.runTickMoves();
        world.runTickMoves();
        world.runTickMoves();
        world.runTickMoves();
        world.runTickMoves();
        world.runTickMoves();

        assertEquals(player.getX(), 3);
        assertEquals(player.getY(), 2);

        assertEquals(player.getHealth(), 100);
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
        assertTrue(world.getInventory().get(0) == sword1);


    }
    @Test
    public void testAllEnemies() {
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

        c.setHealth(-100);
        

        
        //create spawning card
        ZombiePitCard zombiecard = new ZombiePitCard(new SimpleIntegerProperty(1), new SimpleIntegerProperty(1));
        zombiecard.setType("zombie");
        world.addACard(zombiecard);

        VampireCastleCard vampireCastleCard = new VampireCastleCard(new SimpleIntegerProperty(1), new SimpleIntegerProperty(2));
        vampireCastleCard.setType("Tower");
        world.addACard(vampireCastleCard);

        //convert the card to buiding
        Building b1 = world.convertCardToBuildingByCoordinates(1,1,3,4);
         

        // convert the card to building
        Building b2 = world.convertCardToBuildingByCoordinates(1,2,2,2);
        

        for(int i = 0; i < 10; i++)
        {
            world.incrementCycleCounter(3, 2);
            world.possiblySpawnEnemies();
        }
        // we should have 10 zombies and 2 vampires
        int zNum = 0;
        int vNum = 0;
        for(BasicEnemy e : world.getEnemy())
        {
            if(e instanceof Zombie)
                zNum += 1;
            if(e instanceof Vampire)
                vNum += 1;
        }
        assertTrue(zNum == 10);
        assertTrue(vNum == 2);

        // test for dogggggy
        
        for(int i = 0; i < 10; i++)
        {
            world.incrementCycleCounter(3, 2);
            world.possiblySpawnEnemies();
        }

        int doggggy = 0;

        for(BasicEnemy e : world.getEnemy())
        {
            if(e instanceof Doggie)
                doggggy += 1;
        }
        assertTrue(doggggy == 1);

        // for muske
        world.getCharacter().setExperience(10000);
        for(int i = 0; i < 20; i++)
        {
            world.incrementCycleCounter(3, 2);
            world.possiblySpawnEnemies();
        }

        int muske = 0;

        for(BasicEnemy e : world.getEnemy())
        {
            if(e instanceof ElanMuske)
                muske += 1;
        }
        assertTrue(muske == 1);
    }

    @Test
    public void testTrap() {
        List<Pair<Integer, Integer>> path = new ArrayList<Pair<Integer, Integer>>();
        path.add(new Pair<Integer, Integer>(4,3));  //0
        path.add(new Pair<Integer, Integer>(4,2));
        path.add(new Pair<Integer, Integer>(3,2));
        path.add(new Pair<Integer, Integer>(3,1));  
        path.add(new Pair<Integer, Integer>(2,1));
        path.add(new Pair<Integer, Integer>(1,1));
        path.add(new Pair<Integer, Integer>(1,2));
        path.add(new Pair<Integer, Integer>(1,3));
        path.add(new Pair<Integer, Integer>(2,3));
        path.add(new Pair<Integer, Integer>(3,3));  //9
        LoopManiaWorld world = new LoopManiaWorld(5,5, path);

        assertEquals(5, world.getWidth());
        assertEquals(5, world.getHeight());

        // simply try to call all the functions in world
        // and try to simulate a game

        // init a charcter fisrt, 
        PathPosition position = new PathPosition(9, path);
        Character c = new Character(position);
        world.setCharacter(c);

        // create a Slug
        position = new PathPosition(0, path);
        Slug slug = new Slug(position); 
        assertEquals(4,slug.getX());
        assertEquals(3,slug.getY());
        world.addEnemy(slug);


        // create spawning card
        TrapCard trapcard = new TrapCard(new SimpleIntegerProperty(1), new SimpleIntegerProperty(1));
        trapcard.setType("trap");
        world.addACard(trapcard); 
        assertTrue(world.getCardEntities().get(0) instanceof TrapCard);

        // create spawning card
        // put it to a "wrong" place
        TrapCard trapcard1 = new TrapCard(new SimpleIntegerProperty(1), new SimpleIntegerProperty(1));
        trapcard.setType("trap");
        world.addACard(trapcard); 
        assertTrue(world.getCardEntities().get(1) instanceof TrapCard);

        // create a trap on 4,2
        Building b = world.convertCardToBuildingByCoordinates(0,0,4,2);
        assertTrue(world.getBuildingList().get(0).getX() == 4);
        assertTrue(world.getBuildingList().get(0).getY() == 2);

        // create a trap on 4,2
        Building b1 = world.convertCardToBuildingByCoordinates(1,0,4,7);
        assertTrue(b1 == null);
        
        assertTrue(slug.getHealth() == 3);

        world.runTickMoves();

        assertTrue(slug.getHealth() == 0);
    }

    @Test
    public void testAddItem() {
        List<Pair<Integer, Integer>> path = new ArrayList<Pair<Integer, Integer>>();
        path.add(new Pair<Integer, Integer>(4,3));  //0
        path.add(new Pair<Integer, Integer>(4,2));
        path.add(new Pair<Integer, Integer>(3,2));
        path.add(new Pair<Integer, Integer>(3,1));  
        path.add(new Pair<Integer, Integer>(2,1));
        path.add(new Pair<Integer, Integer>(1,1));
        path.add(new Pair<Integer, Integer>(1,2));
        path.add(new Pair<Integer, Integer>(1,3));
        path.add(new Pair<Integer, Integer>(2,3));
        path.add(new Pair<Integer, Integer>(3,3));  //9
        LoopManiaWorld world = new LoopManiaWorld(101,101, path);

        // init a charcter fisrt, 
        PathPosition position = new PathPosition(9, path);
        Character c = new Character(position);
        world.setCharacter(c);

        ArrayList<BasicItem> A = new ArrayList<BasicItem>();

        for(int i = 0 ; i < 10000; i++)
            A.add(world.addUnequippedBasicItem());

        ArrayList<BasicItem> Content = new ArrayList<BasicItem>();

        for(int i = 0 ; i < 10000 ; i++)
        {
            Boolean bb = true;
            BasicItem b = A.get(i);
            for(int j = 0; j < Content.size(); j++)
            {
                if(b.getType().equals(Content.get(j).getType()))
                    bb = false;
            }
            if(bb)
                Content.add(b);
        }
        assertTrue(Content.size() == 9);

        // test generate rare item
        ArrayList<RareItem> B = new ArrayList<RareItem>();

        boolean isTheRing = false;

        for(int i = 0; i< 100; i++)
        {
            B.add(world.addUnequippedRareItem());
            if(B.get(i).getType().equals("TheRing"))
                isTheRing = true;
        }

        assertTrue(isTheRing);
    }

    @Test
    public void testequip() {
        List<Pair<Integer, Integer>> path = new ArrayList<Pair<Integer, Integer>>();
        path.add(new Pair<Integer, Integer>(4,3));  //0
        path.add(new Pair<Integer, Integer>(4,2));
        path.add(new Pair<Integer, Integer>(3,2));
        path.add(new Pair<Integer, Integer>(3,1));  
        path.add(new Pair<Integer, Integer>(2,1));
        path.add(new Pair<Integer, Integer>(1,1));
        path.add(new Pair<Integer, Integer>(1,2));
        path.add(new Pair<Integer, Integer>(1,3));
        path.add(new Pair<Integer, Integer>(2,3));
        path.add(new Pair<Integer, Integer>(3,3));  //9
        LoopManiaWorld world = new LoopManiaWorld(101,101, path);

        // init a charcter fisrt, 
        PathPosition position = new PathPosition(9, path);
        Character c = new Character(position);
        world.setCharacter(c);

        ArrayList<BasicItem> A = new ArrayList<BasicItem>();

        for(int i = 0 ; i < 10000; i++)
            A.add(world.addUnequippedBasicItem());

        ArrayList<BasicItem> Content = new ArrayList<BasicItem>();

        for(int i = 0 ; i < 10000 ; i++)
        {
            Boolean bb = true;
            BasicItem b = A.get(i);
            for(int j = 0; j < Content.size(); j++)
            {
                if(b.getType().equals(Content.get(j).getType()))
                    bb = false;
            }
            if(bb)
                Content.add(b);
        }
        assertTrue(Content.size() == 9);

        // test generate rare item
        ArrayList<RareItem> B = new ArrayList<RareItem>();

        boolean isTheRing = false;

        for(int i = 0; i< 100; i++)
        {
            B.add(world.addUnequippedRareItem());
            if(B.get(i).getType().equals("TheRing"))
                isTheRing = true;
        }

        assertTrue(isTheRing);
    }

    @Test
    public void testEquipAndDrinkPotion()
    {
        List<Pair<Integer, Integer>> path = new ArrayList<Pair<Integer, Integer>>();
        path.add(new Pair<Integer, Integer>(4,3));  //0
        path.add(new Pair<Integer, Integer>(4,2));
        path.add(new Pair<Integer, Integer>(3,2));
        path.add(new Pair<Integer, Integer>(3,1));  
        path.add(new Pair<Integer, Integer>(2,1));
        path.add(new Pair<Integer, Integer>(1,1));
        path.add(new Pair<Integer, Integer>(1,2));
        path.add(new Pair<Integer, Integer>(1,3));
        path.add(new Pair<Integer, Integer>(2,3));
        path.add(new Pair<Integer, Integer>(3,3));  //9
        LoopManiaWorld world = new LoopManiaWorld(101,101, path);

        // init a charcter fisrt, 
        PathPosition position = new PathPosition(9, path);
        Character c = new Character(position);
        world.setCharacter(c);

        world.addItem(ItemFactory.generateBasicItems(eItems.Sword,0,0));
        world.addItem(ItemFactory.generateBasicItems(eItems.Staff,1,0));
        world.addItem(ItemFactory.generateBasicItems(eItems.Stake,2,0));
        world.addItem(ItemFactory.generateBasicItems(eItems.Armour,3,0));
        world.addItem(ItemFactory.generateBasicItems(eItems.Helmet,4,0));
        world.addItem(ItemFactory.generateBasicItems(eItems.Shield,5,0));
        world.addItem(ItemFactory.generateBasicItems(eItems.Potion,6,0));

        world.equip(0, 0);
        assertTrue(world.getCharacter().getWeapon() instanceof Sword);

        world.equip(1, 0);
        assertTrue(world.getCharacter().getWeapon() instanceof Staff);

        world.equip(2, 0);
        assertTrue(world.getCharacter().getWeapon() instanceof Stake);

        world.equip(3, 0);
        assertTrue(world.getCharacter().getArmor() instanceof Armour);

        world.equip(4, 0);
        assertTrue(world.getCharacter().getHelmet() instanceof Helmet);

        world.equip(5, 0);
        assertTrue(world.getCharacter().getShield() instanceof Shield);

        c = world.getCharacter();
        c.setHealth(10);
        assertTrue(world.getCharacter().getHealth() == 10);

        // test equip dup items
        // create a new stake
        world.addItem(ItemFactory.generateBasicItems(eItems.Stake,7,0));
        world.equip(7, 0);
        assertTrue(world.getCharacter().getWeapon() instanceof Stake);

        // drink the potion
        world.useItem(Potion.class);
        assertTrue(world.getCharacter().getHealth() == 100);
        assertTrue(world.getInventory().size() == 1);

        // check the add health
        world.addHealth(100);
        assertTrue(world.getCharacter().getHealth() == 100);
        world.getCharacter().setHealth(20);
        world.addHealth(80);
        assertTrue(world.getCharacter().getHealth() == 100);
    }

    @Test
    public void testEquipdup()
    {
        List<Pair<Integer, Integer>> path = new ArrayList<Pair<Integer, Integer>>();
        path.add(new Pair<Integer, Integer>(4,3));  //0
        path.add(new Pair<Integer, Integer>(4,2));
        path.add(new Pair<Integer, Integer>(3,2));
        path.add(new Pair<Integer, Integer>(3,1));  
        path.add(new Pair<Integer, Integer>(2,1));
        path.add(new Pair<Integer, Integer>(1,1));
        path.add(new Pair<Integer, Integer>(1,2));
        path.add(new Pair<Integer, Integer>(1,3));
        path.add(new Pair<Integer, Integer>(2,3));
        path.add(new Pair<Integer, Integer>(3,3));  //9
        LoopManiaWorld world = new LoopManiaWorld(101,101, path);

        // init a charcter fisrt, 
        PathPosition position = new PathPosition(9, path);
        Character c = new Character(position);
        world.setCharacter(c);

        for(int i = 0; i < 16; i++)
            world.addItem(ItemFactory.generateBasicItems(eItems.Sword,0,0));

        assertTrue(world.getInventory().size() == 16);

        world.equip(0, 0);
        assertTrue(world.getCharacter().getWeapon() instanceof Sword);

        assertTrue(world.getInventory().size() == 15);

        world.addItem(ItemFactory.generateBasicItems(eItems.Sword,0,0));

        world.equip(0, 0);
        assertTrue(world.getCharacter().getWeapon() instanceof Sword);

    }
}







