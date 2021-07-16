package unsw.loopmania;

public class Tower extends Building {
    
    private int attackRadius;

    public Tower(int x, int y) {
        super(x,y,"Tower", 3);
        attackRadius = 1;
    }

   

    public int getAttackRadius() {
        return attackRadius;
    }

    public void dealDamage(BasicEnemy enemy) {
        enemy.takeDamage(new DamageClass(this, 2,0));
    }
}