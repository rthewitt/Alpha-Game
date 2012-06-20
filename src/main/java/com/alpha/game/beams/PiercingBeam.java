package com.alpha.game.beams;

import java.awt.Graphics2D;

import com.alpha.game.MovableEntity;
import com.alpha.game.Resource;
import com.alpha.game.Ship;

public class PiercingBeam extends BeamEntity {
	private int x, y;
	private double damage = .3;
	private double RELOAD = 1;
	
	public PiercingBeam() {
		x = Ship.x;
		y = Ship.y;
	}
	
	public void update() {
		y --;
		
		if(y < 0) {
			kill();
		}
		
		MovableEntity.testHit(x, y, damage);
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
		g2d.drawImage(Resource.IMG_PEN, x - Resource.IMG_PEN.getWidth(), y, null);
	}

	public double getReload() {
		return RELOAD;
	}
}
