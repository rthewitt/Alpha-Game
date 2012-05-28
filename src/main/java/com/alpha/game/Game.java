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
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

@SuppressWarnings("serial")
public class Game extends JPanel implements KeyListener, ActionListener {
	private Vector<Ship> ships = new Vector<Ship>();
	static Vector<Enemy> enemies = new Vector<Enemy>();
	BeamElement beams = new BeamElement();
	static boolean cooldown = true;
	static Timer timer = new Timer();
	BorderLayout buttonLayout = new BorderLayout();
	LandF LF = new LandF();
	
	JButton power1 = new JButton();
	JButton power2 = new JButton();
	JButton power3 = new JButton();
	JButton power4 = new JButton();
	JButton power5 = new JButton();
	JButton power6 = new JButton();
	
	Go go;
	Panel draw;
	
	public Game() {
		setSize(Control.width, Control.height);
		setLayout(null);
		
		GameState.game = this;
		GameState.star.setDraw(this);
		
		go = new Go();
		timer = new Timer();
		
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
	 	  		public void mousePressed(MouseEvent e) {
	 	  			if(cooldown)
	 	  				timer.schedule(new BeamTask(), 0, 500);
	 	  			cooldown = false;
				}
	 	  		
	 	  		public void mouseReleased(MouseEvent e) {
	 	  			timer.cancel();
	 	  			timer = new Timer();
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
			new Levels(GameState.wantedLevel);
		}else {
			new Levels(GameState.level);
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
		setKeys();
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
		power1.setBounds(12, Control.height - Offset, dia, dia);
		power2.setBounds(94, Control.height - Offset, dia, dia);
		power3.setBounds(176, Control.height - Offset, dia, dia);
		power4.setBounds(258, Control.height - Offset, dia, dia);
		power5.setBounds(340, Control.height - Offset, dia, dia);
		power6.setBounds(422, Control.height - Offset, dia, dia);
	}
	
	private void setIcon() {
		power1.setIcon(new ImageIcon(Resource.IMG_BOLT));
		power2.setIcon(new ImageIcon(Resource.IMG_DUAL_LASER));
		power3.setIcon(new ImageIcon(Resource.IMG_PEN));
		power4.setIcon(new ImageIcon(Resource.IMG_EXPLODING));
		power5.setIcon(new ImageIcon(Resource.IMG_LASER));
		
		if(GameState.lastGunEnabled) {
			if(GameState.ship == 3) {
				power6.setIcon(new ImageIcon(Resource.IMG_RAPID_LASER));
			} else if(GameState.ship == 6) {
				power6.setIcon(new ImageIcon(Resource.IMG_RAPID_LASER));
			} else if(GameState.ship == 9) {
				power6.setIcon(new ImageIcon(Resource.IMG_RAPID_LASER));
			}
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
		power2.setEnabled(true);
		power3.setEnabled(true);
		power4.setEnabled(true);
		power5.setEnabled(true);
		
		if(GameState.ship == 3 || GameState.ship == 6 || GameState.ship == 9 && GameState.lastGunEnabled) {
			power6.setEnabled(true);
			power6.setBackground(Color.GREEN);
			power6.setVisible(true);
		} else {
			power6.setEnabled(false);
			power6.setBackground(Color.BLACK);
			power6.setVisible(false);
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
	
	public void setKeys() {
		power1.getInputMap().put(KeyStroke.getKeyStroke("1"), "doSomething");
	}
	
	private class BeamTask extends TimerTask {
		public void run() {
			beams.newBeam();
			cooldown = true;
			GameState.shotsFired ++;
		}
	}
	
	public void keyPressed(KeyEvent ke) {
		switch(ke.getKeyCode()) {
			case KeyEvent.VK_W: go.setUp(true); break;
			
			case KeyEvent.VK_S: go.setDown(true); break;
			
			case KeyEvent.VK_A: go.setLeft(true); break;
			
			case KeyEvent.VK_D: go.setRight(true); break;
			
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
			case KeyEvent.VK_W: go.setUp(false); break;
			
			case KeyEvent.VK_S: go.setDown(false); break;
			
			case KeyEvent.VK_A: go.setLeft(false); break;
			
			case KeyEvent.VK_D: go.setRight(false); break;
		}
	}
	
	public void keyTyped(KeyEvent e) { }
	
	public Dimension getPreferredSize() {
      return new Dimension(Control.width, Control.height);
	}
	
	public void paintComponent (Graphics g) {
     	super.paintComponent(g);
     	Graphics2D g2d = (Graphics2D) g;
     	
     	GameState.star.draw(g2d);
     	
     	beams.draw(g2d);
		
		for (int i = 0; i < enemies.size(); i++) {
        	enemies.elementAt(i).draw(g2d);
     	}
        
		for (int i = 0; i < ships.size(); i++) {
        	ships.elementAt(i).draw(g2d);
     	}
		
		requestFocus();
	}
}