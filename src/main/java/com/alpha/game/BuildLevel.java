package com.alpha.game;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;
import java.util.Vector;

public class BuildLevel extends Thread{
	
	Scanner scan;
	Vector<Integer> times = new Vector<Integer>();
	Vector<Integer> types = new Vector<Integer>();
	int Counter;
	
	public void newLevel(int lvl) {
		InputStream inFile = Thread.currentThread().getContextClassLoader().getResourceAsStream(Resource.levelsPath + "lvl" + lvl + ".txt");
		getData(inFile);
	}
	
	private void getData(InputStream iff) {
		
		scan = new Scanner(iff);
		while(scan.hasNext()) {
			times.add(scan.nextInt());
			// verify that there's another, else throw exception
			types.add(scan.nextInt());
		}
		GameState.enemies = times.size();
		
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