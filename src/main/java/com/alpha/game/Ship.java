package com.alpha.game;

import java.awt.Graphics2D;

public class Ship extends MovableEntity{
	public static int x;
	public static int y;
	static int speed;
	static int initialHealth = 100;
	static int life = 40;
	static int damage = 5;
	static int rateOfFire;
	
	public Ship() {
		x = 250;
		y = 600;
	}
	
	public int getX() {		
		return x;
	}
	
	public int getY() {		
		return x;
	}
	
	static double percentLeft() {
		return (life%initialHealth);
	}
	
	public static int shipMiddle() {
		return (int)x + Statics.currentShip.getWidth()/2;
	}
	
	public void kill() {}

	public void update() {}

	public void	draw(Graphics2D g2d) {
		g2d.drawImage(Statics.currentShip, x, y, null);
	}
}