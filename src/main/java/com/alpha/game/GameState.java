package com.alpha.game;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

public class GameState extends Thread {
	private int level;
	private int ship = 0;
	private int speed;
	private int enemies;
	private int life;
	private int damage;
	private boolean machGun;
	private boolean laser;
	private boolean hullUp;
	private boolean dual;
	
	private Control con;
	private Game game;
	private Collision col;
	private Star star;
	
	static Image currentShip;
	private ImageIcon hullShip;
	private ImageIcon nextShip;
	
	
	GameState() {
		init();
	}
	
	public void init() {
		level = 1;
		damage = 5;
		life = 20;
		speed = 5;
		machGun = false;
		laser = false;
		hullUp = false;
		dual = false;
	}
	
	public void updateShip() {
		BufferedImage img = null;
		if(getHull()) {
			switch(getShip()) {
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
			switch(getShip()) {
				case 1: img = Resource.IMG_SMALL_GREEN;
					this.hullShip = new ImageIcon(Resource.IMG_SMALL_GREEN_ARMOR);
					this.nextShip = new ImageIcon(Resource.IMG_MED_GREEN); break;
				
				case 2: img = Resource.IMG_MED_GREEN;
					this.hullShip = new ImageIcon(Resource.IMG_MED_GREEN_ARMOR);
					this.nextShip = new ImageIcon(Resource.IMG_LARGE_GREEN); break;
				
				case 3: img = Resource.IMG_LARGE_GREEN;
					this.hullShip = new ImageIcon(Resource.IMG_LARGE_GREEN_ARMOR); break;
					
				case 4: img = Resource.IMG_SMALL_RED;
					this.hullShip = new ImageIcon(Resource.IMG_SMALL_RED_ARMOR);
					this.nextShip = new ImageIcon(Resource.IMG_MED_RED); break;
				
				case 5: img = Resource.IMG_MED_RED;
					this.hullShip = new ImageIcon(Resource.IMG_MED_RED_ARMOR);
					this.nextShip = new ImageIcon(Resource.IMG_LARGE_RED); break;
				
				case 6: img = Resource.IMG_LARGE_RED;
					this.hullShip = new ImageIcon(Resource.IMG_LARGE_RED_ARMOR); break;
				
				case 7: img = Resource.IMG_SMALL_BLUE;
					this.hullShip = new ImageIcon(Resource.IMG_SMALL_BLUE_ARMOR);
					this.nextShip = new ImageIcon(Resource.IMG_MED_BLUE); break;
				
				case 8: img = Resource.IMG_MED_BLUE;
					this.hullShip = new ImageIcon(Resource.IMG_MED_BLUE_ARMOR);
					this.nextShip = new ImageIcon(Resource.IMG_LARGE_BLUE); break;
				
				case 9: img = Resource.IMG_LARGE_BLUE;
					this.hullShip = new ImageIcon(Resource.IMG_LARGE_BLUE_ARMOR); break;
			}
		}
		
		GameState.currentShip = Toolkit.getDefaultToolkit().createImage(img.getSource());
	}
	
	public Image getCurrentShip() {
		return currentShip;
	}
	
	public ImageIcon getNextShip() {
		return this.nextShip;
	}

	public ImageIcon getHullShip() {
		return this.hullShip;
	}
	
	public void addMe(Game g) {
		game = g;
	}
	
	public Game getGame() {
		if(game == null)
			System.out.println(game);
			
		return game;
	}
	
	public void addMe(Control c) {
		con = c;
	}
	
	public void addMe(Collision c) {
		col = c;
	}
	
	public Collision getCollision() {
		return col;
	}
	
	public int getLevel() {
		return level;
	}
	
	public void setLevel(int lvl) {
		level = lvl;
	}
	
	public void LevelUp() {
		level++;
	}
	
	public int getShip() {
		return ship;
	}
	
	public void UpgradeShip() {
		ship++;
	}
	
	public void setShip(int s) {
		ship = s;
	}
	
	public int getEnemies() {
		return enemies;
	}
	
	public void IncrementEnemies() {
		enemies ++;
	}
	
	public void setEnemies(int e) {
		enemies = e;
	}
	
	public void DecrementEnemies() {
		enemies --;
		LevelOver();
	}
	
	private void LevelOver() {
		if(enemies <= 0) {
			LevelUp();
			game.scouts.clear();
			con.RunUpgrade(2);
		}
	}
	
	public void Dual() {
		dual = true;
	}
	
	public boolean getDual() {
		return dual;
	}
	
	public void DamageUp(int up) {
		damage += up;
	}
	
	public int getDamage() {
		return damage;
	}
	
	public void addLaser() {
		laser = true;
	}
	
	public boolean getLaser() {
		return laser;
	}
	
	public void addMachGun() {
		machGun = true;
	}
	
	public boolean getMachGun() {
		return machGun;
	}
	
	public void IncrementSpeed() {
		speed += 3;
	}
	
	public void setSpeed(int s) {
		speed = s;
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public void LifeUp(int up) {
		life += up;
	}
	
	public int getLife() {
		return life;
	}
	
	public void HullUp() {
		hullUp = true;
	}
	
	public void HullDown() {
		hullUp = false;
	}
	
	public boolean getHull() {
		return hullUp;
	}

	public void addStar(Star s) {
		star = s;
	}

	public Star getStar() {
		return star;
	}
}