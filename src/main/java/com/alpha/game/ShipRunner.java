package com.alpha.game;

class ShipRunner extends Thread{
	boolean running = true;
	
	ShipRunner() {}
	
	public void run() {}
	
	static void draw() {
		for(int i = 0; i < MovableEntity.ships.size(); i++) {
			MovableEntity.ships.elementAt(i).draw(GameState.g2d);
		}
	}
}