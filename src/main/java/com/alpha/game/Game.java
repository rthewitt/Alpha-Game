package com.alpha.game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Panel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.JPanel;

public class Game extends JPanel implements KeyListener, MouseListener
{
	private static final long serialVersionUID = 1L;
	private int width, height;
	Vector<Beam> Beams = new Vector<Beam>(0, 0);
	private Vector<Ship> Ships = new Vector<Ship>();
	Vector<Enemy> Scouts = new Vector<Enemy>(0, 0);
	private int check = 0, Clicks = 0;
	int locX = 250, locY = 700;
	
	private boolean pressed = false;
	Star star;
	
	Panel draw;
	private GameState state;
	@SuppressWarnings("unused")
	private Lvl1 lvl;
	@SuppressWarnings("unused")
	private Lvl2 lvl2;
	@SuppressWarnings("unused")
	private Lvl3 lvl3;
	
	private Go go = new Go(this);
	
	public Game(int pwid, int pht, Control con, GameState s)
   {
		state = s;
		state.addMe(this);
		state.getSpeed();
		width = pwid;
		height = pht;
		setSize(width, height);
		
		setVisible(true);
		addKeyListener(this);
		
		setBackground(Color.BLACK);
		state.updateShip();
		Ship newShip = new Ship(this, state.getShip(), state.getHull());
		Ships.addElement(newShip);
		newShip.start();
		
		star = new Star(width, height, this);
		star.setNumber(50);
		star.start();
		
		addMouseListener
		(
			new MouseAdapter()
			{
	 	  		public void mouseClicked(MouseEvent e)
           	{
					Clicks ++;
					
					Clicked();
				}
			}
		);
		
		ChooseLevel();
	}
	
	public Vector<Beam> getVector1()
	{
		return Beams;
	}
	
	public Vector<Enemy> getVector2()
	{
		return Scouts;
	}
	
	public void Clicked()
	{
		if(Clicks < 6)
		{
			if(state.getDual())
			{
				Beam newBeam = new Beam(getLocX() - 15, getLocY(), this, state);
				Beams.addElement(newBeam);
				newBeam.setSpeed(3);
				
			
				Beam newBeam1 = new Beam(getLocX() + 15, getLocY(), this, state);
				Beams.addElement(newBeam1);
				newBeam1.setDirX(-1);
				newBeam1.setDirY(3);
				newBeam1.setSpeed(9);
				
				Beam newBeam2 = new Beam(getLocX() + 15, getLocY(), this, state);
				Beams.addElement(newBeam2);
				newBeam2.setDirX(1);
				newBeam2.setDirY(3);
				newBeam1.setSpeed(9);
				
				newBeam.start();
				newBeam1.start();
				newBeam2.start();
			}
			else
			{
				Beam newBeam = new Beam(getLocX() - 3, getLocY(), this, state);
				Beams.addElement(newBeam);
				newBeam.setSpeed(3);
				newBeam.start();
			}
		}
		else
		{
			if(check >= 5)
			{
				Clicks = 0;
				check = 0;
				
				Beams = null;
				Beams = new Vector<Beam>(0, 0);
			}
		}
	}
	
	public void keyPressed(KeyEvent ke)
	{
		switch(ke.getKeyCode())
		{
			case KeyEvent.VK_W: go.setUp(true); break;
			
			case KeyEvent.VK_S: go.setDown(true); break;
			
			case KeyEvent.VK_A: go.setLeft(true); break;
			
			case KeyEvent.VK_D: go.setRight(true); break;
		}
	}
	
	public void keyReleased(KeyEvent ke)
	{
		switch(ke.getKeyCode())
		{
			case KeyEvent.VK_W: go.setUp(false); break;
			
			case KeyEvent.VK_S: go.setDown(false); break;
			
			case KeyEvent.VK_A: go.setLeft(false); break;
			
			case KeyEvent.VK_D: go.setRight(false); break;
		}
	}
	
	public void keyTyped(KeyEvent ke){}
	
	public void mouseExited(MouseEvent me){}
	public void mouseEntered(MouseEvent me){}
	public void mouseReleased(MouseEvent me){pressed = false;}
	public void mouseClicked(MouseEvent me){}
	
	public void mousePressed(MouseEvent me)
	{
		pressed = true;
		if(state.getMachGun())
		{
			while(pressed)
			{
				Beam newBeam = new Beam(getLocX() - 3, getLocY(), this, state);
				Beams.addElement(newBeam);
				newBeam.start();
			}
		}
	}
	
	public void setLocX(int x)
	{
		locX = x;
	}
	
	public void setLocY(int y)
	{
		locY = y;
	}
	
	public int getScreenWidth()
	{
		return width;
	}
	
	public int getScreenHeight()
	{
		return height;
	}
	
	public int getLocX()
	{
		return locX;
	}
	
	public int getLocY()
	{
		return locY;
	}
	
	public void IncrementChecks()
	{
		check ++;
	}
	
	public Dimension getPreferredSize()
	{
      return new Dimension(width, height);
	}
	
	public void ChooseLevel()
	{
		switch(state.getLevel())
		{
			case 1: lvl = new Lvl1(width, height, this, state); break;
			
			case 2: lvl2 = new Lvl2(width, height, this, state); break;
			
			case 3: lvl3 = new Lvl3(width, height, this, state); break;
		}
	}
	
	public void paintComponent (Graphics g)  
   {
     	super.paintComponent(g);
     	Graphics2D g2d = (Graphics2D) g;
		
		for (int i = 0; i < Beams.size(); i++) 
     	{
        	Beams.elementAt(i).draw(g2d);
     	}
		
		for (int i = 0; i < Scouts.size(); i++) 
     	{
        	Scouts.elementAt(i).draw(g2d);
     	}
		
        star.draw(g2d);
        
		for (int i = 0; i < Ships.size(); i++) 
     	{
        	Ships.elementAt(i).draw(g2d);
     	}
		
		requestFocus();
	}
}