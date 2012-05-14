package com.alpha.game;

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
	private Star star;
	private int width = 0, height = 0; 
	private LandF LF = new LandF();
	private GridLayout layout = new GridLayout(0,1);
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
	
	UpgradeMenu(int x, int y, Control con) {
		control = con;
		width = x - 8;
		height = y - 31;
		setVisible(true);
		
		setBackground(Color.BLACK);
		star = GameState.star;
		star.setDraw(this);
		LF.TabbedPane(Bar);
		
		this.setLayout(null);
		layout.setVgap(1);
		
		add(replay);
		add(minus);
		add(plus);
		
		setupButtons();
		
		NestedPanel np1 = new NestedPanel(width, height * 40);
		np1.setLayout(layout);
		np1.add(dual);
		np1.add(life);
		np1.add(speed);
		np1.add(hull);
		np1.add(shipUp);
		JScrollPane scroll = new JScrollPane(np1);
		scroll.setWheelScrollingEnabled(true);
		LF.Scroll(scroll);
		Bar.addTab("SHIP", scroll);
		
		NestedPanel np2 = new NestedPanel(width, height);
		np2.setLayout(layout);
		np2.add(machgun);
		np2.add(damage);
		JScrollPane scroll2 = new JScrollPane(np2);
		Bar.addTab("WEAPONS", scroll2);
		
		NestedPanel np3 = new NestedPanel(width, height);
		np3.setLayout(layout);
		np3.add(laser);
		JScrollPane scroll3 = new JScrollPane(np3);
		Bar.addTab("SPECIAL", scroll3);
		
		label.setIcon(new ImageIcon(GameState.currentShip));
		label.setBounds(0, 0, GameState.currentShip.getWidth(observer), GameState.currentShip.getHeight(observer));
		
		add(label);
		add(Bar);
		add(done);
		
		setBounds(0, 0, width, height);
		Bar.setBounds(0, 200, 495, 200);
		done.setBounds(width/2, height - 40, width/2, 30);
		minus.setBounds(width/2 + 100, height - 70, 50, 30);
		plus.setBounds(width - 50, height - 70, 50, 30);
		replay.setBounds(width/2, height - 70, 100, 30);
	}

	// TODO Set the current, next and hull ship at the start of this context
	public void setupButtons() {
		
		LF.Button(replay);
		LF.Button(plus);
		LF.Button(minus);
		
		LF.Button(done);
		
		dual.setPreferredSize(new Dimension(width - 20, 50));
		dual.setMinimumSize(dual.getPreferredSize());
		dual.setIcon(new ImageIcon(Resource.IMG_DUAL_LASER));
		LF.Button(dual);
		
		damage.setPreferredSize(new Dimension(width - 20, 50));
		damage.setMinimumSize(damage.getPreferredSize());
		damage.setIcon(new ImageIcon(Resource.IMG_DAMAGE));
		LF.Button(damage);
		
		laser.setPreferredSize(new Dimension(width - 20, 50));
		laser.setMinimumSize(laser.getPreferredSize());
		LF.Button(laser);
		
		machgun.setPreferredSize(new Dimension(width - 20, 50));
		machgun.setMinimumSize(machgun.getPreferredSize());
		LF.Button(machgun);
		
		life.setPreferredSize(new Dimension(width - 20, 50));
		life.setMinimumSize(life.getPreferredSize());
		life.setIcon(new ImageIcon(Resource.IMG_HEALTH));
		LF.Button(life);
		
		speed.setPreferredSize(new Dimension(width - 20, 50));
		speed.setMinimumSize(speed.getPreferredSize());
		speed.setIcon(new ImageIcon(Resource.IMG_SPEED));
		LF.Button(speed);
		
		hull.setPreferredSize(new Dimension(width - 20, 50));
		hull.setMinimumSize(hull.getPreferredSize());
		hull.setIcon(GameState.hullShip);
		LF.Button(hull);
		
		if(GameState.hull) {
			hull.setEnabled(false);
			hull.setBackground(Color.BLACK);
		}
		
		if(GameState.ship == 3 || GameState.ship == 6 || GameState.ship == 9) {
			shipUp.setEnabled(false);
		}
		shipUp.setPreferredSize(new Dimension(width - 20, 50));
		shipUp.setMinimumSize(shipUp.getPreferredSize());
		shipUp.setIcon(GameState.nextShip);
		LF.Button(shipUp);
		
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
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == done) {
			star = null;
			done.setVisible(false);
			done = null;
			GameState.useWantedLevel = false;
			control.RunGame(3);
		}else if(ae.getSource() == dual) {
			GameState.dual = true;
			dual.setEnabled(false);
			dual.setBackground(Color.BLACK);
		}else if(ae.getSource() == damage) {
			GameState.damage += 5;
		}else if(ae.getSource() == laser) {
			GameState.laser = true;
		}else if(ae.getSource() == machgun) {
			GameState.machGun = true;
		}else if(ae.getSource() == life) {
			GameState.life += 10;
		}else if(ae.getSource() == speed) {
			GameState.speed ++;		
		}else if(ae.getSource() == hull) {
			GameState.hull = true;
			hull.setEnabled(false);
			hull.setBackground(Color.BLACK);
			GameState.updateShip();
			label.setBounds(0, 0, GameState.currentShip.getWidth(observer), GameState.currentShip.getHeight(observer));
			label.setIcon(new ImageIcon(GameState.currentShip));
			hull.setIcon(GameState.hullShip);
			shipUp.setIcon(GameState.nextShip);
		}else if(ae.getSource() == shipUp) {
			GameState.ship ++;
			GameState.updateShip();
			GameState.hull = false;
			hull.setEnabled(true);
			label.setBounds(0, 0, GameState.currentShip.getWidth(observer), GameState.currentShip.getHeight(observer));
			label.setIcon(new ImageIcon(GameState.currentShip));
			hull.setIcon(GameState.hullShip);
			shipUp.setIcon(GameState.nextShip);
		}else if(ae.getSource() == minus) {
			GameState.wantedLevel --;
		}else if(ae.getSource() == plus) {
			GameState.wantedLevel ++;
		}else if(ae.getSource() == replay) {
			star = null;
			done.setVisible(false);
			done = null;
			GameState.useWantedLevel = true;
			control.RunGame(3);
		}
		
		if(GameState.ship == 3 || GameState.ship == 6 || GameState.ship == 9) {
			shipUp.setEnabled(false);
		}
	}
	
	public void	paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d	= (Graphics2D)	g;
		
		String s = Integer.toString(GameState.wantedLevel);
		
        star.draw(g2d);
        
        g2d.setFont(new Font("TimesNewRoman", Font.PLAIN, 20));
        g2d.setColor(Color.GREEN);
        g2d.drawRect(width/2 + 150, height - 70, 47, 29);
        g2d.drawString(s, width/2 + 167, height - 47);
	}
}