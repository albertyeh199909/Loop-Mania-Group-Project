package unsw.loopmania;
import java.util.ArrayList;

/**
 * represents the main character in the backend of the game world
 */
public class Character extends MovingEntity {
    // TODO = potentially implement relationships between this class and other classes
    
    private ArrayList<Item> inventory = new ArrayList<Item>();
    private BasicItem weapon;
    private Helmet helmet;
    private Armour armor;
    private Shield shield;
    private int gold;
    private int experience = 0;

    

    private Damage damage = new UnarmedStrategy();
    private ArrayList<Defense> defense = new ArrayList<Defense>();
    private ArrayList<MovingEntity> activeEnemies = new ArrayList<MovingEntity>();
    
    //private boolean vampireCrit = false;
    
    @Override
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
                if(inventory.get(i) instanceof TheRing) {
                    inventory.get(i).useItem(this);
                    inventory.remove(i);
                }
            }
  
        }

        if(getHealth() < 0)  {
            //world.loseGame();
        }
        return damageclass;


    }

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

    public ArrayList<Item> getInventory() {
        return this.inventory;
    }

    public void setWeapon(BasicItem weapon) {
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
        
    

    public void setShield(Shield shield) {
        if (this.shield != null) {
            inventory.add(this.shield);
        }
        removeItem(shield);
        this.shield = shield;
        defense.add(new ShieldStrategy());
        
        
    }

    public void setArmor(Armour armor) {
        if (this.armor != null) {
            inventory.add(this.armor);
        }
        removeItem(armor);
        this.armor = armor;
        defense.add(0,new ArmorStrategy());
    }

    public void store(Item item) {
        if(inventory.size() == 16) {
            setGold(inventory.get(0).getpurchasePrice()/4);
            experience += 50;
            inventory.remove(0);
            
        }
        inventory.add(item);
    }

    public void useItem(Item item) {
        if(item.isApplicable()) {
            item.useItem(this);
            removeItem(item);
        }
        
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

    public int getExperience() {
        return this.experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }



    
    
}
