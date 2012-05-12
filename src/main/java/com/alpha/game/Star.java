package com.alpha.game;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.Vector;

public class Star extends Thread {
	private Vector<Ellipse2D> elipse = new Vector<Ellipse2D>();
	private Vector<Integer> startX = new Vector<Integer>();
	private Vector<Integer> startY = new Vector<Integer>();
	private Vector<Integer> size = new Vector<Integer>();
	private Vector<Integer> dir = new Vector<Integer>();
	
	private boolean ballStarted;
	private int width, height;
	private int arraySize;
	
	private Menu menu;
	private Game game;
	private UpgradeMenu up;
	
	public Star(int w, int h) {
		width = w;
		height = h;
	}
	
	public void setDraw( Menu m) {
		menu = m;
	}
	
	public void setDraw( UpgradeMenu p) {
		up = p;
	}
	
	public void setDraw( Game g) {
		game = g;
	}
	
	public void setNumber(int s) {
		arraySize = s;
		init();
	}
	
	void init() {
		for(int i = 0; i < arraySize; i++) {
			size.addElement(1 + (int)(Math.random() * 5));
			dir.addElement(1 + (int)(Math.random() * size.elementAt(i)));
			startX.addElement((int)(Math.random() * width));
			startY.addElement((int)(Math.random() * height));
			
			elipse.addElement(new Ellipse2D.Double(startX.elementAt(i), startY.elementAt(i), size.elementAt(i), size.elementAt(i)));
		}
		ballStarted = true;
	}
	
	public void draw(Graphics2D g2d) {
		g2d.setColor(Color.WHITE);
		
		for(int i = 0; i < arraySize; i++) {	
			g2d.fill(elipse.elementAt(i));
		}
	}
	
	public void run() {
		while(ballStarted) {
			try {
				Thread.sleep(7);
           	}
			catch (InterruptedException e) {
				System.out.println("Woke up prematurely");
			}
			
			for(int i = 0; i < arraySize; i++) {
				int OldY = (int) elipse.elementAt(i).getY();
				startY.set(i, OldY + dir.elementAt(i));
				
				if (startY.elementAt(i) > height) {
					startY.set(i, 0);
					startX.set(i, (int)(Math.random() * width));
				}
			      
				elipse.elementAt(i).setFrame(startX.elementAt(i), startY.elementAt(i), size.elementAt(i), size.elementAt(i));
				
				if(menu != null) {
					menu.repaint();
				}
				
				if(game!= null) {
					game.repaint();
				}
				
				if(up != null) {
					up.repaint();
				}
			}
		}
	}
}