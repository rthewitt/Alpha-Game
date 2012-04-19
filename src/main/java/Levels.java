import java.lang.reflect.Array;
import java.util.Timer;
import java.util.TimerTask;

public class Levels extends Thread
{
	private Timer timer;
	private int sprites = 10;
	private int width, height;
	private Game game;
	private GameState state;
	
	private Array[] lvl1 = new Array[100];
	
	Levels(GameState s, Game g, int lvl)
	{
		state = s;
		game = g;
		width = game.getScreenWidth();
		height = game.getScreenHeight();
		
		Run(lvl);
	}
	
	public void Setup()
	{
		
	}
	
	private void Run(int lvl)
	{
		for(int i = 0; i < lvl1.length; i++)
		{
			timer = new Timer();
			timer.schedule(new Task(), 3000, 1000);
		}
	}
	
	private class Task extends TimerTask
	{
		public void run()
		{
			if(sprites > 0)
			{
				Enemy s = new Enemy(width, height, game, state, 1);
				game.Scouts.addElement(s);
				s.start();
				sprites --;
			}
		}
	}
}
