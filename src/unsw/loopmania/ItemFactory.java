package unsw.loopmania;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.javatuples.Pair;

import javafx.beans.property.SimpleIntegerProperty;

public class ItemFactory
{

    public ItemFactory()
    {

    } 

    /**
    * @param name the type of item to be spawned
    * @param x    x coordinate of basic item
    * @param y    y coordinate of basic item
    */
    public static BasicItem generateBasicItems(eItems name, int x, int y)
    {
        BasicItem item = null;
        switch(name) {
            case Sword:
                item = new Sword(20, "Sword",300,x,y);
                break;
            case Staff:
                item = new Staff(20, "Staff",150,x,y);
                break;
            case Stake:
                item = new Stake(20, "Stake",250,x,y);
                break;
            case Armour:
                item = new Armour(20, "Armour",300,x,y);
                break;
            case Shield:
                item = new Shield(20, "Shield",300,x,y);
                break;
            case Helmet:
                item = new Helmet(20, "Helmet",300,x,y);
                break;
            case Potion:
                item = new Potion(20, "Potion",200,x,y);
                break;
            case Anduril:
                item = new Anduril(10, "Anduril",1000,x,y);
                break;
            case TreeStump:
                item = new TreeStump(10, "TreeStump",1000,x,y);
                break;
        }
        return item;
    }

    /**
    * @param name the type of item to be spawned
    * @param x    x coordinate of rare item
    * @param y    y coordinate of rare item
    */
    public static RareItem generateRareItems(eItems name, int x, int y)
    {
        RareItem item = null;
        switch(name) {
            case TheRing:
                item = new TheRing(20, "TheRing",x,y);
                break;
        }
        return item;
    }
    
}