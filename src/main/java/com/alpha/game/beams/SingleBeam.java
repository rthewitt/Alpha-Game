package com.alpha.game.beams;

import java.awt.Graphics2D;
import com.alpha.game.Frame;
import com.alpha.game.MovableEntity;
import com.alpha.game.Resource;

public class SingleBeam extends BeamEntity {
	private int x, y;
	private boolean down;
	private final double damage = 5;
	private final long RELOAD = 300;
	
	public SingleBeam() {
		
	}
	
	public SingleBeam(int X, int Y, boolean b) {
		x = X;
		y = Y;
		down = b;
	}

	public void update() {
		if(down) {
			y --;
			
			if(y < 0)
				kill();
			if(MovableEntity.testHit(x, y, damage)) {
				kill();
			}
		} else {
			y ++;
			
			if(y > Frame.height)
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
		g2d.drawImage(Resource.IMG_BOLT, x - Resource.IMG_BOLT.getWidth()/2, y, null);
	}

	public long getReload() {
		return RELOAD;
	}
}