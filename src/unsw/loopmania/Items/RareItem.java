package unsw.loopmania.items;

public abstract class RareItem extends Item {
    //constructor for inheritance
    public RareItem()
    {}
    //Constructor
    /*
      @param dropRate ----> the rate of dropping of an item when an enemy is defeated 
      @param type ----> the type of the item
    */
    public RareItem(int dropRate, String type)
    {
         setDropRate(dropRate);
         setType(type);
    }
 }
