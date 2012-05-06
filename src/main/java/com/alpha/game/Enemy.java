package com.alpha.game;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Enemy extends Thread
{
	private boolean scoutStarted;
	private boolean draw = true;
	boolean taken = false;
	
	private BufferedImage using;
	private GameState state;
	private Collision col;
	private Game game;
	
	int startX, startY;
	private int speed;
	private int width, height;
	private int health = 10;
	private int Type;
	
	Enemy(GameState st, int t)
	{
		state = st;
		col = state.getCollision();
		game = state.getGame();
		width = game.getScreenWidth();
		height = game.getScreenHeight();
		Type = t;
		
		switch(Type)
		{
			case 1: using = Resource.IMG_RED_FIGHTER; setHealth(5); break;
			
//			case 2: using = res.getRedHeavy(); setHealth(30); break;
			
			case 3: using = Resource.IMG_BLUE_FIGHTER; setHealth(10); break;
			
			case 4: using = Resource.IMG_BLUE_HEAVY; setHealth(30); break;
		}
		
		startX = (int)(10 + Math.random() * (width - 30));
		startY = -30;
		speed = 30;
		scoutStarted = true;
		col.addShip(this);
	}
	
	public void setPosition(int x)
	{
		startX = x;
	}
	
	public void setSpeed(int s)
	{
		speed = s;
	}
	
	public void setHealth(int h)
	{
		health = h;
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
		if(scoutStarted && draw)
		{
			g2d.drawImage(using, startX, startY, null);
		}
	}
	
	@SuppressWarnings("deprecation")
	public boolean kill()
	{
		health -= 5;
		if(health <1)
		{
			state.DecrementEnemies();
			draw = false;
			scoutStarted = false;
			this.stop();
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void run()
    {
		while(scoutStarted)
		{
			try
			{
				Thread.sleep(speed);
			}
			catch (InterruptedException e)
			{
				System.out.println("Woke up prematurely");
			}
			
			startY += 2;
			
			if(startY > height)
			{
				kill();
			}
		}
	}

	public int getX()
	{
		return startX;
	}

	public int getY()
	{
		return startY;
	}
}