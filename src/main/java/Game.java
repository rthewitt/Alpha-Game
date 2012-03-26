
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
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int Width, Height;
	Vector<Beam> Beams = new Vector<Beam>(0, 0);
	private Vector<Ship> Ships = new Vector<Ship>();
	Vector<Scout> Scouts = new Vector<Scout>(0, 0);
	private int check = 0, Clicks = 0;
	int locX = 250, locY = 700;
	
	private boolean pressed = false;
	Star star;
	
	Panel draw;
	private Stats stat;
	@SuppressWarnings("unused")
	private Lvl1 lvl;
	@SuppressWarnings("unused")
	private Lvl2 lvl2;
	@SuppressWarnings("unused")
	private Lvl3 lvl3;
	
	private Go go = new Go(this);
	
	public Game(int pwid, int pht, Control con, Stats s)
   {
		stat = s;
		stat.addMe(this);
		stat.getSpeed();
		Width = pwid;
		Height = pht;
		setSize(Width, Height);
		
		setVisible(true);
		addKeyListener(this);
		
		setBackground(Color.BLACK);
		
		Ship newShip = new Ship(this, stat.getShipUp(), stat.getHull(), stat);
		Ships.addElement(newShip);
		newShip.start();
		
		star = new Star(Width, Height, this);
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
	
	public Vector<Scout> getVector2()
	{
		return Scouts;
	}
	
	public void Clicked()
	{
		if(Clicks < 6)
		{
			Beam newBeam = new Beam(getLocX() - 3, getLocY(), this, stat, 1);
			Beams.addElement(newBeam);
			newBeam.start();
			
			for (int i = 0; i < Scouts.size(); i++) 
     		{
        		Scouts.elementAt(i).send(getLocX() - 3, getLocY(), stat, newBeam, this);
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
		if(stat.getMachGun())
		{
			while(pressed)
			{
				Beam newBeam = new Beam(getLocX() - 3, getLocY(), this, stat, 1);
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
      return new Dimension(Width, Height);
   }
	
	public void ChooseLevel()
	{
		switch(stat.getLevel())
		{
			case 1: lvl = new Lvl1(Width, Height, this, stat); break;
			
			case 2: lvl2 = new Lvl2(Width, Height, this, stat); break;
			
			case 3: lvl3 = new Lvl3(Width, Height, this, stat); break;
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