package com.alpha.game;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

public class GameState extends Thread
{
	private int Level;
	private int ship = 0;
	private int speed;
	private int Enemies;
	private int Life;
	private int Damage;
	private boolean MachGun;
	private boolean Laser;
	private boolean HullUp;
	private boolean Dual;
	
	private Control con;
	private Game game;
	private Collision col;
	private Star star;
	
	// This should not be kept in Resource
	// also, cannot as it's not an object
	static Image currentShip; // Changed to static - it can't find an instance of it for some reason
	private ImageIcon hullShip;
	private ImageIcon nextShip;
	
	
	GameState()
	{
		init();
	}
	
	public void init()
	{
		Level = 1;
		Damage = 5;
		Life = 20;
		speed = 5;
		MachGun = false;
		Laser = false;
		HullUp = false;
		Dual = false;
	}
	
	public void updateShip()
	{
		BufferedImage img = null;
		if(getHull())
		{
			switch(getShip())
			{
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
		}
		else
		{
			switch(getShip())
			{
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
	
	public Image getCurrentShip()
	{
		return currentShip;
	}
	
	public ImageIcon getNextShip()
	{
		return this.nextShip;
	}

	public ImageIcon getHullShip()
	{
		return this.hullShip;
	}
	
	public void addMe(Game g)
	{
		game = g;
	}
	
	public Game getGame()
	{
		if(game == null)
			System.out.println(game);
			
		return game;
	}
	
	public void addMe(Control c)
	{
		con = c;
	}
	
	public void addMe(Collision c)
	{
		col = c;
	}
	
	public Collision getCollision()
	{
		return col;
	}
	
	public int getLevel()
	{
		return Level;
	}
	
	public void setLevel(int lvl)
	{
		Level = lvl;
	}
	
	public void LevelUp()
	{
		Level++;
	}
	
	public int getShip()
	{
		return ship;
	}
	
	public void UpgradeShip()
	{
		ship++;
	}
	
	public void setShip(int s)
	{
		ship = s;
	}
	
	public int getEnemies()
	{
		return Enemies;
	}
	
	public void IncrementEnemies()
	{
		Enemies ++;
	}
	
	public void setEnemies(int e)
	{
		Enemies = e;
	}
	
	public void DecrementEnemies()
	{
		Enemies --;
		LevelOver();
	}
	
	private void LevelOver()
	{
		if(Enemies <= 0)
		{
			LevelUp();
			game.Scouts.clear();
			con.RunUpgrade(2);
		}
	}
	
	public void Dual()
	{
		Dual = true;
	}
	
	public boolean getDual()
	{
		return Dual;
	}
	
	public void DamageUp(int up)
	{
		Damage += up;
	}
	
	public int getDamage()
	{
		return Damage;
	}
	
	public void addLaser()
	{
		Laser = true;
	}
	
	public boolean getLaser()
	{
		return Laser;
	}
	
	public void addMachGun()
	{
		MachGun = true;
	}
	
	public boolean getMachGun()
	{
		return MachGun;
	}
	
	public void IncrementSpeed()
	{
		speed += 3;
	}
	
	public void setSpeed(int s)
	{
		speed = s;
	}
	
	public int getSpeed()
	{
		return speed;
	}
	
	public void LifeUp(int up)
	{
		Life += up;
	}
	
	public int getLife()
	{
		return Life;
	}
	
	public void HullUp()
	{
		HullUp = true;
	}
	
	public void HullDown()
	{
		HullUp = false;
	}
	
	public boolean getHull()
	{
		return HullUp;
	}

	public void addStar(Star s)
	{
		star = s;
	}

	public Star getStar()
	{
		return star;
	}
}