package com.alpha.game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import com.alpha.game.ships.ShipEntity;

@SuppressWarnings("serial")
public class Game extends JPanel implements KeyListener, ActionListener {
	BorderLayout buttonLayout = new BorderLayout();
	
	JButton power1 = new JButton();
	JButton power2 = new JButton();
	JButton power3 = new JButton();
	JButton power4 = new JButton();
	JButton power5 = new JButton();
	JButton power6 = new JButton();
	
	Panel draw;
	
	public Game() {
		setSize(Frame.width, Frame.height);
		setLayout(null);
		
		Refresher.setDraw(this);
		
		MovableEntity.ships.clear();
		Factory.newShip(GameState.ship);
		new ShipControl();
		
		setVisible(true);
		addKeyListener(this);
		setBackground(Color.BLACK);
		
		addMouseListener(
			new MouseAdapter() {
	 	  		public void mousePressed(MouseEvent e) {
	 	  			ShipControl.mousePressed = true;
				}
	 	  		
	 	  		public void mouseReleased(MouseEvent e) {
	 	  			ShipControl.mousePressed = false;
	 	  		}
	 	  		
	 	  		public void mouseExited(MouseEvent e) {
	 	  			GameState.pause = true;
	 	  		}
	 	  		
	 	  		public void mouseEntered(MouseEvent e) {
	 	  			GameState.pause = false;
	 	  		}
			}
		);
		
		if(GameState.useWantedLevel) {
			Factory.newNormalLevel(GameState.wantedLevel);
		}else {
			Factory.newNormalLevel(GameState.level);
		}
		setup();
	}

	public void setup() {
		setLayout();
		setSize();
		setBounds();
		setIcon();
		setLandF();
		setListener();
		setEnabled();
		add();
	}
	
	private void setLayout() {
		power1.setLayout(buttonLayout);
		power2.setLayout(buttonLayout);
		power3.setLayout(buttonLayout);
		power4.setLayout(buttonLayout);
		power5.setLayout(buttonLayout);
		power6.setLayout(buttonLayout);
	}
	
	private void setSize() {
		int dia = 50;
		power1.setPreferredSize(new Dimension(dia, dia)); power1.setMinimumSize(power1.getPreferredSize());
		power2.setPreferredSize(new Dimension(dia, dia)); power2.setMinimumSize(power2.getPreferredSize());
		power3.setPreferredSize(new Dimension(dia, dia)); power3.setMinimumSize(power3.getPreferredSize());
		power4.setPreferredSize(new Dimension(dia, dia)); power4.setMinimumSize(power4.getPreferredSize());
		power5.setPreferredSize(new Dimension(dia, dia)); power5.setMinimumSize(power5.getPreferredSize());
		power6.setPreferredSize(new Dimension(dia, dia)); power6.setMinimumSize(power6.getPreferredSize());
	}
	
	private void setBounds() {
		int Offset = 110;
		int dia = 50;
		power1.setBounds(12, Frame.height - Offset, dia, dia);
		power2.setBounds(94, Frame.height - Offset, dia, dia);
		power3.setBounds(176, Frame.height - Offset, dia, dia);
		power4.setBounds(258, Frame.height - Offset, dia, dia);
		power5.setBounds(340, Frame.height - Offset, dia, dia);
		power6.setBounds(422, Frame.height - Offset, dia, dia);
	}
	
	private void setIcon() {
		power1.setIcon(new ImageIcon(Resource.IMG_BOLT));
		power2.setIcon(new ImageIcon(Resource.IMG_DUAL_LASER));
		power3.setIcon(new ImageIcon(Resource.IMG_PIERCE_LASER));
		power4.setIcon(new ImageIcon(Resource.IMG_EXPLOSIVE_LASER));
		power5.setIcon(new ImageIcon(Resource.IMG_LASER));
		
		if(GameState.ship <= 3) {
			power6.setIcon(new ImageIcon(Resource.IMG_WAVE_LASER));
		} else if(GameState.ship <= 6) {
			power6.setIcon(new ImageIcon(Resource.IMG_SPREAD_LASER));
		} else if(GameState.ship <= 9) {
			power6.setIcon(new ImageIcon(Resource.IMG_RAPID_LASER));
		}
	}
	
