package com.alpha.game.enemies;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import com.alpha.game.Frame;
import com.alpha.game.Resource;
import com.alpha.game.GameState;

public class RedHeavy extends EnemyEntity {
	
	private BufferedImage using = Resource.IMG_RED_HEAVY;
	int x, y = -30;
	private int health = 40;
	
	public RedHeavy() {
		
		x = (int)(10 + Math.random() * (Frame.width - 30));
	}
	
	public boolean testMe(int beamX, int beamY, double damage) {
		boolean go = false;
		
		if(x < beamX && beamX < x + using.getWidth()) {
			go = true;
		}
		
		if(go) {
			if(y < beamY && beamY < y + using.getHeight()) {
				GameState.numHits ++;
				health -= damage;
				
				if(health <1) {
					GameState.enemiesKilled ++;
					kill();
				}
				return true;
			}
		}
		return false;
	}
	
	public void kill() {
		GameState.enemiesKilled ++;
		GameState.enemies --;
		GameState.LevelOver();
		enemies.remove(this);
	}
	
	public void update() {
		y += 1;
		
		if(y > Frame.height) {
			kill();
		}
	}
	
	public void	draw(Graphics2D g2d) {
		g2d.drawImage(using, x, y, null);
	}
}
