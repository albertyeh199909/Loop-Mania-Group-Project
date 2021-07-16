package unsw.loopmania;

public class Trap extends Building {
   

    public Trap(int x, int y) {
        super(x,y,"Trap", 1);
    }

    public void dealDamage(BasicEnemy enemy) {
        enemy.takeDamage(new DamageClass(this, 2,0));
        //this.destroy();
    }
}