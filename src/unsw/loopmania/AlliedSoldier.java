package unsw.loopmania;



public class AlliedSoldier extends MovingEntity{
    private int bonus = 2;
    private boolean isAlive = true;
    private boolean turnedToZombie = false;
    private PathPosition locationIfConvertedZombie = null; 
    private BasicEnemy convertedFrom = null;
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

    public boolean getIsAlive() {
        return this.isAlive;
    }

    public void setIsAlive(boolean isAlive) {
        this.isAlive =isAlive;
    }

    public boolean getTurnToZombie() {
        return this.turnedToZombie;
    }

    public void setTurnToZombie(boolean turnedToZombie) {
        this.turnedToZombie = turnedToZombie;
        //this.isAlive = false;
    }

    public PathPosition getPath() {
        return this.locationIfConvertedZombie;
    }

    public void setPath(PathPosition locationIfConvertedZombie) {
        this.locationIfConvertedZombie = locationIfConvertedZombie;
    }

    public BasicEnemy getConvertedFrom() {
        return convertedFrom;
    }

    public void setConvertedFrom(BasicEnemy convertedFrom) {
        this.convertedFrom = convertedFrom;
    }




    
    

}

