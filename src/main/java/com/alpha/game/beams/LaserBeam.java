package com.alpha.game.beams;

import java.awt.Graphics2D;

import com.alpha.game.MovableEntity;
import com.alpha.game.Resource;

public class LaserBeam extends BeamEntity {
	private int x, y;
	private double damage = .3;
	private final long RELOAD = 1;
	
	public LaserBeam() {
		
	}
	
	public LaserBeam(int X, int Y) {
		x = X;
		y = Y;
	}
	
	public void update() {
		y -= 3;
		
		if(y < 0) {
			kill();
		}
		
		if(MovableEntity.testHit(x, y, damage)) {
			kill();
		}
	}
	
	public double getDamage() {
		return damage;
	}
	
	public void kill() {
		beams.remove(this);
	}

	public void draw(Graphics2D g2d) {
		g2d.drawImage(Resource.IMG_LASER, x + Resource.IMG_LASER.getWidth(), y, null);
	}

	public long getReload() {
		return RELOAD;
	}
}