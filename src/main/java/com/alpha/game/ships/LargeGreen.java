package com.alpha.game.ships;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import com.alpha.game.Factory;
import com.alpha.game.GameState;
import com.alpha.game.Resource;

public class LargeGreen extends ShipEntity{
	private int x, y;
	private int speed = 2;
	private int totalHealth = 50;
	private int health = totalHealth;
	private double damage = 1;
	private BufferedImage using;
	
	public LargeGreen(int X, int Y) {
		x = X;
		y = Y;
		currentShip = this;
		if(GameState.hullEnabled) {
			using = Resource.IMG_LARGE_GREEN_ARMOR;
			health += 20;
		} else {
			using = Resource.IMG_LARGE_GREEN;
		}
		nextShip = null;
		hullShip = Resource.IMG_LARGE_GREEN_ARMOR;
	}
	
	public int getX() {		
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setX(int X) {
		x = X;
	}

	public void setY(int Y) {
		y = Y;
	}
	
	public void fire() {
		Factory.newShipBeam(x, y - 5, GameState.beamType);
		Factory.newShipBeam(x + getWidth()/2, y, GameState.beamType);
		Factory.newShipBeam(x + getWidth(), y - 5, GameState.beamType);
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public double percentLeft() {
		return health/totalHealth;
	}
	
	public void kill() {
		ships.remove(this);
	}

	public void update() {}

	public void	draw(Graphics2D g2d) {
		g2d.drawImage(using, x, y, null);
	}
	
	public double getDamage() {
		return damage;
	}

	public int getHealth() {
		return health;
	}

	public int getWidth() {
		return using.getWidth();
	}

	public int getHeight() {
		return using.getHeight();
	}

	public BufferedImage getImage() {
		return using;
	}
}
