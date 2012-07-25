package com.alpha.game;

import java.awt.image.BufferedImage;
import java.util.Random;

public class Factory {
	
	static Enemies e;
	static Ship s;
	static Beams b;
	
	private static void newBeam(double x, double y, int type, boolean yourBeam) {
		switch(type) {
		case 0: b = new Beams(x, y, 3.2, yourBeam, 500, 5, Resource.IMG_BOLT); break;
		
		case 1: b = new Beams(x, y, 3.2, yourBeam, 750, 10, Resource.IMG_BOLT); break;

		case 2: b = new Beams(x, y, 3.2, yourBeam, 1000, .1, Resource.IMG_PEN); break;
		
		case 3: b = new Beams(x, y, 2.0, yourBeam, 2000, 20, Resource.IMG_EXPLODING); break;
		
		case 4: b = new Beams(x, y, 3.2, yourBeam, 1000, 5, Resource.IMG_LASER); break;
		
		case 5: b = new Beams(x, y, 3.2, yourBeam, 1000, 5, Resource.IMG_BOLT); break;
		
		case 6: b = new Beams(x, y, 3.2, yourBeam, 1000, 5, Resource.IMG_BOLT); break;

		case 7: b = new Beams(x, y, 3.2, yourBeam, 1000, 5, Resource.IMG_BOLT); break;
		}
	}
	
	public static void newEnemyBeam(int x, int y, int type){
		newBeam(x, y, type, false);
	}
	
	public static void newShipBeam(int x, int y, int type) {
		newBeam(x, y, type, true);
	}
	
	static void newEnemy(int type) {
		switch(type) {
		case 1: e = new Enemies(ranGenX(Resource.IMG_RED_FIGHTER), 1, 5, Resource.IMG_RED_FIGHTER, 1); break;
		
		case 2: e = new Enemies(ranGenX(Resource.IMG_RED_HEAVY), .7, 20, Resource.IMG_RED_HEAVY, 10); break;
		
		case 3: e = new Enemies(ranGenX(Resource.IMG_BLUE_FIGHTER), .9, 15, Resource.IMG_BLUE_FIGHTER, 3); break;
		
		case 4: e = new Enemies(ranGenX(Resource.IMG_BLUE_HEAVY), .6, 30, Resource.IMG_BLUE_HEAVY, 12); break;
		
		case 5: e = new Enemies(ranGenX(Resource.IMG_MED_YELLOW), .7, 50, Resource.IMG_MED_YELLOW, 20); break;
		
		case 6: e = new Enemies(ranGenX(Resource.IMG_BIG_YELLOW), .5, 70, Resource.IMG_BIG_YELLOW, 25); break;
		
		case 7: e = new Enemies(pickSides(Resource.IMG_PINK_CORVETTE), .3, 30, Resource.IMG_BIG_YELLOW, 20); break; 
				
		case 8: e = new Enemies(ranGenX(Resource.IMG_BOSS_ONE), .1, 400, Resource.IMG_BOSS_ONE, 100); break;
		}
	}
	
	private static double ranGenX(BufferedImage bi) {
		Random generator = new Random();
		return (double)generator.nextInt(Frame.width - bi.getWidth()) + 1;
	}
	
	private static double pickSides(BufferedImage bi) {
		Random generator = new Random();
		int side = generator.nextInt(3) + 1;
		double choice = 0;
		
		switch(side) {
		case 1: choice = 1.0; break;
		
		case 2: choice = Frame.width/2 - bi.getWidth()/2; break;
		
		case 3: choice = Frame.width - bi.getWidth();
		}
		return choice;
	}
	
	static void newShip(int type) {
		int x = 250, y = 600;
		switch(type) {
		case 1: s = new Ship(x, y, 1, 10, Resource.IMG_SMALL_GREEN, Resource.IMG_MED_GREEN, Resource.IMG_SMALL_GREEN_ARMOR); break;
		
		case 4: s = new Ship(x, y, .5, 10, Resource.IMG_SMALL_RED, Resource.IMG_MED_RED, Resource.IMG_SMALL_RED_ARMOR); break;
		
		case 7: s = new Ship(x, y, 2, 10, Resource.IMG_SMALL_BLUE, Resource.IMG_MED_BLUE, Resource.IMG_SMALL_BLUE_ARMOR); break;
		
		case 2: s = new Ship(x, y, 1, 10, Resource.IMG_MED_GREEN, Resource.IMG_LARGE_GREEN, Resource.IMG_MED_GREEN_ARMOR); break;
		
		case 5: s = new Ship(x, y, .5, 10, Resource.IMG_MED_RED, Resource.IMG_LARGE_RED, Resource.IMG_MED_RED_ARMOR); break;
		
		case 8: s = new Ship(x, y, 2, 10, Resource.IMG_MED_BLUE, Resource.IMG_LARGE_BLUE, Resource.IMG_MED_BLUE_ARMOR); break;
		
		case 3: s = new Ship(x, y, 1, 10, Resource.IMG_LARGE_GREEN, null, Resource.IMG_LARGE_GREEN_ARMOR); break;
		
		case 6: s = new Ship(x, y, .5, 10, Resource.IMG_LARGE_RED, null, Resource.IMG_LARGE_RED_ARMOR); break;
		
		case 9: s = new Ship(x, y, 2, 10, Resource.IMG_LARGE_BLUE, null, Resource.IMG_LARGE_BLUE_ARMOR); break;
		}
	}
	
	//Example of what I have in mind for level options
	static void newNormalLevel(int lvl) {
		new BuildLevel().newLevel(lvl);
	}
	
	static void newSlowModeLevel(int lvl) {
		//speedModifier = 2
		new BuildLevel().newLevel(lvl);
	}
	
	static void newHardModeLevel(int lvl) {
		//EnemieDamageModifier += 1.5
		//EnemieSpeedModifier += 1
		//EnemieHealthModifier = 2
		new BuildLevel().newLevel(lvl);
	}
	
	static void newImpossibleLevel(int lvl) {
		//EnemieDamageModifier += 2
		//EnemieSpeedModifier += 2
		//EnemieHealthModifier = 4
		new BuildLevel().newLevel(lvl);
	}
}