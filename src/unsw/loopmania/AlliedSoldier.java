package unsw.loopmania;



public class AlliedSoldier extends MovingEntity{
    int bonus = 2;
    /**
     * 
     */
    public AlliedSoldier() {
        super(null);
        setHealth(4);
    }
    
    public int getBonus() {
        return this.bonus;
    }

    
    

}

