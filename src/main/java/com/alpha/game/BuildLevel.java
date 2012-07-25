package com.alpha.game;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class BuildLevel {
	Timer timer = new Timer();
	Scanner scan;
	List<Integer> times = new ArrayList<Integer>();
	List<Integer> types = new ArrayList<Integer>();
	int Counter;
	
	public void newLevel(int lvl) {
		InputStream inFile = Thread.currentThread().getContextClassLoader().getResourceAsStream(Resource.levelsPath + "lvl" + lvl + ".txt");
		getData(inFile);
	}
	
	private void getData(InputStream iff) {
		
		scan = new Scanner(iff);
		while(scan.hasNext()) {
			times.add(scan.nextInt());
			types.add(scan.nextInt());
		}
		GameState.enemies = times.size();
		
		timer.schedule(new Task(), 1, 1000);
	}
	
	class Task extends TimerTask {
		public void run() {
			update();
		}
	}
	
	public void update() {
		if(GameState.pause == false) {
			Counter += 1;
			for(int i = 0; i < times.size(); i ++)
				if(Counter >= times.get(i)) {
					Factory.newEnemy(types.get(i));
					times.remove(i);
					types.remove(i);
					
					if(times.isEmpty()) {
						timer.cancel();
					}
				}
		}
	}
}