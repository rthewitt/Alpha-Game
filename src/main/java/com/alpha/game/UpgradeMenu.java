package com.alpha.game;
import java.awt.Color;
import java.awt.Dimension;
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
public class UpgradeMenu extends JPanel implements ActionListener
{
	private Control control;
	private Star star;
	private int Width = 0, Height = 0; 
	private GameState state;
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
	
	//Will be implemented later
//	JButton replay = new JButton();
//	JButton minus = new JButton();
//	JButton plus = new JButton();
//	JTextField number = new JTextField();
	
	UpgradeMenu(int x, int y, Control con, GameState s)
	{
		state = s;
		control = con;
		Width = x - 8;
		Height = y - 31;
		setVisible(true);
		
		setBackground(Color.BLACK);
		star = state.getStar();
		star.setDraw(this);
		LF.TabbedPane(Bar);
		
		this.setLayout(null);
		layout.setVgap(1);
		
//		number.setText("Yes");
//		add(replay);
//		add(minus);
//		add(number);
//		add(plus);
		
		setupButtons();
		
		NestedPanel np1 = new NestedPanel(Width, Height * 40);
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
		
		NestedPanel np2 = new NestedPanel(Width, Height);
		np2.setLayout(layout);
		np2.add(machgun);
		np2.add(damage);
		JScrollPane scroll2 = new JScrollPane(np2);
		Bar.addTab("WEAPONS", scroll2);
		
		NestedPanel np3 = new NestedPanel(Width, Height);
		np3.setLayout(layout);
		np3.add(laser);
		JScrollPane scroll3 = new JScrollPane(np3);
		Bar.addTab("SPECIAL", scroll3);
		
		label.setIcon(new ImageIcon( state.getCurrentShip() ));
		label.setBounds(0, 0, state.getCurrentShip().getWidth(observer), state.getCurrentShip().getHeight(observer));
		
		add(label);
		add(Bar);
		add(done);
		
		setBounds(0, 0, Width, Height);
		Bar.setBounds(0, 200, 495, 200);
		done.setBounds(0, Height - 30, Width, Height);
		done.setSize(Width, 30);
	}

	// TODO Set the current, next and hull ship at the start of this context
	public void setupButtons()
	{
//		minus.setBounds(230, 10, 60, 50);
//		number.setBounds(290, 10, 50, 50);
//		plus.setBounds(340, 10, 60, 50);
//		replay.setBounds(100, 10, 300, 50);
		
//		LF.Button(replay);
//		LF.Button(plus);
//		LF.Button(minus);
		
		LF.Button(done);
		
		dual.setPreferredSize(new Dimension(Width - 20, 50));
		dual.setMinimumSize(dual.getPreferredSize());
		dual.setIcon(new ImageIcon(Resource.IMG_DUAL_LASER));
		LF.Button(dual);
		
		damage.setPreferredSize(new Dimension(Width - 20, 50));
		damage.setMinimumSize(damage.getPreferredSize());
		LF.Button(damage);
		
		laser.setPreferredSize(new Dimension(Width - 20, 50));
		laser.setMinimumSize(laser.getPreferredSize());
		LF.Button(laser);
		
		machgun.setPreferredSize(new Dimension(Width - 20, 50));
		machgun.setMinimumSize(machgun.getPreferredSize());
		LF.Button(machgun);
		
		life.setPreferredSize(new Dimension(Width - 20, 50));
		life.setMinimumSize(life.getPreferredSize());
		life.setIcon(new ImageIcon(Resource.IMG_HEALTH));
		LF.Button(life);
		
		speed.setPreferredSize(new Dimension(Width - 20, 50));
		speed.setMinimumSize(speed.getPreferredSize());
		speed.setIcon(new ImageIcon(Resource.IMG_SPEED));
		LF.Button(speed);
		
		hull.setPreferredSize(new Dimension(Width - 20, 50));
		hull.setMinimumSize(hull.getPreferredSize());
		hull.setIcon(state.getHullShip());
		LF.Button(hull);
		if(state.getHull())
		{
			hull.setEnabled(false);
			hull.setBackground(Color.BLACK);
		}
		
		if(state.getShip() == 3 || state.getShip() == 6 || state.getShip() == 9)
		{
			shipUp.setEnabled(false);
		}
		shipUp.setPreferredSize(new Dimension(Width - 20, 50));
		shipUp.setMinimumSize(shipUp.getPreferredSize());
		shipUp.setIcon(state.getNextShip());
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
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == done)
		{
			star = null; done.setVisible(false);
			done = null;
			control.RunGame(3);
		}
		else if(ae.getSource() == dual)
		{
			state.Dual();
			dual.setEnabled(false);
			dual.setBackground(Color.BLACK);
		}
		else if(ae.getSource() == damage)
		{
			state.DamageUp(5);
		}	
		else if(ae.getSource() == laser)
		{
			state.addLaser();
		}	
		else if(ae.getSource() == machgun)
		{
			state.addMachGun();
		}	
		else if(ae.getSource() == life)
		{
			state.LifeUp(2);
		}
		else if(ae.getSource() == speed)
		{
			state.IncrementSpeed();		
		}
		else if(ae.getSource() == hull)
		{
			state.HullUp();
			hull.setEnabled(false);
			hull.setBackground(Color.BLACK);
			state.updateShip();
			label.setBounds(0, 0, state.getCurrentShip().getWidth(observer), state.getCurrentShip().getHeight(observer));
			label.setIcon(new ImageIcon(state.getCurrentShip()));
			hull.setIcon(state.getHullShip());
			shipUp.setIcon(state.getNextShip());
		}
		else if(ae.getSource() == shipUp)
		{
			state.UpgradeShip();
			state.updateShip();
			state.HullDown();
			hull.setEnabled(true);
			label.setBounds(0, 0, state.getCurrentShip().getWidth(observer), state.getCurrentShip().getHeight(observer));
			label.setIcon(new ImageIcon(state.getCurrentShip()));
			hull.setIcon(state.getHullShip());
			shipUp.setIcon(state.getNextShip());
			
			if(state.getShip() == 3 || state.getShip() == 6 || state.getShip() == 9)
			{
				shipUp.setEnabled(false);
			}
		}
	}
	
	public void	paintComponent(Graphics g)  
	{
		super.paintComponent(g);
		Graphics2D g2d	= (Graphics2D)	g;
		
        star.draw(g2d);
	}
}