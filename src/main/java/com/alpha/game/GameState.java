package com.alpha.game;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

import com.alpha.game.ships.ShipEntity;

public class GameState {
	static int level = 1;
	static int wantedLevel;
	static int ship = 0;
	public static int enemies;
	static int beamType = 0;
	static boolean pause = false;
	
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
	static boolean hullEnabled = false;
	static boolean lifeEnabled = false;
	
	static boolean dualEnabled = false;
	static boolean pierceEnabled = false;
	static boolean machGunEnabled = false;
	static boolean laserEnabled = false;
	static boolean lastGunEnabled = false;
	
	static int bulletSpeed = 3;
	
	static Frame frame;
	static Game game;
	static Star star;
	
	public static BufferedImage currentShip;
	static ImageIcon hullShip;
	static ImageIcon nextShip;
	
	static Graphics2D g2d;
	
	public static void updateShip() {
		BufferedImage img = null;
		if(hullEnabled) {
			switch(ship) {
				case 1: img = Resource.IMG_SMALL_GREEN_ARMOR; break;
				
				case 2: img = Resource.IMG_MED_GREEN_ARMOR; break;
				
				case 3: img = Resource.IMG_LARGE_GREEN_ARMOR; break;
				
				case 4: img = Resource.IMG_SMALL_RED_ARMOR; break;
				
				case 5: img = Resource.IMG_MED_RED_ARMOR; break;
				
				case 6: img = Resource.IMG_LARGE_RED_ARMOR; break;
				
				case 7: img = Resource.IMG_SMALL_BLUE_ARMOR; break;
				
				case 8: img = Resource.IMG_MED_BLUE_ARMOR; break;
				
				case 9: img = Resource.IMG_LARGE_BLUE_ARMOR; break;
			}
		}else {
			switch(ship) {
				case 1: img = Resource.IMG_SMALL_GREEN;
					hullShip = new ImageIcon(Resource.IMG_SMALL_GREEN_ARMOR);
					nextShip = new ImageIcon(Resource.IMG_MED_GREEN); break;
				
				case 2: img = Resource.IMG_MED_GREEN;
					hullShip = new ImageIcon(Resource.IMG_MED_GREEN_ARMOR);
					nextShip = new ImageIcon(Resource.IMG_LARGE_GREEN); break;
				
				case 3: img = Resource.IMG_LARGE_GREEN;
					hullShip = new ImageIcon(Resource.IMG_LARGE_GREEN_ARMOR); break;
					
				case 4: img = Resource.IMG_SMALL_RED;
					hullShip = new ImageIcon(Resource.IMG_SMALL_RED_ARMOR);
					nextShip = new ImageIcon(Resource.IMG_MED_RED); break;
				
				case 5: img = Resource.IMG_MED_RED;
					hullShip = new ImageIcon(Resource.IMG_MED_RED_ARMOR);
					nextShip = new ImageIcon(Resource.IMG_LARGE_RED); break;
				
				case 6: img = Resource.IMG_LARGE_RED;
					hullShip = new ImageIcon(Resource.IMG_LARGE_RED_ARMOR); break;
				
				case 7: img = Resource.IMG_SMALL_BLUE;
					hullShip = new ImageIcon(Resource.IMG_SMALL_BLUE_ARMOR);
					nextShip = new ImageIcon(Resource.IMG_MED_BLUE); break;
				
				case 8: img = Resource.IMG_MED_BLUE;
					hullShip = new ImageIcon(Resource.IMG_MED_BLUE_ARMOR);
					nextShip = new ImageIcon(Resource.IMG_LARGE_BLUE); break;
				
				case 9: img = Resource.IMG_LARGE_BLUE;
					hullShip = new ImageIcon(Resource.IMG_LARGE_BLUE_ARMOR); break;
			}
		}
		currentShip = img;
	}
	
	public static void LevelOver() {
		if(enemies <= 0) {
			if(useWantedLevel == false)
				level ++;
			wantedLevel = level - 1;
			Game.timer.cancel();
			ShipEntity.currentShip.kill();
			hitRatio = ((double)numHits/(double)shotsFired) * 100;
			frame.RunUpgrade(2);
		}
	}
}