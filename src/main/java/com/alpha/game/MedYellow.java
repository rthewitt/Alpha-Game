package com.alpha.game;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class MedYellow extends Dif {
	
	private BufferedImage using = Resource.IMG_MED_YELLOW;
	int x, y = -30;
	private int health = 10;
	
	MedYellow() {
		x = (int)(10 + Math.random() * (Frame.width - 30));
	}
	
	public boolean testMe(int beamX, int beamY, double damage) {
		boolean go = false;
		
		if(x < beamX && beamX < x + using.getWidth()) {
			go = true;
		}
		
		if(go) {
			if(y < beamY && beamY < y + using.getHeight()) {
				Statics.numHits ++;
				health -= damage;
				
				if(health <1) {
					Statics.enemiesKilled ++;
					kill();
				}
				return true;
			}
		}
		return false;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public void kill() {
		Statics.enemiesKilled ++;
		Statics.enemies --;
		Statics.LevelOver();
		enemies.remove(this);
	}
	
	public void run() {
		y += 2;
		
		if(y > Frame.height) {
			kill();
		}
	}
	
	public void	draw(Graphics2D g2d) {
		g2d.drawImage(using, x, y, null);
	}

	@Override
	double getReload() {
		return 0;
	}
}