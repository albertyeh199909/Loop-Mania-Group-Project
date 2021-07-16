package unsw.loopmania;




public abstract class Item extends StaticEntity{
    private int dropRate;
    private String type;
    private int purchasePrice;
    private int sellPrice;     

    public Item()
    {
        
    }

    //    Setters
    /**
    *   @param dropRate of a item, so a higher drop rate would mean a higher chance of 
    *   of dropping when an enemy is defeated.
    */
    public void setDropRate(int dropRate) {
        this.dropRate = dropRate;
    }

    /**
    *   @param type is just the name of the type of an item
    */
    public void setType(String type) {
        this.type = type;
    }

    /**
    *   @param purchasePrice is the price which an item is sold in 
    *   hero's castle, it is worth noting that sell price is half of the purchase price
    */
    public void setPurchasePrice(int purchasePrice)
    {
        this.purchasePrice = purchasePrice;
        this.sellPrice = purchasePrice/2;
    }

    /*
        check whether the player can "use" this particular item
        note, the potion is the only item which can be use at this milestone(2)
    */
    public Boolean isApplicable()
    {
        return true;   
    }

    /*
        display this particular item to frotend
    */
    public void display()
    {
        return;
    }

    /*
        use this item for its special effect
    */
    public void useItem(Character c)
    {
        return;
    }

    /*
        Getters
    */

    /*
        @return the type of the this item
    */
    public String getType() {
        return type;
    }


    /*
        @return the droprate of the this item
    */
    public int getDropRate() {
        return dropRate;
    }

    /*
        @return the purchaseprice of the this item
    */
    public int getpurchasePrice() {
        return purchasePrice;
    }

    /*
        @return the type of the this item
    */
    public int getSellPrice() {
        return sellPrice;
    }
}
