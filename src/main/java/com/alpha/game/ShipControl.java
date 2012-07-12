package com.alpha.game;

import com.alpha.game.ships.ShipEntity;

public class ShipControl extends Thread {
	private static boolean up = false;
	private static boolean down = false;
	private static boolean left = false;
	private static boolean right = false;
	
	public static boolean mousePressed;
	
	public int leap = 1;
	private ShipEntity currentShip;
	boolean running = true;
	
	ShipControl() {
		currentShip = ShipEntity.currentShip;
		leap = currentShip.getSpeed();
		this.start();
	}

	static void setUp(boolean b) {
		up = b;
	}
	
	static void setDown(boolean b) {
		down = b;
	}
	
	static void setLeft(boolean b) {
		left = b;
	}
	
	static void setRight(boolean b) {
		right = b;
	}
	
	public void run() {
		while(running) {
			int x = currentShip.getX() , y = currentShip.getY();
			
			if(up && y > 0) {
				currentShip.setY(y - leap);
			}
			
			if(down && y < Frame.height - ShipEntity.currentShip.getHeight()) {
				currentShip.setY(y + leap);
			}
			
			if(left && x > 0) {
				currentShip.setX(x - leap);
			}
			
			if(right && x < Frame.width - ShipEntity.currentShip.getWidth()) {
				currentShip.setX(x + leap);
			}
			
			if(mousePressed) {
				FiringMechanism.tryToFire();
			}
			
			try {
				Thread.sleep(14);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}