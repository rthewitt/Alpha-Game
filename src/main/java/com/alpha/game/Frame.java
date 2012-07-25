package com.alpha.game;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Frame extends JFrame {
	public static int width = 500;
	public static int height = 800;
	private JPanel currentPanel;
	
	Frame() {
		setSize(width, height);
		setVisible(true);
		setResizable(false);
		setTitle("Alpha");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GameState.frame = this;
		
		startStars();
		new Refresher();
		new Runner();
		new FiringMechanism();
		NewPanel(new Menu());
	}
	
	void startStars() {
		new Stars(width, height, 50);
	}
	
	void NewPanel(JPanel panel) {
		if(currentPanel != null)
			remove();
		add(currentPanel = panel, BorderLayout.CENTER);
	}
	
	private void remove() {
		remove(currentPanel); currentPanel = null;
		System.gc();
	}
}