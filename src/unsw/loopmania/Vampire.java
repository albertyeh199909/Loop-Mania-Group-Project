package unsw.loopmania;

import java.util.Random;

public class Vampire extends BasicEnemy {
    private boolean isCrit = false;

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
    public void inflictDamage() {
        if (isCrit) {
            ((Character) movingEntity).takeDamage(new DamageClass(this, this.damage * 2, 0));
        } else {
            int number = new Random().nextInt(100);
            if (number < 15) {
                isCrit = true;
                ((Character) movingEntity).takeDamage(new DamageClass(this, this.damage * 2, 0));
            } else {
                ((Character) movingEntity).takeDamage(new DamageClass(this, this.damage, 0));
            }
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
