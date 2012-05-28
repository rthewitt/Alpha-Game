PATCH NOTES - Update 1.5

- Summary of Changes: 
  1. Added Buttons for Game Class, they are used to switch weapons.
  2. Added two different ways to active the Game Class buttons: 1. hot keys(first for me), 2. click them.
  3. Added Functionality to most weapons. Some are giving me problems.
  4. Updated the UpgradeMenu with: Ship stats, Game statistics and all new weapons buttons(not functional because I am getting ready to add currency).
  5. Added a pause mechanism for the beams. If the mouse moves out of the screen while a level is active, the beams will stop.
     Next update I will add enemies and ship to this, it is a really cool feature and yet increadibly simple.
  6. Organized Upgrade Menu Setup to make it way less confusing.
  7. Did the same to Menu. I want to make an interface class for both of them and add a configurations method so that
     it is easy to run specific configurations of the buttons.
  8. Fixed the glitch of ending a level early by fixing the Enemy class's testHit() and kill() methods.
  9. Removed PoisonBeam Class since it will never be implemented.
  10. Added Laser as a replacement for Poison Beam.