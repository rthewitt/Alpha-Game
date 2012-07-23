package com.alpha.game;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

public class BuildLevel extends Thread{
	
	Scanner scan;
	Vector<Integer> times = new Vector<Integer>();
	Vector<Integer> types = new Vector<Integer>();
	int Counter;
	
	public void newLevel(int lvl) {
		getData(new File(Resource.levelsPath + "lvl" + lvl + ".txt"));
	}
	
	private void getData(File f) {
		try {
			scan = new Scanner(f);
			while(scan.hasNext()) {
				times.add(scan.nextInt());
				// verify that there's another, else throw exception
				types.add(scan.nextInt());
			}
			GameState.enemies = times.size();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		start();
	}
	
	public void run() {
		while(true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if(GameState.pause == false) {
				Counter += 1;
				for(int i = 0; i < times.size(); i ++)
					if(Counter >= times.elementAt(i)) {
						Factory.newEnemy(types.elementAt(i));
						times.remove(i);
						types.remove(i);
						
						if(times.isEmpty()) {
							kill();
						}
					}
			}
		}	
	}
	
	@SuppressWarnings("deprecation")
	private void kill() {
		stop();
	}
}