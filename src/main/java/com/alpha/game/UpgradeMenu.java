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
import java.awt.image.ImageObserver;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

@SuppressWarnings("serial")
public class UpgradeMenu extends JPanel implements ActionListener {
	private Control control;
	private int panelWidth = 0, panelHeight = 0; 
	
	private LandF LF = new LandF();
	
	private GridLayout pnaelLayout = new GridLayout(0,1);
	BorderLayout buttonLayout = new BorderLayout();
	
	JLabel label = new JLabel();
	
	private JTabbedPane Bar = new JTabbedPane();
	JButton done = new JButton("Next Level");
	JButton dual = new JButton("DUAL LASERS");
	JButton damage = new JButton("+1 DAMAGE");
	JButton laser = new JButton("LASER SIGHT");
	JButton machgun = new JButton("MACHINE GUN");
	JButton life = new JButton("LIFE UP");
	JButton speed = new JButton("SPEED UP");
	JButton hull = new JButton("HULL UP");
	JButton shipUp = new JButton("UPGRADE SHIP");
	private ImageObserver observer;
	
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
		control = GameState.con;
		panelWidth = Control.width - 8;
		panelHeight = Control.height - 31;
		setVisible(true);
		
		setBackground(Color.BLACK);
		GameState.star.setDraw(this);
		LF.TabbedPane(Bar);
		
		this.setLayout(null);
		
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
		pnaelLayout.setVgap(1);
		dual.setLayout(buttonLayout);
		damage.setLayout(buttonLayout);
		machgun.setLayout(buttonLayout);
		life.setLayout(buttonLayout);
		laser.setLayout(buttonLayout);
		speed.setLayout(buttonLayout);
		hull.setLayout(buttonLayout);
		shipUp.setLayout(buttonLayout);
		np1.setLayout(pnaelLayout);
		np2.setLayout(pnaelLayout);
		np3.setLayout(pnaelLayout);
	}
	
	private void setSize() {
		dual.setPreferredSize(new Dimension(panelWidth - 20, 50)); dual.setMinimumSize(dual.getPreferredSize());
		damage.setPreferredSize(new Dimension(panelWidth - 20, 50)); damage.setMinimumSize(damage.getPreferredSize());
		laser.setPreferredSize(new Dimension(panelWidth - 20, 50)); laser.setMinimumSize(laser.getPreferredSize());
		machgun.setPreferredSize(new Dimension(panelWidth - 20, 50)); machgun.setMinimumSize(machgun.getPreferredSize());
		life.setPreferredSize(new Dimension(panelWidth - 20, 50)); life.setMinimumSize(life.getPreferredSize());
		speed.setPreferredSize(new Dimension(panelWidth - 20, 50)); speed.setMinimumSize(speed.getPreferredSize());
		hull.setPreferredSize(new Dimension(panelWidth - 20, 50)); hull.setMinimumSize(hull.getPreferredSize());
		shipUp.setPreferredSize(new Dimension(panelWidth - 20, 50)); shipUp.setMinimumSize(shipUp.getPreferredSize());
	}
	
	private void setBounds() {
		setBounds(0, 0, panelWidth, panelHeight);
		Bar.setBounds(0, 200, 495, 200);
		done.setBounds(panelWidth/2, panelHeight - 40, panelWidth/2, 30);
		minus.setBounds(panelWidth/2 + 100, panelHeight - 70, 50, 30);
		plus.setBounds(panelWidth - 50, panelHeight - 70, 50, 30);
		replay.setBounds(panelWidth/2, panelHeight - 70, 100, 30);
		label.setBounds(0, 0, GameState.currentShip.getWidth(observer), GameState.currentShip.getHeight(observer));
	}
	
	private void setIcon() {
		dual.setIcon(new ImageIcon(Resource.IMG_DUAL_LASER));
		damage.setIcon(new ImageIcon(Resource.IMG_DAMAGE));
		life.setIcon(new ImageIcon(Resource.IMG_HEALTH));
		speed.setIcon(new ImageIcon(Resource.IMG_SPEED));
		hull.setIcon(GameState.hullShip);
		shipUp.setIcon(GameState.nextShip);
		label.setIcon(new ImageIcon(GameState.currentShip));
	}
	
	private void setLandF() {
		LF.Button(replay);
		LF.Button(plus);
		LF.Button(minus);
		LF.Button(done);
		LF.Button(dual);
		LF.Button(damage);
		LF.Button(laser);
		LF.Button(machgun);
		LF.Button(life);
		LF.Button(speed);
		LF.Button(hull);
		LF.Button(shipUp);
		LF.Scroll(scroll);
	}
	
	private void setListener() {
		done.addActionListener(this);
		dual.addActionListener(this);
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
		np1.add(dual);
		np1.add(life);
		np1.add(speed);
		np1.add(hull);
		np1.add(shipUp);
		np2.add(machgun);
		np2.add(damage);
		np3.add(laser);
		add(label);
		add(Bar);
		add(done);
		add(replay);
		add(minus);
		add(plus);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == done) {
			done.setVisible(false);
			done = null;
			GameState.useWantedLevel = false;
			control.RunGame(3);
		}else if(ae.getSource() == dual) {
			GameState.dualEnabled = true;
			dual.setBackground(Color.BLACK);
		}else if(ae.getSource() == damage) {
			GameState.damage += 5;
		}else if(ae.getSource() == laser) {
			GameState.laserEnabled = true;
		}else if(ae.getSource() == machgun) {
			GameState.machGunEnabled = true;
		}else if(ae.getSource() == life) {
			GameState.life += 10;
		}else if(ae.getSource() == speed) {
			GameState.speed ++;		
		}else if(ae.getSource() == hull) {
			GameState.hullEnabled = true;
			GameState.updateShip();
			label.setBounds(0, 0, GameState.currentShip.getWidth(observer), GameState.currentShip.getHeight(observer));
		}else if(ae.getSource() == shipUp) {
			GameState.ship ++;
			GameState.updateShip();
			GameState.hullEnabled = false;
			label.setBounds(0, 0, GameState.currentShip.getWidth(observer), GameState.currentShip.getHeight(observer));
		}else if(ae.getSource() == minus) {
			GameState.wantedLevel --;
		}else if(ae.getSource() == plus) {
			GameState.wantedLevel ++;
		}else if(ae.getSource() == replay) {
			done.setVisible(false);
			done = null;
			GameState.useWantedLevel = true;
			control.RunGame(3);
		}
		
		setEnabled();
		setIcon();
	}
	
	public void	paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d	= (Graphics2D)	g;
		
		String s = Integer.toString(GameState.wantedLevel);
		
        GameState.star.draw(g2d);
        
        g2d.setFont(new Font("TimesNewRoman", Font.PLAIN, 20));
        g2d.setColor(Color.GREEN);
        g2d.drawRect(panelWidth/2 + 150, panelHeight - 70, 47, 29);
        g2d.drawString(s, panelWidth/2 + 167, panelHeight - 47);
	}
}