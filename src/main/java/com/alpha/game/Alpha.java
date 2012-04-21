package com.alpha.game;


public class Alpha
{
	@SuppressWarnings("unused")
	public static void main (String args[]) 
	{
		try {
			Resource.init();
			GameState state = new GameState();
			state.init();
			Collision col = new Collision(state);
			state.addMe(col);
			Control con = new Control(state);
		} catch(Exception e){}
		/*
		catch(AlphaResourceException are) {
			// Handle gracefully?  Try to recover?  Your call.
			throw new AlphaException(are);
		} */
	}
}