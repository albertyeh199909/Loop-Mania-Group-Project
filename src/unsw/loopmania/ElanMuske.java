package unsw.loopmania;

public class ElanMuske extends BasicEnemy{

    private DoggieCoin doggiecoin = null;
    private boolean isInit = true;

    /**
     * inflates doggiecoin on spawn
     * @param pathPosition pathposition for entity
     */
    public ElanMuske(PathPosition pathPosition) {  
        super(pathPosition, 1, 20, 1);
        setMaximumHealth(50);
        setHealth(getMaximumHealth());
        
    }

    
    /**
     * deflates doggiecoin on defeat
     */
    @Override
    public DamageClass takeDamage(DamageClass damage){
        int health = getHealth() - damage.getDamage();
        setHealth(health);
        if(this.getHealth() <=0) {
            doggiecoin.deflation();
        }
        return damage;

    }

    public void setDoggieCoin(DoggieCoin doggiecoin) {
        this.doggiecoin = doggiecoin;
        if(isInit == true)
        {
            this.doggiecoin.inflation();
            isInit = false;
        }
    }

    /**
    *   @param b the basicenemy to heal
    */
    public boolean heal(BasicEnemy b) 
    {
        if(b.getHealth() > 0 && b.getHealth() < b.getMaximumHealth() && b.getTrance() == -1)
        {
            b.setHealth(b.getHealth() + 1);
            return true;
        }
        return false;
    }
}
