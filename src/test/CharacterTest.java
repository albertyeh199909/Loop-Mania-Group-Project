package test;

import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import unsw.loopmania.LoopManiaWorld;
import unsw.loopmania.PathPosition;
import unsw.loopmania.SwordStrategy;
import unsw.loopmania.BasicEnemy;
import unsw.loopmania.Character;

import java.util.*;
import org.javatuples.Pair;

public class CharacterTest {

    @Test
    public void testMove() {
        List<Pair<Integer, Integer>> path = new ArrayList<Pair<Integer, Integer>>();
        path.add(new Pair(4,3));
        path.add(new Pair(4,2));
        path.add(new Pair(3,2));
        path.add(new Pair(3,1));
        path.add(new Pair(2,1));
        path.add(new Pair(1,1));
        path.add(new Pair(1,2));
        path.add(new Pair(1,3));
        path.add(new Pair(2,3));
        path.add(new Pair(3,3));

        LoopManiaWorld world = new LoopManiaWorld(5,5, path);
        PathPosition start = new PathPosition(2, path);
        Character player = new Character(start);
        assertEquals(player.getX(), 3);
        assertEquals(player.getY(), 1);
    }

    @Test
    public void testInventory() {
        List<Pair<Integer, Integer>> path = new ArrayList<Pair<Integer, Integer>>();
        path.add(new Pair(4,3);
        path.add(new Pair(4,2));
        path.add(new Pair(3,2));
        path.add(new Pair(3,1));
        path.add(new Pair(2,1));
        path.add(new Pair(1,1));
        path.add(new Pair(1,2));
        path.add(new Pair(1,3));
        path.add(new Pair(2,3));
        path.add(new Pair(3,3));

        LoopManiaWorld world = new LoopManiaWorld(5,5, path);
        PathPosition start = new PathPosition(2, path);
        Character player = new Character(start);
        BasicItem sword = new Sword();
        player.store(sword);
        assertTrue(player.getInventory().contains(sword));
        player.equipWeapon(sword);
        assertFalse(player.getInventory().contains(sword));
        assertEquals(player.getWeapon(), sword);
        assertTrue(player.getDamage() instanceof SwordStrategy);
        BasicItem potion = new Potion();
        player.store(potion);
        assertTrue(player.getInventory().contains(sword));
        player.use(potion);
        assertFalse(player.getInventory().contains(potion));

    }

    @Test
    public void testDamage() {
        List<Pair<Integer, Integer>> path = new ArrayList<Pair<Integer, Integer>>();
        path.add(new Pair(4,3);
        path.add(new Pair(4,2));
        path.add(new Pair(3,2));
        path.add(new Pair(3,1));
        path.add(new Pair(2,1));
        path.add(new Pair(1,1));
        path.add(new Pair(1,2));
        path.add(new Pair(1,3));
        path.add(new Pair(2,3));
        path.add(new Pair(3,3));

        LoopManiaWorld world = new LoopManiaWorld(5,5, path);
        PathPosition start = new PathPosition(2, path);
        Character player = new Character(start);
        PathPosition above = new PathPosition(3, path);
        PathPosition below = new PathPosition(4, path);
        Slug slug = new slug(above);
        Vampire vampire = new vampire(below));
        player.dealDamagae(slug);
        assertEquals(2, slug.getHealth());
        BasicItem stake = new Stake();
        player.store(stake);
        player.setWeapon(stake);
        player.dealDamagae(slug);
        assertEquals(0, slug.getHealth());
        player.dealDamage(vampire);
        assertEquals(0, vampire.getHealth());
        vampire.setHealth(10);
        BasicItem sword = new Sword();
        player.store(sword);
        player.dealDamage(vampire));
        assertEquals(6, vampire.getHealth());
        

    }
    
}
