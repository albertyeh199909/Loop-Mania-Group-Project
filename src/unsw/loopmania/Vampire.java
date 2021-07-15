package unsw.loopmania;

import java.util.Random;

public class Vampire extends BasicEnemy {
    private boolean isCrit = false;
    private int criticalChance = 10;    

    public Vampire(PathPosition pathPosition) {
        super(pathPosition, 10, 4, 10, 2);
    }

    @Override
    public void move() {
        //Twice as fast as zombies
        super.move();
        super.move();
    }

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

    @Override
    public void takeDamage(DamageClass damage) {
        if (damage.getDamagedealer() instanceof Stake) {
            // Extra damage by stake
            this.health -= damage.getDamage() * 2;
        } else {
            this.health -= damage.getDamage();
        }
    }
}
