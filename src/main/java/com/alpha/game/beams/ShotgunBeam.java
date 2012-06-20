package com.alpha.game.beams;

import java.awt.Graphics2D;

import com.alpha.game.MovableEntity;
import com.alpha.game.Resource;
import com.alpha.game.Ship;

public class ShotgunBeam extends BeamEntity {
	private int x, y;
	private double damage = 7;
	private final double RELOAD = 1;
	
	public ShotgunBeam() {
		x = Ship.x;
		y = Ship.y;
	}
	
	public void update() {
		y --;
		
		if(y < 0) {
			kill();
		}
		
		if(MovableEntity.testHit(x, y, damage)) {
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
	
	public void kill() {
		beams.remove(this);
	}

	public void draw(Graphics2D g2d) {
		g2d.drawImage(Resource.IMG_BOLT, x, y, null);
	}

	double getReload() {
		return RELOAD;
	}
}
