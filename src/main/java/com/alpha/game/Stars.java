package com.alpha.game;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Vector;

public class Stars extends Thread {
	private static Vector<Star> stars = new Vector<Star>();
	static Star s;
	
	private int width, height;
	private int arraySize;
	
	public Stars(int w, int h) {
		width = w;
		height = h;
		start();
	}
	
	private class Star {
		int x, y;
		int size;
		int dir;
	}
	
	public void setNumber(int s) {
		arraySize = s;
		init();
	}
	
	void init() {
		Star s;
		for(int i = 0; i < arraySize; i++) {
			s = new Star();
			s.x = (int)(Math.random() * width);
			s.y = (int)(Math.random() * height);
			s.size = 1 + (int)(Math.random() * 5);
			s.dir = 1 + (int)(Math.random() * s.size);
			stars.addElement(s);
		}
	}
	
	public static void draw(Graphics2D g2d) {
		g2d.setColor(Color.WHITE);
		for(int i = 0; i < stars.size(); i++) {
			s = stars.elementAt(i);
			g2d.fillOval(s.x, s.y, s.size, s.size);
		}
	}
	
	public void run() {
		while(true) {
			try {
				Thread.sleep(7);
           	}
			catch (InterruptedException e) {
				System.out.println("Woke up prematurely");
			}
			
			for(int i = 0; i < stars.size(); i++) {
				s = stars.elementAt(i);
				s.y += s.dir;
				
				if (s.y > height) {
					s.y = 0;
					s.x = (int)(Math.random() * width);
				}
			}
		}
	}
}