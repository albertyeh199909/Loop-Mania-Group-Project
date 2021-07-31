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
        assertTrue(b instanceof Sword);

        // test the stake
        b = null;
        b = ItemFactory.generateBasicItems(eItems.Stake, 0, 0);
        assertEquals(b.getX(), 0);
        assertEquals(b.getY(), 0);
        assertEquals(b.getType(), "Stake");
        assertTrue(b instanceof Stake);

        // test the staff
        b = ItemFactory.generateBasicItems(eItems.Staff, 0, 0);
        assertEquals(b.getX(), 0);
        assertEquals(b.getY(), 0);
        assertEquals(b.getType(), "Staff");
        assertTrue(b instanceof Staff);

        // test the Armour
        b = ItemFactory.generateBasicItems(eItems.Armour, 0, 0);
        assertEquals(b.getX(), 0);
        assertEquals(b.getY(), 0);
        assertEquals(b.getType(), "Armour");
        assertTrue(b instanceof Armour);

        // test the Helmet
        b = ItemFactory.generateBasicItems(eItems.Helmet, 0, 0);
        assertEquals(b.getX(), 0);
        assertEquals(b.getY(), 0);
        assertEquals(b.getType(), "Helmet");
        assertTrue(b instanceof Helmet);

        // test the Shield
        b = ItemFactory.generateBasicItems(eItems.Shield, 0, 0);
        assertEquals(b.getX(), 0);
        assertEquals(b.getY(), 0);
        assertEquals(b.getType(), "Shield");
        assertTrue(b instanceof Shield);
        
        // test the Potion
        b = ItemFactory.generateBasicItems(eItems.Shield, 0, 0);
        assertEquals(b.getX(), 0);
        assertEquals(b.getY(), 0);
        assertEquals(b.getType(), "Shield");
        assertTrue(b instanceof Shield);











    }




}