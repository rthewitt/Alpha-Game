package com.alpha.game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import com.alpha.game.ships.ShipEntity;

@SuppressWarnings("serial")
public class UpgradeMenu extends JPanel implements ActionListener {
	private Frame frame;
	private int panelWidth = 0, panelHeight = 0; 
	
	private GridLayout panelLayout = new GridLayout(0,1);
	BorderLayout buttonLayout = new BorderLayout();
	DecimalFormat df = new DecimalFormat("#.##");
	
	JLabel label = new JLabel();
	
	private JTabbedPane Bar = new JTabbedPane();
	
	JButton done = new JButton("Next Level");
	
	//Ship Upgrades
	JButton damage = new JButton("+1 DAMAGE");
	JButton life = new JButton("LIFE UP");
	JButton speed = new JButton("SPEED UP");
	JButton hull = new JButton("HULL UP");
	JButton shipUp = new JButton("UPGRADE SHIP");
	JButton RofUp = new JButton("FIRING SPEED");
	
	//gun buttons
	JButton dual = new JButton("DUAL GUN");
	JButton machgun = new JButton("MACH GUN");
	JButton pierce = new JButton("PIERCE GUN");
	JButton explosive = new JButton("EXPLOSIVE GUN");
	JButton laser = new JButton("LASER GUN");
	JButton wave = new JButton("WAVE GUN");
	JButton shotgun = new JButton("SHOT-GUN");
	
	//Bonus Buttons
	JButton bulletSpeed = new JButton("BULLET SPEED");
	
	JButton replay = new JButton("REPLAY");
	JButton minus = new JButton("-");
	JButton plus = new JButton("+");
	
	NestedPanel np1 = new NestedPanel();
	NestedPanel np2 = new NestedPanel();
	NestedPanel np3 = new NestedPanel();
	JScrollPane scroll = new JScrollPane(np1);
	JScrollPane scroll2 = new JScrollPane(np2);
	JScrollPane scroll3 = new JScrollPane(np3);
	
	UpgradeMenu() {
		frame = GameState.frame;
		panelWidth = Frame.width - 7;
		panelHeight = Frame.height - 31;
		setVisible(true);
		
		Refresher.setDraw(this);
		
		setBackground(Color.BLACK);
		LF.TabbedPane(Bar);
		
		setLayout(null);
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
		scroll.setWheelScrollingEnabled(true);
	}
	
	private void setLayout() {
		panelLayout.setVgap(1);
		dual.setLayout(buttonLayout);
		machgun.setLayout(buttonLayout);
		pierce.setLayout(buttonLayout);
		explosive.setLayout(buttonLayout);
		shotgun.setLayout(buttonLayout);
		wave.setLayout(buttonLayout);
		damage.setLayout(buttonLayout);
		life.setLayout(buttonLayout);
		laser.setLayout(buttonLayout);
		speed.setLayout(buttonLayout);
		hull.setLayout(buttonLayout);
		shipUp.setLayout(buttonLayout);
		bulletSpeed.setLayout(buttonLayout);
		np1.setLayout(panelLayout);
		np2.setLayout(panelLayout);
		np3.setLayout(panelLayout);
	}
	
	private void setSize() {
		dual.setPreferredSize(new Dimension(panelWidth - 20, 50)); dual.setMinimumSize(dual.getPreferredSize());
		pierce.setPreferredSize(new Dimension(panelWidth - 20, 50)); dual.setMinimumSize(dual.getPreferredSize());
		explosive.setPreferredSize(new Dimension(panelWidth - 20, 50)); dual.setMinimumSize(dual.getPreferredSize());
		shotgun.setPreferredSize(new Dimension(panelWidth - 20, 50)); dual.setMinimumSize(dual.getPreferredSize());
		wave.setPreferredSize(new Dimension(panelWidth - 20, 50)); dual.setMinimumSize(dual.getPreferredSize());
		damage.setPreferredSize(new Dimension(panelWidth - 20, 50)); damage.setMinimumSize(damage.getPreferredSize());
		laser.setPreferredSize(new Dimension(panelWidth - 20, 50)); laser.setMinimumSize(laser.getPreferredSize());
		machgun.setPreferredSize(new Dimension(panelWidth - 20, 50)); machgun.setMinimumSize(machgun.getPreferredSize());
		life.setPreferredSize(new Dimension(panelWidth - 20, 50)); life.setMinimumSize(life.getPreferredSize());
		speed.setPreferredSize(new Dimension(panelWidth - 20, 50)); speed.setMinimumSize(speed.getPreferredSize());
		hull.setPreferredSize(new Dimension(panelWidth - 20, 50)); hull.setMinimumSize(hull.getPreferredSize());
		shipUp.setPreferredSize(new Dimension(panelWidth - 20, 50)); shipUp.setMinimumSize(shipUp.getPreferredSize());
		bulletSpeed.setPreferredSize(new Dimension(panelWidth - 20, 50)); bulletSpeed.setMinimumSize(bulletSpeed.getPreferredSize());
	}
	
