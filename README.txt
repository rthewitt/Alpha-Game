PATCH NOTES - Update 2.0

So many improvements to go over... so here is the list of major changes

- Ships package:
  * Added getWidth, getHeight and getImage methods.
  * Added the buffered Image variable using to lessen the amount of code where the classes image is accessed
  * Added hullShip and nextShip to ShipEntity to simplify the process of updating the upgradeMenu.

- Enemies package:
  * Fixed the health stat of each ship

- Stars class
  * Renamed Star to Stars to reflect it's purpose
  * Removed all the repainting features
  * Added the private inner class Star(This is a really good example of how an inner class should work)
  * Generally reworked how the Stars class run, it is now less expensive and runs with less glitches.

- ShipControl
  * Renamed Go to ShipControl to reflect it current purpose

- Factory
  * Added Methods for future game mode options.

- New class Refresher - Thread
  * Refresher simply repaints the screen, it does a much better job than the Stars class did.

- GameState
  * Removed UpdateShip because it is no longer needed.
  * I am very happy with this because it makes the image updating very clean.