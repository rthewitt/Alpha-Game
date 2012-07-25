PATCH NOTES - Update 2.2

Umm.... wow, just WOW.

Threads Remaining
 - UpgradeMenuAnimation(Have not gotten to it yet, will probably be added to game loop or be a timer)
 - FiringMechanism(will remain a thread, slows down the game as a timer)

Classes Changed from thread
 - Runner
 - BuildLevel
 - Refresher
 - ShipControl
 - Stars

NewClasses
 - GameLoop
 - Ships
 - Beams
 - Enemies

Major changes
- The game now runs off the standard game loop, which is a timer not a thread.
- Build Level has it's own timer since I do not want levels building at GameLoop speed. 
- Enemies, Beams, Ship are now self contained.
- GameLoop first updates, does user input, and the draws.
- Removed all Vectors
- converted most obvious for loops to advanced for loops.
- The pause feature, amazingly still works(I will probably move it into the game loop).
- Removed all packages
- Removed all "Entity" classes
