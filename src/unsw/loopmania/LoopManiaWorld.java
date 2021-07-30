package unsw.loopmania;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.javatuples.Pair;

import javafx.beans.property.SimpleIntegerProperty;

/**
 * A backend world.
 * can contain many entities, each occupy a square. More than one
 * entity can occupy the same square.
 */
public class LoopManiaWorld {
    // TODO = add additional backend functionality

    public static final int unequippedInventoryWidth = 4;
    public static final int unequippedInventoryHeight = 4;

    
    public int cycleCounter = 1;
    /**
     * width of the world in GridPane cells
     */
    private int width;

    /**
     * height of the world in GridPane cells
     */
    private int height;
    
    /*
    * the pos of the main character
    * the checker that checks the monster has already been spawned.
    */
    private int initMainCharacterPosX;
    private int initMainCharacterPosY;
    private int VampireSpawnChecker = 0;
    private int ZombieSpawnChecker = 0;



    /**
     * generic entitites - i.e. those which don't have dedicated fields
     */
    private List<Entity> nonSpecifiedEntities;

    private Character character;

    // TODO = add more lists for other entities, for equipped inventory items, etc...

    // TODO = expand the range of enemies
    private List<BasicEnemy> enemies;

    // TODO = expand the range of cards
    private List<Card> cardEntities;

    // TODO = expand the range of items
    private List<Entity> unequippedInventoryItems;

    // The list of equippedItems
    private List<Entity> equippedInventoryItems;

    // create a marketplace class
    private MarketHandler markethandler;


    // TODO = expand the range of buildings
    private List<Building> buildingEntities;

    private ArrayList<AlliedSoldier> friendlySoldiers = new ArrayList<AlliedSoldier>();
    
    /**
     * list of x,y coordinate pairs in the order by which moving entities traverse them
     */
    private List<Pair<Integer, Integer>> orderedPath;

    private DoggieCoin doggieCoin = new DoggieCoin();

