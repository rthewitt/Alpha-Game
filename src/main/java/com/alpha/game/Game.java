package com.alpha.game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Panel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Game extends JPanel implements KeyListener {
	private Vector<Ship> ships = new Vector<Ship>();
	Vector<Enemy> scouts = new Vector<Enemy>(0, 0);
	BeamElement beams = new BeamElement();
	
	Go go;
	Panel draw;
	
	public Game() {
		setSize(Control.width, Control.height);
		
		GameState.game = this;
		
		GameState.star.setDraw(this);
		
		go = new Go();
		
		Ship newShip = new Ship();
		ships.addElement(newShip);
		newShip.start();
		
		GameState.updateShip();
		
		setVisible(true);
		addKeyListener(this);
		setBackground(Color.BLACK);
		
		beams.start();
		
		addMouseListener(
			new MouseAdapter() {
	 	  		public void mouseClicked(MouseEvent e) {
	 	  			beams.newBeam();
				}
			}
		);
		
		if(GameState.useWantedLevel) {
			new Levels(GameState.wantedLevel);
		}else {
			new Levels(GameState.level);
		}
	}
	
	public void keyPressed(KeyEvent ke) {
		switch(ke.getKeyCode()) {
			case KeyEvent.VK_W: go.setUp(true); break;
			
			case KeyEvent.VK_S: go.setDown(true); break;
			
			case KeyEvent.VK_A: go.setLeft(true); break;
			
			case KeyEvent.VK_D: go.setRight(true); break;
		}
	}
	
	public void keyReleased(KeyEvent ke) {
		switch(ke.getKeyCode()) {
			case KeyEvent.VK_W: go.setUp(false); break;
			
			case KeyEvent.VK_S: go.setDown(false); break;
			
			case KeyEvent.VK_A: go.setLeft(false); break;
			
			case KeyEvent.VK_D: go.setRight(false); break;
		}
	}
	
	public void keyTyped(KeyEvent ke) {}
	
	public Dimension getPreferredSize() {
      return new Dimension(Control.width, Control.height);
	}
	
	public void paintComponent (Graphics g) {
     	super.paintComponent(g);
     	Graphics2D g2d = (Graphics2D) g;
     	
     	GameState.star.draw(g2d);
     	
     	beams.draw(g2d);
		
		for (int i = 0; i < scouts.size(); i++) {
        	scouts.elementAt(i).draw(g2d);
     	}
        
		for (int i = 0; i < ships.size(); i++) {
        	ships.elementAt(i).draw(g2d);
     	}
		
		requestFocus();
	}
}