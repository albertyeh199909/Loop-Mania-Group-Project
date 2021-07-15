package unsw.loopmania;

public class TheRing extends RareItem {
    //Constructor
    public TheRing(int dropRate, String type,PathPosition position)
    {
        super(dropRate,type,position);
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
