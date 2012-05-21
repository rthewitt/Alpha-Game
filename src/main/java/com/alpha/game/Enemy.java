package com.alpha.game;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Enemy extends Thread {
	private boolean scoutStarted;
	private boolean draw = true;
	boolean taken = false;
	
	private BufferedImage using;
	
	int startX, startY;
	private int speed;
	private int health = 10;
	private int type;
	
	Enemy(int t) {
		type = t;
		
		switch(type) {
			case 1: using = Resource.IMG_RED_FIGHTER; setHealth(5); break;
			
			case 2: using = Resource.IMG_RED_HEAVY; setHealth(20); break;
			
			case 3: using = Resource.IMG_BLUE_FIGHTER; setHealth(10); break;
			
			case 4: using = Resource.IMG_BLUE_HEAVY; setHealth(30); break;
			
			case 5: using = Resource.IMG_MED_YELLOW; setHealth(30); break;
			
			case 6: using = Resource.IMG_BIG_YELLOW; setHealth(40); break;
			
			case 7: using = Resource.IMG_BOSS_ONE; setHealth(300); break;
		}
		
		startX = (int)(10 + Math.random() * (Control.width - 30));
		startY = -30;
		speed = 30;
		scoutStarted = true;
	}
	
	public void setPosition(int x) {
		startX = x;
	}
	
	public void setSpeed(int s) {
		speed = s;
	}
	
	public void setHealth(int h) {
		health = h;
	}
	
//	private class BeamTask extends TimerTask {
//		public void run() {
//			Beam newBeam = new Beam(StartX, StartY, game, 2);
//			game.Beams.addElement(newBeam);
//			newBeam.start();
//		}
//	}
	
	public void	draw(Graphics2D g2d) {
		if(scoutStarted && draw) {
			g2d.drawImage(using, startX, startY, null);
		}
	}
	
	public void testHit(BeamElement be) {
		int Y = be.getY();
		int X = be.getX();
		boolean go = false;
		
		if(startX < X && X < startX + using.getWidth()) {
			go = true;
		}
		
		if(go) {
			if(startY < Y && Y < startY + using.getHeight()) {
				be.kill();
				kill();
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	public boolean kill() {
		health -= 5;
		if(health <1) {
			GameState.enemies --;
			GameState.LevelOver();
			
			draw = false;
			scoutStarted = false;
			this.stop();
			return true;
		}else {
			return false;
		}
	}
	
	public void run() {
		while(scoutStarted) {
			try {
				Thread.sleep(speed);
			}catch (InterruptedException e) {
				System.out.println("Woke up prematurely");
			}
			
			startY += 2;
			
			if(startY > Control.height) {
				kill();
			}
		}
	}

	public int getX() {
		return startX;
	}

	public int getY() {
		return startY;
	}
}