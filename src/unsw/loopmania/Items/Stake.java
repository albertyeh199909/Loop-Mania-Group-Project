package unsw.loopmania.items;

public class Stake extends BasicItem {
    //Constructor
    /*
      @param dropRate ----> the rate of dropping of an item when an enemy is defeated 
      @param type ----> the type of the item
      @param purchasePrice -----> the price for purhcase this item
      note: the sell price for this item will be 1/2 of the pruchase price
    */
    public Stake(int dropRate, String type, int purchasePrice)
    {
        super(dropRate,type,purchasePrice);
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
}

