package unsw.loopmania;
import java.util.ArrayList;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.IntegerProperty;

/**
 * represents the main character in the backend of the game world
 */
public class Character extends MovingEntity {
    // TODO = potentially implement relationships between this class and other classes
    

    private BasicItem weapon;
    private Helmet helmet;
    private Armour armor;
    private Shield shield;
    private int gold;
    private int experience = 0;
    
    

    private Damage damage = new UnarmedStrategy();
    private ArrayList<Defense> defense = new ArrayList<Defense>();
    private IntegerProperty healthDisplay;
    private IntegerProperty goldDisplay;
    private IntegerProperty xpDisplay;

    // the Stuned 
    private boolean isStuned = false;
    
    
    //private boolean vampireCrit = false;
    
    /** goes through the defensive strategies and set health to reflect damage taken
     * @param damageclass damageclass that contains all damage info
     * 
     */
    @Override
    public DamageClass takeDamage(DamageClass damageclass) {
        for(int i = 0; i < defense.size(); i++) {
            defense.get(i).specialEffect(damageclass);
        }

        for(int i = 0; i < defense.size(); i++) {
           defense.get(i).defense(damageclass);
        }
        setHealth(getHealth() - damageclass.getDamage()); 
       

        
        return damageclass;


    }
    /**
     * deal damage to entity based on allied soldiers and weapon strategy
     * @param entity
     * @param array
     */
    public void dealDamage(BasicEnemy entity,ArrayList<AlliedSoldier> array) {
        DamageClass damageclass = damage.dealDamage(this,entity);
        for(int i = 0; i < defense.size(); i++) {
            defense.get(i).specialEffect(damageclass);
        }
        for(int i = 0; i < array.size(); i++) {
            damageclass.setValue(damageclass.getValue()+array.get(i).getBonus());
        }
        entity.takeDamage(damageclass);

    }

    public Character(PathPosition position) {
        super(position);
        setMaximumHealth(100);
        this.healthDisplay= new SimpleIntegerProperty(getMaximumHealth());
        setHealth(getMaximumHealth());
        this.goldDisplay= new SimpleIntegerProperty(0);
        this.xpDisplay= new SimpleIntegerProperty(0);
        
    }

    @Override
    public void setHealth(int health) {
        super.setHealth(health);
        this.healthDisplay.set(health);

    }

    public IntegerProperty getHealthIntegerProperty(){
        return this.healthDisplay;
    }

    public IntegerProperty getGoldIntegerProperty() {
        return this.goldDisplay;
    }

    public IntegerProperty getXPIntegerProperty() {
        return this.xpDisplay;
    }

    public Damage getDamage() {
        return damage;
    }

    public void move() {
        super.moveDownPath();
    }

    public BasicItem getWeapon() {
        return this.weapon;
    }

    public Armour getArmor() {
        return this.armor;
    } 
    
    public Shield getShield() {
        return this.shield;
    }

    public int getGold() {
        return this.gold;
    }

    public void setGold(int number) {
        this.gold = number;
        this.goldDisplay.set(number);
    }

    public void setStun(boolean b)
    {
        this.isStuned = b;
    }

    public boolean getStun()
    {
        return isStuned;
    }

    

    /**
     * Change the wewapon the player character is wearing.
     * @param weapon The weapon to be equipped
     */
    public void setWeapon(BasicItem weapon) {
        
        
        this.weapon = weapon;
        setStrategy(weapon);
        
        
    }

    /**
     * Change the armor the player character is wearing.
     * @param helmet The helmet to be equipped
     */
    public void setHelmet(Helmet helmet) {
        
        this.helmet = helmet;
        int index = -1;
        for(Defense def: defense) {
            if(def instanceof HelmetStrategy) {
                index = defense.indexOf(def);
               
                
            }    
        }
        if(index != -1) {
            defense.remove(index);
            defense.add(index,new HelmetStrategy());
            
        }
        defense.add(new HelmetStrategy());
    }
        
    
    /**
     * Change the shield the player character is wearing.
     * @param shield The shield to be equipped
     */
    public void setShield(Shield shield) {
        
        this.shield = shield;
        if(shield instanceof TreeStump) {
            int index  = -1;
            for(Defense def: defense) {
                if(def instanceof ShieldStrategy || def instanceof TreeStumpStrategy) {
                    index = defense.indexOf(def);
                }    
            }
            if(index != -1) {
                defense.remove(index);
                defense.add(index, new TreeStumpStrategy());
            }
            else {
                defense.add(new TreeStumpStrategy());
            }
        }
        else {
            defense.add(new ShieldStrategy());
        }
    }

    /**
     * Change the armor the player character is wearing.
     * @param The armor to be equipped
     */
    public void setArmor(Armour armor) {
        
        this.armor = armor;
        int index = -1;
        for(Defense def: defense) {
            if(def instanceof ArmorStrategy) {
                index = defense.indexOf(def);
                defense.remove(index);
                
            }    
        }
        if(index != -1) {
            defense.remove(index);
           
        }

        defense.add(0,new ArmorStrategy());
        
    }

    

    public void useItem(Item item) {
        if(item.isApplicable()) {
            item.useItem(this);
            
        }
        
    }      
        
    /** 
     * Changes the strategy with the player's weapon accordingly 
     * @param weapon The weapon that the character is equipped with
     */
    public void setStrategy(BasicItem weapon) {
        
        if(weapon instanceof Sword) {
            damage = new SwordStrategy();
        } 
        else if (weapon instanceof Anduril) {
            damage = new AndurilStrategy();
        }
        else if(weapon instanceof Staff) {
            damage = new StaffStrategy();
        } 
        else if(weapon instanceof Stake) {
            damage = new StakeStrategy();
        } 
    }

    public int getExperience() {
        return this.experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
        this.xpDisplay.set(experience);
    }



    
    
}
