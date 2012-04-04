package com.alpha.game;

import java.util.Timer;
import java.util.TimerTask;

public class Go extends Thread
{
	private boolean Up = false;
	private boolean Down = false;
	private boolean Left = false;
	private boolean Right = false;
	
	public int x, y;
	
	private Timer timer;
	private Game game;
	
	Go(Game g)
	{
		game = g;
		x = game.getLocX();
		y = game.getLocY();
		createTimer();
	}
	
	public void setUp(boolean b)
	{
		Up = b;
	}
	
	public void setDown(boolean b)
	{
		Down = b;
	}
	
	public void setLeft(boolean b)
	{
		Left = b;
	}
	
	public void setRight(boolean b)
	{
		Right = b;
	}
	
	private void createTimer()
	{
		timer = new Timer();
		timer.schedule(new Task(this), 1, 10);
	}
	
	private class Task extends TimerTask
	{
		private Go go;
		Task(Go g)
		{
			go = g;
		}
		
		public void run()
		{
			go.run();
		}
	}
	
	public void run()
	{
		if(Up)
		{
			game.setLocY(y --);
		}
		
		if(Down)
		{
			game.setLocY(y ++);
		}
		
		if(Left)
		{
			game.setLocX(x --);
		}
		
		if(Right)
		{
			game.setLocX(x ++);
		}
		
		game.repaint();
	}
}