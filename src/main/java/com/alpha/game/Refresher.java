package com.alpha.game;

import javax.swing.JPanel;

public class Refresher extends Thread {
	
	private static JPanel panel;
	
	Refresher() {
		start();
	}
	
	static void setDraw(JPanel p) {
		panel = p;
	}
	
	public void run() {
		while(true) {
			try {
				panel.repaint();
			} catch(NullPointerException e) {}
		}
	}
}
