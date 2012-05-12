package com.alpha.game;

import java.util.Timer;
import java.util.TimerTask;

public class Go extends Thread {
	private boolean up = false;
	private boolean down = false;
	private boolean left = false;
	private boolean right = false;
	
	public int x, y;
	public int leap = 1;
	
	private Timer timer;
	private GameState state;
	private Game game;
	
	Go(GameState s) {
		state = s;
		game = state.getGame();
		x = game.getLocX();
		y = game.getLocY();
		
		leap = state.getSpeed();
		
		createTimer();
	}

	public void setUp(boolean b) {
		up = b;
	}
	
	public void setDown(boolean b) {
		down = b;
	}
	
	public void setLeft(boolean b) {
		left = b;
	}
	
	public void setRight(boolean b) {
		right = b;
	}
	
	private void createTimer() {
		timer = new Timer();
		timer.schedule(new Task(this), 1, 14);
	}
	
	private class Task extends TimerTask {
		private Go go;
		Task(Go g) {
			go = g;
		}
		
		public void run() {
			go.run();
		}
	}
	
	public void run() {
		if(up) {
			game.setLocY(y -= leap);
		}
		
		if(down) {
			game.setLocY(y += leap);
		}
		
		if(left) {
			game.setLocX(x -= leap);
		}
		
		if(right) {
			game.setLocX(x += leap);
		}
		
		game.repaint();
	}
}