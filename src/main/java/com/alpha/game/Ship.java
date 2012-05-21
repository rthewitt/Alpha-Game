package com.alpha.game;

import java.awt.Graphics2D;

public class Ship extends Thread {
	private boolean shipStarted = true;
	static int x, y;
	
	public Ship() {
		x = 250;
		y = 700;
	}

	public void	draw(Graphics2D g2d) {
		if(shipStarted) {
			g2d.drawImage(GameState.currentShip, x - 15, y, null);
		}
	}
}