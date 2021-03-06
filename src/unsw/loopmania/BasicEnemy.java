package unsw.loopmania;

import java.util.Random;
import java.lang.Math;

/**
 * a basic form of enemy in the world
 */
public abstract class BasicEnemy extends MovingEntity {
    // TODO = modify this, and add additional forms of enemy
    
    private int battleRadius;
    protected int damage;
    private int supportRadius;
    private int trance = -1;

    public void setTrance(int trance) {
        this.trance = trance;
    }

    public int getTrance() {
        return this.trance;
    }

    public int getBattleRadius() {
        return this.battleRadius;
    }

    public void setBattleRadius(int battleRadius) {
        this.battleRadius = battleRadius;
    }

    public int getDamage() {
        return this.damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getSupportRadius() {
        return this.supportRadius;
    }

    public void setSupportRadius(int supportRadius) {
        this.supportRadius = supportRadius;
    }

    protected MovingEntity movingEntity;

    private boolean inBattle;

    public BasicEnemy(PathPosition position, int battleRadius, int damage, int supportRadius) {
        super(position);
        this.battleRadius = battleRadius;
        this.damage = damage;
        this.supportRadius = supportRadius;
    }

    /**
     * move the enemy
     */
    public void move(Character character){
        // TODO = modify this, since this implementation doesn't provide the expected enemy behaviour
        // this basic enemy moves in a random direction... 25% chance up or down, 50% chance not at all...
        if (!inBattle) {
            
            int directionChoice = (new Random()).nextInt(4);
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
                //inflictDamage(character);
            }
        }
    }
    public void inflictDamage(MovingEntity entity) {
        
        entity.takeDamage(new DamageClass(this, this.damage, 0));
        

        // else if for allied soldier using same format
    }

    public boolean getInBattle() {
        return inBattle;
    }

    public void setInBattle(boolean inBattle) {
        this.inBattle = inBattle;
    }

    

    

    
}
