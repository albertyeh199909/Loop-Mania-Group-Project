package unsw.loopmania;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.javatuples.Pair;

import javafx.beans.property.SimpleIntegerProperty;

public class MarketItemFactory
{

    public MarketItemFactory()
    {

    } 

    public static BasicItem generateItems(String name, int x, int y)
    {
        BasicItem item = null;
        if(name.equals("Sword"))
            item = new Sword(20, "Sword",300,x,y);
        else if(name.equals("Staff"))
            item = new Staff(20, "Staff",150,x,y);
        else if(name.equals("Stake"))
            item = new Stake(20, "Stake",250,x,y);
        else if(name.equals("Armour"))
            item = new Armour(20, "Armour",300,x,y);
        else if (name.equals("Helmet"))
            item = new Helmet(20, "Helmet",300,x,y);
        else if(name.equals("Shield"))
            item = new Shield(20, "Shield",300,x,y);
        else if(name.equals("Potion"))
            item = new Potion(20, "Potion",200,x,y);
        else
            System.out.println("EXCEPTION erros at line around 66 MarketHandler.java");
        return item;
    }
    
}