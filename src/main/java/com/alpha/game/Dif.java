package com.alpha.game;

import java.awt.Graphics2D;
import java.util.Vector;

public abstract class Dif {
	static Vector<Dif> beams = new Vector<Dif>();
	static Vector<Dif> enemies = new Vector<Dif>();
	static Vector<Dif> ships = new Vector<Dif>();
	
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
	abstract double getReload();
	abstract void kill();
	abstract void run();
	abstract void draw(Graphics2D g2d);
}
