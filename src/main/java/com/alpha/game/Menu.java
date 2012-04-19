package com.alpha.game;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Menu extends JPanel implements ActionListener
{
	private static final long serialVersionUID = 1L;
	
	JButton go = new JButton("Start a New Game");
	JButton ship1 = new JButton("1");
	JButton ship2 = new JButton("2");
	JButton ship3 = new JButton("3");
	JButton instructions = new JButton("Instructions");
	JButton credits	= new JButton("Credits");
	
	private int Width, Height;
	private Control control;
	private LandF LF = new LandF();
	
	String ship1Tip = "<html>Green<br>Speed = 2<br>Power = 2<br>Defense = 2</html>";
	String ship2Tip = "<html>Red<br>Speed = 1<br>Power = 3<br>Defense = 2</html>";
	String ship3Tip = "<html>Blue<br>Speed = 3<br>Power = 2<br>Defense = 1</html>";
	
	Star star;
	GameState state;
	
	public Menu(int w, int h, Control con, GameState s)
	{
		state = s;
		control = con;
		Width = w;
		Height = h;
		setSize(Width, Height);
		
		star = new Star(Width, Height, this);
		star.setNumber(50);
		star.start();
			
		this.setLayout(null);
		
		buttonSetup();
		
		go.addActionListener(new ActionListener()
		{
			public void	actionPerformed(ActionEvent e)
			{
				add(ship1);
				add(ship2);
				add(ship3);
			}
		});
		
		setBackground(Color.BLACK);
	}
	
	private void buttonSetup()
	{
		ship1.setBounds(90, 255, 100, 50);
		ship2.setBounds(193, 255, 100, 50);
		ship3.setBounds(296, 255, 100, 50);
		go.setBounds(70,150,350,100);
		instructions.setBounds(70, 400, 350, 100);
		credits.setBounds(70, 600, 350, 100);
		
		LF.Button(ship1);
		LF.Button(ship2);
		LF.Button(ship3);
		LF.Button(go);
		LF.Button(instructions);
		LF.Button(credits);
		
		ship1.setIcon(Resource.ICON_SMALL_GREEN_ICON);
		ship2.setIcon(Resource.ICON_SMALL_RED_ICON);
		ship3.setIcon(Resource.ICON_SMALL_BLUE_ICON);
		
		ship1.setToolTipText(ship1Tip);
		ship2.setToolTipText(ship2Tip);
		ship3.setToolTipText(ship3Tip);
		
		add(go);
		add(instructions);
		add(credits);
		
		ship1.addActionListener(this);
		ship2.addActionListener(this);
		ship3.addActionListener(this);
	}
	
	public void	paintComponent(Graphics g)  
	{
		super.paintComponent(g);
		Graphics2D g2d	= (Graphics2D)	g;
		
		try
		{
        	star.draw(g2d);
		}
		catch(NullPointerException e)
		{
		}
	}

	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent ae)
	{
		if("1".equalsIgnoreCase(ae.getActionCommand()))
		{
			state.setShip(1);
		}
		else if("2".equalsIgnoreCase(ae.getActionCommand()))
		{
			state.setShip(4);
		}
		else if("3".equalsIgnoreCase(ae.getActionCommand()))
		{
			state.setShip(7);
		}
		
		star.stop();
		star = null;
		go.setVisible(false);
		go = null;
		ship1 = null;
		ship2 = null;
		ship3 = null;
		control.RunGame(1);
	}
}