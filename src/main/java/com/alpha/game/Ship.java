package com.alpha.game;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Ship {
	static double x, y;
	static double speed = 3;
	static double totalHealth = 15;
	static double health = totalHealth;
	static double damage = 1;
	private static BufferedImage using;
	public static BufferedImage hullShip;
	public static BufferedImage nextShip;
	
	public Ship(int X, int Y, double spd, double hlth, BufferedImage img, BufferedImage next, BufferedImage hull) {
		x = X;
		y = Y;
		speed = spd;
		totalHealth = health = hlth;
		using = img;
		hullShip = hull;
		nextShip = next;
	}
	
	public static void setX(double d) {
		x = d;
	}

	public static void setY(double d) {
		y = d;
	}
	
	public static double getX() {		
		return x;
	}
	
	public static double getY() {
		return y;
	}
	
	public static void fire() {
		Factory.newShipBeam((int)x + getWidth()/2, (int)y, GameState.beamType);
	}
	
	public static double getSpeed() {
		return speed;
	}
	
	public static double percentLeft() {
		return health/totalHealth;
	}

	public static void draw(Graphics2D g2d) {
		g2d.drawImage(using, (int)x, (int)y, null);
	}
	
	public static double getDamage() {
		return damage;
	}

	public static double getHealth() {
		return health;
	}
	
	public static int getWidth() {
		return using.getWidth();
	}

	public static int getHeight() {
		return using.getHeight();
	}

	public static BufferedImage getImage() {
		return using;
	}

	public static boolean testShip(double x2, double y2, double damage2) {
		return false;
	}
}
