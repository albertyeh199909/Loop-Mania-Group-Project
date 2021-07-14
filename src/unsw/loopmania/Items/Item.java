package unsw.loopmania.items;

public abstract class Item {
    private int dropRate;
    private String type;
    private int purchasePrice;
    private int sellPrice;      

    public Item()
    {

    }

    /*
        Setters
    */
    public void setDropRate(int dropRate) {
        this.dropRate = dropRate;
    }
    
    public void setType(String type) {
        this.type = type;
    }

    public void setPurchasePrice(int purchasePrice)
    {
        this.purchasePrice = purchasePrice;
        this.sellPrice = purchasePrice/2;
    }

    /*
        check whether the player can "use" 
    */
    public Boolean isApplicable()
    {
        return true;   
    }

    public void display()
    {
        return;
    }

    public void useItem(Character c)
    {
        return;
    }

    /*
        Getters
    */
    public String getType() {
        return type;
    }

    public int getDropRate() {
        return dropRate;
    }

    public int getpurchasePrice() {
        return purchasePrice;
    }

    public int getSellPrice() {
        return sellPrice;
    }
}
