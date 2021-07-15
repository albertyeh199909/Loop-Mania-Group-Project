package unsw.loopmania;

public class Potion extends BasicItem {
    //Constructor
    /*
        @param dropRate ----> the rate of dropping of an item when an enemy is defeated 
        @param type ----> the type of the item
        @param purchasePrice -----> the price for purhcase this item
        @param postion is the postion of the current item
        note: the sell price for this item will be 1/2 of the pruchase price
    */
    public Potion(int dropRate, String type, int purchasePrice,PathPosition position)
    {
        super(dropRate,type, purchasePrice,position);
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
        return true;
    }

    @Override
    public void useItem(Character c)
    {
        //c.setHealth(20);
    }
}