	private void setLandF() {
		LF.Button(power1);
		LF.Button(power2);
		LF.Button(power3);
		LF.Button(power4);
		LF.Button(power5);
		LF.Button(power6);
	}
	
	private void setListener() {
		power1.addActionListener(this);
		power2.addActionListener(this);
		power3.addActionListener(this);
		power4.addActionListener(this);
		power5.addActionListener(this);
		power6.addActionListener(this);
	}
	
	private void setEnabled() {
		power1.setEnabled(true);
		
		if(GameState.dualEnabled) {
			power2.setEnabled(true);
			LF.setGreen(power2);
		} else {
			power2.setEnabled(false);
			LF.setBlack(power2);
		}
		
		if(GameState.damageEnabled) {
			power3.setEnabled(true);
			LF.setGreen(power3);
		} else {
			power3.setEnabled(false);
			LF.setBlack(power3);
		}
		
		if(GameState.machGunEnabled) {
			power4.setEnabled(true);
			LF.setGreen(power4);
		} else {
			power4.setEnabled(false);
			LF.setBlack(power4);
		}
		
		if(GameState.laserEnabled) {
			power5.setEnabled(true);
			LF.setGreen(power5);
		} else {
			power5.setEnabled(false);
			LF.setBlack(power5);
		}
		
		if(GameState.ship == 3 || GameState.ship == 6 || GameState.ship == 9 && GameState.lastGunEnabled) {
			power6.setEnabled(true);
			LF.setGreen(power6);
		} else {
			power6.setEnabled(false);
			LF.setBlack(power6);
		}
	}
	
	private void add() {
		add(power1);
		add(power2);
		add(power3);
		add(power4);
		add(power5);
		add(power6);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == power1) {
			GameState.beamType = 0;
		} else if(ae.getSource() == power2) {
			GameState.beamType = 1;
		} else if(ae.getSource() == power3) {
			GameState.beamType = 2;
		} else if(ae.getSource() == power4) {
			GameState.beamType = 3;
		} else if(ae.getSource() == power5) {
			GameState.beamType = 4;
		} else if(ae.getSource() == power6) {
			GameState.beamType = 5;
		}
	}
	
	public void keyPressed(KeyEvent ke) {
		if(GameState.pause == false)
		switch(ke.getKeyCode()) {
			case KeyEvent.VK_W: ShipControl.setUp(true); break;
			
			case KeyEvent.VK_S: ShipControl.setDown(true); break;
			
			case KeyEvent.VK_A: ShipControl.setLeft(true); break;
			
			case KeyEvent.VK_D: ShipControl.setRight(true); break;
			
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
			case KeyEvent.VK_W: ShipControl.setUp(false); break;
			
			case KeyEvent.VK_S: ShipControl.setDown(false); break;
			
			case KeyEvent.VK_A: ShipControl.setLeft(false); break;
			
			case KeyEvent.VK_D: ShipControl.setRight(false); break;
		}
	}
	
	public void keyTyped(KeyEvent e) { }
	
	public Dimension getPreferredSize() {
      return new Dimension(Frame.width, Frame.height);
	}
	
	public void paintComponent (Graphics g) {
     	super.paintComponent(g);
     	Graphics2D g2d = (Graphics2D) g;
     	
     	g2d.setColor(Color.RED);
     	g2d.fillRoundRect(10, 673, 475, 10, 3, 3);
     	g2d.setColor(Color.GREEN);
     	g2d.fillRoundRect(10, 673, (int)(ShipEntity.currentShip.percentLeft() * 475), 10, 3, 3);
     	
     	GameState.g2d = g2d;
     	EnemyRunner.draw();
     	BeamRunner.draw();
     	ShipRunner.draw();
     	Stars.draw(g2d);
		
		requestFocus();
	}
}