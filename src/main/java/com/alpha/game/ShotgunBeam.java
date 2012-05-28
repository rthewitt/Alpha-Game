package com.alpha.game;

import java.awt.Graphics2D;

public class ShotgunBeam extends BeamElement {
	private int x, y;
	private double damage = 7;
	
	public ShotgunBeam() {
		x = Ship.x;
		y = Ship.y;
	}
	
	public void run() {
		y --;
		
		if(y < 0) {
			kill();
		}
		
		for (int i = 0; i < Game.enemies.size(); i++) {
        	Game.enemies.elementAt(i).testHit(this);
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
	
	@SuppressWarnings("deprecation")
	void kill() {
		beams.remove(this);
		this.stop();
	}

	void draw(Graphics2D g2d) {
		g2d.drawImage(Resource.IMG_BOLT, x, y, null);
	}
}
