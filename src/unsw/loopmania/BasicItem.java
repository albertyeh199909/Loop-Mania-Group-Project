package unsw.loopmania;

public abstract class BasicItem extends Item {
   // constructor for heritance
   public BasicItem()
   {}
   //Constructor
   /*
      @param dropRate ----> the rate of dropping of an item when an enemy is defeated 
      @param type ----> the type of the item
      @param purchasePrice -----> the price for purhcase this item
      @param postion is the postion of the current item
      note: the sell price for this item will be 1/2 of the pruchase price
   */
   public BasicItem(int dropRate, String type, int purchasePrice,PathPosition position)
   {
        setDropRate(dropRate);
        setType(type);
        setPurchasePrice(purchasePrice);
        setPosition(position);
   }
}
