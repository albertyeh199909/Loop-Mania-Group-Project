package unsw.loopmania;

import java.util.Random;
import java.lang.Math;

/**
 * a basic form of enemy in the world
 */
public class BasicEnemy extends MovingEntity {
    // TODO = modify this, and add additional forms of enemy
    protected int health;
    private int battleRadius;
    protected int damage;
    private int supportRadius;

    protected MovingEntity movingEntity;

    private boolean inBattle;

    public BasicEnemy(PathPosition position, int health, int battleRadius, int damage, int supportRadius) {
        super(position);
        this.health = health;
        this.battleRadius = battleRadius;
        this.damage = damage;
        this.supportRadius = supportRadius;
    }

    /**
     * move the enemy
     */
    public void move(){
        // TODO = modify this, since this implementation doesn't provide the expected enemy behaviour
        // this basic enemy moves in a random direction... 25% chance up or down, 50% chance not at all...
        if (!inBattle) {
            int directionChoice = (new Random()).nextInt(2);
            if (directionChoice == 0) {
                moveUpPath();
            } else if (directionChoice == 1) {
                moveDownPath();
            }

            if (Math.hypot(getX() - character.getX(), getY() - character.getY()) <= battleRadius) {
                inBattle = true;
            }

        } else {
            if (Math.abs(getX() - character.getX()) > 1 || Math.abs(getY() - character.getY()) > 1) {
                moveUpPath();
            } else {
                inflictDamage();
            }
        }
    }

    public void inflictDamage(MovingEntity entity) {
        
        entity.takeDamage(new DamageClass(this, this.damage, 0));
        

        // else if for allied soldier using same format
    }

    public void takeDamage(DamageClass damage) {
        this.health -= damage.getDamage();
    }

    public int getHealth() {
        return this.health;
    }
}
