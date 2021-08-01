package unsw.loopmania;

import java.util.Random;

public class Vampire extends BasicEnemy {
    private boolean isCrit = false;
    private int criticalChance = 10;    

    public Vampire(PathPosition pathPosition) {
        super(pathPosition, 4, 10, 6);
        setMaximumHealth(10);
        setHealth(getMaximumHealth());
    }
    
    @Override
    public void move(Character character) {
        //Twice as fast as zombies
        super.move(character);
        super.move(character);
    }
    
    /** damages entity, if damageClass returns isCritical true then vampire does bonus damage for random amount of times
     * @param entity entity to attack   
     */
    @Override
    public void inflictDamage(MovingEntity entity) {
        int damageValue = this.damage;
        if (isCrit) {
            damageValue = damageValue + new Random().nextInt(3);

            int continueCrit =  new Random().nextInt(100);
            if(continueCrit < 90) {
                isCrit = false;
            }
        }
        
        DamageClass damage = entity.takeDamage(new DamageClass(this, damageValue, this.criticalChance));
        
        if(damage.getIsCritical()) {
            isCrit = true;
        }
        
    }

    /**
     * used for testing only
     * @return whether attack was critical bite
     */
    public boolean getIsCrit() {
        return isCrit;
    }

    
}
