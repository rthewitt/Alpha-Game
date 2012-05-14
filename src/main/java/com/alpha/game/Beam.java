package com.alpha.game;

import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class Beam extends Thread {
	private boolean beamStarted;
	private boolean draw = true;
	private Ellipse2D.Double thisBeam;
	
	private int	speed = 1;
	private int	diry = 1, dirx = 0;
	private int	size = 7;
	int x, y;
	private int counter = 0;
	
	private Game game;
	private Collision col;
	
	public Beam(int StartX,	int StartY, Game g) {
		col = GameState.col;
		game = g;
		thisBeam = new Ellipse2D.Double(StartX, StartY, size, size);
		beamStarted	= true;
	}
	
	public void	draw(Graphics2D g2d) {
		if(thisBeam	!= null && beamStarted && draw) {
			g2d.drawImage(Resource.IMG_BOLT, getX(), getY(), null);
		}
	}
	
	@SuppressWarnings("deprecation")
	public void kill() {
		game.IncrementChecks();
		draw = false;
		beamStarted = false;
		this.stop();
	}
	
	public void setDirX(int dir) {
		dirx = dir;
	}
	
	public void setDirY(int dir) {
		diry = dir;
	}
	
	public void setSpeed(int s) {
		speed = s;
	}
	
	public void	run() {
		while(beamStarted) {
			if(counter > 9) {
				col.TestBeam(this);
			}else {
				counter ++;
			}
			
			try {
				Thread.sleep(speed);
			}
			catch(InterruptedException e) {}
			
			int OldY = (int) thisBeam.getY();
			int NewY = OldY;
			int OldX = (int) thisBeam.getX();
			int NewX = OldX;
			
			NewY -= diry;
			NewX += dirx;
			
			if(NewY < 0 || NewX < 0 || NewX > 500) {
				kill();
			}
			
			y = NewY;
			x = NewX;
			
			thisBeam.setFrame(NewX,	NewY,	size,	size);
			
			game.repaint();
		}
	}

	public int getX() {
		return (int) thisBeam.getX();
	}
	public int getY() {
		return (int) thisBeam.getY();
	}

	public int getDir() {
		return dirx;
	}
}