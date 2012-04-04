package com.alpha.game;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Ship extends Thread
{
	private boolean ShipStarted =	true;
	private BufferedImage img;
	private Game gamePanel;
	
	public Ship(Game g, int ship, boolean hull)
	{
		gamePanel = g;
		
		if(ship == 1)
		{
			// TODO verify this, doesn't look like the others
			if(hull)
			{
				img = Resource.IMG_SMALL_GREEN_ARMOR;
			}
			else
			{
				img = Resource.IMG_SMALL_GREEN;
			}
		}
		else if(ship == 2)
		{
			if(hull)
			{
				img = Resource.IMG_MED_GREEN;
			}
			else
			{
				img = Resource.IMG_MED_GREEN_ARMOR;
			}
		}
		else
		{
			if(hull)
			{
				img = Resource.IMG_LARGE_GREEN_ARMOR;
			}
			else
			{
				img = Resource.IMG_LARGE_GREEN;
			}
		}
	}

	public void	draw(Graphics2D g2d)
	{
		if(ShipStarted)
		{
			g2d.drawImage(img, gamePanel.getLocX() - 15, gamePanel.getLocY(), null);
		}
	}
}