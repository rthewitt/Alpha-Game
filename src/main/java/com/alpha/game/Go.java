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
	public int leap = 1;
	
	private Timer timer;
	private GameState state;
	private Game game;
	
	Go(GameState s)
	{
		state = s;
		game = state.getGame();
		x = game.getLocX();
		y = game.getLocY();
		
		leap = state.getSpeed();
		
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
		timer.schedule(new Task(this), 1, 14);
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
			game.setLocY(y -= leap);
		}
		
		if(Down)
		{
			game.setLocY(y += leap);
		}
		
		if(Left)
		{
			game.setLocX(x -= leap);
		}
		
		if(Right)
		{
			game.setLocX(x += leap);
		}
		
		game.repaint();
	}
}