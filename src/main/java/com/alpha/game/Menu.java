package com.alpha.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Menu extends JPanel implements ActionListener
{
	JButton go = new JButton("Start a New Game");
	JButton ship1 = new JButton("1");
	JButton ship2 = new JButton("2");
	JButton ship3 = new JButton("3");
	JButton instruct = new JButton("Instructions");
	JButton credit	= new JButton("Credits");
	JButton done = new JButton("Done");
	
	JPanel instructions = new JPanel();
	JPanel credits = new JPanel();
	
	private int width, height;
	private Control control;
	private LandF LF = new LandF();
	
	String ship1Tip = "<html>Green\nSpeed = 2\nPower = 2\nDefense = 2</html>";
	String ship2Tip = "<html>Red\nSpeed = 1\nPower = 3\nDefense = 2</html>";
	String ship3Tip = "<html>Blue\nSpeed = 3\nPower = 2\nDefense = 1</html>";
	
	String stringIntstruct = "This will be instructions";
	String stringCredits = " Producer: Brennan Zuber\n Programmer: Brennan Zuber\n Structural design: Ryan Hewitt\n Graphics: Elyse Zuber\n Music: David Torres\n\n" +
			"Testers: Greg Wright - Willaim Wright - Dean Mellas - Trevor Davenport\n Various students, staff and teachers of Cerritos College";
	
	Star star;
	GameState state;

	private boolean drawInstructions = false;
	private boolean drawCredits = false;
	
	public Menu(int w, int h, Control con, GameState s)
	{
		state = s;
		control = con;
		width = w;
		height = h;
		setSize(width, height);
		
		star = state.getStar();
		star.setDraw(this);
			
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
	
	private void drawString(Graphics2D g2d, String text, int x, int y)
	{
        for (String line : text.split("\n"))
            g2d.drawString(line, x, y += 50);
    }
	
	private void buttonSetup()
	{
		ship1.setBounds(90, 255, 100, 50);
		ship2.setBounds(193, 255, 100, 50);
		ship3.setBounds(296, 255, 100, 50);
		go.setBounds(70,150,350,100);
		instruct.setBounds(70, 400, 350, 100);
		credit.setBounds(70, 600, 350, 100);
		done.setBounds(width - 100, height - 80, 80, 30);
		
		instructions.setBounds(0, 0, width, height);
		credits.setBounds(0, 0, width, height);
		
		LF.Button(ship1);
		LF.Button(ship2);
		LF.Button(ship3);
		LF.Button(go);
		LF.Button(instruct);
		LF.Button(credit);
		LF.Button(done);
		
		LF.Panel(instructions);
		LF.Panel(credits);
		
		ship1.setIcon(Resource.ICON_SMALL_GREEN_ICON);
		ship2.setIcon(Resource.ICON_SMALL_RED_ICON);
		ship3.setIcon(Resource.ICON_SMALL_BLUE_ICON);
		
		ship1.setToolTipText(ship1Tip);
		ship2.setToolTipText(ship2Tip);
		ship3.setToolTipText(ship3Tip);
		
		add(go);
		add(instruct);
		add(credit);
		
		ship1.addActionListener(this);
		ship2.addActionListener(this);
		ship3.addActionListener(this);
		instruct.addActionListener(this);
		credit.addActionListener(this);
		done.addActionListener(this);
	}
	
	public void	paintComponent(Graphics g)  
	{
		super.paintComponent(g);
		Graphics2D g2d	= (Graphics2D)	g;
		
        star.draw(g2d);
        
        if(drawInstructions)
        {
        	g2d.setColor(Color.GREEN);
        	drawString(g2d, stringIntstruct, 10, 10);
        }
        
        if(drawCredits)
        {
        	g2d.setColor(Color.GREEN);
        	drawString(g2d, stringCredits, 10, 10);
        }
        
        repaint();
	}
	
	private void runNull()
	{
		go.setVisible(false);
		go = null;
		ship1 = null;
		ship2 = null;
		ship3 = null;
		control.RunGame(1);
	}
	
	public void enable(boolean b)
	{
		boolean o = false;
		if(b)
			o = false;
		else
			o = true;
		
		ship1.setVisible(b);
		ship2.setVisible(b);
		ship3.setVisible(b);
		instruct.setVisible(b);
		credit.setVisible(b);
		go.setVisible(b);
		done.setVisible(o);
		
		ship1.setEnabled(b);
		ship2.setEnabled(b);
		ship3.setEnabled(b);
		instruct.setEnabled(b);
		credit.setEnabled(b);
		go.setEnabled(b);
		done.setEnabled(o);
	}

	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == ship1)
		{
			state.setShip(1);
			state.setSpeed(2);
			runNull();
		}
		else if(ae.getSource() == ship2)
		{
			state.setShip(4);
			state.setSpeed(1);
			runNull();
		}
		else if(ae.getSource() == ship3)
		{
			state.setShip(7);
			state.setSpeed(3);
			runNull();
		}
		
		if(ae.getSource() == instruct)
		{
			enable(false);
			drawInstructions = true;
			add(done);
		}
		
		if(ae.getSource() == credit)
		{
			enable(false);
			drawCredits = true;
			add(done);
		}
		
		if(ae.getSource() == done)
		{
			drawInstructions = false;
			drawCredits = false;
			enable(true);
		}
	}
}