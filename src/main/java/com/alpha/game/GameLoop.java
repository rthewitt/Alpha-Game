package com.alpha.game;

import java.util.Timer;
import java.util.TimerTask;

public class GameLoop {
	Timer timer = new Timer();
	
	GameLoop() {
		timer.schedule(new Task(), 1, 8);
	}
	
	class Task extends TimerTask {
		public void run() {
			Runner.run();
			ShipControl.run();
			Refresher.run();
		}
	}
}
