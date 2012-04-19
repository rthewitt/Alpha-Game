package com.alpha.game;
import java.util.Vector;

public class Collision extends Thread
{
	private Vector<Enemy> ships = new Vector<Enemy>();
	
	private int X = 0;
	private int Y = 0;
	@SuppressWarnings("unused")
	private GameState state;
	@SuppressWarnings("unused")
	private Beam beam;
	
	Collision(GameState s)
	{
		state = s;
	}
	
	public void addShip(Enemy s)
	{
		ships.addElement(s);
	}
	
	public void TestBeam(Beam b)
	{
		beam = b;
		X = b.getX();
		Y = b.getY();
		run();
	}
	
	public void run()
	{
		boolean found = false;
		
		for(int i = 0; i < ships.size() && found == false; i++)
		{
			int ShipX = ships.elementAt(i).getX();
			int ShipY = ships.elementAt(i).getY();
			
			if(Y >= (ShipY - 30) && Y <= ShipY)
			{
				
			}
			else
			{
				continue;
			}
			
			if(X >= ShipX && X <= (ShipX + 30))
			{
				ships.elementAt(i).kill();
				ships.remove(i);
				found = true;
			}
		}
	}
}