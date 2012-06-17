PATCH NOTES - Update 1.6

1. List of New Classes
  - New
  - BeamRunner
  - ShipRunner
  - EnemyRunner
  - Runnable
  - BigYellow
  - BlueFighter
  - BlueHeavy
  - BossOne
  - MedYellow
  - RedFighter
  - RedHeavy
  - Statics(renamed from GameState)
  - Frame(renamed from Control)

2. New Structure explanation
  Basically the old structure had way to many threads and was causing recursion. So now all Classes the extends Runnable
  can be run by one of three runner threads. This way all runnables are not threads but can still act like them. This way
  there are very few threads running at the same time yet they are running lots of objects. The reason for the multiple
  runners is that beam and enemies threads have different wait times to run smoothly. This structure seems to generally
  less expensive and runs everything while still providing an expandable structure.
  
3. I will not go into specifics of changes because of the immensity of this update but here are a few other details of changes.
  - Modified the way the Graphics context is shared.
  - Cleaned Game class a bit so that it is mostly Graphics and controls.