package com.alpha.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class NestedPanel extends JPanel {
	private Border border = new LineBorder(Color.GREEN, 1);
	
	NestedPanel() {
		setBounds(0, 0, Control.width, Control.height);
		setOpaque(false);
		setBackground(Color.BLACK);
		setBorder(border);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.fillRect(3, 3, Control.width - 3, Control.height - 3);
	}
}