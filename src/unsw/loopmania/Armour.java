package unsw.loopmania;

public class Armour extends BasicItem {

    //Constructor
    /*
        @param dropRate ----> the rate of dropping of an item when an enemy is defeated 
        @param type ----> the type of the item
        @param purchasePrice -----> the price for purhcase this item
        @param postion is the postion of the current item
        note: the sell price for this item will be 1/2 of the pruchase price
    */
    public Armour(int dropRate, String type, int purchasePrice,int x, int y)
    {
        super(dropRate,type, purchasePrice, x, y);
    }
    /*
        display the item in the frontend, 
    */
    @Override
    public void display() 
    {
        return;
    }
    /*
        return
    */
    @Override
    public Boolean isApplicable()
    {
        return false;
    }
}