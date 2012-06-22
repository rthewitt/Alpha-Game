package com.alpha.game.ships;

import java.awt.Graphics2D;
import com.alpha.game.Factory;
import com.alpha.game.Resource;

public class LargeBlue extends ShipEntity{
	private int x;
	private int y;
	private int speed = 3;
	private int initialHealth = 100;
	private int health = 40;
	private double damage = 1;
	
	public LargeBlue(int X, int Y) {
		x = X;
		y = Y;
		currentShip = this;
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
		Factory.newBeam(x, y);
		Factory.newBeam(x + Resource.IMG_LARGE_BLUE.getWidth()/2, y);
		Factory.newBeam(x + Resource.IMG_LARGE_BLUE.getWidth(), y);
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public double percentLeft() {
		return health%initialHealth;
	}
	
	public void kill() {
		ships.remove(this);
	}

	public void update() {}

	public void	draw(Graphics2D g2d) {
		g2d.drawImage(Resource.IMG_LARGE_BLUE, x, y, null);
	}
	
	public double getDamage() {
		return damage;
	}

	public int getHealth() {
		return health;
	}
}
