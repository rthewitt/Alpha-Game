package com.alpha.game.enemies;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import com.alpha.game.Frame;
import com.alpha.game.GameState;

public class BlueHeavy extends EnemyEntity {
	private BufferedImage using;
	int x, y = -30;
	private int health = 100;
	private final int YIN = 4;
	
	public BlueHeavy() {
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
					GameState.yin += YIN;
					kill();
				}
				return true;
			}
		}
		return false;
	}
	
	public void kill() {
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