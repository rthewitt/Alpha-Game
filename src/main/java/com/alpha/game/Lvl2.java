package com.alpha.game;

import java.util.Timer;
import java.util.TimerTask;

public class Lvl2
{
	private Timer timer;
	private int Sprites = 10;
	private int Width, Height;
	private Game game;
	private GameState state;
	
	Lvl2(int x, int y, Game g, GameState s)
	{
		Width = x;
		Height = y;
		game = g;
		state = s;
		state.setEnemies(Sprites);
		timer = new Timer();
		timer.schedule(new Task(), 3000, 1000);
	}
	
	private class Task extends TimerTask
	{
		public void run()
		{
			if(Sprites > 0)
			{
				Enemy s = new Enemy(Width, Height, game, state, 3);
				game.Scouts.addElement(s);
				s.start();
				Sprites --;
			}
		}
	}
}