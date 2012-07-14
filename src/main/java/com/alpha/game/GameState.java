package com.alpha.game;

import java.awt.Graphics2D;
import com.alpha.game.ships.ShipEntity;

public class GameState {
	static int level = 1;
	static int wantedLevel;
	static int ship = 0;
	public static int enemies;
	static int beamType = 0;
	static boolean pause = false;
	public static int yin;
	
	//Stats
	public static int enemiesKilled = 0;
	public static int numDeaths = 0;
	public static int shotsFired = 0;
	public static int numHits = 0;
	public static double hitRatio = 0;
	public static int timePlayed = 0;
	public static int timesPlayed = 0;
	public static int achievmentsEarned = 0;
	
	static boolean useWantedLevel = false;
	
	//UpgradeMenu
	static boolean damageEnabled = false;
	public static boolean hullEnabled = false;
	static boolean lifeEnabled = false;
	
	static boolean dualEnabled = false;
	static boolean pierceEnabled = false;
	static boolean machGunEnabled = false;
	static boolean laserEnabled = false;
	static boolean lastGunEnabled = false;
	
	static int bulletSpeed = 3;
	
	static Frame frame;
	static Graphics2D g2d;
	
	public static void LevelOver() {
		if(enemies <= 0) {
			if(useWantedLevel == false)
				level ++;
			wantedLevel = level - 1;
			ShipControl.mousePressed = false;
			ShipEntity.currentShip.kill();
			hitRatio = ((double)numHits/(double)shotsFired) * 100;
			frame.RunUpgrade(2);
		}
	}
}