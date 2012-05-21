package com.alpha.game;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

 public class GameState extends Thread {
	static int level = 1;
	static int wantedLevel;
	static int ship = 0;
	static int speed;
	static int enemies;
	static int life = 20;
	static int damage = 5;
	static int beamType = 0;
	
	static boolean useWantedLevel = false;
	
	//UpgradeMenu
	static boolean damageEnabled = false;
	static boolean machGunEnabled = false;
	static boolean laserEnabled = false;
	static boolean hullEnabled = false;
	static boolean dualEnabled = false;
	static boolean lifeEnabled = false;
	
	static Control con;
	static Game game;
	static Star star;
	
	static Image currentShip;
	static ImageIcon hullShip;
	static ImageIcon nextShip;
	
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
		
		currentShip = Toolkit.getDefaultToolkit().createImage(img.getSource());
	}
	
	static void LevelOver() {
		if(enemies <= 0) {
			if(useWantedLevel == false)
				level ++;
			wantedLevel = level - 1;
			game.scouts.clear();
			con.RunUpgrade(2);
		}
	}
}