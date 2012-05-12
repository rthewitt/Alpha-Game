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
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Game extends JPanel implements KeyListener, MouseListener {
	private int width, height;
	Vector<Beam> beams = new Vector<Beam>(0, 0);
	private Vector<Ship> ships = new Vector<Ship>();
	Vector<Enemy> scouts = new Vector<Enemy>(0, 0);
	private int check = 0, clicks = 0;
	int locX = 250, locY = 700;
	
	private boolean pressed = false;
	Star star;
	Go go;
	
	Panel draw;
	private GameState state;
	@SuppressWarnings("unused")
	private Levels lvl;
	
	public Game(int pwid, int pht, Control con, GameState s) {
		state = s;
		state.addMe(this);
		state.getSpeed();
		star = state.getStar();
		star.setDraw(this);
		width = pwid;
		height = pht;
		setSize(width, height);
		
		go = new Go(state);
		
		setVisible(true);
		addKeyListener(this);
		
		setBackground(Color.BLACK);
		state.updateShip();
		Ship newShip = new Ship(this, state.getShip(), state.getHull());
		ships.addElement(newShip);
		newShip.start();
		
		addMouseListener(
			new MouseAdapter() {
	 	  		public void mouseClicked(MouseEvent e) {
	 	  			clicks ++;
					
					Clicked();
				}
			}
		);
		
		lvl = new Levels(state, state.getLevel());
	}
	
	public Vector<Beam> getVector1() {
		return beams;
	}
	
	public Vector<Enemy> getVector2() {
		return scouts;
	}
	
	public void Clicked() {
		if(clicks < 6) {
			if(state.getDual()) {
				Beam newBeam = new Beam(getLocX() - 15, getLocY(), this, state);
				beams.addElement(newBeam);
				newBeam.setSpeed(3);
				
			
				Beam newBeam1 = new Beam(getLocX() + 15, getLocY(), this, state);
				beams.addElement(newBeam1);
				newBeam1.setSpeed(3);
				
				newBeam.start();
				newBeam1.start();
			}else {
				Beam newBeam = new Beam(getLocX() - 3, getLocY(), this, state);
				beams.addElement(newBeam);
				newBeam.setSpeed(3);
				newBeam.start();
			}
		}else {
			if(check >= 5) {
				clicks = 0;
				check = 0;
				
				beams = null;
				beams = new Vector<Beam>(0, 0);
			}
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
	
	public void mouseExited(MouseEvent me) {}
	public void mouseEntered(MouseEvent me) {}
	public void mouseReleased(MouseEvent me) {pressed = false;}
	public void mouseClicked(MouseEvent me) {}
	
	public void mousePressed(MouseEvent me) {
		pressed = true;
		if(state.getMachGun()) {
			while(pressed) {
				Beam newBeam = new Beam(getLocX() - 3, getLocY(), this, state);
				beams.addElement(newBeam);
				newBeam.start();
			}
		}
	}
	
	public void setLocX(int x) {
		locX = x;
	}
	
	public void setLocY(int y) {
		locY = y;
	}
	
	public int getScreenWidth() {
		return width;
	}
	
	public int getScreenHeight() {
		return height;
	}
	
	public int getLocX() {
		return locX;
	}
	
	public int getLocY() {
		return locY;
	}
	
	public void IncrementChecks() {
		check ++;
	}
	
	public Dimension getPreferredSize() {
      return new Dimension(width, height);
	}
	
	public void paintComponent (Graphics g) {
     	super.paintComponent(g);
     	Graphics2D g2d = (Graphics2D) g;
		
		for (int i = 0; i < beams.size(); i++) {
        	beams.elementAt(i).draw(g2d);
     	}
		
		for (int i = 0; i < scouts.size(); i++) {
        	scouts.elementAt(i).draw(g2d);
     	}
		
        star.draw(g2d);
        
		for (int i = 0; i < ships.size(); i++) {
        	ships.elementAt(i).draw(g2d);
     	}
		
		requestFocus();
	}
}