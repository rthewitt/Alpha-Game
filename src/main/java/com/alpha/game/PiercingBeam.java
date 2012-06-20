package com.alpha.game;

import java.awt.Graphics2D;

public class PiercingBeam extends Dif {
	private int x, y;
	private double damage = .3;
	private double RELOAD = 1;
	
	public PiercingBeam() {
		x = Ship.x;
		y = Ship.y;
	}
	
	public void run() {
		y --;
		
		if(y < 0) {
			kill();
		}
		
		Dif.testHit(x, y, damage);
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
		g2d.drawImage(Resource.IMG_PEN, x - Resource.IMG_PEN.getWidth(), y, null);
	}

	@Override
	double getReload() {
		return RELOAD;
	}
}
