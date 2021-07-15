package unsw.loopmania.items;

public class TheRing extends RareItem {
    //Constructor
    public TheRing(int dropRate, String type)
    {
        super(dropRate,type);
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
