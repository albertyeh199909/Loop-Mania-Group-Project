package unsw.loopmania;

import java.util.Random;

public class DamageClass {
    private Entity damageDealer;
    private int value;
    private boolean isCritical;    //everytime the vampire finishes attack, check this variable
    private int criticalChance;

    public int getCriticalChance() {
        return this.criticalChance;
    }

    public void setCriticalChance(int criticalChance) {
        this.criticalChance = criticalChance;
    }

    public DamageClass(Entity damageDealer, int value, int criticalChance) {
        this.damageDealer = damageDealer;
        this.value = value;
        this.criticalChance =criticalChance;
    }

    public Entity getDamagedealer() {
        return this.damageDealer;
    }

    public void setDamagedealer(Entity damagedealer) {
        this.damageDealer = damagedealer;
    }

    public int getValue() {
        return this.value;
    }
    

    public void setValue(int value) {
        this.value = value;
    }

    public boolean getIsCritical() {
        return this.isCritical;
    }

    public void setIsCritical(boolean isCritical) {
        this.isCritical = isCritical;
    }

    public int getDamage() {
        int a =  new Random().nextInt(100);
        if(a < criticalChance)
        {
            this.value = this.value * 2;
            this.isCritical = true;
        } 
        return value;
    }
    
}
