package com.alpha.game;

import java.awt.BorderLayout;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Control extends JFrame
{
	private Menu Menu;
	private Game game;
	private UpgradeMenu Up;
	private GameState state;
	private int width = 500, height = 800;
	Star star;
	
	Control(GameState s)
	{
		state = s;
		
		setSize(width, height);
		setVisible(true);
		setResizable(false);
		setTitle("Alpha");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		state.addMe(this);
		startStars();
		
		RunMenu(0);
	}
	
	void startStars()
	{
		star = new Star(width, height);
		state.addStar(star);
		star.setNumber(50);
		star.start();
	}
	
	void RunMenu(int con)
	{
		if(con != 0)
		{
			nullIt(con);
		}
		Menu = new Menu(width, height, this, state);
		add(Menu, BorderLayout.CENTER);
	}
	
	void RunGame(int con)
	{
		if(con != 0)
		{
			nullIt(con);
		}
		game = new Game(width, height, this, state);
		add(game, BorderLayout.CENTER);
	}
	
	void RunUpgrade(int con)
	{
		if(con != 0)
		{
			nullIt(con);
		}
		Up = new UpgradeMenu(width, height, this, state);
		add(Up, BorderLayout.CENTER);
	}
	
	void nullIt(int con)
	{
		switch(con)
		{
			case 1: remove(Menu); Menu = null; break;
			
			case 2: remove(game); game = null; break;
			
			case 3: remove(Up); Up = null; break;
		}
		System.gc();
	}
}