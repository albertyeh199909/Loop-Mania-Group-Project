**Combat:**
- ~~Attack order is determined by an attack speed attribute. If two values are equal, randomise attack order.~~
- Character doesn't need a weapon to fight.
- Allied Soldier will take damage from monsters before player character does.
- Critical damage deals 2X damage.

**Enemies:**
- Some users want to see the battle and support radius, more experienced users may not.
- Maximum of 1 enemy per tile.
- Users should see character and enemy health display according to their status.
- Allied soldier turned zombies are able to infect other soldiers too (through critical bite).
- Critical damage multiplier is applied before any damage reductions from other sources.
- Increase of critical vamplire damage will be applied to any entities.
- If player does not have enough experience after the first 40 cycles, and gains enough experience afterwards, Elan will spawn after another set of 40 cycles.
- Elan Muske only heals one enemy a turn.
- Each boss only spawns a maximum of once per game.

**Equipment:**
- Equipment is vague in its description. Assumption is that (e.g. for armour), "provides defence" equals "halves enemy attack".
- Assumes armor takes priority before helmet for damage reduction.
- Assumes tree stump is also has the same function as basic shield.

**Inventory:**
- Health potion is added to inventory for later consumption instead of automatically being consumed.
- DoggieCoin only changes in value while time is passing (e.g. doesn't change while paused).
- The character can get more than 1 unique rare item.
- The character can get more than 1 specific rare item.

**Mode**
- User can't switch between modes in the middle of a game.
- In confusing mode, the secondary effect is removed if the item is destroyed or used.

**Rewards:**
- All basic items have a similar drop rate when defeating enemies.
- All basic items have a similar drop rate when card is destroyed.
- All card types have a similar chance of dropping.

**Miscellaneous:**
- Classes and their methods given to us is working as intended.
- Frontend classes along with simple getters and setters are not included for coverage.
- Campfire has a radius of 1.
- Adjacent tiles include diagonal neighbors.
- Goals are never tautological (e.g. 1000 exp and 2000 exp). 