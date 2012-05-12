package com.alpha.game;

import java.util.Timer;
import java.util.TimerTask;

public class Levels extends Thread {
	private Timer timer;
	private Game game;
	private GameState state;
	
	private int i = 0, i2 = 0;
	
	int[][] work;
	
	private int[][] lvl1 =  { {3, 1},  {4, 1},  {5, 1},  {6, 1},  {7, 1},  {8, 1},  {9, 1},  {10, 1},  {11, 1},  {12, 1}};
	private int[][] lvl2 =  { {3, 3},  {4, 3},  {5, 3},  {6, 3},  {7, 3},  {8, 3},  {9, 3},  {10, 3},  {11, 3},  {12, 3}};
	private int[][] lvl3 =  { {4, 1},  {3, 3},  {4, 1},  {7, 1},  {6, 3},  {7, 1},  {10, 1},  {9, 3},  {10, 1},  {13, 1},  {12, 3},  {13, 1}};
	
	Levels(GameState s, int lvl) {
		state = s;
		game = state.getGame();
		
		Run(lvl);
	}
	
	private void Run(int lvl) {
		switch(lvl) {
			case 1: work = lvl1.clone(); break;
			
			case 2: work = lvl2.clone(); break;
			
			case 3: work = lvl3.clone(); break;
		}
		
		state.setEnemies(work.length);
		
		for(;i < work.length; i++) {
			timer = new Timer();
			timer.schedule(new Task(), work[i][0]*1000);
		}
	}
	
	public void build() {
		Enemy s = new Enemy(state, work[i2][1]);
		game.scouts.addElement(s);
		s.start();
		i2 ++;
	}
	
	public class Task extends TimerTask {
		public void run() {
			build();
		}
	}
}