    /**
     * create the world (constructor)
     * 
     * @param width width of world in number of cells
     * @param height height of world in number of cells
     * @param orderedPath ordered list of x, y coordinate pairs representing position of path cells in world
     */
    public LoopManiaWorld(int width, int height, List<Pair<Integer, Integer>> orderedPath) {
        this.width = width;
        this.height = height;
        nonSpecifiedEntities = new ArrayList<>();
        character = null;
        enemies = new ArrayList<>();
        cardEntities = new ArrayList<>();
        unequippedInventoryItems = new ArrayList<>();
        this.orderedPath = orderedPath;
        buildingEntities = new ArrayList<>();
        markethandler = new MarketHandler();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void addSoldier() {
        this.friendlySoldiers.add(new AlliedSoldier());
    }

    public Character getCharacter()
    {
        return this.character;
    }

    public List<Entity> getInventory() {
        return this.unequippedInventoryItems;
    }

    public void addItem(BasicItem item) {
        unequippedInventoryItems.add(item);
    }
    public int getCycleCounter() {
        return this.cycleCounter;
    }
    public void addACard(Card card)
    {
        cardEntities.add(card);
    }

    public void addEnemy(BasicEnemy e)
    {
        enemies.add(e);
    }

    public List<Building> getBuildingList()
    {
        return buildingEntities;
    }

    public List<Card> getCardEntities()
    {
        return cardEntities;
    }


    /**
     * set the character. This is necessary because it is loaded as a special entity out of the file
     * @param character the character
     */
    public void setCharacter(Character character) {
        this.character = character;
        // retrive the pos of the character
        this.initMainCharacterPosX = character.getX();
        this.initMainCharacterPosY = character.getY();
    }

    /**
     * add a generic entity (without it's own dedicated method for adding to the world)
     * @param entity
     */
    public void addEntity(Entity entity) {
        // for adding non-specific entities (ones without another dedicated list)
        // TODO = if more specialised types being added from main menu, add more methods like this with specific input types...
        nonSpecifiedEntities.add(entity);
    }
    public int adjacentTile(Building building) {
        int x = building.getX();
        int y = building.getY();

        for(int i = x-1; i < x+2; i++) {
            for(int j = y-1; j < y+2;j++) {
                if(i!=x && j!= y) {
                    Pair<Integer,Integer> pair = new Pair<Integer, Integer>(i,j);
                    if(orderedPath.contains(pair)) {
                        return orderedPath.indexOf(pair);
                    }
                }
            }
        }
        return -1;
    }

    /**
     * spawns enemies if the conditions warrant it, adds to world
     * @return list of the enemies to be displayed on screen
     */
    public List<BasicEnemy> possiblySpawnEnemies(){
        // TODO = expand this very basic version
        // go through all the building try to to find zombie pit and Vampire catsle

        
        List<BasicEnemy> spawningEnemies = new ArrayList<>();
        for(int i =0; i < buildingEntities.size();i++) {
            if(buildingEntities.get(i) instanceof ZombiePit) {
                if(adjacentTile(buildingEntities.get(i))!= -1) {
                    PathPosition pos = new PathPosition(adjacentTile(buildingEntities.get(i)), orderedPath);
                    if(cycleCounter != ZombieSpawnChecker)
                    {
                        Zombie zombie = new Zombie(pos);
                        spawningEnemies.add(zombie);
                        enemies.add(zombie);
                        ZombieSpawnChecker = cycleCounter;
                    }
                }
            }
            else if(buildingEntities.get(i) instanceof VampireCastle && cycleCounter%5 ==0) {
                
                if(adjacentTile(buildingEntities.get(i))!= -1) {
                    PathPosition pos = new PathPosition(adjacentTile(buildingEntities.get(i)), orderedPath);
                    if(cycleCounter != VampireSpawnChecker)
                    {
                        Vampire v = new Vampire(pos);
                        spawningEnemies.add(v);
                        enemies.add(v);
                        VampireSpawnChecker = cycleCounter;
                    }
                }
            }
        }
        Pair<Integer, Integer> pos = possiblyGetBasicEnemySpawnPosition();
        
        if (pos != null){
            int indexInPath = orderedPath.indexOf(pos);
            BasicEnemy enemy = new Slug(new PathPosition(indexInPath, orderedPath));
            enemies.add(enemy);
            spawningEnemies.add(enemy);
        }
        pos = possiblyGetBasicEnemySpawnPosition();
        if (pos != null && cycleCounter % 40 == 0 && character.getExperience() == 10000) {
            int indexInPath = orderedPath.indexOf(pos);
            ElanMuske elan = new ElanMuske(new PathPosition(indexInPath, orderedPath));
            enemies.add(elan);
            spawningEnemies.add(elan);
        }
        pos = possiblyGetBasicEnemySpawnPosition();
        if (pos != null && cycleCounter % 20 == 0 ) {
            int indexInPath = orderedPath.indexOf(pos);
            Doggie doggie = new Doggie(new PathPosition(indexInPath, orderedPath));
            enemies.add(doggie);
            spawningEnemies.add(doggie);
        }
        return spawningEnemies;
    }

    /**
     * kill an enemy
     * @param enemy enemy to be killed
     */
    private void killEnemy(BasicEnemy enemy){
        enemy.destroy();
        enemies.remove(enemy);
    }

    public boolean isAEntityInBuildingRange(Building towerOrFire, MovingEntity entity) {
        if(!(towerOrFire instanceof Tower) && !(towerOrFire instanceof Campfire)) {
            return false;
        }
        int eX = entity.getX();
        int eY = entity.getY();
        int x = towerOrFire.getX();
        int y = towerOrFire.getY();

        for(int i = x-1; i < x+2; i++) {
            for(int j = y-1; j < y+2;j++) {
                if(i!=x && j!= y) {
                    Pair<Integer,Integer> pair = new Pair<Integer, Integer>(i,j);
                    if(orderedPath.contains(pair)) {
                        if(eX == i && eY == j ) { 
                            return true;
                        }
                        
                    }
                }
            }
        }

       
        return false;
    }

    //####################################################################################################################################################################
    //###################################################################################################################################################################

    // helper function for runbattle
    // check if a main character is affected by campfire
    private boolean characterAffectedByCampfire()
    {
        // check wheather the character is affcected by campfire
        boolean affectedByCampfire = false;

        for(Building b: buildingEntities) {
            if(b instanceof Campfire) {
                if(isAEntityInBuildingRange(b,character)) {
                    affectedByCampfire = true;
                }

            }
        }
        return affectedByCampfire;
    }

    // helper funtion that acutally runs one battle
    // this function is a helper function which will be called in runbattle function
    public void executeBattle(List<BasicEnemy> enemiesInBattle, List<BasicEnemy> defeatedEnemies) {
        character.setStun(false );
        while(true) {
                // first we want to "use" the tower first
                // every tower will attack any enemy that entered the range
                for(BasicEnemy e: enemiesInBattle) {
                    for(Building b: buildingEntities) {
                        if(b instanceof Tower && e.getHealth() > 0 && (e.getTrance() == -1)) {
                            if(isAEntityInBuildingRange(b, e)) {
                                Tower t = (Tower)b;
                                t.dealDamage(e);
                            }
                        }
                    }   
                }
                // update the defeatedEnemies
                // if these enemies are terminated by the tower
                for(BasicEnemy e: enemiesInBattle) {
                    if(e.getHealth() <= 0) {
                        defeatedEnemies.add(e);
                    }
                }

                // the monster attack the main character
                // we need to consider the probability of allied soidlers being converted to zombie
                int counter = 0;
                for(BasicEnemy e: enemiesInBattle) {
                    if(e instanceof ElanMuske) {
                        // if the enemy is elan muske
                        ElanMuske elan = (ElanMuske) e;
                        for(BasicEnemy other : enemiesInBattle) {
                            if(other != elan && elan.heal(other))
                                // elan muske only heals one enemy at ont time
                                break;
                        }
                        
                    }
                    if(!defeatedEnemies.contains(e) && e.getTrance() == -1) {
                        while(counter < friendlySoldiers.size()) 
                        {
                            AlliedSoldier s = friendlySoldiers.get(counter);
                            if(s.getHealth() > 0 && s.getTurnToZombie() == false &&counter < friendlySoldiers.size()) {
                                e.inflictDamage(friendlySoldiers.get(counter));
                                break;
                                
                            }
                            else if ((s.getHealth() <=0 || s.getTurnToZombie() == true) && counter < friendlySoldiers.size()) {
                                counter++;
                                s.setIsAlive(false);
                            }
                        }  
                        if(!defeatedEnemies.contains(e) && counter >= friendlySoldiers.size() && e.getTrance() == -1){
                            e.inflictDamage(character);
                        } 
                    }
                    
                }
                
                //if an allied soilder is turned to a zombie
                ArrayList<AlliedSoldier> RemoveAlliedSoldierL = new ArrayList<AlliedSoldier>();
                // get the list of friendly soliders to be removed 
                for(AlliedSoldier s: friendlySoldiers) 
                {
                    if(s.getTurnToZombie()) {
                        RemoveAlliedSoldierL.add(s);
                        enemiesInBattle.add(new Zombie(s.getPath()));
                    }
                }
                //remove the allied soilder that turned into a zombie
                for(AlliedSoldier a: RemoveAlliedSoldierL)
                {
                    if(friendlySoldiers.contains(a))
                        friendlySoldiers.remove(a);     
                }
                
                
                // check wheather the character is affcected by campfire
                boolean affectedByCampfire = characterAffectedByCampfire();

                // the main character attack the monster
                // need to consider the condition of the any enemy being converted to friendly.
                for(BasicEnemy e : enemiesInBattle)
                {
                    if(e.getTrance() == -1 && !(defeatedEnemies.contains(e)) && character.getHealth() > 0 && !character.getStun())
                    {
                        // we simply let the 
                        if(affectedByCampfire)
                        {
                            character.dealDamage(e, friendlySoldiers);
                            character.dealDamage(e, friendlySoldiers);
                        }
                        else
                        {
                            character.dealDamage(e, friendlySoldiers);
                        }
                        break;
                    }

                }
                
                for(BasicEnemy e: enemiesInBattle) {
                    if(e.getTrance() == 3) {
                        AlliedSoldier s = new AlliedSoldier();
                        s.setHealth(e.getHealth());
                        s.setConvertedFrom(e);
                        friendlySoldiers.add(s);
                    }
                    
                }

                // if an alliedSoilder is converted back to enemy, then remove the allied soilder
                ArrayList<AlliedSoldier> RemoveAlliedSoldierL1  = new ArrayList<AlliedSoldier>();
                
                //for every enemed tranced, decrement time left of trance
                for(BasicEnemy e: enemiesInBattle) {
                    if(e.getTrance() != -1) 
                        e.setTrance(e.getTrance() - 1);
                    
                    if(e.getTrance() == 0)
                    {
                        e.setTrance(-1);
                        for(AlliedSoldier s: friendlySoldiers) 
                        {
                            if(s.getConvertedFrom() != null && s.getConvertedFrom() == e) {
                                RemoveAlliedSoldierL1.add(s); 
                            }
                        } 
                    }
                }
                
                //remove the allied soilder that turned into a zombie
                for(AlliedSoldier a: RemoveAlliedSoldierL1)
                {
                    if(friendlySoldiers.contains(a))
                        friendlySoldiers.remove(a);     
                }

                //determine whether the battle is over
                if(character.getHealth() <= 0)
                {
                    break;
                }
                // any there is still an undeafted enemy then simply carry on the battle
                boolean continueBattle = false;
                for(BasicEnemy e : enemiesInBattle)
                {
                    if(e.getHealth() > 0 && e.getTrance() == -1)
                        continueBattle = true;
                }
                if(continueBattle == false)
                    break;
        }
    }

    //############################################################################################################################################################
    //############################################################################################################################################################

    /**
     * run the expected battles in the world, based on current world state
     * @return list of enemies which have been killed
     */
    public List<BasicEnemy> runBattles() {
        // TODO = modify this - currently the character automatically wins all battles without any damage!
        //tower monster and players
        // the tower will attack the adjancent enemies
        List<BasicEnemy> defeatedEnemies = new ArrayList<BasicEnemy>();
        List<BasicEnemy> enemiesInBattle = new ArrayList<BasicEnemy>();
        // check all the in range enemies 
        for (BasicEnemy e: enemies){
            // Pythagoras: a^2+b^2 < radius^2 to see if within radius
            // TODO = you should implement different RHS on this inequality, based on influence radii and battle radii
            //check if character is in battle radius, if so set battle to true
            //if battle is true, check if character in support radius
            if (Math.pow((character.getX()-e.getX()), 2) +  Math.pow((character.getY()-e.getY()), 2) <=  Math.pow(e.getBattleRadius(),2)){
                // fight...
                e.setInBattle(true);
                enemiesInBattle.add(e);
                System.out.println(e.getClass());
                //defeatedEnemies.add(e);
            }
        }
        //if main character is in support radius, add enemy to list of combatants
        for (BasicEnemy e: enemies){
            if (Math.pow((character.getX()-e.getX()), 2) +  Math.pow((character.getY()-e.getY()), 2) < e.getSupportRadius()){
                // fight...
                // get in battle is simply a boolean
                if(!e.getInBattle()) {
                    e.setInBattle(true);
                    enemiesInBattle.add(e);
                }
            }
        }

        System.out.println(character.getHealth());
        // execute the battle here !!!
        executeBattle(enemiesInBattle, defeatedEnemies);

        // we need function to indicate the character has lost the battle

        //remove the defated enemy after the battle
        for (BasicEnemy e: defeatedEnemies){
            // IMPORTANT = we kill enemies here, because killEnemy removes the enemy from the enemies list
            // if we killEnemy in prior loop, we get java.util.ConcurrentModificationException
            // due to mutating list we're iterating over
            System.out.println("KILLL");
            killEnemy(e);
        }
        return defeatedEnemies;
    }

    /**
     * spawn a card in the world and return the card entity
     * @return a card to be spawned in the controller as a JavaFX node
     */
    public Card Card(){
        // if adding more cards than have, remove the first card...
        if (cardEntities.size() >= getWidth()){
            // TODO = give some cash/experience/item rewards for the discarding of the oldest card
            character.setExperience(character.getExperience()+100);
            character.setGold(character.getGold()+100);
            removeCard(0);
        }
        Card card = null;
        Random random = new Random();
        // the player will be rewarded from these cards
        // and the droprate of those cards are equally distrubted

        int value = random.nextInt(7);
        //using switch breaks the random
        if(value == 0)
            card = new VampireCastleCard(new SimpleIntegerProperty(cardEntities.size()), new SimpleIntegerProperty(0));
        else if(value == 1)
            card = new ZombiePitCard(new SimpleIntegerProperty(cardEntities.size()), new SimpleIntegerProperty(0));
        else if(value == 2)
            card = new TowerCard(new SimpleIntegerProperty(cardEntities.size()), new SimpleIntegerProperty(0));
        else if(value == 3)
            card = new BarracksCard(new SimpleIntegerProperty(cardEntities.size()), new SimpleIntegerProperty(0));
        else if(value == 4)
            card = new VillageCard(new SimpleIntegerProperty(cardEntities.size()), new SimpleIntegerProperty(0));
        else if(value == 5)
            card = new TrapCard(new SimpleIntegerProperty(cardEntities.size()), new SimpleIntegerProperty(0));
        else if(value == 6)
            card = new CampfireCard(new SimpleIntegerProperty(cardEntities.size()), new SimpleIntegerProperty(0));
        else
            System.out.println("EXCEPTION erros at line around 490 filename: World");
        
        cardEntities.add(card);
        return card;
    }

    /**
     * remove card at a particular index of cards (position in gridpane of unplayed cards)
     * @param index the index of the card, from 0 to length-1
     */
    private void removeCard(int index){
        Card c = cardEntities.get(index);
        int x = c.getX();
        c.destroy();
        cardEntities.remove(index);
        shiftCardsDownFromXCoordinate(x);
    }

    /**
     * spawn a sword in the world and return the sword entity
     * @return a sword to be spawned in the controller as a JavaFX node
     */
    public BasicItem addUnequippedBasicItem(){
        // TODO = expand this - we would like to be able to add multiple types of items, apart from swords
        if(unequippedInventoryItems.size() >= (unequippedInventoryWidth * unequippedInventoryHeight))
        {
            removeItemByPositionInUnequippedInventoryItems(0);
            
            character.setGold(100);
            character.setExperience(100);
        }
        Pair<Integer, Integer> firstAvailableSlot = getFirstAvailableSlotForItem();

        /*
        BasicItem item = null;
        int value = new Random().nextInt(7);
        if(value == 0)
            item = new Sword(20, "Sword",300, firstAvailableSlot.getValue0(),firstAvailableSlot.getValue1());
        else if(value == 1)
            item = new Staff(20, "Staff",150, firstAvailableSlot.getValue0(),firstAvailableSlot.getValue1());
        else if(value == 2)
            item = new Stake(20, "Stake",250, firstAvailableSlot.getValue0(),firstAvailableSlot.getValue1());
        else if(value == 3)
            item = new Armour(20, "Armour",300, firstAvailableSlot.getValue0(),firstAvailableSlot.getValue1());
        else if (value ==4)
            item = new Helmet(20, "Helmet",300, firstAvailableSlot.getValue0(),firstAvailableSlot.getValue1());
        else if(value == 5)
            item = new Shield(20, "Shield",300, firstAvailableSlot.getValue0(),firstAvailableSlot.getValue1());
        else if(value == 6)
            item = new Potion(20, "Potion",200,firstAvailableSlot.getValue0(),firstAvailableSlot.getValue1());
        else
            System.out.println("EXCEPTION erros at line around 550 filename: World");

        //check if inventory is full, then remove the first item
        */

        int value = new Random().nextInt(7);
        BasicItem item = null;
        if(value == 0)
            item = MarketItemFactory.generateItems("Sword",firstAvailableSlot.getValue0(),firstAvailableSlot.getValue1());
        else if(value == 1)
            item = MarketItemFactory.generateItems("Staff",firstAvailableSlot.getValue0(),firstAvailableSlot.getValue1());
        else if(value == 2)
            item = MarketItemFactory.generateItems("Stake",firstAvailableSlot.getValue0(),firstAvailableSlot.getValue1());
        else if(value == 3)
            item = MarketItemFactory.generateItems("Armour",firstAvailableSlot.getValue0(),firstAvailableSlot.getValue1());
        else if (value ==4)
            item = MarketItemFactory.generateItems("Helmet",firstAvailableSlot.getValue0(),firstAvailableSlot.getValue1());
        else if(value == 5)
            item = MarketItemFactory.generateItems("Shield",firstAvailableSlot.getValue0(),firstAvailableSlot.getValue1());
        else if(value == 6)
            item = MarketItemFactory.generateItems("Potion",firstAvailableSlot.getValue0(),firstAvailableSlot.getValue1());
        else
            System.out.println("EXCEPTION erros at line around 66 MarketHandler.java");
    
        unequippedInventoryItems.add(item);
        return item;
    }

    /**
     * remove an item by x,y coordinates
     * @param x x coordinate from 0 to width-1
     * @param y y coordinate from 0 to height-1
     */
    public void removeUnequippedInventoryItemByCoordinates(int x, int y){
        Entity item = getUnequippedInventoryItemEntityByCoordinates(x, y);
        removeUnequippedInventoryItem(item);
    }

    /**
     * run moves which occur with every tick without needing to spawn anything immediately
     */
    public void runTickMoves(){
        // we expanded
        for(AlliedSoldier s: friendlySoldiers)
        {
            System.out.print(s.getHealth() + " ");
        }
        System.out.println();
        character.moveDownPath();
        int x = character.getX();
        int y = character.getY();

        for(Building b : buildingEntities)
        {
            
            if(b.getX() == x && b.getY() == y)
            {
                if(b instanceof Village) {
                    character.setHealth(character.getMaximumHealth());
                }   
                else if(b instanceof Barracks) {
                    friendlySoldiers.add(new AlliedSoldier());
                }
            }
        }
        // move the old enemies
        // and generate the new enemies
        // cycle counter increments by 1

        runBattles();
        moveBasicEnemies();
        incrementCycleCounter(x,y);
    }

    public void incrementCycleCounter(int x, int y)
    {
        if(x == this.initMainCharacterPosX && y == this.initMainCharacterPosY) {
            this.cycleCounter += 1;
            int random = new Random().nextInt(2);
            if(random == 0) {
                doggieCoin.inflation();
            }
            else {
                doggieCoin.deflation();
            }
            // everytime the player finished a cycle, new items will be generated
            this.markethandler.generateMarketList();
        }

    }

    /**
     * remove an item from the unequipped inventory
     * @param item item to be removed
     */
    private void removeUnequippedInventoryItem(Entity item){
        item.destroy();
        unequippedInventoryItems.remove(item);
    }

    /**
     * return an unequipped inventory item by x and y coordinates
     * assumes that no 2 unequipped inventory items share x and y coordinates
     * @param x x index from 0 to width-1
     * @param y y index from 0 to height-1
     * @return unequipped inventory item at the input position
     */
    private Entity getUnequippedInventoryItemEntityByCoordinates(int x, int y){
        for (Entity e: unequippedInventoryItems){
            if ((e.getX() == x) && (e.getY() == y)){
                return e;
            }
        }
        return null;
    }

    /**
     * remove item at a particular index in the unequipped inventory items list (this is ordered based on age in the starter code)
     * @param index index from 0 to length-1
     */
    private void removeItemByPositionInUnequippedInventoryItems(int index){
        Entity item = unequippedInventoryItems.get(index);
        item.destroy();
        unequippedInventoryItems.remove(index);
    }

    /**
     * get the first pair of x,y coordinates which don't have any items in it in the unequipped inventory
     * @return x,y coordinate pair
     */
    private Pair<Integer, Integer> getFirstAvailableSlotForItem(){
        // first available slot for an item...
        // IMPORTANT - have to check by y then x, since trying to find first available slot defined by looking row by row
        for (int y=0; y<unequippedInventoryHeight; y++){
            for (int x=0; x<unequippedInventoryWidth; x++){
                if (getUnequippedInventoryItemEntityByCoordinates(x, y) == null){
                    return new Pair<Integer, Integer>(x, y);
                }
            }
        }
        return null;
    }

    /**
     * shift card coordinates down starting from x coordinate
     * @param x x coordinate which can range from 0 to width-1
     */
    private void shiftCardsDownFromXCoordinate(int x){
        for (Card c: cardEntities){
            if (c.getX() >= x){
                c.x().set(c.getX()-1);
            }
        }
    }

    /**
     * move all enemies
     */
    private void moveBasicEnemies() {
        // TODO = expand to more types of enemy
        List<BasicEnemy> defeatedEnemies = new ArrayList<BasicEnemy>();
        List<Building> destroyedBuildings = new ArrayList<Building>();
        for (BasicEnemy e: enemies){
            e.move(character);
            int x = e.getX();
            int y = e.getY();
            
            for(Building b: buildingEntities) {
                if(b instanceof Trap) {
                    if(b.getX() == x && b.getY() == y) {
                        Trap t = (Trap) b;
                        t.dealDamage(e);
                        if(e.getHealth() <= 0) {
                            defeatedEnemies.add(e);
                        }
                        destroyedBuildings.add(b);
                    }
                }
            }
            
        }
        
        for(BasicEnemy e: defeatedEnemies) {
            killEnemy(e);
        }
        for(Building b :destroyedBuildings) {   
            b.destroy();
            buildingEntities.remove(b);
        }
    }

    /**
     * get a randomly generated position which could be used to spawn an enemy
     * @return null if random choice is that wont be spawning an enemy or it isn't possible, or random coordinate pair if should go ahead
     */
    private Pair<Integer, Integer> possiblyGetBasicEnemySpawnPosition(){
        // TODO = modify this
        
        // has a chance spawning a basic enemy on a tile the character isn't on or immediately before or after (currently space required = 2)...
        Random rand = new Random();
        int choice = rand.nextInt(2); // TODO = change based on spec... currently low value for dev purposes...
        // TODO = change based on spec
        if ((choice == 0) && (enemies.size() < 2)){
            List<Pair<Integer, Integer>> orderedPathSpawnCandidates = new ArrayList<>();
            int indexPosition = orderedPath.indexOf(new Pair<Integer, Integer>(character.getX(), character.getY()));
            // inclusive start and exclusive end of range of positions not allowed
            int startNotAllowed = (indexPosition - 2 + orderedPath.size())%orderedPath.size();
            int endNotAllowed = (indexPosition + 3)%orderedPath.size();
            // note terminating condition has to be != rather than < since wrap around...
            for (int i=endNotAllowed; i!=startNotAllowed; i=(i+1)%orderedPath.size()){
                orderedPathSpawnCandidates.add(orderedPath.get(i));
            }

            // choose random choice
            Pair<Integer, Integer> spawnPosition = orderedPathSpawnCandidates.get(rand.nextInt(orderedPathSpawnCandidates.size()));

            return spawnPosition;
        }
        return null;
    }

    /**
     * remove a card by its x, y coordinates
     * @param cardNodeX x index from 0 to width-1 of card to be removed
     * @param cardNodeY y index from 0 to height-1 of card to be removed
     * @param buildingNodeX x index from 0 to width-1 of building to be added
     * @param buildingNodeY y index from 0 to height-1 of building to be added
     */
    public Building convertCardToBuildingByCoordinates(int cardNodeX, int cardNodeY, int buildingNodeX, int buildingNodeY) {
        // start by getting card
        Card card = null;
        int pos = 0;
        for (Card c: cardEntities){
            if ((c.getX() == cardNodeX) && (c.getY() == cardNodeY)){
                pos = cardEntities.indexOf(c);
                break;
            }
        }
        // card == null here
        card = cardEntities.get(pos);
        //need to check if building can be placed at tile
        if(!card.checkPlaceable(buildingNodeX, buildingNodeY, orderedPath)) {
            return null;
        }
        Building newBuilding = card.createBuilding(buildingNodeX, buildingNodeY);

        // now spawn building
        
        buildingEntities.add(newBuilding);

        // destroy the card
        
        card.destroy();
        cardEntities.remove(card);
        shiftCardsDownFromXCoordinate(cardNodeX);
        

        return newBuilding;
    }


// how do we interchange equipments
// assume the player can only grag items from unequipped inventory to equipped inventory 


    public void equip(Item e)
    {
        
        if(checkEquip(e.getType())!=null) {
            Item item = checkEquip(e.getType());
            equippedInventoryItems.remove(item);
            Pair<Integer, Integer> firstAvailableSlot = getFirstAvailableSlotForItem();
            unequippedInventoryItems.add(item);
            item.setX(firstAvailableSlot.getValue0());
            item.setY(firstAvailableSlot.getValue1());
        } 
        equippedInventoryItems.add(e);
        switch(e.getType()) {
            case("Shield"):            
                character.setShield((Shield)e);
                e.setX(3);
                e.setY(0);
                break;
            case("Sword"):
                character.setWeapon((Sword)e);
                e.setX(0);
                e.setY(0);
                break;
            case("Helmet"):
                character.setHelmet((Helmet)e);
                e.setX(1);
                e.setY(0);
                break;
            case("Armour"):
                character.setArmor((Armour)e);
                e.setX(2);
                e.setY(0);
                break;
            case("Staff"):
                character.setWeapon((Staff)e);
                e.setX(0);
                e.setY(0);
                break;
            case("Stake"):
                character.setWeapon((Stake)e);
                e.setX(0);
                e.setY(0);
                break;
        }
            
    }
    
    // check if a equipment is equpped in the equipped inventory
    private Item checkEquip(String type) {
        for(Entity e: equippedInventoryItems) {
            Item i = (Item)e;
            if(type == i.getType()) {
                return i;
            }
        }
        return null;
    }

    // create sell function so the player can sell items in the marketplace
    public void sellToMarketPlace(int x, int y)
    {
        Entity find = null;
        for(Entity e: unequippedInventoryItems)
        {
            if(e.getX() == x && e.getY() == y)
                find = e;
        }
        if(find != null)
        {
            BasicItem item = (BasicItem) find;
            character.setGold(character.getGold()+item.getSellPrice());
            removeUnequippedInventoryItemByCoordinates(x, y);
        }
        else
            System.out.println("around line 943 world, can not find the item in the  unequippedInventoryItems ");
    }

    // create purchase function so the player can sell items in the marketplace
    public void purchaseHandler(int x, int y)
    {
        if(this.markethandler.getDifficulties() == 0)
            purchaseFromMarketPlace(-1, -1,x,y);
        else if(this.markethandler.getDifficulties() == 1)
            purchaseFromMarketPlace(-1, 1,x,y);
        else if(this.markethandler.getDifficulties() == 2)
            purchaseFromMarketPlace(1, -1,x,y);
        else
            System.out.println("Error,the difficuites is not 1,2 or 3, line 950 World");
    }

    //actuall purchase function
    public void purchaseFromMarketPlace(int amourLimit, int potionLimit, int x, int y)
    {
        Entity find = null;
        for(Entity e: markethandler.getShopItemList())
        {
            if(e.getX() == x && e.getY() == y)
                find = e;
        }
        if(find != null)
        {
            BasicItem item = (BasicItem) find;
            if(character.getGold() >= item.getpurchasePrice()) 
            {
                character.setGold(character.getGold() - item.getpurchasePrice());  
                 
            }
        }
        else
            System.out.println("around line 943 world, can not find the item in the  unequippedInventoryItems ");
    }
}

