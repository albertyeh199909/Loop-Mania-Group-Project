package unsw.loopmania;

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
            ((Character) movingEntity).takeDamage(new DamageClass(this, 20, 0));
        } else {

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
