package com.alpha.game;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Levels {
	private Timer timer;
	
	private int i = 0, i2 = 0;
	
	File lvl1 = new File(Resource.levelsPath + "lvl" + 1 + ".txt");
	File lvl2 = new File(Resource.levelsPath + "lvl2.txt");
	File lvl3 = new File(Resource.levelsPath + "lvl3.txt");
	File lvl4 = new File(Resource.levelsPath + "lvl4.txt");
	File lvl5 = new File(Resource.levelsPath + "lvl5.txt");
	File lvl6 = new File(Resource.levelsPath + "lvl6.txt");
	File lvl7 = new File(Resource.levelsPath + "lvl7.txt");
	File lvl8 = new File(Resource.levelsPath + "lvl8.txt");
	File lvl9 = new File(Resource.levelsPath + "lvl9.txt");
	File lvl10 = new File(Resource.levelsPath + "lvl10.txt");
	
	Scanner scan;
	int length;
	int[][] work = new int[100][2];
	
	Levels(int lvl) {
		Run(lvl);
	}
	
	private void Run(int lvl) {
		switch(lvl) {
			case 1: getData(lvl1); break;
			
			case 2: getData(lvl2); break;
			
			case 3: getData(lvl3); break;
			
			case 4: getData(lvl4); break;
			
			case 5: getData(lvl5); break;
			
			case 6: getData(lvl6); break;
			
			case 7: getData(lvl7); break;
			
			case 8: getData(lvl8); break;
			
			case 9: getData(lvl9); break;
			
			case 10: getData(lvl10); break;
		}
		
		Statics.enemies = length;
		
		for(;i < length; i++) {
			timer = new Timer();
			timer.schedule(new Task(), work[i][0]*1000);
		}
	}
	
	public void getData(File f) {
		try {
			scan = new Scanner(f);
			for(int i = 0; scan.hasNext(); i++) {
				work[i][0] = scan.nextInt();
				work[i][1] = scan.nextInt();
				length = i + 1;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void build() {
		new New().newEnemy(work[i2][1]);
		i2 ++;
	}
	
	public class Task extends TimerTask {
		public void run() {
			build();
		}
	}
}
