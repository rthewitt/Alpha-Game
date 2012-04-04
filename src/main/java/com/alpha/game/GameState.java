package com.alpha.game;

public class GameState
{
	private int Level;
	private int ShipUp;
	private int Speed;
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
	
	
	GameState()
	{
	}
	
	public void init()
	{
		Level = 1;
		ShipUp = 1;
		Damage = 5;
		Life = 20;
		Speed = 5;
		MachGun = false;
		Laser = false;
		HullUp = false;
		Dual = false;
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
	
	public int getShipUp()
	{
		return ShipUp;
	}
	
	public void UpgradeShip()
	{
		ShipUp++;
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
		Speed += 3;
	}
	
	public int getSpeed()
	{
		return Speed;
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
	
	public boolean getHull()
	{
		return HullUp;
	}
}