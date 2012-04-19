package com.alpha.game;

import java.awt.Graphics2D;
import java.awt.Image;

public class Ship extends Thread
{
	private boolean ShipStarted =	true;
	// Changing to GameState.  You can get image from there...
	// getting the changing static image from Resource is wrong
	// logically speaking.  Let me know if this is a problem.
	private GameState gameState; // TODO wire this sucker in
	private Game gamePanel;
	
	public Ship(Game g, int ship, boolean hull)
	{
		gamePanel = g;
	}

	public void	draw(Graphics2D g2d)
	{
		if(ShipStarted)
		{
			g2d.drawImage(gameState.getCurrentShip(), gamePanel.getLocX() - 15, gamePanel.getLocY(), null);
		}
	}
}