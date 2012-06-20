package com.alpha.game;

import java.awt.Graphics2D;
import java.util.Vector;

public abstract class MovableEntity {
	protected static Vector<MovableEntity> beams = new Vector<MovableEntity>();
	protected static Vector<MovableEntity> enemies = new Vector<MovableEntity>();
	protected static Vector<MovableEntity> ships = new Vector<MovableEntity>();
	
	protected static boolean testHit(int x, int y, double damage) {
		for(int i = 0; i < enemies.size(); i++) {
			if(enemies.elementAt(i).testMe(x, y, damage)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean testMe(int x, int y, double damage) {
		return false;
	}
	
	abstract public int getX();
	abstract public int getY();
	abstract public void kill();
	abstract public void update();
	abstract public void draw(Graphics2D g2d);
}
