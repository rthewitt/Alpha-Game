package com.alpha.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

public class ShipControl implements MouseListener, MouseMotionListener, KeyListener, ActionListener{
	private static boolean up = false;
	private static boolean down = false;
	private static boolean left = false;
	private static boolean right = false;
	public static boolean mousePressed;
	
	public static double leap;
	boolean running = true;

	ShipControl(JPanel game) {
		leap = Ship.getSpeed();
		up = false; down = false; left = false; right = false;
		
		game.addKeyListener(this);
		game.addMouseListener(this);
		game.addMouseMotionListener(this);
		
		Game.power1.addActionListener(this);
		Game.power2.addActionListener(this);
		Game.power3.addActionListener(this);
		Game.power4.addActionListener(this);
		Game.power5.addActionListener(this);
		Game.power6.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == Game.power1) {
			GameState.beamType = 0;
		} else if(ae.getSource() == Game.power2) {
			GameState.beamType = 1;
		} else if(ae.getSource() == Game.power3) {
			GameState.beamType = 2;
		} else if(ae.getSource() == Game.power4) {
			GameState.beamType = 3;
		} else if(ae.getSource() == Game.power5) {
			GameState.beamType = 4;
		} else if(ae.getSource() == Game.power6) {
			GameState.beamType = 5;
		}
	}

	public void keyTyped(KeyEvent e) {}

	public void keyPressed(KeyEvent ke) {
		if(GameState.pause == false)
			switch(ke.getKeyCode()) {
				case KeyEvent.VK_W: up = true; break;
				
				case KeyEvent.VK_S: down = true; break;
				
				case KeyEvent.VK_A: left = true; break;
				
				case KeyEvent.VK_D: right = true; break;
				
				case KeyEvent.VK_1: GameState.beamType = 0; break;
	        	
	        	case KeyEvent.VK_2: GameState.beamType = 1; break;
	        	
	        	case KeyEvent.VK_3: GameState.beamType = 2; break;
	        	
	        	case KeyEvent.VK_4: GameState.beamType = 3; break;
	        	
	        	case KeyEvent.VK_5: GameState.beamType = 4; break;
			}
			
		if(GameState.lastGunEnabled) {
			if(GameState.ship == 3 && ke.getKeyCode() == KeyEvent.VK_6) {
				GameState.beamType = 5;
			} else if(GameState.ship == 6 && ke.getKeyCode() == KeyEvent.VK_7) {
				GameState.beamType = 6;
			} else if(GameState.ship == 9 && ke.getKeyCode() == KeyEvent.VK_8) {
				GameState.beamType = 7;
			}
		}
	}
	
	public void keyReleased(KeyEvent ke) {
		switch(ke.getKeyCode()) {
		case KeyEvent.VK_W: up = false; break;
		
		case KeyEvent.VK_S: down = false; break;
		
		case KeyEvent.VK_A: left = false; break;
		
		case KeyEvent.VK_D: right = false; break;
		}
	}

	public void mouseDragged(MouseEvent e) {}

	public void mouseMoved(MouseEvent e) {}

	public void mouseClicked(MouseEvent e) {}

	public void mousePressed(MouseEvent e) {
		mousePressed = true;
	}
		
	public void mouseReleased(MouseEvent e) {
		mousePressed = false;
	}
	
	public void mouseExited(MouseEvent e) {
		GameState.pause = true;
	}
	
	public void mouseEntered(MouseEvent e) {
		GameState.pause = false;
	}
	
	public static void update() {
		double x = Ship.getX() , y = Ship.getY();
		
		if(up && y > 0) {
			Ship.setY(y - leap);
		}
		
		if(down && y < Frame.height - Ship.getHeight()) {
			Ship.setY(y + leap);
		}
		
		if(left && x > 0) {
			Ship.setX(x - leap);
		}
		
		if(right && x < Frame.width - Ship.getWidth()) {
			Ship.setX(x + leap);
		}
		
		if(mousePressed) {
			FiringMechanism.tryToFire();
		}
	}
}
