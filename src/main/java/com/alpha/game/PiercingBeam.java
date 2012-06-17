package com.alpha.game;

import java.awt.Graphics2D;

public class PiercingBeam extends Runnable {
	private int x, y;
	private double damage = .3;
	
	public PiercingBeam() {
		x = Ship.x;
		y = Ship.y;
	}
	
	public void run() {
		y --;
		
		if(y < 0) {
			kill();
		}
		
		Runnable.testHit(x, y, damage);
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
		g2d.drawImage(Resource.IMG_PEN, x, y, null);
	}
}
