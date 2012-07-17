package com.alpha.game.ships;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import com.alpha.game.Factory;
import com.alpha.game.GameState;
import com.alpha.game.Resource;

public class SmallGreen extends ShipEntity{
	private int x, y;
	private int speed = 2;
	private int totalHealth = 20;
	private int health = totalHealth;
	private double damage = 1;
	private BufferedImage using;
	
	public SmallGreen(int X, int Y) {
		x = X;
		y = Y;
		currentShip = this;
		if(GameState.hullEnabled) {
			using = Resource.IMG_SMALL_GREEN_ARMOR;
			health += 20;
		} else {
			using = Resource.IMG_SMALL_GREEN;
		}
		nextShip = Resource.IMG_MED_GREEN;
		hullShip = Resource.IMG_SMALL_GREEN_ARMOR;
	}
	
	public void setX(int X) {
		x = X;
	}

	public void setY(int Y) {
		y = Y;
	}
	
	public int getX() {		
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void fire() {
		Factory.newBeam(x + getWidth()/2, y);
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