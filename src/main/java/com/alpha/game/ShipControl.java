package com.alpha.game;

public class ShipControl {
	private static boolean up = false;
	private static boolean down = false;
	private static boolean left = false;
	private static boolean right = false;
	public static boolean mousePressed;
	
	public static double leap;
	boolean running = true;
	
	ShipControl() {
		leap = Ship.getSpeed();
		up = false; down = false; left = false; right = false;
	}

	static void setUp(boolean b) {
		up = b;
	}
	
	static void setDown(boolean b) {
		down = b;
	}
	
	static void setLeft(boolean b) {
		left = b;
	}
	
	static void setRight(boolean b) {
		right = b;
	}
	
	public static void run() {
		double x = Ship.getX() , y = Ship.getY();
		
		if(up && y > 0) {
			Ship.setY(y - leap);
		}
		
		if(down && y < Frame.height - Ship.getHeight()) {
			Ship.setY(y + leap);
		}
		
		if(left && x > 0) {
			Ship.setX(x - leap);
		}
		
		if(right && x < Frame.width - Ship.getWidth()) {
			Ship.setX(x + leap);
		}
		
		if(mousePressed) {
			FiringMechanism.tryToFire();
		}
	}
}