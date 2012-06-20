package com.alpha.game;

import java.awt.BorderLayout;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Frame extends JFrame {
	private Menu menu;
	private Game game;
	private UpgradeMenu Up;
	public static int width = 500;
	public static int height = 800;
	Star star;
	
	Frame() {
		
		setSize(width, height);
		setVisible(true);
		setResizable(false);
		setTitle("Alpha");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Statics.frame = this;
		startStars();
		
		new EnemyRunner();
		new BeamRunner();
		new ShipRunner();
		
		RunMenu(0);
	}
	
	void startStars() {
		star = new Star(width, height);
		Statics.star = star;
		star.setNumber(50);
		star.start();
	}
	
	void RunMenu(int con) {
		if(con != 0) {
			nullIt(con);
		}
		menu = new Menu();
		add(menu, BorderLayout.CENTER);
	}
	
	void RunGame(int con) {
		if(con != 0) {
			nullIt(con);
		}
		game = new Game();
		add(game, BorderLayout.CENTER);
	}
	
	void RunUpgrade(int con) {
		if(con != 0) {
			nullIt(con);
		}
		Up = new UpgradeMenu();
		add(Up, BorderLayout.CENTER);
	}
	
	void nullIt(int con) {
		switch(con) {
			case 1: remove(menu); menu = null; break;
			
			case 2: remove(game); game = null; break;
			
			case 3: remove(Up); Up = null; break;
		}
		System.gc();
	}
}