package com.alpha.game;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class MenuItem extends JButton {
	
	BorderLayout buttonLayout = new BorderLayout();
	private String name;
	private String desc;
	private int cost;
	
	MenuItem(NestedPanel np, UpgradeMenu um, String n, BufferedImage bi, int c, String d) {
		setLayout(buttonLayout);
		LF.Button(this);
		setPreferredSize(new Dimension(UpgradeMenu.panelWidth - 20, 50));
		setMinimumSize(getPreferredSize());
		setText(n);
		name = n;
		cost = c;
		desc = d;
		np.add(this);
		this.addActionListener(um);
		
		try {
			setIcon(new ImageIcon(bi));
		} catch(NullPointerException e) {}
	}
	
	public String getName() {
		return name;
	}
	
	public String getDesc() {
		return desc;
	}
	
	public int getCost() {
		return cost;
	}
}