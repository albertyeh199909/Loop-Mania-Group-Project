package unsw.loopmania;



public class Zombie extends BasicEnemy {
    int criticalChance = 10;
    PathPosition path;
    public Zombie(PathPosition pathPosition) {
        super(pathPosition, 4, 5, 2);
        setHealth(3);
        path = pathPosition;
    }

    /** damages entity, if damageClass returns isCritical true then zombie will convert allied soldier to zombie
     * @param entity entity to attack   
     */
    @Override
    public void inflictDamage(MovingEntity movingEntity) {
        
        DamageClass damageClass = movingEntity.takeDamage(new DamageClass(this, this.damage, this.criticalChance));
        
        if (movingEntity instanceof AlliedSoldier && damageClass.getIsCritical()) {
                // Turn alliedSoldier to zombie
            
            AlliedSoldier s = (AlliedSoldier)movingEntity;
            if(s.getConvertedFrom() == null) {
                s.setTurnToZombie(true);    
                s.setPath(path);
            }
        }
        
    }

}
