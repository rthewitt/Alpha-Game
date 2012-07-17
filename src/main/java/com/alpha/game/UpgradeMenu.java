package com.alpha.game;

import java.awt.BorderLayout;
import java.awt.Color;
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
	static int panelWidth, panelHeight; 
	MenuItem currentItem;
	
	private GridLayout panelLayout = new GridLayout(0,1);
	BorderLayout buttonLayout = new BorderLayout();
	DecimalFormat df = new DecimalFormat("#.##");
	
	JLabel label = new JLabel();
	
	private JTabbedPane Bar = new JTabbedPane();
	
	JButton done = new JButton("Next Level");
	JButton replay = new JButton("REPLAY");
	JButton minus = new JButton("-");
	JButton plus = new JButton("+");
	
	NestedPanel np1 = new NestedPanel();
	NestedPanel np2 = new NestedPanel();
	NestedPanel np3 = new NestedPanel();
	JScrollPane scroll = new JScrollPane(np1);
	JScrollPane scroll2 = new JScrollPane(np2);
	JScrollPane scroll3 = new JScrollPane(np3);
	
	MenuItem damage = new MenuItem(np1, this, "+1 DAMAGE", Resource.IMG_DAMAGE, 5, "Increases all damage by 10%");
	MenuItem life = new MenuItem(np1, this, "LIFE UP", Resource.IMG_HEALTH, 5, "Increase Ships max health by 10");
	MenuItem speed = new MenuItem(np1, this, "SPEED UP", Resource.IMG_SPEED, 15, "Increase Ships speed");
	MenuItem hull = new MenuItem(np1, this, "HULL UP", ShipEntity.hullShip, 30, "New Look and Increase Health");
	MenuItem shipUp = new MenuItem(np1, this, "UPGRADE SHIP", ShipEntity.nextShip, 60, "You get a new Ship! + 1 weapons emplacements");
	MenuItem RofUp = new MenuItem(np3, this, "FIRING SPEED", null, 30, "Decrease time between bullets");
	MenuItem dual = new MenuItem(np2, this, "DUAL GUN", Resource.IMG_DUAL_LASER, 10, "Fire two bolts for the price of one");
	MenuItem machgun = new MenuItem(np2, this, "MACH GUN", Resource.IMG_RAPID_LASER, 80, "Rapid fire bolts!");
	MenuItem pierce = new MenuItem(np2, this, "PIERCE GUN", Resource.IMG_PIERCE_LASER, 20, "Tiny damage but goes through ships while damaging them");
	MenuItem explosive = new MenuItem(np2, this, "EXPLOSIVE GUN", Resource.IMG_EXPLOSIVE_LASER, 30, "High damage but slow reload");
	MenuItem laser = new MenuItem(np2, this, "LASER GUN", Resource.IMG_LASER, 40, "Low Damage but its a Laser!");
	MenuItem wave = new MenuItem(np2, this, "WAVE GUN", Resource.IMG_WAVE_LASER, 60, "The entire field of view is at least damages");
	MenuItem shotgun = new MenuItem(np2, this, "SHOT-GUN", Resource.IMG_SPREAD_LASER, 40, "How many bullets do you need?");
	MenuItem bulletSpeed = new MenuItem(np3, this, "BULLET SPEED", null, 15, "Increases the speed of all beams");
	
	static int rectSize;
	static boolean animationDone;
	static int row1, row2, rowHeight;
	
	UpgradeMenu() {
		frame = GameState.frame;
		panelWidth = Frame.width - 7;
		panelHeight = Frame.height - 31;
		row1 = 50; row2 = 300; rowHeight = 350; rectSize = 0; animationDone = false;
		setVisible(true);
		
		Refresher.setDraw(this);
		
		setBackground(Color.BLACK);
		LF.TabbedPane(Bar);
		
		setLayout(null);
		setup();
	}

	public void setup() {
		setLayout();
		setBounds();
		setLandF();
		setListener();
		setEnabled();
		label.setIcon(new ImageIcon(ShipEntity.currentShip.getImage()));
		add();
		scroll.setWheelScrollingEnabled(true);
	}
	
	private void setLayout() {
		panelLayout.setVgap(1);
		np1.setLayout(panelLayout);
		np2.setLayout(panelLayout);
		np3.setLayout(panelLayout);
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
	
	private void setLandF() {
		LF.Button(replay);
		LF.Button(plus);
		LF.Button(minus);
		LF.Button(done);
		LF.Scroll(scroll);
	}
	
	private void setListener() {
		done.addActionListener(this);
		minus.addActionListener(this);
		plus.addActionListener(this);
		replay.addActionListener(this);
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
			frame.NewPanel(new Game());
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
			frame.NewPanel(new Game());
		}
		
		try {
			currentItem = (MenuItem) ae.getSource();
		} catch(ClassCastException e) {}
		
		try {
			hull.setIcon(new ImageIcon(ShipEntity.hullShip));
			shipUp.setIcon(new ImageIcon(ShipEntity.nextShip));
		} catch(NullPointerException e) {}
		
		setEnabled();
		label.setIcon(new ImageIcon(ShipEntity.currentShip.getImage()));
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
        g2d.drawString("Yin: " + GameState.yin, 270, 70);
        
        if(currentItem != null) {
        	new UpgradeMenuAnimation().go();
        	g2d.drawRoundRect(3, 330, panelWidth - 7, rectSize, 30, 30);
        	if(animationDone) {
            	g2d.setFont(new Font("TimesNewRoman", Font.PLAIN, 40));
            	g2d.drawString(currentItem.getName(), 7, 370);
            	g2d.setFont(new Font("TimesNewRoman", Font.PLAIN, 20));
            	g2d.drawString("Description:", 5, 420);
            	g2d.drawString(currentItem.getDesc(), 5, 440);
            	g2d.drawString("Cost: " + currentItem.getCost(), panelWidth - 80, 355);
        	}
        }
        
        g2d.drawString("Enemies Killed: " + GameState.enemiesKilled, row1, rowHeight);
        g2d.drawString("Number of Deaths: " + GameState.numDeaths, row1, rowHeight + 35);
        g2d.drawString("Shots Fired: " + GameState.shotsFired, row1, rowHeight + 70);
        g2d.drawString("Number of Hits: " + GameState.numHits, row1, rowHeight + 105);
        g2d.drawString("Hit Ratio: " + df.format(GameState.hitRatio) + "%", row2, rowHeight);
        g2d.drawString("Time Played: " + GameState.timePlayed, row2, rowHeight + 35);
        g2d.drawString("Times Played: " + GameState.timesPlayed, row2, rowHeight + 70);
        g2d.drawString("Achievments: " + GameState.achievmentsEarned, row2, rowHeight + 105);
	}
}