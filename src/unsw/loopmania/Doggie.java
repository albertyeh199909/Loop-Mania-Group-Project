package unsw.loopmania;

import java.util.*;


public class Doggie extends BasicEnemy{

    private DoggieCoin doggiecoin = null;
    private boolean isInit = true;

    public Doggie(PathPosition pathPosition) {
        super(pathPosition, 1, 5, 1);
        setMaximumHealth(70);
        setHealth(getMaximumHealth());
    }
    
   /**  the doggie has a chance to stun the main character
     * @param entity entity to attack   
     */
    @Override
    public void inflictDamage(MovingEntity movingEntity) {
        
        DamageClass damageClass = movingEntity.takeDamage(new DamageClass(this, this.damage,10));
        
        if (movingEntity instanceof Character) {
            // Turn alliedSoldier to zombie
            // 
            int randValue = new Random().nextInt(4);
            if(randValue == 1)
            {
                // 25% to stun the main character
                Character c = (Character) movingEntity;
                if(c.getStun() == false) 
                {
                    c.setStun(true);
                }
            }
        }
        
    }
    /**
     * deflates doggiecoin on defeat
     */
    @Override
    public DamageClass takeDamage(DamageClass damage){
        int health = getHealth() - damage.getDamage();
        setHealth(health);
        if(this.getHealth() <=0) {
            doggiecoin.setAmount(doggiecoin.getAmount()+1);
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
}