	private void setBounds() {
		setBounds(0, 0, panelWidth, panelHeight);
		Bar.setBounds(0, 120, 495, 200);
		done.setBounds(panelWidth/2, panelHeight - 40, panelWidth/2, 30);
		minus.setBounds(panelWidth/2 + 100, panelHeight - 70, 50, 30);
		plus.setBounds(panelWidth - 50, panelHeight - 70, 50, 30);
		replay.setBounds(panelWidth/2, panelHeight - 70, 100, 30);
		label.setBounds(50 - ShipEntity.currentShip.getWidth()/2, 50 - ShipEntity.currentShip.getHeight()/2, ShipEntity.currentShip.getWidth(), ShipEntity.currentShip.getHeight());
	}
	
	private void setIcon() {
		dual.setIcon(new ImageIcon(Resource.IMG_DUAL_LASER));
		pierce.setIcon(new ImageIcon(Resource.IMG_PIERCE_LASER));
		explosive.setIcon(new ImageIcon(Resource.IMG_EXPLOSIVE_LASER));
		machgun.setIcon(new ImageIcon(Resource.IMG_RAPID_LASER));
		shotgun.setIcon(new ImageIcon(Resource.IMG_SPREAD_LASER));
		wave.setIcon(new ImageIcon(Resource.IMG_WAVE_LASER));
		damage.setIcon(new ImageIcon(Resource.IMG_DAMAGE));
		life.setIcon(new ImageIcon(Resource.IMG_HEALTH));
		speed.setIcon(new ImageIcon(Resource.IMG_SPEED));
		if(GameState.hullEnabled == false) {
			hull.setIcon(ShipEntity.hullShip);
		} else {
			hull.setIcon(null);
		}
		shipUp.setIcon(ShipEntity.nextShip);
		label.setIcon(new ImageIcon(ShipEntity.currentShip.getImage()));
	}
	
	private void setLandF() {
		LF.Button(replay);
		LF.Button(plus);
		LF.Button(minus);
		LF.Button(done);
		LF.Button(dual);
		LF.Button(pierce);
		LF.Button(explosive);
		LF.Button(laser);
		LF.Button(machgun);
		LF.Button(shotgun);
		LF.Button(wave);
		LF.Button(damage);
		LF.Button(life);
		LF.Button(speed);
		LF.Button(hull);
		LF.Button(shipUp);
		LF.Button(bulletSpeed);
		LF.Scroll(scroll);
	}
	
	private void setListener() {
		done.addActionListener(this);
		dual.addActionListener(this);
		pierce.addActionListener(this);
		explosive.addActionListener(this);
		shotgun.addActionListener(this);
		wave.addActionListener(this);
		damage.addActionListener(this);
		machgun.addActionListener(this);
		life.addActionListener(this);
		laser.addActionListener(this);
		speed.addActionListener(this);
		hull.addActionListener(this);
		shipUp.addActionListener(this);
		minus.addActionListener(this);
		plus.addActionListener(this);
		replay.addActionListener(this);
		bulletSpeed.addActionListener(this);
	}
	
	private void setEnabled() {
		if(GameState.hullEnabled) {
			hull.setEnabled(false);
			hull.setBackground(Color.BLACK);
		} else {
			hull.setEnabled(true);
			hull.setBackground(Color.GREEN);
		}
		
		if(GameState.lifeEnabled) {
			life.setEnabled(false);
			life.setBackground(Color.BLACK);
		} else {
			life.setEnabled(true);
			life.setBackground(Color.GREEN);
		}
		
		if(GameState.damageEnabled) {
			damage.setEnabled(false);
			damage.setBackground(Color.BLACK);
		} else {
			damage.setEnabled(true);
			damage.setBackground(Color.GREEN);
		}
		
		if(GameState.dualEnabled) {
			dual.setEnabled(false);
			hull.setBackground(Color.BLACK);
		} else {
			dual.setEnabled(true);
			dual.setBackground(Color.GREEN);
		}
		
		if(GameState.ship == 3 || GameState.ship == 6 || GameState.ship == 9) {
			shipUp.setEnabled(false);
			shipUp.setBackground(Color.BLACK);
		} else {
			shipUp.setEnabled(true);
			shipUp.setBackground(Color.GREEN);
		}
		
		if(GameState.wantedLevel < GameState.level - 1) {
			plus.setEnabled(true);
			plus.setBackground(Color.BLACK);
		} else {
			plus.setEnabled(false);
			plus.setBackground(Color.GREEN);
		}
			
		if(GameState.wantedLevel > 1) {
			minus.setEnabled(true);
			minus.setBackground(Color.BLACK);
		} else {
			minus.setEnabled(false);
			minus.setBackground(Color.GREEN);
		}
	}
	
