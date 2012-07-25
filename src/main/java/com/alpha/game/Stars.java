package com.alpha.game;

import java.awt.Color;
import java.awt.Graphics2D;

public class Stars {
	static Star s;
	private static int width;
	private static int height;
	private int arraySize;
	private static Star[] starArray;
	
	public Stars(int w, int h, int number) {
		width = w;
		height = h;
		arraySize = number;
		init();
	}
	
	private class Star {
		int x, y;
		int size;
		int dir;
	}
	
	void init() {
		starArray = new Star[arraySize];
		for(int i = 0; i < 50; i ++) {
			s = new Star();
			s.x = (int)(Math.random() * width);
			s.y = (int)(Math.random() * height);
			s.size = 1 + (int)(Math.random() * 5);
			s.dir = 1 + (int)(Math.random() * s.size);
			starArray[i] = s;
		}
	}
	
	public static void draw(Graphics2D g2d) {
		g2d.setColor(Color.WHITE);
		for(Star s : starArray) {
			g2d.fillOval(s.x, s.y, s.size, s.size);
		}
	}
	
	public static void update() {		
		for(Star s : starArray) {
			s.y += s.dir;
			
			if (s.y > height) {
				s.y = 0;
				s.x = (int)(Math.random() * width);
			}
		}
	}
}