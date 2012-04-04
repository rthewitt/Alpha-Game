package com.alpha.game;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Menu extends JPanel
{
	private static final long serialVersionUID = 1L;
	JButton go = new JButton("Start The Game!");
	private int Width, Height;
	private Control control;
	private LandF LF = new LandF();
	Star star;
	
	public Menu(int w, int h, Control con)
	{
		control = con;
		Width = w;
		Height = h;
		setSize(Width, Height);
		
		star = new Star(Width, Height, this);
		star.setNumber(50);
		star.start();
			
		this.setLayout(null);
		
		LF.Button(go);
		go.setBounds(70,150,350,100);
		
		// TODO Brennan, please remove deprecated methods where possible
		go.addActionListener(new ActionListener()
		{
			@SuppressWarnings("deprecation")
			public void	actionPerformed(ActionEvent e)
			{
				star.stop();
				star = null;
				go.setVisible(false);
				go = null;
				setLayout(new BorderLayout());
				control.RunGame(1);
			}
		});
		
		add(go);
		
		setBackground(Color.BLACK);
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
}