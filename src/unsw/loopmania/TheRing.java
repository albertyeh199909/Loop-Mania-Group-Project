package unsw.loopmania;

import javax.swing.text.html.HTMLDocument.HTMLReader.CharacterAction;

public class TheRing extends RareItem {
    //Constructor
    /*
        @param dropRate ----> the rate of dropping of an item when an enemy is defeated 
        @param type ----> the type of the item
        @param postion is the postion of the current item
        note: the sell price for this item will be 1/2 of the pruchase price
    */
    public TheRing(int dropRate, String type, int x, int y)
    {
        super(dropRate,type, x, y);
    }
    /*
        equip and unequip
    */
    @Override
    public void display() 
    {
        return;
    }
    @Override
    public Boolean isApplicable()
    {
        return false;
    }
    @Override
    public void useItem(Character c) {
        c.setHealth(c.getMaximumHealth());
    }
}