package com.alpha.game;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

public class Enemies {
	protected static List<Enemy> enemies = new ArrayList<Enemy>();
	
	public Enemies(double X, double s, double h, BufferedImage bi, int r) {
		Enemy e = new Enemy();
		e.x = X;
		e.speed = s;
		e.health = h;
		e.using = bi;
		e.reward = r;
		enemies.add(e);
	}
	
	private class Enemy {
		double x, y = -30;
		double speed;
		double health;
		BufferedImage using;
		int reward;
	}
	
	public static boolean testMe(double x, double y, double damage) {
		for(Enemy e : enemies) {
			boolean go = false;
			
			if(e.x < x && x < e.x + e.using.getWidth()) {
				go = true;
			}
			
			if(go) {
				if(e.y < y && y < e.y + e.using.getHeight()) {
					GameState.numHits ++;
					e.health -= damage;
					
					if(e.health <1) {
						GameState.enemiesKilled ++;
						GameState.yin += e.reward;
						kill(e);
					}
					return true;
				}
			}
		}
		return false;
	}
	
	public static void kill(Enemy e) {
		enemies.remove(e);
		GameState.enemies --;
		GameState.LevelOver();
	}
	
	public static void update() {
		for(Enemy e : enemies) {
			e.y += e.speed;
			
			if(e.y > Frame.height) {
				kill(e);
			}
		}
	}
	
	public static void draw(Graphics2D g2d) {
		try {
			for(Enemy e : enemies) {
				g2d.drawImage(e.using, (int)e.x, (int)e.y, null);
			}
		} catch (ConcurrentModificationException e) {}
	}
	
//	protected void fire() {
//		Factory.newEnemyBeam((int)x, (int)y, 1);
//	}
}