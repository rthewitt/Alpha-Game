package com.alpha.game;

import java.awt.Graphics2D;

public class WaveBeam extends Dif {
	private int x, y;
	private double damage = .5;
	private final double RELOAD = 1;
	
	public WaveBeam() {
		x = Ship.x;
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
		g2d.drawImage(Resource.IMG_WAVE, x, y, null);
	}

	@Override
	double getReload() {
		return RELOAD;
	}
}
