PATCH NOTES - Update 1.7

1. Added new Package ships
 - Split class ships into 9 different classes
 - Added lots of methods
   - getSpeed();
   - getDamage();
   - getHealth();
   - fire();
     - fire all emplacements for that ship.

2. Added ship gun emplacements
  - Small Green and Blue have 1 gun.
  - Small Red has two
  - Each upgrade adds a gun.
  - The guns fire whatever ammo is currently selected.

3. Moved Levels into Factory and renamed it newLevel();

4. ShipEntity now holds a reference to the current ship.

5. remove getX() and getY() from MovableEntity, BeamEntity, and Enemy Entity