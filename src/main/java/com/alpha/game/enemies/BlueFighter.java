package com.alpha.game.enemies;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import com.alpha.game.Frame;
import com.alpha.game.Resource;
import com.alpha.game.Statics;

public class BlueFighter extends EnemyEntity {
	
	private BufferedImage using = Resource.IMG_BLUE_FIGHTER;
	int x, y = -30;
	private int health = 10;
	
	public BlueFighter() {
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
	
	public void update() {
		y += 2;
		
		if(y > Frame.height) {
			kill();
		}
	}
	
	public void	draw(Graphics2D g2d) {
		g2d.drawImage(using, x, y, null);
	}
}