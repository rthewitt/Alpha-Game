
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class Beam extends Thread
{
	private boolean BeamStarted;
	private boolean draw = true;
	private Ellipse2D.Double thisBeam;
	
	private int	speed = 3;
	private int	diry = 1, dirx;
	private int	size = 7;
	private int Type = 0;
	int x, y;
	private int Counter = 0;
	
	private Game gamePanel;
	private Beam beam = this;
	private GameState state;
	private Collision col;
	
	public Beam(int StartX,	int StartY, Game g, GameState s, int t)
	{
		state = s;
		col = state.getCollision();
		Type = t;
		gamePanel = g;
		dirx = StartX;
		thisBeam	= new	Ellipse2D.Double(StartX, StartY, size, size);
		BeamStarted	= true;
	}
	
	public void	draw(Graphics2D g2d)
	{
		if(thisBeam	!=	null && BeamStarted && draw)
		{
			if(Type == 1)
			{
				g2d.setColor(Color.GREEN);
			}
			else if(Type == 2)
			{
				g2d.setColor(Color.RED);
			}
			g2d.fill(thisBeam);
		}
	}
	
	public void destroy(int y, int time)
	{
		draw = false;
	}
	
	@SuppressWarnings("deprecation")
	public void	run()
	{
		while(BeamStarted)
		{
			if(Counter > 2)
			{
				col.TestBeam(this);
			}
			else
			{
				Counter ++;
			}
			
			try
			{
				Thread.sleep(speed);
			}
			catch	(InterruptedException e)
			{
				System.out.println("Woke up prematurely");
			}
			
			int OldY	= (int) thisBeam.getY();
			int NewY	= OldY;
			x = (int)thisBeam.getX();
			
			if(Type == 1)
			{
				NewY -= diry;
				
				if(NewY < 0)
				{
					gamePanel.IncrementChecks();
					BeamStarted	= false;
					beam.stop();
				}
			}
			else if(Type == 2)
			{
				NewY += diry;
				
				x = (int)thisBeam.getX();
				
				if(NewY > 800)
				{
					BeamStarted	= false;
					beam.stop();
				}
			}
			
			y = NewY;
			
			thisBeam.setFrame(dirx,	NewY,	size,	size);
			
			gamePanel.repaint();
		}
	}

	public int getX()
	{
		return (int) thisBeam.getX();
	}
	public int getY()
	{
		return (int) thisBeam.getY();
	}

	public int getDir()
	{
		return dirx;
	}
}