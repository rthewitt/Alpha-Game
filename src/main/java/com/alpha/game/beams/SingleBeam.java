package com.alpha.game.beams;

import java.awt.Graphics2D;

import com.alpha.game.MovableEntity;
import com.alpha.game.Resource;
import com.alpha.game.Ship;

public class SingleBeam extends BeamEntity {
	private int x, y;
	private final double damage = 5;
	private final double RELOAD = 1;
	
	public SingleBeam() {
		x = Ship.shipMiddle();
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
		g2d.drawImage(Resource.IMG_BOLT, x - Resource.IMG_BOLT.getWidth()/2, y, null);
	}

	double getReload() {
		return RELOAD;
	}
}