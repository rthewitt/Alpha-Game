package com.alpha.game;

import java.awt.Graphics2D;

public class Ship extends Thread {
	private boolean shipStarted = true;
	private Game game;
	
	public Ship(Game g, int ship, boolean hull) {
		game = g;
	}

	public void	draw(Graphics2D g2d) {
		if(shipStarted) {
			g2d.drawImage(GameState.currentShip, game.getLocX() - 15, game.getLocY(), null);
		}
	}
}