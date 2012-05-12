package com.alpha.game;

import com.alpha.error.AlphaException;
import com.alpha.error.AlphaResourceException;

public class Alpha {
	public static void main (String args[]) throws AlphaException {
		try {
			Resource.init();
			GameState state = new GameState();
			Collision col = new Collision();
			state.addMe(col);
			new Control(state);
		}
		catch(AlphaResourceException are) {
			throw new AlphaException(are);
		}
	}
}