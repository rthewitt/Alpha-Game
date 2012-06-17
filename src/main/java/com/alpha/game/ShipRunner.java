package com.alpha.game;

class ShipRunner extends Thread{
	boolean running = true;
	
	ShipRunner() {
		
	}
	
	public void run() {
		
	}
	
	static void draw() {
		for(int i = 0; i < Runnable.ships.size(); i++) {
			Runnable.ships.elementAt(i).draw(Statics.g2d);
		}
	}
}