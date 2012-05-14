package com.alpha.game;

import java.awt.BorderLayout;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Control extends JFrame {
	private Menu menu;
	private Game game;
	private UpgradeMenu Up;
	private int width = 500, height = 800;
	Star star;
	
	Control() {
		
		setSize(width, height);
		setVisible(true);
		setResizable(false);
		setTitle("Alpha");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GameState.con = this;
		startStars();
		
		RunMenu(0);
	}
	
	void startStars() {
		star = new Star(width, height);
		GameState.star = star;
		star.setNumber(50);
		star.start();
	}
	
	void RunMenu(int con) {
		if(con != 0) {
			nullIt(con);
		}
		menu = new Menu(width, height, this);
		add(menu, BorderLayout.CENTER);
	}
	
	void RunGame(int con) {
		if(con != 0) {
			nullIt(con);
		}
		game = new Game(width, height, this);
		add(game, BorderLayout.CENTER);
	}
	
	void RunUpgrade(int con) {
		if(con != 0) {
			nullIt(con);
		}
		Up = new UpgradeMenu(width, height, this);
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