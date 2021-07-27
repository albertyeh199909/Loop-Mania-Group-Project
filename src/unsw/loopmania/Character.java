package unsw.loopmania;
import java.util.ArrayList;

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
     * deal daamge to entity based on allied soldiers and weapon strategy
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
        setHealth(20);
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
        defense.add(new HelmetStrategy());
    }
        
    
    /**
     * Change the shield the player character is wearing.
     * @param shield The shield to be equipped
     */
    public void setShield(Shield shield) {
        
        this.shield = shield;
        defense.add(new ShieldStrategy());
        
        
    }

    /**
     * Change the armor the player character is wearing.
     * @param The armor to be equipped
     */
    public void setArmor(Armour armor) {
        
        this.armor = armor;
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
    }



    
    
}
