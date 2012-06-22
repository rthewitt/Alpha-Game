package com.alpha.game;

import com.alpha.game.ships.ShipEntity;

public class Go extends Thread {
	private boolean up = false;
	private boolean down = false;
	private boolean left = false;
	private boolean right = false;
	
	public int leap = 1;
	private ShipEntity currentShip;
	boolean running = true;
	
	Go() {
		currentShip = ShipEntity.currentShip;
		leap = currentShip.getSpeed();
		this.start();
	}

	public void setUp(boolean b) {
		up = b;
	}
	
	public void setDown(boolean b) {
		down = b;
	}
	
	public void setLeft(boolean b) {
		left = b;
	}
	
	public void setRight(boolean b) {
		right = b;
	}
	
	public void run() {
		while(running) {
			int x = currentShip.getX() , y = currentShip.getY();
			
			if(up && y > 0) {
				currentShip.setY(y - leap);
			}
			
			if(down && y < Frame.height - GameState.currentShip.getHeight()) {
				currentShip.setY(y + leap);
			}
			
			if(left && x > 0) {
				currentShip.setX(x - leap);
			}
			
			if(right && x < Frame.width - GameState.currentShip.getWidth()) {
				currentShip.setX(x + leap);
			}
			
			try {
				Thread.sleep(14);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}