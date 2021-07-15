package unsw.loopmania.buildings;

public class Tower extends Building {
    private int attack;
    private int attackRadius;

    public Tower() {
        super("Tower", 3);
        attack = 1;
        attackRadius = 1;
    }

    public int getAttack() {
        return attack;
    }

    public int getAttackRadius() {
        return attackRadius;
    }
}