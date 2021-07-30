package unsw.loopmania;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.javatuples.Pair;

import javafx.beans.property.SimpleIntegerProperty;

public class MarketHandler
{
    
    private ArrayList<Entity> marketItems = new ArrayList<Entity>();
    // number 0 Standard mode
    // number 1 berserker mode
    // number 2 survival mode
    private int difficulties = 0; 

    public MarketHandler()
    {

    } 

    public void setDifficulties(int difficulties)
    {   
        this.difficulties = difficulties;
    }

    public ArrayList<Entity> getShopItemList()
    {
        return marketItems;
    }

    public int getDifficulties()
    {
        return difficulties;
    }

    public void generateMarketList()
    {
        marketItems.clear();
        for(int i = 0; i < 10; i++)
        {
            int value = new Random().nextInt(7);
            Entity item = null;
            if(value == 0)
                item = MarketItemFactory.generateItems("Sword",0,i);
            else if(value == 1)
                item = MarketItemFactory.generateItems("Staff",0,i);
            else if(value == 2)
                item = MarketItemFactory.generateItems("Stake",0,i);
            else if(value == 3)
                item = MarketItemFactory.generateItems("Armour",0,i);
            else if (value ==4)
                item = MarketItemFactory.generateItems("Helmet",0,i);
            else if(value == 5)
                item = MarketItemFactory.generateItems("Shield",0,i);
            else if(value == 6)
                item = MarketItemFactory.generateItems("Potion",0,i);
            else
                System.out.println("EXCEPTION erros at line around 66 MarketHandler.java");
            if( item != null)
                marketItems.add(item);
        }
    }

}