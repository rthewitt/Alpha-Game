package com.alpha.game;

import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class Beam extends Thread
{
	private boolean BeamStarted;
	private boolean draw = true;
	private Ellipse2D.Double thisBeam;
	
	private int	speed = 1;
	private int	diry = 1, dirx = 0;
	private int	size = 7;
	int x, y;
	private int Counter = 0;
	
	private Game gamePanel;
	private Beam beam = this;
	private GameState state;
	private Collision col;
	
	public Beam(int StartX,	int StartY, Game g, GameState s)
	{
		state = s;
		col = state.getCollision();
		gamePanel = g;
		thisBeam = new Ellipse2D.Double(StartX, StartY, size, size);
		BeamStarted	= true;
	}
	
	public void	draw(Graphics2D g2d)
	{
		if(thisBeam	!=	null && BeamStarted && draw)
		{
			g2d.drawImage(Resource.IMG_BOLT, getX(), getY(), null);
		}
	}
	
	public void destroy(int y, int time)
	{
		draw = false;
	}
	
	public void setDirX(int dir)
	{
		dirx = dir;
	}
	
	public void setDirY(int dir)
	{
		diry = dir;
	}
	
	public void setSpeed(int s)
	{
		speed = s;
	}
	
	@SuppressWarnings("deprecation")
	public void	run()
	{
		while(BeamStarted)
		{
			if(Counter > 9)
			{
				col.TestBeam(this);
			}
			else
			{
				Counter ++;
			}
			
			try
			{
				Thread.sleep(speed);
			}
			catch	(InterruptedException e)
			{
				System.out.println("Woke up prematurely");
			}
			
			int OldY = (int) thisBeam.getY();
			int NewY = OldY;
			int OldX = (int) thisBeam.getX();
			int NewX = OldX;
			
			NewY -= diry;
			NewX += dirx;
			
			if(NewY < 0 || NewX < 0 || NewX > 500)
			{
				gamePanel.IncrementChecks();
				BeamStarted	= false;
				beam.stop();
			}
			
			y = NewY;
			x = NewX;
			
			thisBeam.setFrame(NewX,	NewY,	size,	size);
			
			gamePanel.repaint();
		}
	}

	public int getX()
	{
		return (int) thisBeam.getX();
	}
	public int getY()
	{
		return (int) thisBeam.getY();
	}

	public int getDir()
	{
		return dirx;
	}
}