package com.alpha.game;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Enemy extends Thread
{
	private boolean ScoutStarted;
	private boolean draw = true;
	boolean taken = false;
	
	private BufferedImage using;
	private GameState state;
	private Collision col;
	@SuppressWarnings("unused")
	private Game game;
	Enemy s = this;
	
	int StartX, StartY;
	private int speed;
	private int Width, Height;
	@SuppressWarnings("unused")
	private int Health = 10;
	private int Type;
	
	Enemy(int x, int y, Game g, GameState st, int t)
	{
		state = st;
		col = state.getCollision();
		game = g;
		Width = x;
		Height = y;
		Type = t;
		
		switch(Type)
		{
			case 1: using = Resource.IMG_RED_FIGHTER; setHealth(10); break;
			
//			case 2: using = res.getRedHeavy(); setHealth(30); break;
			
			case 3: using = Resource.IMG_BLUE_FIGHTER; setHealth(15); break;
			
			case 4: using = Resource.IMG_BLUE_HEAVY; setHealth(45); break;
		}
		
		StartX = (int)(10 + Math.random() * (Width - 30));
		StartY = 0;
		speed = 30;
		ScoutStarted = true;
		col.addShip(this);
	}
	
	public void setPosition(int x)
	{
		StartX = x;
	}
	
	public void setSpeed(int s)
	{
		speed = s;
	}
	
	public void setHealth(int h)
	{
		Health = h;
	}
	
//	private class BeamTask extends TimerTask
//	{
//		public void run()
//		{
//			Beam newBeam = new Beam(StartX, StartY, game, state, 2);
//			game.Beams.addElement(newBeam);
//			newBeam.start();
//		}
//	}
	
	public void	draw(Graphics2D g2d)
	{
		if(ScoutStarted && draw)
		{
			g2d.drawImage(using, StartX, StartY, null);
		}
	}
	
	@SuppressWarnings("deprecation")
	public void kill()
	{
		state.DecrementEnemies();
		draw = false;
		this.stop();
	}
	
	@SuppressWarnings("deprecation")
	public void run()
   {
      while(ScoutStarted)
      {
    	  try
    	  {
            Thread.sleep(speed);
    	  }
    	  catch (InterruptedException e)
    	  {
    		  System.out.println("Woke up prematurely");
    	  }
			
			StartY += 2;
			
			if(StartY > Height)
			{
				ScoutStarted = false;
				state.DecrementEnemies();
				s.stop();
			}
		}
	}

	public int getX()
	{
		return StartX;
	}

	public int getY()
	{
		return StartY;
	}
}