package com.alpha.game.beams;

import java.awt.Graphics2D;
import com.alpha.game.MovableEntity;
import com.alpha.game.Resource;

public class ExplodingBeam extends BeamEntity {
	private int x, y;
	private int damage = 20;
	private final long RELOAD = 1000;
	
	public ExplodingBeam() {
		
	}
	
	public ExplodingBeam(int X, int Y) {
		x = X;
		y = Y;
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
	
	public double getDamage() {
		return damage;
	}
	
	public void kill() {
		beams.remove(this);
	}

	public void draw(Graphics2D g2d) {
		g2d.drawImage(Resource.IMG_EXPLODING, x - Resource.IMG_EXPLODING.getWidth(), y, null);
	}

	public long getReload() {
		return RELOAD;
	}
}
