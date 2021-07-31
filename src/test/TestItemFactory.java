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

public class TestItemFactory
{
    @Test
    void testFactory()
    {
        // test the sword
        BasicItem b = null;
        b = ItemFactory.generateBasicItems(eItems.Sword, 0, 0);
        assertEquals(b.getX(), 0);
        assertEquals(b.getY(), 0);
        assertEquals(b.getType(), "Sword");
        assertEquals(b instanceof Sword, true);

        // test the stake
        b = null;
        b = ItemFactory.generateBasicItems(eItems.Stake, 0, 0);
        assertEquals(b.getX(), 0);
        assertEquals(b.getY(), 0);
        assertEquals(b.getType(), "Stake");
         assertEquals(b instanceof Stake, true);

        // test the staff
        b = ItemFactory.generateBasicItems(eItems.Staff, 0, 0);
        assertEquals(b.getX(), 0);
        assertEquals(b.getY(), 0);
        assertEquals(b.getType(), "Staff");
         assertEquals(b instanceof Staff, true);

        // test the Armour
        b = ItemFactory.generateBasicItems(eItems.Armour, 0, 0);
        assertEquals(b.getX(), 0);
        assertEquals(b.getY(), 0);
        assertEquals(b.getType(), "Armour");
        assertEquals(b instanceof Armour, true);

        // test the Helmet
        b = ItemFactory.generateBasicItems(eItems.Helmet, 0, 0);
        assertEquals(b.getX(), 0);
        assertEquals(b.getY(), 0);
        assertEquals(b.getType(), "Helmet");
        assertEquals(b instanceof Helmet, true);

        // test the Shield
        b = ItemFactory.generateBasicItems(eItems.Shield, 0, 0);
        assertEquals(b.getX(), 0);
        assertEquals(b.getY(), 0);
        assertEquals(b.getType(), "Shield");
        assertEquals(b instanceof Shield, true);
        
        // test the Potion
        b = ItemFactory.generateBasicItems(eItems.Potion, 0, 0);
        assertEquals(b.getX(), 0);
        assertEquals(b.getY(), 0);
        assertEquals(b.getType(), "Potion");
        assertEquals(b instanceof Potion, true);

        // test the Anduril
        b = ItemFactory.generateBasicItems(eItems.Anduril, 0, 0);
        assertEquals(b.getX(), 0);
        assertEquals(b.getY(), 0);
        assertEquals(b.getType(), "Anduril");
        assertEquals(b instanceof Anduril, true);

        // test the TreeStump
        b = ItemFactory.generateBasicItems(eItems.TreeStump, 0, 0);
        assertEquals(b.getX(), 0);
        assertEquals(b.getY(), 0);
        assertEquals(b.getType(), "TreeStump");
        assertEquals(b instanceof TreeStump, true);

        // test the TheRing

        RareItem c = ItemFactory.generateRareItems(eItems.TheRing, 0, 0);
        assertEquals(c.getX(), 0);
        assertEquals(c.getY(), 0);
        assertEquals(c.getType(), "TheRing");
        assertEquals(c instanceof TheRing, true);
    }




}