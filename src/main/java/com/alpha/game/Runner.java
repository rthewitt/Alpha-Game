package com.alpha.game;

import java.util.ConcurrentModificationException;

class Runner {
	boolean running = true;
	
	public static void run() {
		if(GameState.pause == false) {
			try {
				Beams.update();
				Enemies.update();
			} catch(ConcurrentModificationException e) {}
			Stars.update();
		}
	}
}