package com.alpha.game;

import java.awt.Graphics2D;

public class SingleBeam extends Dif {
	private int x, y;
	private final double damage = 5;
	private final double RELOAD = 1;
	
	public SingleBeam() {
		x = Ship.shipMiddle();
		y = Ship.y;
	}
	
	public void run() {
		y --;
		
		if(y < 0) {
			kill();
		}
		
		if(Dif.testHit(x, y, damage)) {
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
		g2d.drawImage(Resource.IMG_BOLT, x - Resource.IMG_BOLT.getWidth()/2, y, null);
	}

	double getReload() {
		return RELOAD;
	}
}