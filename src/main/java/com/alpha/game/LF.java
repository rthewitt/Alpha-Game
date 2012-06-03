package com.alpha.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class LF {
	static Border green = new LineBorder(Color.GREEN, 1);
	static Border black = new LineBorder(Color.GRAY, 1);
	
	LF() {}
	
	static void Button(JButton jb) {
		jb.setOpaque(false);
		jb.setContentAreaFilled(false);
		jb.setBorder(green);
		jb.setForeground(Color.GREEN);
		jb.setFont(new Font("sansserif",Font.PLAIN,20));
	}
	
	static void Panel(JPanel p) {
		p.setBackground(Color.BLACK);
		p.setBorder(green);
		p.setForeground(Color.GREEN);
		p.setFont(new Font("sansserif", Font.PLAIN, 20));
	}
	
	static void ToolBar(JToolBar tb) {
		tb.setOpaque(false);
		tb.setBorder(green);
		tb.setForeground(Color.GREEN);
		tb.setLayout(new GridLayout());
	}
	
	static void Scroll(JScrollPane sp) {
		sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		sp.getVerticalScrollBar().setBackground(Color.BLACK);
		sp.getVerticalScrollBar().setForeground(Color.GREEN);
	}
	
	static void TabbedPane(JTabbedPane tp) {
		tp.setOpaque(false);
		tp.setBorder(green);
		tp.setBackground(Color.BLACK);
		tp.setForeground(Color.GREEN);
	}
	
	static void setBlack(JButton b) {
		b.setBorder(black);
	}
	
	static void setGreen(JButton b) {
		b.setBorder(green);
	}
}