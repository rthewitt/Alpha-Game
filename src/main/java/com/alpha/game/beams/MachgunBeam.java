package com.alpha.game.beams;

import java.awt.Graphics2D;

import com.alpha.game.Frame;
import com.alpha.game.MovableEntity;
import com.alpha.game.Resource;

public class MachgunBeam extends BeamEntity {
	private int x, y;
	private boolean down;
	private double damage = 3;
	private final long RELOAD = 100;
	
	public MachgunBeam() {
		
	}
	
	public MachgunBeam(int X, int Y, boolean b) {
		x = X;
		y = Y;
		down = b;
	}
	
	public void update() {
		if(down) {
			y --;
			
			if(y < 0)
				kill();
		} else {
			y --;
			
			if(y > Frame.height)
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
		g2d.drawImage(Resource.IMG_BOLT, x + Resource.IMG_BOLT.getWidth(), y, null);
	}

	public long getReload() {
		return RELOAD;
	}
}
