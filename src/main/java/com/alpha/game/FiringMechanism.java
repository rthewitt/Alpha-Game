package com.alpha.game;

import com.alpha.game.ships.ShipEntity;

public class FiringMechanism extends Thread {
	static boolean running = true;
	static boolean reloaded;
	private static long timer;
	
	FiringMechanism() {
		this.start();
	}
	
	static void tryToFire() {
		if(reloaded) {
			reloaded = false;
			setBeam();
		}
	}
	
	private static void setBeam() {
		ShipEntity.currentShip.fire();
		GameState.shotsFired ++;
		setTimer(Factory.getCurrentBeam().getReload());
	}
	
	private static void setTimer(long time) {
		timer = time;
	}
	
	public void run() {
		while(running) {
			try {
				Thread.sleep(1);
				while(timer > 0) {
					Thread.sleep(1);
					timer --;
				}
				timer = 0;
				reloaded = true;
			} catch (InterruptedException e) {
				System.out.println("Interrupted");
			}
		}
	}
}