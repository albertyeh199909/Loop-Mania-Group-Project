package unsw.loopmania;

import java.util.Random;

public class Zombie extends BasicEnemy {
    int criticalChance = 10;
    public Zombie(PathPosition pathPosition) {
        super(pathPosition, 4, 5, 2);
        setHealth(3);
    }

    @Override
    public void inflictDamage(MovingEntity movingEntity) {
        
        DamageClass damageClass = movingEntity.takeDamage(new DamageClass(this, this.damage, this.criticalChance));
        /*
        if (movingEntity instanceof AlliedSoldier && damage.getIsCritical()) {
                // Turn alliedSoldier to zombie
        }
        */
    }

}
