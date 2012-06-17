package com.alpha.game;

import java.awt.Graphics2D;
import java.util.Vector;

public abstract class Runnable {
	static Vector<Runnable> beams = new Vector<Runnable>();
	static Vector<Runnable> enemies = new Vector<Runnable>();
	static Vector<Runnable> ships = new Vector<Runnable>();
	
	static boolean testHit(int x, int y, double damage) {
		for(int i = 0; i < enemies.size(); i++) {
			if(enemies.elementAt(i).testMe(x, y, damage)) {
				return true;
			}
		}
		return false;
	}
	
	boolean testMe(int x, int y, double damage) {
		return false;
	}
	
	abstract int getX();
	abstract int getY();
	abstract void kill();
	abstract void run();
	abstract void draw(Graphics2D g2d);
}
