package com.alpha.game;


public class Alpha
{
	@SuppressWarnings("unused")
	public static void main (String args[]) 
	{
		try {
			Resource.init();
			GameState stat = new GameState();
			stat.init();
			Collision col = new Collision(stat);
			stat.addMe(col);
			Control con = new Control(stat);
		} catch(Exception e){}
		/*
		catch(AlphaResourceException are) {
			// Handle gracefully?  Try to recover?  Your call.
			throw new AlphaException(are);
		} */
	}
}