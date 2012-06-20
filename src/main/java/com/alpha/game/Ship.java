package com.alpha.game;

import java.awt.Graphics2D;

public class Ship extends Dif{
	static int x, y;
	static int speed;
	static int initialHealth = 100;
	static int life = 40;
	static int damage = 5;
	static int rateOfFire;
	
	public Ship() {
		x = 250;
		y = 600;
	}
	
	int getX() {		
		return x;
	}
	
	int getY() {		
		return x;
	}
	
	static double percentLeft() {
		return (life%initialHealth);
	}
	
	static int shipMiddle() {
		return (int)x + Statics.currentShip.getWidth()/2;
	}
	
	void kill() {
		
	}

	void run() {
		
	}

	public void	draw(Graphics2D g2d) {
		g2d.drawImage(Statics.currentShip, x, y, null);
	}

	double getReload() {
		return 0;
	}
}