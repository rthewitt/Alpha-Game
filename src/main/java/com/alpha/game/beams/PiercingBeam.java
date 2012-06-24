package com.alpha.game.beams;

import java.awt.Graphics2D;

import com.alpha.game.MovableEntity;
import com.alpha.game.Resource;

public class PiercingBeam extends BeamEntity {
	private int x, y;
	private double damage = .3;
	private final long RELOAD = 400;
	
	public PiercingBeam() {
		
	}
	
	public PiercingBeam(int X, int Y) {
		x = X;
		y = Y;
	}
	
	public void update() {
		y --;
		
		if(y < 0) {
			kill();
		}
		
		MovableEntity.testHit(x, y, damage);
	}
	
	public double getDamage() {
		return damage;
	}
	
	public void kill() {
		beams.remove(this);
	}

	public void draw(Graphics2D g2d) {
		g2d.drawImage(Resource.IMG_PEN, x - Resource.IMG_PEN.getWidth()/2, y, null);
	}

	public long getReload() {
		return RELOAD;
	}
}
