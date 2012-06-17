package com.alpha.game;

import java.awt.Graphics2D;

public class Ship extends Runnable{
	static int x, y;
	
	public Ship() {
		x = 250;
		y = 600;
	}
	
	int getX() {		
		return 0;
	}
	
	int getY() {		
		return 0;
	}
	
	void kill() {
		
	}

	void run() {
		
	}

	public void	draw(Graphics2D g2d) {
		g2d.drawImage(Statics.currentShip, x - 15, y, null);
	}
}