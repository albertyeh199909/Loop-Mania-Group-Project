package unsw.loopmania;

public abstract class RareItem extends Item {
    //constructor for inheritance
    public RareItem()
    {}
    //Constructor
    /*
      @param dropRate ----> the rate of dropping of an item when an enemy is defeated 
      @param type ----> the type of the item
      @param postion is the postion of the current item
    */
    public RareItem(int dropRate, String type, PathPosition position)
    {
         setDropRate(dropRate);
         setType(type);
         setPosition(position);
    }
 }
