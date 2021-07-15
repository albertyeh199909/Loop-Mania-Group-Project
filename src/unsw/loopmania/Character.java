package unsw.loopmania;
import java.util.ArrayList;

/**
 * represents the main character in the backend of the game world
 */
public class Character extends MovingEntity {
    // TODO = potentially implement relationships between this class and other classes

    private World world;
    private ArrayList<BasicItem> inventory;
    private BasicItem weapon;
    private Helmet helmet;
    private Armor armor;
    private Shield shield;
    private int gold;
    private Damage damage = new UnarmedStrategy();
    private ArrayList<Defense> defense = new ArrayList<Defense>();
    private ArrayList<MovingEntity> activeEnemies = new Arraylist<MovingEntity>();
    //private boolean vampireCrit = false;
    
    public DamageClass takeDamage(DamageClass damageclass) {
        for(int i = 0; i < defense.size(); i++) {
            defense.get(i).specialEffect(damageclass);
        }

        for(int i = 0; i < defense.size(); i++) {
           defense.get(i).defense(damageclass);
        }
        setHealth(getHealth() - damageclass.getDamage()); 
        if(getHealth() < 0) {
            for(int i =0; i < inventory.size(); i++) {
                if(inventory.get(i) instanceof OneRing) {
                    inventory.get(i).use();
                    inventory.remove(i);
                }
            }
            else {
                world.loseGame();
            }
        }
        return damageclass;


    }

    public void dealDamage(Entity entity) {
        DamageClass damageclass = damage.dealDamage(this,entity);
        for(int i = 0; i < defense.size(); i++) {
            defense.get(i).specialEffect(damageclass);
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

    public Armor getArmor() {
        return this.armor;
    } 
    
    public Shield getShield() {
        return this.shield;
    }

    public int getGold() {
        return this.gold;
    }

    public ArrayList<Item> getInventory() {
        return this.inventory;
    }

    public setWeapon(BasicItem weapon) {
        if (this.weapon != null) {
            inventory.add(this.weapon);
        }
        removeItem(weapon);
        this.weapon = weapon;
        setStrategy(weapon);
        
        
    }

    public void setHelmet(Helmet helmet) {
        if (this.helmet != null) {
            inventory.add(this.helmet);
        }
        removeItem(shield);
        this.helmet = helmet;
        defense.add(new HelmetStrategy());
    }
        
    

    public setShield(Shield shield) {
        if (this.shield != null) {
            inventory.add(this.shield);
        }
        removeItem(shield);
        this.shield = shield;
        defense.add(new ShieldStrategy());
        
        
    }

    public void setArmor(Armor armor) {
        if (this.armor != null) {
            inventory.add(this.armor);
        }
        removeItem(armor);
        this.armor = armor;
        defense.add(new ArmorStrategy(),0);
    }

    public void useItem(Item item) {
        item.use();
        removeItem(item);
        
    }
        
        
        
        
    
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
    public void removeItem(Item item) {
        for(int i = 0; i < inventory.size(); i++) {
            if(inventory.get(i) == item) {
                inventory.remove(i);
            }
        }
    }



    
    
}
