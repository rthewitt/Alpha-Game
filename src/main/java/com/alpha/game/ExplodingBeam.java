package com.alpha.game;

import java.awt.Graphics2D;

public class ExplodingBeam extends Runnable {
	private int x, y;
	private int damage = 20;
	
	public ExplodingBeam() {
		x = Ship.x;
		y = Ship.y;
	}
	
	public void run() {
		y --;
		
		if(y < 0) {
			kill();
		}
		
		if(Runnable.testHit(x, y, damage)) {
			kill();
		}
	}
	
	public int getX() {
		return x;
		
	}
	
	public int getY() {
		return y;
	}
	
	public double getDamage() {
		return damage;
	}
	
	void kill() {
		beams.remove(this);
	}

	void draw(Graphics2D g2d) {
		g2d.drawImage(Resource.IMG_EXPLODING, x, y, null);
	}
}
