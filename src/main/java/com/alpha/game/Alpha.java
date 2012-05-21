package com.alpha.game;

import com.alpha.error.AlphaException;
import com.alpha.error.AlphaResourceException;

public class Alpha {
	public static void main (String args[]) throws AlphaException {
		try {
			Resource.init();
			new Control();
		}
		catch(AlphaResourceException are) {
			throw new AlphaException(are);
		}
	}
}