package com.alpha.game;

import javax.swing.JPanel;

public class Refresher{
	
	private static JPanel panel;
	
	static void setDraw(JPanel p) {
		panel = p;
	}
	
	public static void run() {
		try {
			panel.repaint();
		} catch(NullPointerException e) {}
	}
}
