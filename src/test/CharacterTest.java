package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;


import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;

import unsw.loopmania.LoopManiaWorld;
import unsw.loopmania.PathPosition;
import unsw.loopmania.SwordStrategy;
import unsw.loopmania.BasicEnemy;
import unsw.loopmania.Character;
import unsw.loopmania.DamageClass;
import unsw.loopmania.*;

import java.util.*;
import org.javatuples.Pair;


public class CharacterTest {

    @Test
    public void testMove() {
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
        Character player = new Character(start);
        assertEquals(player.getX(), 3);
        assertEquals(player.getY(), 2);
        player.move();
        assertEquals(player.getX(), 3);
        assertEquals(player.getY(), 1);
        player.move();
        player.move();
        assertEquals(player.getX(), 1);
        assertEquals(player.getY(), 1);
    }

   
    

    @Test
    public void testDamage() {
        
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
        PathPosition start = new PathPosition(2, path);
        Character player = new Character(start);
        PathPosition above = new PathPosition(3, path);
        PathPosition below = new PathPosition(4, path);
        Slug slug = new Slug(above);
        Vampire vampire = new Vampire(below);
        //test unarmed damage
        ArrayList<AlliedSoldier> array = new ArrayList<AlliedSoldier>();
        player.dealDamage(slug,array);
        assertEquals(2, slug.getHealth());
        //test stake damage against basic enemy and against vampire
        BasicItem stake = new Stake(10,"stake",100,-1,-1);
        
        player.setWeapon(stake);
        player.dealDamage(slug,array);
        assertEquals(-1, slug.getHealth());
        player.dealDamage(vampire,array);
        assertEquals(4, vampire.getHealth());

        //test sword damage
        vampire.setHealth(10);
        BasicItem sword = new Sword(10, "sword", 200,-1,-1);
        
        player.setWeapon(sword);
        player.dealDamage(vampire,array);
        assertEquals(6, vampire.getHealth());
        array.add(new AlliedSoldier());
        player.dealDamage(vampire,array);
        assertEquals(0, vampire.getHealth());
        array.add(new AlliedSoldier());
        array.add(new AlliedSoldier());
        player.dealDamage(vampire,array);
        assertEquals(-10, vampire.getHealth());

        //test the damage of Anduril
        vampire.setHealth(10);
        array.clear
        BasicItem anduril = ItemFactory.generateBasicItems(eItems.Anduril, -1, -1);
        player.setWeapon(anduril);


    }
    @Test
    public void testDefence() {
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
        PathPosition start = new PathPosition(2, path);
        Character player = new Character(start);
        PathPosition above = new PathPosition(3, path);
        PathPosition below = new PathPosition(4, path);
        Slug slug = new Slug(above);
        Vampire vampire = new Vampire(below);
        
        //test helmet defence and damage reduction
        Helmet helmet = new Helmet(10, "helmet", 100,-1,-1);
        
        player.setHelmet(helmet);
        ArrayList<AlliedSoldier> array = new ArrayList<AlliedSoldier>();
        player.dealDamage(slug,array);
        assertEquals(3, slug.getHealth());

        DamageClass damage = new DamageClass(vampire, 10, 0);
        damage = player.takeDamage(damage);
        assertEquals(8,damage.getDamage());

        //test armor and armor damage reduction, armor should take priority over helmet for damage calculations
        Armour armor = new Armour(10, "Armour", 100,-1,-1);
        
        player.setArmor(armor);

        damage = new DamageClass(vampire, 10, 0);
        damage = player.takeDamage(damage);
        assertEquals(3,damage.getDamage());

        //test if shield reduces vampire crit chance by 60%
        Shield shield = new Shield(10, "Shield", 100,-1,-1);
        
        player.setShield(shield);

        damage = new DamageClass(vampire, 10, 10);
        damage = player.takeDamage(damage);
        assertEquals(4,damage.getCriticalChance());
    
        
        

    }
    
    
}