	private void add() {
		Bar.addTab("SHIP", scroll);
		Bar.addTab("WEAPONS", scroll2);
		Bar.addTab("SPECIAL", scroll3);
		np1.add(life);
		np1.add(speed);
		np1.add(damage);
		np1.add(hull);
		np1.add(shipUp);
		np2.add(dual);
		np2.add(machgun);
		np2.add(laser);
		np2.add(explosive);
		np2.add(pierce);
		np2.add(wave);
		np2.add(shotgun);
		np3.add(bulletSpeed);
		add(label);
		add(Bar);
		add(done);
		add(replay);
		add(minus);
		add(plus);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == done) {
			GameState.useWantedLevel = false;
			frame.RunGame(3);
		}else if(ae.getSource() == dual) {
			GameState.dualEnabled = true;
			dual.setBackground(Color.BLACK);
		}else if(ae.getSource() == damage) {
		}else if(ae.getSource() == laser) {
			GameState.laserEnabled = true;
		}else if(ae.getSource() == machgun) {
			GameState.machGunEnabled = true;
		}else if(ae.getSource() == life) {
		}else if(ae.getSource() == speed) {	
		}else if(ae.getSource() == hull) {
			GameState.hullEnabled = true;
			Factory.newShip(GameState.ship);
			label.setBounds(0, 0, ShipEntity.currentShip.getWidth(), ShipEntity.currentShip.getHeight());
		}else if(ae.getSource() == shipUp) {
			GameState.ship ++;
			GameState.hullEnabled = false;
			Factory.newShip(GameState.ship);
			label.setBounds(0, 0, ShipEntity.currentShip.getWidth(), ShipEntity.currentShip.getHeight());
		}else if(ae.getSource() == minus) {
			GameState.wantedLevel --;
		}else if(ae.getSource() == plus) {
			GameState.wantedLevel ++;
		}else if(ae.getSource() == replay) {
			GameState.useWantedLevel = true;
			frame.RunGame(3);
		}
		
		setEnabled();
		setIcon();
		setBounds();
	}
	
	public void	paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d	= (Graphics2D)	g;
		
		String s = Integer.toString(GameState.wantedLevel);
		
		Stars.draw(g2d);
        
        g2d.setFont(new Font("TimesNewRoman", Font.PLAIN, 20));
        g2d.setColor(Color.GREEN);
        g2d.drawRect(panelWidth/2 + 150, panelHeight - 70, 47, 29);
        g2d.drawString(s, panelWidth/2 + 167, panelHeight - 47);
        
        g2d.drawRoundRect(1, 1, 100, 100, 15, 15);
        
        g2d.drawString("Speed: " + ShipEntity.currentShip.getSpeed(), 150, 30);
        g2d.drawString("Health: " + ShipEntity.currentShip.getHealth(), 270, 30);
        g2d.drawString("Damage: " + ShipEntity.currentShip.getDamage(), 150, 70);
        
        g2d.drawString("Enemies Killed: " + GameState.enemiesKilled, 50, 350);
        g2d.drawString("Number of Deaths: " + GameState.numDeaths, 50, 390);
        g2d.drawString("Shots Fired: " + GameState.shotsFired, 50, 430);
        g2d.drawString("Number of Hits: " + GameState.numHits, 50, 470);
        g2d.drawString("Hit Ratio: " + df.format(GameState.hitRatio) + "%", 300, 350);
        g2d.drawString("Time Played: " + GameState.timePlayed, 300, 390);
        g2d.drawString("Times Played: " + GameState.timesPlayed, 300, 430);
        g2d.drawString("Achievments: " + GameState.achievmentsEarned, 300, 470);
	}
}