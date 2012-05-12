package com.alpha.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Vector;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class NestedPanel extends JPanel {
	private Vector<Star> stars = new Vector<Star>();
	private int width, height;
	private Border border = new LineBorder(Color.GREEN, 1);
	
	NestedPanel(int w, int h) {
		width = w;
		height = h;
		setBounds(0, 0, width, height);
		setOpaque(false);
		setBackground(Color.BLACK);
		setBorder(border);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.fillRect(3, 3, width - 3, height - 3);
		
		for (int i = 0; i < stars.size(); i++) {
        	stars.elementAt(i).draw(g2d);
     	}
	}
}