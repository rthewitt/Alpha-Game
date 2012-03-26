
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Timer;
import java.util.TimerTask;

public class Scout extends Thread
{
	private boolean ScoutStarted;
	private boolean draw = true;
	boolean taken = false;
	
	private BufferedImage using;
	GameState stat;
	private Timer timer;
	@SuppressWarnings("unused")
	private Game game;
	Scout s = this;
	
	int StartX, StartY;
	private int speed;
	private int Width, Height;
	private int Health = 10;
	private int Type;
	
	Scout(int x, int y, Game g, GameState st, int t)
	{
		stat = st;
		game = g;
		Width = x;
		Height = y;
		Type = t;
		
		switch(Type)
		{
			case 1: using = Resource.RED_FIGHTER; setHealth(10); break;
			
			case 2: using = Resource.redHeavy; setHealth(30); break;
			
			case 3: using = Resource.blueFighter; setHealth(15); break;
			
			case 4: using = Resource.blueHeavy; setHealth(45); break;
		}
		
		StartX = (int)(Math.random() * Width - 30);
		StartY = 0;
		speed = 30;
		ScoutStarted = true;
		
//		timer = new Timer();
//		timer.schedule(new BeamTask(), 5000, 5000);
	}
	
	public void setPosition(int x)
	{
		StartX = x;
	}
	
	public void setSpeed(int s)
	{
		speed = s;
	}
	
	public void setHealth(int h)
	{
		Health = h;
	}
	
//	private class BeamTask extends TimerTask
//	{
//		public void run()
//		{
//			Beam newBeam = new Beam(StartX, StartY, game, stat, 2);
//			game.Beams.addElement(newBeam);
//			newBeam.start();
//		}
//	}
	
	public void	draw(Graphics2D g2d)
	{
		if(ScoutStarted && draw)
		{
			g2d.drawImage(using, StartX, StartY, null); // why is this not using the scout's location?
		}
	}
	
	public void send(int x, int y, GameState s, Beam b, Game g)
	{
		if(taken == false)
		{
			stat = s;
			if(StartX <= x && StartX + 30 >= x)
			{
				int time = (y - StartY) - (StartY/30);
				if(time > 0)
				{
					Health -= 5;
					taken = true;
					b.destroy(StartY, time);
					if(Health <= 0)
					{
						timer = new Timer();
						timer.schedule(new Task(), time);
					}
					else
					{
						taken = false;
					}
				}
			}
		}
	}
	
	private class Task extends TimerTask
	{
		@SuppressWarnings("deprecation")
		public void run()
		{
			draw = false;
			s.stop();
			stat.DecrementEnemies();
			timer.cancel();
		}
	}
	
	@SuppressWarnings("deprecation")
	public void run()
   {
      while(ScoutStarted)
      {
    	  try
    	  {
            Thread.sleep(speed);
    	  }
    	  catch (InterruptedException e)
    	  {
    		  System.out.println("Woke up prematurely");
    	  }
			
			StartY += 2;
			
			if(StartY > Height)
			{
				ScoutStarted = false;
				stat.DecrementEnemies();
				try
				{
					timer.cancel();
				}
				catch(NullPointerException e)
				{
				}
				s.stop();
			}
		}
	}
}