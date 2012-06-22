package com.alpha.game;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import com.alpha.game.beams.*;
import com.alpha.game.enemies.*;
import com.alpha.game.ships.*;

public class Factory {
	
	static MovableEntity r;
	
	public static void newBeam(int x, int y) {
		switch(GameState.beamType) {
		case 0: r = new SingleBeam(x, y); break;
		
		case 1: r = new DualBeam(x, y); break;

		case 2: r = new PiercingBeam(x, y); break;
		
		case 3: r = new ExplodingBeam(x, y); break;
		
		case 4: r = new LaserBeam(x, y); break;
		
		case 5: r = new WaveBeam(x, y); break;
		
		case 6: r = new ShotgunBeam(x, y); break;

		case 7: r = new MachgunBeam(x, y); break;
		}
		MovableEntity.beams.addElement(r);
	}
	
	static void newEnemy(int type) {
		switch(type) {
		case 1: r = new RedFighter(); break;
		
		case 2: r = new RedHeavy(); break;
		
		case 3: r = new BlueFighter(); break;
		
		case 4: r = new BlueHeavy(); break;
		
		case 5: r = new MedYellow(); break;
		
		case 6: r = new BigYellow(); break;
		
		case 7: r = new BossOne(); break;
		}
		MovableEntity.enemies.addElement(r);
	}
	
	static void newShip(int type) {
		int x = 250, y = 600;
		switch(type) {
		case 1: r = new SmallGreen(x, y); break;
		
		case 2: r = new MedGreen(x, y); break;
		
		case 3: r = new LargeGreen(x, y); break;
		
		case 4: r = new SmallRed(x, y); break;
		
		case 5: r = new MedRed(x, y); break;
		
		case 6: r = new LargeRed(x, y); break;
		
		case 7: r = new SmallBlue(x, y); break;
		
		case 8: r = new MedBlue(x, y); break;
		
		case 9: r = new LargeBlue(x, y); break;
		}
		MovableEntity.ships.addElement(r);
	}
	
	private static Timer timer;
	private static int i = 0;
	private static int i2 = 0;
	static File level;
	static Scanner scan;
	static int length;
	static int[][] work = new int[100][2];
	
	static void newLevel(int lvl) {
		getData(level = new File(Resource.levelsPath + "lvl" + lvl + ".txt"));
		
		GameState.enemies = length;
		
		for(;i < length; i++) {
			timer = new Timer();
			timer.schedule(new Task(), work[i][0]*1000);
		}
	}
	
	private static void getData(File f) {
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
	
	private static void build() {
		Factory.newEnemy(work[i2][1]);
		i2 ++;
	}
	
	private static class Task extends TimerTask {
		public void run() {
			build();
		}
	}
}
