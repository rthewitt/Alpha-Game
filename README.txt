PATCH NOTES - Update 1.2

- Menu
   1. Implemented instructions panel - no instruction yet.
   2. Implemented Credits
   3. Reworked action command to use the source method instead of strings. Hopefully this is more professional. 

- Levels - the big update
  1. Implemented levels class as a replacement for lvl1/2/3 classes
     a. Levels holds an array for each level and reads in the information on demand.
     b. Working on a file based system to read into empty arrays. It would be less expesive for the program and only read in the level if neccessary.

- Star
  1. Reworked Star class to only be used once.
  2. Stars class is now grabbed from Menu/Game/UpgradeMenu.
  3. Implemented in Control and passed to GameState to be distributed.
  4. Replaced try/catch blocks around repaint code and other places with if/else structure.

- Alpha
  1. Removed the useless reference for Control class

- UpgradeMenu
  1. Reworked action command to use the source method instead of strings. Hopefully this is more professional.

- Beam
  1. Replaced try/catch blocks around repaint code and other places with if/else structure.

- Classes (all of them)
  1. Went over naming conventions and camelcased all that were not.
  2. Updated names to be consistent through all classes.
  3. Limeted the passes if refrences such as game. Instead used GameState to pass game.
  4. Removed all useless imports.

- In game systems
  1. re-introduced damage system.
     a. Damage system relies on choice of ship.
  2. Implemented speed system.
     a. Also relies on ship choice.

- Performance tests have greatly improved due to decreased amount of threading from star class

- Future updates:
  1. Currency system officially named Yin
  2. instuctions
  3. Official Title
  4. Implementing last 27 levels
  5. Hud - this and coin should come first
  6. In game clock
  7. Save files
  8. Health system.